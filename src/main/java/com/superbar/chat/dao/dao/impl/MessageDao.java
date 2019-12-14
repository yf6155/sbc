package com.superbar.chat.dao.dao.impl;

import com.superbar.chat.dao.dao.IDao;
import com.superbar.chat.dao.dos.mapper.IMessageMapper;
import com.superbar.chat.dao.dos.provider.MessageProvider;
import com.superbar.chat.dao.entity.MessageEntity;
import com.superbar.chat.exception.DataBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * <p>Application Name : MessageDao </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */

@Component
public class MessageDao implements IDao<MessageEntity> {

    private static final Logger log = LoggerFactory.getLogger(MessageDao.class);

    @Autowired(required = false)
    private IMessageMapper iMessageMapper;

    @Override
    public Integer insert(MessageEntity messageEntity) {
        Integer result = 0;
        if (!ObjectUtils.isEmpty(messageEntity)) {
            try {
                result = iMessageMapper.insertMessageEntity(messageEntity);
            } catch (Exception e) {
                log.error("The MessageDao execute insertMessageEntity method happends exception.", e);
                result = 0;
                throw new DataBaseException("The MessageDao execute insertMessageEntity method happends exception.", e);
            }
        }
        return result;
    }

    @Override
    public MessageEntity selectByKey(MessageEntity messageEntity) {
        if (!ObjectUtils.isEmpty(messageEntity)) {
            Integer msgId = messageEntity.getMsgId();
            MessageEntity rtnMessageEntity = new MessageEntity();
            try {
                rtnMessageEntity = iMessageMapper.selectMessageEntity(msgId);
            } catch (Exception e) {
                log.error("The MessageDao execute selectByKey method happends exception.", e);
                rtnMessageEntity = new MessageEntity();
                throw new DataBaseException("The MessageDao execute selectByKey method happends exception.", e);
            }
            return rtnMessageEntity;
        } else {
            return new MessageEntity();
        }
    }

    /**
     * 通过接收用户id和状态查询消息列表
     *
     * @param userId
     * @param status
     * @return
     */
    public ArrayList<MessageEntity> selectMessageEntityList(Integer userId, String status) {
        ArrayList<MessageEntity> result = new ArrayList<MessageEntity>();
        if (!StringUtils.isEmpty(status)) {
            try {
                result = iMessageMapper.selectMessageEntityList(userId, status);
            } catch (Exception e) {
                log.error("The MessageDao execute selectMessageEntityList method happends exception.", e);
                result = new ArrayList<MessageEntity>();
                throw new DataBaseException("The MessageDao execute selectMessageEntityList method happends exception.", e);
            }
            return result;
        } else {
            return new ArrayList<MessageEntity>();
        }
    }

    @Override
    public Integer updateByKey(MessageEntity messageEntity) {
        return null;
    }

    /**
     * 更新状态和最后更新时间戳
     *
     * @param messageEntity
     * @return
     */
    public Integer updateMessageEntitySendInfoByKey(MessageEntity messageEntity) {
        Integer result = 0;
        if (!ObjectUtils.isEmpty(messageEntity)) {
            try {
                result = iMessageMapper.updateMessageEntitySendInfoByKey(messageEntity);
            } catch (Exception e) {
                log.error("The MessageDao execute updateMessageEntityStatusByKey method happends exception.", e);
                result = 0;
                throw new DataBaseException("The MessageDao execute updateMessageEntityStatusByKey method happends exception.", e);
            }
        }
        return result;
    }

    /**
     * 查询全量聊天记录
     *
     * @param userId     登录用户
     * @param chatUserId 登录用户聊天用户
     * @return
     */
    public ArrayList<MessageEntity> selectChatMsgList(Integer userId, Integer chatUserId) {
        ArrayList<MessageEntity> result = new ArrayList<MessageEntity>();
        try {
            result = iMessageMapper.selectChatMsgList(userId, chatUserId);
        } catch (Exception e) {
            log.error("The MessageDao execute selectChatMsgList method happends exception.", e);
            result = new ArrayList<MessageEntity>();
            throw new DataBaseException("The MessageDao execute selectChatMsgList method happends exception.", e);
        }
        return result;
    }

    /**
     * 翻页查询
     *
     * @param userId
     * @param chatUserId
     * @param pageNo     页码（从1开始）
     * @param pageSize   分页容量
     * @return
     */
    public ArrayList<MessageEntity> selectChatMsgListByPage(Integer userId, Integer chatUserId, Integer pageNo, Integer pageSize) {
        ArrayList<MessageEntity> result = new ArrayList<MessageEntity>();
        Integer offset = 0;
        if (pageNo >= 1) {
            pageNo = pageNo - 1;
        } else {
            pageNo = 0;
        }

        // 分页查询偏移量
        offset = pageNo * pageSize;

        try {
            result = iMessageMapper.selectChatMsgListByPage(userId, chatUserId, offset, pageSize);
        } catch (Exception e) {
            log.error("The MessageDao execute selectChatMsgListByPage method happends exception.", e);
            result = new ArrayList<MessageEntity>();
            throw new DataBaseException("The MessageDao execute selectChatMsgListByPage method happends exception.", e);
        }
        return result;
    }


}
