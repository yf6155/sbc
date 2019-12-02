package com.superbar.chat.dao.dao.impl;

import com.superbar.chat.dao.dao.IDao;
import com.superbar.chat.dao.dos.mapper.IUserMapper;
import com.superbar.chat.dao.entity.MessageEntity;
import com.superbar.chat.dao.entity.User;
import com.superbar.chat.exception.DataBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * <p>Application Name : UserDao </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
@Component
public class UserDao implements IDao<User> {

    private static final Logger log = LoggerFactory.getLogger(MessageDao.class);

    @Autowired(required = false)
    private IUserMapper iUserMapper;

    @Override
    public Integer insert(User user) {
        return null;
    }

    @Override
    public User selectByKey(User user) {
        return null;
    }

    @Override
    public Integer updateByKey(User user) {
        return null;
    }

    public ArrayList<User> getAllUserList(Integer deleted) {
        ArrayList<User> result = new ArrayList<User>();
        try {
            result = iUserMapper.selectAllUserList(deleted);
        } catch (Exception e) {
            log.error("The UserDao execute getAllUserList method happends exception.", e);
            result = new ArrayList<User>();
            throw new DataBaseException("The UserDao execute getAllUserList method happends exception.", e);
        }
        return result;
    }
}
