package com.superbar.chat.service;

import com.superbar.chat.dao.dao.impl.MessageDao;
import com.superbar.chat.dao.entity.MessageEntity;
import com.superbar.chat.exception.SuperBarException;
import com.superbar.chat.service.inf.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * <p>Application Name : MessageServiceImpl </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/12/14
 * @Version : v1.0
 */
@Component
public class MessageServiceImpl implements IMessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired(required = false)
    private MessageDao messageDao;

    /**
     * 全量聊天记录查询
     *
     * @param userId     登录用户
     * @param chatUserId 登录用户聊天用户
     * @return
     */
    @Override
    public ArrayList<MessageEntity> selectChatMsgList(Integer userId, Integer chatUserId) {
        ArrayList<MessageEntity> msgList = new ArrayList<MessageEntity>();
        try {
            msgList = messageDao.selectChatMsgList(userId, chatUserId);
        } catch (Exception e) {
            log.error("execute selectChatMsgList happends exception,the userId is " + userId);
            throw new SuperBarException("selectChatMsgList happends exception,the userId is " + userId, null);
        }
        return msgList;
    }

    /**
     * 翻页查询
     *
     * @param userId     登录用户
     * @param chatUserId 登录用户聊天用户
     * @param pageNo     页码（从1开始）
     * @param pageSize   分页容量
     * @return
     */
    @Override
    public ArrayList<MessageEntity> selectChatMsgListByPage(Integer userId, Integer chatUserId, Integer pageNo, Integer pageSize) {
        ArrayList<MessageEntity> msgList = new ArrayList<MessageEntity>();
        try {
            msgList = messageDao.selectChatMsgListByPage(userId, chatUserId, pageNo, pageSize);
        } catch (Exception e) {
            log.error("execute selectChatMsgListByPage happends exception,the userId is " + userId);
            throw new SuperBarException("selectChatMsgListByPage happends exception,the userId is " + userId, null);
        }
        return msgList;
    }
}
