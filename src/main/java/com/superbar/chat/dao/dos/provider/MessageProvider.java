package com.superbar.chat.dao.dos.provider;

import com.superbar.chat.dao.entity.MessageEntity;
import org.springframework.util.StringUtils;

/**
 * <p>Application Name : MessageProvider </p>
 * <p>Application Description : 消息数据库构建类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
public class MessageProvider {

    /**
     * 通过主键查询
     *
     * @param msgId
     * @return
     */
    public String selectMessageEntityByKey(Integer msgId) {
        StringBuffer sb = new StringBuffer();
        sb.append("select msgid, msgtype, contenttype, textmsg, fromuserid, touserid, ctimestamp, status, lastutimestamp from t_msg where 1 = 1 ");
        sb.append(" and msgid = ").append(msgId);
        return sb.toString();
    }

    /**
     * 通过接收用户Id和状态查询消息列表
     *
     * @param userId
     * @param status
     * @return
     */
    public String selectMessageEntityList(Integer userId, String status) {
        StringBuffer sb = new StringBuffer();
        sb.append("select msgid, msgtype, contenttype, textmsg, fromuserid, touserid, ctimestamp, status, lastutimestamp from t_msg where 1 = 1 ");
        sb.append(" and touserid = ").append(userId);
        if (!StringUtils.isEmpty(status)) {
            sb.append(" and status = '").append(status).append("'");
        }
        return sb.toString();
    }

    /**
     * 数据入库
     *
     * @param msg
     * @return
     */
    public String insertMessageEntity(MessageEntity msg) {
        StringBuffer sb = new StringBuffer();
        sb.append("insert into t_msg(msgtype, contenttype, textmsg, fromuserid, touserid, ctimestamp, status, lastutimestamp) values(");
        sb.append("'").append(msg.getMsgType()).append("',");
        sb.append("'").append(msg.getContentType()).append("',");
        sb.append("'").append(msg.getTextmsg()).append("',");
        sb.append(msg.getFromUserId()).append(",");
        sb.append(msg.getToUserId()).append(",");
        sb.append("'").append(msg.getcTimeStamp()).append("',");
        sb.append("'").append(msg.getStatus()).append("',");
        sb.append("'").append(msg.getLastUTimeStamp()).append("')");
        return sb.toString();
    }

    /**
     * 通过主键更新状态和最后更新时间戳
     *
     * @param messageEntity
     * @return
     */
    public String updateMessageEntitySendInfoByKey(MessageEntity messageEntity) {
        StringBuffer sb = new StringBuffer();
        sb.append("update t_msg set status = '").append(messageEntity.getStatus()).append("'");
        sb.append(",lastutimestamp = '").append(messageEntity.getLastUTimeStamp()).append("'");
        sb.append(" where msgId = ").append(messageEntity.getMsgId());
        return sb.toString();
    }

    /**
     * 通过消息实体类更新非空内容
     *
     * @return
     */
    public String updateMessageEntityByKey(MessageEntity msg) {
        StringBuffer sb = new StringBuffer();

        return sb.toString();
    }

    /**
     * 查询全量聊天消息
     *
     * @param userId
     * @param chatUserId
     * @return
     */
    public String selectChatMsgList(Integer userId, Integer chatUserId) {
        StringBuffer sb = new StringBuffer();
        sb.append("select msgid, msgtype, contenttype, textmsg, fromuserid, touserid, ctimestamp, status, lastutimestamp from t_msg WHERE fromuserid = #{userId} AND touserid = #{chatUserId} AND STATUS <> '0' ");
        sb.append(" UNION ");
        sb.append("select msgid, msgtype, contenttype, textmsg, fromuserid, touserid, ctimestamp, status, lastutimestamp from t_msg WHERE fromuserid = #{chatUserId} AND touserid = #{userId} AND STATUS <> '0' ");
        sb.append(" ORDER BY ctimestamp");
        return sb.toString();
    }

    /**
     * 翻页查询聊天消息
     *
     * @param userId
     * @param chatUserId
     * @return
     */
    public String selectChatMsgListByPage(Integer userId, Integer chatUserId, Integer offset, Integer pageSize) {
        StringBuffer sb = new StringBuffer();
        sb.append("select msgid, msgtype, contenttype, textmsg, fromuserid, touserid, ctimestamp, status, lastutimestamp from t_msg WHERE fromuserid = #{userId} AND touserid = #{chatUserId} AND STATUS <> '0' ");
        sb.append(" UNION ");
        sb.append("select msgid, msgtype, contenttype, textmsg, fromuserid, touserid, ctimestamp, status, lastutimestamp from t_msg WHERE fromuserid = #{chatUserId} AND touserid = #{userId} AND STATUS <> '0' ");
        sb.append(" ORDER BY ctimestamp");
        sb.append(" LIMIT #{pageSize} OFFSET #{offset}");
        return sb.toString();
    }

}
