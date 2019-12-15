package com.superbar.chat.controller;

import com.superbar.chat.controller.eny.ControllerResponse;
import com.superbar.chat.dao.entity.User;
import com.superbar.chat.exception.SuperBarException;
import com.superbar.chat.service.inf.IAdviceService;
import com.superbar.chat.service.inf.IUserService;
import com.superbar.chat.websocket.dto.AdviceDataTransferObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * <p>Application Name : UserController </p>
 * <p>Application Description : User Controller Service </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired(required = false)
    private IAdviceService iAdviceService;

    @Autowired(required = false)
    private IUserService iUserService;

    /**
     * 新增用户信息
     *
     * @param session session
     * @param userId  userId
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(HttpSession session, String userId) {

        if (userId != null) {
            session.setAttribute("userId", userId);
        }
    }

    /**
     * 通过用户id查询与该用户聊天的所有用户记录数（包括异常状态的用户）
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getChatUserCount", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getChatUserCount(String userId) {
        ControllerResponse controllerResponse = new ControllerResponse();
        int resCode = 0;

        if (StringUtils.isEmpty(userId)) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("请求用户Id为空，请检查！");
            return controllerResponse;
        }

        Integer count = 0;
        try {
            count = iUserService.queryChatUserCount(Integer.valueOf(userId));
        } catch (SuperBarException e) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("查询聊天用户数量异常，异常信息为：" + e.getMessage());
            return controllerResponse;
        }

        controllerResponse.setResCode(resCode);
        controllerResponse.setResObject(count);
        return controllerResponse;
    }

    /**
     * 通过用户id查询与该用户聊天的所有用户列表（包括异常状态的用户）
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getChatUserList", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getChatUserList(String userId) {
        ControllerResponse controllerResponse = new ControllerResponse();
        int resCode = 0;

        if (StringUtils.isEmpty(userId)) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("请求用户Id为空，请检查！");
            return controllerResponse;
        }

        ArrayList<User> userList;

        try {
            userList = iUserService.queryChatUserList(Integer.valueOf(userId));
        } catch (SuperBarException e) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("查询用户列表异常，异常信息为：" + e.getMessage());
            return controllerResponse;
        }

        controllerResponse.setResCode(resCode);
        controllerResponse.setResObject(userList);
        return controllerResponse;
    }

    /**
     * 通过用户id查询与该用户聊天的所有用户列表（包括异常状态的用户）
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getChatUserListByPage", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getChatUserListByPage(String userId, String pageNo, String pageSize) {
        ControllerResponse controllerResponse = new ControllerResponse();
        int resCode = 0;

        if (StringUtils.isEmpty(userId)) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("请求用户Id为空，请检查！");
            return controllerResponse;
        }

        if (StringUtils.isEmpty(pageNo) || StringUtils.isEmpty(pageSize)) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("分页为空，请检查！");
            return controllerResponse;
        }

        ArrayList<User> userList;

        try {
            userList = iUserService.queryChatUserListByPage(Integer.valueOf(userId), Integer.valueOf(pageNo), Integer.valueOf(pageSize));
        } catch (SuperBarException e) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("查询用户列表异常，异常信息为：" + e.getMessage());
            return controllerResponse;
        }

        controllerResponse.setResCode(resCode);
        controllerResponse.setResObject(userList);
        return controllerResponse;
    }

}
