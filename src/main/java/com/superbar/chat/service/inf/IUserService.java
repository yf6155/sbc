package com.superbar.chat.service.inf;

import com.superbar.chat.dao.entity.User;

import java.util.ArrayList;

public interface IUserService {

    public ArrayList<User> queryChatUserList(Integer userId);

    public ArrayList<User> queryChatUserListByPage(Integer userId, Integer pageNo, Integer pageSize);

    public Integer queryChatUserCount(Integer userId);
}
