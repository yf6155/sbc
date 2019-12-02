package com.superbar.chat.controller.eny;

/**
 * <p>Application Name : Constant </p>
 * <p>Application Description : 常量类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
public class Constant {

    /**
     * 响应消息返回类型--通知公告类消息
     */
    public static final String ADVICE_RETURN = "1";

    /**
     * 响应消息返回类型--聊天类消息
     */
    public static final String MESSAGE_RETURN = "2";

    // MSG表消息内容类型常量 T_MSG.CONTENTTYPE
    /**
     * 文本
     */
    public static final String MSG_CONTENTTYPE_TEXT = "1";

    /**
     * 字节
     */
    public static final String MSG_CONTENTTYPE_BIN = "2";

    //MSG表消息状态常量 T_MSG.STATUS
    /**
     * 创建入库
     */
    public static final String MSG_STATUS_CREATE = "0";

    /**
     * 同步已发送
     */
    public static final String MSG_STATUS_SYNC_SEND = "2";

    /**
     * 异步已发送
     */
    public static final String MSG_STATUS_ASYN_SEND = "3";

    //ADVICE表通知公告类型 T_ADVICE.ADVICETYPE
    /**
     * 系统公告
     */
    public static final String ADVICE_TYPE_SYS = "1";

    /**
     * 预留
     */
    public static final String ADVICE_TYPE_KEEP = "2";

    /**
     * 导师申请消息（师生关系的申请跳转对方详情页）
     */
    public static final String ADVICE_TYPE_MENTOR_APPLICATION = "3";

    /**
     * 动态消息（点赞，评论，@ 跳转相应的动态）
     */
    public static final String ADVICE_TYPE_DYNAMIC_MSG = "4";

    /**
     * 关注消息（跳转到我的关注列表）
     */
    public static final String ADVICE_TYPE_FOCUS_MSG = "5";

    /**
     * 导师申请通过（跳转我的导师列表）
     */
    public static final String ADVICE_TYPE_MENTOR_APPLICATION_PASS = "6";

    /**
     * 评论消息（回复，点赞，跳转到相应的评论）
     */
    public static final String ADVICE_TYPE_COMMENT_MSG = "7";

    /**
     * 回复消息（点赞，跳转到相应的回复）
     */
    public static final String ADVICE_TYPE_APPLY_MSG = "8";

    //ADVICE表通知公告类型 T_ADVICE.ADVICESENDTYPE
    /**
     * 全体通知
     */
    public static final String ADVICE_SEND_TYPE_ALL = "1";

    /**
     * 单人通知
     */
    public static final String ADVICE_SEND_TYPE_SINGLE = "2";

    //ADVICESTATUS表状态 T_ADVICESTATUS.STATUS
    /**
     * 未推送状态
     */
    public static final String ADVICESTATUS_STATUS_UNSEND = "0";

    /**
     * 已推送
     */
    public static final String ADVICESTATUS_STATUS_SENDED = "1";

    //ADVICE表状态 T_ADVICE.STATUS
    /**
     * 未读取状态
     */
    public static final String ADVICE_STATUS_UNREAD = "1";

    /**
     * 已读取状态
     */
    public static final String ADVICE_STATUS_READED = "2";

    //USER表用户状态T_USER.DELETED
    /**
     * 正常
     */
    public static final String USER_DELETED_NORMAL = "1";

    /**
     * 封号
     */
    public static final String USER_DELETED_FORBIDDEN = "2";

    /**
     * 暂停使用
     */
    public static final String USER_DELETED_PAUSE_USE = "3";
}
