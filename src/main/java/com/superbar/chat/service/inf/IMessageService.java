package com.superbar.chat.service.inf;

import com.superbar.chat.dao.entity.MessageEntity;

import java.util.ArrayList;

/**
 * <p>Application Name : IMessageService </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/12/14
 * @Version : v1.0
 */
public interface IMessageService {

    /**
     * 全量聊天记录条数查询
     *
     * @param userId     登录用户
     * @param chatUserId 登录用户聊天用户
     * @return
     */
    public Integer selectChatMsgCount(Integer userId, Integer chatUserId);

    /**
     * 全量聊天记录查询
     *
     * @param userId     登录用户
     * @param chatUserId 登录用户聊天用户
     * @return
     */
    public ArrayList<MessageEntity> selectChatMsgList(Integer userId, Integer chatUserId);

    /**
     * 翻页查询
     *
     * @param userId     登录用户
     * @param chatUserId 登录用户聊天用户
     * @param pageNo     页码（从1开始）
     * @param pageSize   分页容量
     * @return
     */
    public ArrayList<MessageEntity> selectChatMsgListByPage(Integer userId, Integer chatUserId, Integer pageNo, Integer pageSize);

}
