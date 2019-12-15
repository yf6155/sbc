package com.superbar.chat.service;

import com.superbar.chat.dao.dao.impl.UserDao;
import com.superbar.chat.dao.entity.User;
import com.superbar.chat.exception.SuperBarException;
import com.superbar.chat.service.inf.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * <p>Application Name : UserService </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/12/14
 * @Version : v1.0
 */
@Component
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public ArrayList<User> queryChatUserList(Integer userId) {

        ArrayList<User> chatUserList = new ArrayList<User>();

        try {
            chatUserList = userDao.queryChatUserList(userId);
        } catch (Exception e) {
            log.error("execute queryChatUserList happends exception,the userId is " + userId);
            throw new SuperBarException("GetChatUserList happends exception,the userId is " + userId, null);
        }

        return chatUserList;
    }

    /**
     * 分页查询聊天用户列表
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ArrayList<User> queryChatUserListByPage(Integer userId, Integer pageNo, Integer pageSize) {
        ArrayList<User> chatUserList = new ArrayList<User>();

        try {
            chatUserList = userDao.queryChatUserListByPage(userId, pageNo, pageSize);
        } catch (Exception e) {
            log.error("execute queryChatUserList happends exception,the userId is " + userId);
            throw new SuperBarException("GetChatUserList happends exception,the userId is " + userId, null);
        }

        return chatUserList;
    }

    @Override
    public Integer queryChatUserCount(Integer userId) {
        return queryChatUserList(userId).size();
    }
}
