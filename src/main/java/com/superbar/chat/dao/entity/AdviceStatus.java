package com.superbar.chat.dao.entity;

import java.sql.Timestamp;

/**
 * <p>Application Name : AdviceStatus </p>
 * <p>Application Description : 通知公告状态表 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-23
 * @Version : v1.0
 */
public class AdviceStatus {

    private Integer adviceId;

    private Integer toUserId;

    private Integer fromUserId;

    private String status;

    private Timestamp cTimeStamp;

    private Timestamp lastUTimeStamp;


    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "AdviceStatus{" +
                "adviceId=" + adviceId +
                ", toUserId=" + toUserId +
                ", fromUserId=" + fromUserId +
                ", status='" + status + '\'' +
                ", cTimeStamp=" + cTimeStamp +
                ", lastUTimeStamp=" + lastUTimeStamp +
                '}';
    }
}
