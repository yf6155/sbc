package com.superbar.chat.scheduler;

import com.alibaba.fastjson.JSON;
import com.superbar.chat.controller.eny.Constant;
import com.superbar.chat.controller.eny.MessageResponse;
import com.superbar.chat.dao.dao.impl.AdviceStatusDao;
import com.superbar.chat.dao.entity.AdviceSendInfo;
import com.superbar.chat.dao.entity.AdviceStatus;
import com.superbar.chat.utils.CommonUtils;
import com.superbar.chat.websocket.handler.SuperBarChatHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Application Name : AdvicePushScheduler </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/30
 * @Version : v1.0
 */
@Component
public class AdvicePushScheduler {

    private static final Logger log = LoggerFactory.getLogger(SuperBarChatHandler.class);

    @Autowired(required = false)
    private SuperBarChatHandler superBarChatHandler;

    @Autowired(required = false)
    private AdviceStatusDao adviceStatusDao;

    @Scheduled(cron = "0/5 * * * * *")
    private void pushAdvicesTask() {
        // 获取在线用户列表
        ConcurrentHashMap<String, WebSocketSession> onLineUserHashMap = superBarChatHandler.getWssConcurrentHashMap();

        Map.Entry<String, WebSocketSession> entry = null;
        ArrayList<AdviceSendInfo> adviceSendInfos = new ArrayList<AdviceSendInfo>();
        if (onLineUserHashMap != null) {
            adviceSendInfos.clear();
            Iterator iterator = onLineUserHashMap.entrySet().iterator();

            //循环所有在线用户
            while (iterator.hasNext()) {
                entry = (Map.Entry<String, WebSocketSession>) iterator.next();

                // 接收session
                WebSocketSession acceptSession = entry.getValue();

                //获取用户id
                String strUserId = entry.getKey();
                Integer toUserId = Integer.valueOf(strUserId);

                try {
                    adviceSendInfos = adviceStatusDao.selectAdviceSendInfoList(toUserId, Constant.ADVICESTATUS_STATUS_UNSEND);
                } catch (Exception e) {
                    log.error("selectAdviceSendInfoList happends exception.", e);
                    continue;//循环处理下一个用户
                }

                //发送通知公告
                MessageResponse messageResponse = null;
                for (AdviceSendInfo adviceSendInfo : adviceSendInfos) {
                    messageResponse = new MessageResponse(Constant.ADVICE_RETURN, Constant.MSG_CONTENTTYPE_TEXT, "", adviceSendInfo.getAdviceType(), String.valueOf(adviceSendInfo.getFromUserId()), String.valueOf(adviceSendInfo.getRelationId()));
                    messageResponse.setPayload(adviceSendInfo.getAdviceContent());

                    String sendInfo = JSON.toJSONString(messageResponse);

                    //发送通知
                    try {
                        acceptSession.sendMessage(new TextMessage(sendInfo));
                    } catch (IOException e) {
                        log.error("Send advice toUserId: {} happends exception.", toUserId, e);
                        break;//中断循环，处理下一个用户
                    }

                    //更新t_advicestatus表状态
                    AdviceStatus adviceStatus = new AdviceStatus();
                    adviceStatus.setAdviceId(adviceSendInfo.getAdviceId());
                    adviceStatus.setToUserId(toUserId);
                    adviceStatus.setStatus(Constant.ADVICESTATUS_STATUS_SENDED);
                    adviceStatus.setLastUTimeStamp(new Timestamp(System.currentTimeMillis()));
                    try {
                        adviceStatusDao.updateByKey(adviceStatus);
                    } catch (Exception e) {
                        log.error("Send Comleted and update adviceStatus happends exception,the adviceStatus String is {}.", adviceStatus.toString(), toUserId, e);
                        break;//中断循环，处理下一个用户
                    }
                }
            }
        }
    }

}
