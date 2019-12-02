package com.superbar.chat.websocket.enums;

/**
 * 消息类型枚举
 */
public enum MessageTypeEnum {

    ONLINE("online", "上线提示"),
    OFFLINE("offline", "下线提示"),
    AUTH("auth", "认证"),
    LIST("list", "用户列表"),
    ERROR("error", "连接异常"),
    CHATOTO("chatoto", "私聊"),// one to one
    CHATOTM("chatotm", "群聊");// one to many

    // 关键字
    private String key;

    // 类型说明
    private String info;

    MessageTypeEnum(String key, String info) {
        this.key = key;
        this.info = info;
    }

    public String getKey() {
        return key;
    }

    public String getInfo() {
        return info;
    }
}
