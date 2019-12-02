package com.superbar.chat.controller.eny;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 服务端响应
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse {

    /**
     * 返回类型，对应Constant类中值
     * <p>
     * 1:通知公告类消息
     * <p>
     * 2:聊天类消息
     */
    private String resType;

    /**
     * 消息枚举类型，对应MessageTypeEnum类中值
     */
    private String messageType;

    /**
     * 通知公告类型详细类型，对应Constant类中值
     * <p>
     * 公告：系统公告/导师申请消息/动态消息等等
     */
    private String adviceType;

    /**
     * 消息类型：
     * <p>
     * 文本消息
     * <p>
     * 图片消息
     */
    private String contentType;

    /**
     * 来源用户HttpSessionId
     */
    private String httpSessionId;

    /**
     * 来源用户host
     */
    private String host;

    /**
     * 来源用户Id
     */
    private String fromUserId;

    /**
     * 来源用户昵称
     */
    private String username;

    /**
     * 关联Id
     */
    private String relationId;

    /**
     * 传输信息内容
     */
    private Object payload;

    public MessageResponse() {
    }

    /**
     * 响应消息类（聊天）构造方法
     *
     * @param resType
     * @param contentType
     * @param messageType
     * @param adviceType
     * @param fromUserId
     */
    public MessageResponse(String resType, String contentType, String messageType, String adviceType, String fromUserId) {
        this.resType = resType;
        this.contentType = contentType;
        this.messageType = messageType;
        this.adviceType = adviceType;
        this.fromUserId = fromUserId;
    }

    /**
     * 响应消息类(通知)构造方法
     *
     * @param resType
     * @param contentType
     * @param messageType
     * @param adviceType
     * @param fromUserId
     * @param relationId
     */
    public MessageResponse(String resType, String contentType, String messageType, String adviceType, String fromUserId, String relationId) {
        this.resType = resType;
        this.contentType = contentType;
        this.messageType = messageType;
        this.adviceType = adviceType;
        this.fromUserId = fromUserId;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(String adviceType) {
        this.adviceType = adviceType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHttpSessionId() {
        return httpSessionId;
    }

    public void setHttpSessionId(String httpSessionId) {
        this.httpSessionId = httpSessionId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "resType='" + resType + '\'' +
                ", messageType='" + messageType + '\'' +
                ", adviceType='" + adviceType + '\'' +
                ", contentType='" + contentType + '\'' +
                ", httpSessionId='" + httpSessionId + '\'' +
                ", host='" + host + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                ", username='" + username + '\'' +
                ", relationId='" + relationId + '\'' +
                ", payload=" + payload +
                '}';
    }
}
