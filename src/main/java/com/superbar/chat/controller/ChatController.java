package com.superbar.chat.controller;

import com.superbar.chat.dao.entity.User;
import com.superbar.chat.service.inf.IUserService;
import com.superbar.chat.websocket.dto.AdviceDataTransferObject;
import com.superbar.chat.controller.eny.ControllerResponse;
import com.superbar.chat.exception.SuperBarException;
import com.superbar.chat.service.inf.IAdviceService;
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
 * <p>Application Name : ChatController </p>
 * <p>Application Description : Chat Controller Service </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
@Controller
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    @Autowired(required = false)
    private IAdviceService iAdviceService;

    @Autowired(required = false)
    private IUserService iUserService;

    /**
     * 索引页
     *
     * @return page
     */
    @RequestMapping("/index")
    public String index() {
        return "chat";
    }

    /**
     * 添加通知公告
     * <p>
     * 请求数据使用POJO类进行传递
     *
     * @param adviceDataTransferObject
     * @return
     */
    @RequestMapping(value = "/addAdvice", method = RequestMethod.POST)
    @ResponseBody
    public ControllerResponse addAdvice(HttpSession session, @RequestBody AdviceDataTransferObject adviceDataTransferObject) {
        ControllerResponse controllerResponse = new ControllerResponse();
        int resCode = 0;

        try {
            resCode = iAdviceService.addAdviceInfo(adviceDataTransferObject);
        } catch (SuperBarException e) {
            log.error("Call Service happends exception.", e);
            controllerResponse = new ControllerResponse();
            controllerResponse.setResCode(2);
            controllerResponse.setResMessage("Call Service happends exception.pleace check the log info.");
            return controllerResponse;
        }
        controllerResponse.setResCode(resCode);
        return controllerResponse;
    }

}
