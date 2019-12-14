package com.superbar.chat.websocket.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.superbar.chat.websocket.dto.MessageDataTransferObject;
import com.superbar.chat.websocket.enums.MessageTypeEnum;
import com.superbar.chat.controller.eny.MessageResponse;
import com.superbar.chat.controller.eny.Constant;
import com.superbar.chat.dao.dao.impl.MessageDao;
import com.superbar.chat.dao.entity.MessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * <p>Application Name : SuperBarChatHandler </p>
 * <p>Application Description : Ws处理器用于处理WebSocketSession的生命周期、单播消息、广播消息 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
@Service(value = "superBarCharHandler")
public class SuperBarChatHandler implements WebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(SuperBarChatHandler.class);


    // 用于存放所有连接的WebSocketSession
    private static CopyOnWriteArraySet<WebSocketSession> webSocketSessions = new CopyOnWriteArraySet<>();

    // 用于存放所有在线用户信息
    private static ConcurrentHashMap<String, WebSocketSession> wssConcurrentHashMap = new ConcurrentHashMap<String, WebSocketSession>();

    /**
     * 对于websocket一次无法传输完成的大内容，使用线程安全的对象进行接收组装
     */
    private ThreadLocal<StringBuffer> bigMsgAppend = new ThreadLocal<StringBuffer>();

    @Autowired(required = false)
    private MessageDao messageDao;

    /**
     * 成功连接WebSocket后执行
     *
     * @param session session
     * @throws Exception Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        String userId = (String) session.getAttributes().get("userId");

        if (!StringUtils.isEmpty(userId)) {

            // 成功连接后将该连接加入集合
            webSocketSessions.add(session);
            wssConcurrentHashMap.put(userId, session);

        }

        //配置传输文件大小10M
        session.setTextMessageSizeLimit(10240 * 1024 * 8);

    }

    /**
     * 处理收到的WebSocketMessage，根据需求只处理TextMessage
     * （参照org.springframework.web.socket.handler.AbstractWebSocketHandler）
     *
     * @param session session
     * @param message message
     * @throws Exception Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

        boolean isLast = message.isLast();

        StringBuffer sb = bigMsgAppend.get();
        if (ObjectUtils.isEmpty(sb)) {
            sb = new StringBuffer("");
        }
        if (!isLast) {
            sb.append(message.getPayload());
            bigMsgAppend.set(sb);
            return;
        } else {
            sb.append(message.getPayload());
            bigMsgAppend.set(sb);
        }

        //获取传输整体对象
        String dtoStr = (String) bigMsgAppend.get().toString();

        MessageDataTransferObject dto = null;

        if (!StringUtils.isEmpty(dtoStr)) {
            try {
                dto = JSON.parseObject(dtoStr, MessageDataTransferObject.class);
            } catch (JSONException e) {
                log.error("The input JsonString is :{}", dtoStr);
                return;
            }
        }

        dto.setTimeStamp(new Date());

        String messageType = "";
        if (!ObjectUtils.isEmpty(dto)) {
            messageType = dto.getMessageType();
        }

        if (!StringUtils.isEmpty(messageType)) {
            if (MessageTypeEnum.CHATOTO.getKey().equalsIgnoreCase(messageType)) {
                //私聊
                unicast(session, dto);
            } else if (MessageTypeEnum.CHATOTM.getKey().equalsIgnoreCase(messageType)) {
                //群聊
                broadcast(session, dto);
            }
        }

    }

    /**
     * 处理WebSocketMessage transport error
     *
     * @param session   session
     * @param exception exception
     * @throws Exception Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 对于异常连接，关闭并从webSocket移除Sessions中
        if (session.isOpen()) {
            session.close();
        }

        if (webSocketSessions.contains(session)) {
            webSocketSessions.remove(session);
        }

        String userId = (String) session.getAttributes().get("userId");

        if (!StringUtils.isEmpty(userId) && wssConcurrentHashMap.containsKey(userId)) {

            wssConcurrentHashMap.remove(userId);

        }

        log.warn("The WebSocket transport happends exception." + new Date());
    }

    /**
     * 在两端WebSocket connection都关闭或transport error发生后执行
     *
     * @param session     session
     * @param closeStatus closeStatus
     * @throws Exception Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

        if (webSocketSessions.contains(session)) {

            boolean removeNow = webSocketSessions.remove(session);

        }

        String userId = (String) session.getAttributes().get("userId");

        if (!StringUtils.isEmpty(userId) && wssConcurrentHashMap.containsKey(userId)) {

            wssConcurrentHashMap.remove(userId);

        }

        log.info("The WebSocket afterConnectionClosed." + new Date());

    }

    /**
     * Whether the WebSocketHandler handles partial messages. If this flag is set to
     * {@code true} and the underlying WebSocket server supports partial messages,
     * then a large WebSocket message, or one of an unknown size may be split and
     * maybe received over multiple calls to
     * {@link #handleMessage(WebSocketSession, WebSocketMessage)}. The flag
     * {@link WebSocketMessage#isLast()} indicates if
     * the message is partial and whether it is the last part.
     */
    @Override
    public boolean supportsPartialMessages() {
        return true;
    }

    /**
     * 返回当前在线用户列表HashMap
     *
     * @return
     */
    public ConcurrentHashMap<String, WebSocketSession> getWssConcurrentHashMap() {
        return wssConcurrentHashMap;
    }

    /**
     * 向单个WebSocketSession单播消息
     *
     * @param session
     * @param dataTransferObject
     */
    private void unicast(WebSocketSession session, MessageDataTransferObject dataTransferObject) {
        String toUserId = dataTransferObject.getToUserId();
        WebSocketSession acceptSession;

        if (!StringUtils.isEmpty(toUserId)) {
            //发送前消息入库
            MessageEntity messageEntity = saveMessageInfoBeforeSend(session, dataTransferObject);

            if (wssConcurrentHashMap.containsKey(toUserId)) {
                //接收用户在线
                acceptSession = wssConcurrentHashMap.get(toUserId);
                sendMsgBySingle(session, acceptSession, dataTransferObject);

                //发送成功更新状态
                updateMsgInfo(messageEntity, Constant.MSG_STATUS_SYNC_SEND);

            } else {
                //用户离线，不做处理，后续用户上线后通过定时任务执行发送
            }
        }
    }

    /**
     * 私聊消息发送
     *
     * @param sendSession
     * @param acceptSession
     * @param dataTransferObject
     */
    private void sendMsgBySingle(WebSocketSession sendSession, WebSocketSession acceptSession, MessageDataTransferObject dataTransferObject) {
        //组装响应消息
        String response = this.getResponse(sendSession, Constant.MESSAGE_RETURN, getContentType(dataTransferObject), dataTransferObject.getMessageType(), "", dataTransferObject.getPayload());

        try {
            acceptSession.sendMessage(new TextMessage(response));
        } catch (IOException e) {
            log.error("Send Single Message Happends Exception.from  userId:{} to userId{}", sendSession.getAttributes().get("userId"), acceptSession.getAttributes().get("userId"), e);
        }
    }

    /**
     * 群聊消息发送
     *
     * @param session
     * @param dataTransferObject
     */
    private void broadcast(WebSocketSession session, MessageDataTransferObject dataTransferObject) {
        Object payload = dataTransferObject.getPayload();

        if (!ObjectUtils.isEmpty(payload)) {

            sentMsgByGroup(session, dataTransferObject);
        }

    }

    /**
     * 群聊发送文本消息方法，自己不接受消息
     *
     * @param sendSession
     * @param dataTransferObject
     */
    private void sentMsgByGroup(WebSocketSession sendSession, MessageDataTransferObject dataTransferObject) {
        //组装响应消息
        String response = this.getResponse(sendSession, Constant.MESSAGE_RETURN, getContentType(dataTransferObject), dataTransferObject.getMessageType(), "", dataTransferObject.getPayload());

        // 群发消息
        for (WebSocketSession acceptSession : webSocketSessions) {

            if (sendSession == acceptSession) {
                continue;
            }

            try {
                acceptSession.sendMessage(new TextMessage(response));
            } catch (IOException e) {
                log.error("Send Group Message Happends Exception.from  userId:{} to userId{}", sendSession.getAttributes().get("userId"), acceptSession.getAttributes().get("userId"), e);
            }
        }

    }

    /**
     * 保存文本消息，返回MSG表实体对象
     *
     * @param sendSession
     * @param dataTransferObject
     * @return messageEntity
     */
    private MessageEntity saveMessageInfoBeforeSend(WebSocketSession sendSession, MessageDataTransferObject dataTransferObject) {
        Integer result = 0;//mybatis执行结果
        Integer msgId = 0;//主键
        MessageEntity messageEntity = new MessageEntity();

        messageEntity = fillMessgeData(dataTransferObject);
        try {
            result = messageDao.insert(messageEntity);
            if (result == 1) {
                msgId = messageEntity.getMsgId();
            } else {
                log.warn("Save TextMessageInfo Before Sending Failed.from  userId:{} to userId{}", sendSession.getAttributes().get("userId"), dataTransferObject.getToUserId());
            }
        } catch (Exception e) {
            log.error("Save TextMessageInfo Before Sending Happends Exception.from  userId:{} to userId{}", sendSession.getAttributes().get("userId"), dataTransferObject.getToUserId(), e);
        }
        return messageEntity;
    }

    /**
     * 初次保存入库消息体，消息状态是：未发送
     *
     * @param dataTransferObject
     * @return
     */
    private MessageEntity fillMessgeData(MessageDataTransferObject dataTransferObject) {
        MessageEntity messageEntity = new MessageEntity();

        String msgContent = String.valueOf(dataTransferObject.getPayload());

        messageEntity.setMsgType(dataTransferObject.getMessageType());
        if (!StringUtils.isEmpty(msgContent) && msgContent.indexOf("base64") >= 0) {
            messageEntity.setContentType(Constant.MSG_CONTENTTYPE_BIN);//文本消息
        } else {
            messageEntity.setContentType(Constant.MSG_CONTENTTYPE_TEXT);//文本消息
        }
        messageEntity.setTextmsg(msgContent);
        messageEntity.setFromUserId(Integer.valueOf(dataTransferObject.getFromUserId()));
        messageEntity.setToUserId(Integer.valueOf(dataTransferObject.getToUserId()));
        messageEntity.setcTimeStamp(new Timestamp(System.currentTimeMillis()));
        messageEntity.setStatus(Constant.MSG_STATUS_CREATE);//未发送
        messageEntity.setLastUTimeStamp(new Timestamp(System.currentTimeMillis()));
        return messageEntity;
    }

    /**
     * 获取消息内容类型，文本/图片
     *
     * @param dataTransferObject
     * @return
     */
    private String getContentType(MessageDataTransferObject dataTransferObject) {
        String msgContent = String.valueOf(dataTransferObject.getPayload());

        if (!StringUtils.isEmpty(msgContent) && msgContent.indexOf("base64") >= 0) {
            return Constant.MSG_CONTENTTYPE_BIN;//图片消息
        } else {
            return Constant.MSG_CONTENTTYPE_TEXT;//文本消息
        }
    }

    /**
     * 通过主键更新消息状态
     *
     * @param messageEntity
     * @param status
     */
    private void updateMsgInfo(MessageEntity messageEntity, String status) {
        Integer result = 0;

        //设置状态
        if (!StringUtils.isEmpty(status)) {
            messageEntity.setStatus(status);
        }
        //设置最后更新时间戳
        messageEntity.setLastUTimeStamp(new Timestamp(System.currentTimeMillis()));

        result = messageDao.updateMessageEntitySendInfoByKey(messageEntity);
    }

    /**
     * 查询消息
     *
     * @param sendSession
     * @param dataTransferObject
     */
    private MessageEntity queryMessageInfo(WebSocketSession sendSession, MessageDataTransferObject dataTransferObject) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMsgId(1);
        messageEntity = messageDao.selectByKey(messageEntity);
        return messageEntity;
    }

    /**
     * 封装response并转为json字符串
     *
     * @param session
     * @param resType
     * @param contentType
     * @param messageType
     * @param adviceType
     * @param payload
     * @return
     */
    private String getResponse(WebSocketSession session, String resType, String contentType, String messageType, String adviceType, Object payload) {
        MessageResponse messageResponse;

        if (null == session) {
            messageResponse = new MessageResponse();
        } else {
            Map<String, Object> attributes = session.getAttributes();
            String httpSessionId = (String) attributes.get("httpSessionId");
            String host = (String) attributes.get("host");
            String fromUserId = (String) attributes.get("userId");

            messageResponse = new MessageResponse(resType, contentType, messageType, adviceType, fromUserId);
        }

        messageResponse.setPayload(payload);

        // 转为json字符串
        return JSON.toJSONString(messageResponse);
    }

    /**
     * 封装离线response并转为json字符串
     *
     * @param fromUserId
     * @param contentType
     * @param messageType
     * @param payload
     * @return
     */
    private String getOfflineResponse(String fromUserId, String contentType, String messageType, Object payload) {
        MessageResponse messageResponse;


        messageResponse = new MessageResponse(Constant.MESSAGE_RETURN, contentType, messageType, "", fromUserId);

        messageResponse.setPayload(payload);

        // 转为json字符串
        return JSON.toJSONString(messageResponse);
    }

    /**
     * 保存图片
     *
     * @param dataTransferObject
     * @param path
     */
    private void savePicInLocal(MessageDataTransferObject dataTransferObject, String path) {
        String payLoad = (String) dataTransferObject.getPayload();
        if (!StringUtils.isEmpty(payLoad)) {
            String[] data = payLoad.split("base64,");

            if (data != null && data.length >= 2) {
                String picBase64Data = data[1];
                byte[] bs = Base64Utils.decodeFromString(picBase64Data);
                for (int i = 0; i < bs.length; ++i) {
                    if (bs[i] < 0) {
                        //调整异常数据
                        bs[i] += 256;
                    }
                }
                String fileName = "Test.jpg";
                String filePath = path + fileName;

                OutputStream out = null;
                try {
                    out = new FileOutputStream(filePath);
                    out.write(bs);
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    log.error("Save pic happends exception.", e);
                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            log.error("close outputstream happends exception.", e);
                        }
                    }
                }
            }
        }

    }

    /**
     * 定时任务，每15秒轮训一次在线用户，检查是否有未接受的消息
     * <p>
     * 任务间隔5秒
     *
     * @throws Exception Exception
     */
    @Scheduled(cron = "0/5 * * * * *")
    private void sendOfflineMsg() {
        Iterator iterator = wssConcurrentHashMap.entrySet().iterator();
        ArrayList<MessageEntity> offlineMsgList = new ArrayList<MessageEntity>();
        Map.Entry<String, WebSocketSession> entry = null;

        //循环在线用户，是否存在离线消息
        while (iterator.hasNext()) {

            offlineMsgList.clear();

            entry = (Map.Entry<String, WebSocketSession>) iterator.next();

            // 接收session
            WebSocketSession acceptSession = entry.getValue();

            //获取用户id
            String strUserId = entry.getKey();
            Integer userId = Integer.valueOf(strUserId);

            // 获取此用户为接收消息的离线消息列表
            try {
                offlineMsgList = messageDao.selectMessageEntityList(userId, Constant.MSG_STATUS_CREATE);
            } catch (Exception e) {
                log.error("Send offline message happends exception. userId:{}", userId, e);
            }

            for (MessageEntity item : offlineMsgList) {


                String response = getOfflineResponse(String.valueOf(item.getFromUserId()), item.getContentType(), item.getMsgType(), item.getTextmsg());

                //发送消息
                try {
                    acceptSession.sendMessage(new TextMessage(response));

                    //更新状态
                    updateMsgInfo(item, Constant.MSG_STATUS_ASYN_SEND);

                } catch (IOException e) {
                    log.error("Send offline message happends exception.  MSG info:{} ", item.toString(), e);
                }
            }
        }
    }
}
