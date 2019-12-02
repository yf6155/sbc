package com.superbar.chat.dao.entity;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * <p>Application Name : MessageEntity </p>
 * <p>Application Description : 消息实体类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
public class MessageEntity {

    private Integer msgId;

    private String msgType;

    /**
     * 1：文本
     * <p>
     * 2：字节类（图片等）
     */
    private String contentType;

    private String textmsg;

    private Integer fromUserId;

    private Integer toUserId;

    private Timestamp cTimeStamp;

    private String status;

    private Timestamp lastUTimeStamp;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTextmsg() {
        return textmsg;
    }

    public void setTextmsg(String textmsg) {
        this.textmsg = textmsg;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Timestamp getcTimeStamp() {
        return cTimeStamp;
    }

    public void setcTimeStamp(Timestamp cTimeStamp) {
        this.cTimeStamp = cTimeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getLastUTimeStamp() {
        return lastUTimeStamp;
    }

    public void setLastUTimeStamp(Timestamp lastUTimeStamp) {
        this.lastUTimeStamp = lastUTimeStamp;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "msgId=" + msgId +
                ", msgType='" + msgType + '\'' +
                ", contentType='" + contentType + '\'' +
                ", textmsg='" + textmsg + '\'' +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", cTimeStamp=" + cTimeStamp +
                ", status='" + status + '\'' +
                ", lastUTimeStamp=" + lastUTimeStamp +
                '}';
    }
}
