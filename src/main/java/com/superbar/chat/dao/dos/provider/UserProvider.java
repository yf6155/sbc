package com.superbar.chat.dao.dos.provider;

/**
 * <p>Application Name : UserProvider </p>
 * <p>Application Description : 用户表SQL配置类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-23
 * @Version : v1.0
 */
public class UserProvider {

    public String selectAllUserList(Integer deleted) {
        StringBuffer sb = new StringBuffer();
        sb.append("select user_id userId from t_user where 1 = 1");
        sb.append(" and deleted = ").append(deleted);
        return sb.toString();
    }
}
