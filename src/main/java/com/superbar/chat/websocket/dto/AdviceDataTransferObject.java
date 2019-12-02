package com.superbar.chat.websocket.dto;

/**
 * <p>Application Name : AdviceDataTransferObject </p>
 * <p>Application Description : 通知公告数据传输类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/23
 * @Version : v1.0
 */
public class AdviceDataTransferObject {

    private String fromUserId;

    /**
     * Constant类中变量
     */
    private String adviceType;

    /**
     * Constantl类中变量
     * <p>
     * 全体通知
     * <p>
     * 单人通知
     */
    private String adviceSendType;

    /**
     * 全员通告，此参数可不用传递
     * <p>
     * 非全员公告，将接收用户列表以逗号","分割传递为字符串参数
     */
    private String acceptUserIdStr;

    private String adviceContent;

    private String relationId;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
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

    public String getAcceptUserIdStr() {
        return acceptUserIdStr;
    }

    public void setAcceptUserIdStr(String acceptUserIdStr) {
        this.acceptUserIdStr = acceptUserIdStr;
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    @Override
    public String toString() {
        return "AdviceDataTransferObject{" +
                "fromUserId='" + fromUserId + '\'' +
                ", adviceType='" + adviceType + '\'' +
                ", adviceSendType='" + adviceSendType + '\'' +
                ", acceptUserIdStr='" + acceptUserIdStr + '\'' +
                ", adviceContent='" + adviceContent + '\'' +
                ", relationId='" + relationId + '\'' +
                '}';
    }
}
