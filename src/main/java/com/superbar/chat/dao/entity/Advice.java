package com.superbar.chat.dao.entity;

import java.sql.Timestamp;

/**
 * <p>Application Name : Advice </p>
 * <p>Application Description : 通知公告实体类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-23
 * @Version : v1.0
 */
public class Advice {

    private Integer adviceId;

    private Integer fromUserId;

    private String adviceType;

    private String adviceSendType;

    private String adviceContent;

    private Integer relationId;

    private Integer deleted;

    private Integer status;

    private Timestamp createdDate;

    private Timestamp updatedDate;

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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Advice{" +
                "adviceId=" + adviceId +
                ", fromUserId=" + fromUserId +
                ", adviceType='" + adviceType + '\'' +
                ", adviceSendType='" + adviceSendType + '\'' +
                ", adviceContent='" + adviceContent + '\'' +
                ", relationId=" + relationId +
                ", deleted=" + deleted +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
