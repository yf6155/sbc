package com.superbar.chat.exception.handler;

import com.alibaba.fastjson.JSON;
import com.superbar.chat.controller.ChatController;
import com.superbar.chat.controller.eny.ControllerResponse;
import com.superbar.chat.exception.SuperBarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>Application Name : GlobalExceptionHandler </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/29
 * @Version : v1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {

        // ajax
        if (req.getHeader("accept").contains("application/json") || (req.getHeader("X-Requested-With") != null
                && req.getHeader("X-Requested-With").contains("XMLHttpRequest"))) {
            try {
                ControllerResponse controllerResponse = new ControllerResponse();
                controllerResponse.setResCode(2);
                controllerResponse.setResMessage("The error msg is : " + e.getMessage());

                resp.setCharacterEncoding("utf-8");
                PrintWriter writer = resp.getWriter();
                writer.write(JSON.toJSONString(controllerResponse));
                writer.flush();
            } catch (IOException i) {
                i.printStackTrace();
            }
            return null;
        }

        // TODO 后续可分类处理异常
        if (e instanceof SuperBarException) {
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("message", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

}