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
                throw new DataBaseException("The MessageDao execute insertMessageEntity method happends exception.",e);
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
                throw new DataBaseException("The MessageDao execute selectByKey method happends exception.",e);
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
                throw new DataBaseException("The MessageDao execute selectMessageEntityList method happends exception.",e);
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
                throw new DataBaseException("The MessageDao execute updateMessageEntityStatusByKey method happends exception.",e);
            }
        }
        return result;
    }
}
