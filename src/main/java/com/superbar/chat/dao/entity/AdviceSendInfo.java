package com.superbar.chat.dao.entity;

import java.sql.Timestamp;

/**
 * <p>Application Name : AdviceSendInfo </p>
 * <p>Application Description : 通知公告推送消息 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/30
 * @Version : v1.0
 */
public class AdviceSendInfo {

    private Integer adviceId;

    private Integer fromUserId;

    private Integer toUserId;

    private String adviceType;

    private String adviceSendType;

    private String adviceContent;

    private Integer relationId;

    private Timestamp createdDate;

    private Timestamp updatedDate;

    private Timestamp cTimeStamp;

    private Timestamp lastUTimeStamp;

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
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

    public String getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(String adviceType) {
        this.adviceType = adviceType;
    }

    public String getAdviceSendType() {
        return adviceSendType;
    }

    public void setAdviceSendType(String adviceSendType) {
        this.adviceSendType = adviceSendType;
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getcTimeStamp() {
        return cTimeStamp;
    }

    public void setcTimeStamp(Timestamp cTimeStamp) {
        this.cTimeStamp = cTimeStamp;
    }

    public Timestamp getLastUTimeStamp() {
        return lastUTimeStamp;
    }

    public void setLastUTimeStamp(Timestamp lastUTimeStamp) {
        this.lastUTimeStamp = lastUTimeStamp;
    }
}
