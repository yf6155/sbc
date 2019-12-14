package com.superbar.chat.dao.dos.mapper;

import com.superbar.chat.dao.dos.provider.MessageProvider;
import com.superbar.chat.dao.dos.provider.UserProvider;
import com.superbar.chat.dao.entity.MessageEntity;
import com.superbar.chat.dao.entity.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.ArrayList;

public interface IUserMapper {

    /**
     * 通过账号状态查询所有用户列表
     *
     * @param deleted
     * @return
     */
    @SelectProvider(type = UserProvider.class, method = "selectAllUserList")
    @ResultType(User.class)
    public ArrayList<User> selectAllUserList(Integer deleted);

    /**
     * 查询当前用户的所有聊天用户列表
     *
     * @param userId
     * @return
     */
    @SelectProvider(type = UserProvider.class, method = "queryChatUserList")
    @ResultType(User.class)
    public ArrayList<User> queryChatUserList(Integer userId);

}
