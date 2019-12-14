package com.superbar.chat.controller;

import com.superbar.chat.controller.eny.ControllerResponse;
import com.superbar.chat.dao.entity.MessageEntity;
import com.superbar.chat.dao.entity.User;
import com.superbar.chat.exception.SuperBarException;
import com.superbar.chat.service.inf.IAdviceService;
import com.superbar.chat.service.inf.IMessageService;
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
 * <p>Application Name : MessageController </p>
 * <p>Application Description : Message Controller Service </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
@Controller
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired(required = false)
    private IMessageService iMessageService;

    /**
     * 全量聊天记录查询
     *
     * @param userId     登录用户
     * @param chatUserId 登录用户聊天用户
     * @return
     */
    @RequestMapping(value = "/getMsg", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getMsg(String userId, String chatUserId) {
        ControllerResponse controllerResponse = new ControllerResponse();
        int resCode = 0;

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(chatUserId)) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("用户Id为空，请检查！");
            return controllerResponse;
        }

        ArrayList<MessageEntity> msgList = new ArrayList<MessageEntity>();

        try {
            msgList = iMessageService.selectChatMsgList(Integer.valueOf(userId), Integer.valueOf(chatUserId));
        } catch (SuperBarException e) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("查询消息列表异常，异常信息为：" + e.getMessage());
            return controllerResponse;
        }

        controllerResponse.setResCode(resCode);
        controllerResponse.setResObject(msgList);
        return controllerResponse;
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
    @RequestMapping(value = "/getMsgByPage", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getMsgByPage(String userId, String chatUserId, String pageNo, String pageSize) {
        ControllerResponse controllerResponse = new ControllerResponse();
        int resCode = 0;

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(chatUserId)) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("用户Id为空，请检查！");
            return controllerResponse;
        }

        if (StringUtils.isEmpty(pageNo) || StringUtils.isEmpty(pageSize)) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("分页为空，请检查！");
            return controllerResponse;
        }

        ArrayList<MessageEntity> msgList = new ArrayList<MessageEntity>();

        try {
            msgList = iMessageService.selectChatMsgListByPage(Integer.valueOf(userId), Integer.valueOf(chatUserId), Integer.valueOf(pageNo), Integer.valueOf(pageSize));
        } catch (SuperBarException e) {
            resCode = 2;
            controllerResponse.setResCode(resCode);
            controllerResponse.setResMessage("分页查询消息列表异常，异常信息为：" + e.getMessage());
            return controllerResponse;
        }

        controllerResponse.setResCode(resCode);
        controllerResponse.setResObject(msgList);
        return controllerResponse;
    }

}
