package com.superbar.chat.service;

import com.superbar.chat.websocket.dto.AdviceDataTransferObject;
import com.superbar.chat.controller.eny.Constant;
import com.superbar.chat.dao.dao.impl.AdviceDao;
import com.superbar.chat.dao.dao.impl.AdviceStatusDao;
import com.superbar.chat.dao.dao.impl.UserDao;
import com.superbar.chat.dao.entity.Advice;
import com.superbar.chat.dao.entity.AdviceStatus;
import com.superbar.chat.dao.entity.User;
import com.superbar.chat.exception.SuperBarException;
import com.superbar.chat.service.inf.IAdviceService;
import com.superbar.chat.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * <p>Application Name : AdviceServiceImpl </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/24
 * @Version : v1.0
 */
@Service
public class AdviceServiceImpl implements IAdviceService {

    private static final Logger log = LoggerFactory.getLogger(AdviceServiceImpl.class);

    @Autowired(required = false)
    private AdviceDao adviceDao;

    @Autowired(required = false)
    private AdviceStatusDao adviceStatusDao;

    @Autowired(required = false)
    private UserDao userDao;

    @Transactional
    @Override
    public Integer addAdviceInfo(AdviceDataTransferObject adviceDataTransferObject) {
        //处理结果码
        Integer resCode = 0;

        // 通知公告消息入库
        Advice advice = new Advice();
        try {
            advice = fillAdviceValue(adviceDataTransferObject);
            Integer result = adviceDao.insert(advice);
        } catch (Exception e) {
            log.error("Insert advice happends exception,the advice is " + advice.toString(), e);
            resCode = 2;
            throw new SuperBarException("Insert advice happends exception,the advice is " + advice.toString(), e);
        }

        if (Constant.ADVICE_SEND_TYPE_ALL.equals(adviceDataTransferObject.getAdviceSendType())) {
            //ADVICE_SEND_TYPE_ALL全员通知

            //获取有效的用户列表
            ArrayList<User> userArrayList = userDao.getAllUserList(Integer.valueOf(Constant.USER_DELETED_NORMAL));

            if (userArrayList.size() <= 0) {
                log.error("There are no normal user list,the advice is " + advice.toString());
                resCode = 2;
                throw new SuperBarException("There are no normal user list,the advice is " + advice.toString(), null);
            }

            //循环用户列表插入通知公告状态表中
            AdviceStatus adviceStatus = new AdviceStatus();
            try {
                for (User user : userArrayList) {
                    adviceStatus.setAdviceId(advice.getAdviceId());
                    adviceStatus.setToUserId(user.getUserId());
                    adviceStatus.setFromUserId(advice.getFromUserId());
                    adviceStatus.setStatus(Constant.ADVICESTATUS_STATUS_UNSEND);
                    adviceStatus.setcTimeStamp(new Timestamp(System.currentTimeMillis()));
                    adviceStatus.setLastUTimeStamp(new Timestamp(System.currentTimeMillis()));
                    adviceStatusDao.insert(adviceStatus);
                }
            } catch (Exception e) {
                log.error("Insert adviceStatus happends exception,the adviceStatus is " + adviceStatus.toString(), e);
                resCode = 2;
                throw new SuperBarException("Insert adviceStatus happends exception,the adviceStatus is " + adviceStatus.toString(), e);
            }

        } else {
            //ADVICE_SEND_TYPE_SINGLE单人通知
            String acceptUserStr = adviceDataTransferObject.getAcceptUserIdStr();
            if (!StringUtils.isEmpty(acceptUserStr)) {
                AdviceStatus adviceStatus = new AdviceStatus();
                try {
                    String[] userArrays = acceptUserStr.split(",");
                    if (userArrays != null && userArrays.length > 0) {

                        for (int i = 0, j = userArrays.length; i < j; i++) {
                            adviceStatus.setAdviceId(advice.getAdviceId());
                            adviceStatus.setToUserId(Integer.valueOf(userArrays[i]));
                            adviceStatus.setFromUserId(advice.getFromUserId());
                            adviceStatus.setStatus(Constant.ADVICESTATUS_STATUS_UNSEND);
                            adviceStatus.setcTimeStamp(new Timestamp(System.currentTimeMillis()));
                            adviceStatus.setLastUTimeStamp(new Timestamp(System.currentTimeMillis()));
                            adviceStatusDao.insert(adviceStatus);
                        }
                    }
                } catch (Exception e) {
                    log.error("Insert adviceStatus happends exception in Single Sent Type,the adviceStatus is " + adviceStatus.toString(), e);
                    resCode = 2;
                    throw new SuperBarException("Insert adviceStatus happends exception in Single Sent Type,the adviceStatus is " + adviceStatus.toString(), e);
                }

            } else {
                log.error("Single Type Advice must have acceptUserList,the advice is " + advice.toString());
                resCode = 2;
                throw new SuperBarException("Single Type Advice must have acceptUserList.", null);
            }
        }

        return resCode;
    }

    /**
     * Advice实体类数据封装
     *
     * @param adviceDataTransferObject
     * @return
     */
    private Advice fillAdviceValue(AdviceDataTransferObject adviceDataTransferObject) {
        Advice advice = new Advice();
        advice.setFromUserId(CommonUtils.formatStr2Int(adviceDataTransferObject.getFromUserId()));
        advice.setAdviceType(adviceDataTransferObject.getAdviceType());
        advice.setAdviceSendType(adviceDataTransferObject.getAdviceSendType());
        advice.setAdviceContent(adviceDataTransferObject.getAdviceContent());
        advice.setRelationId(CommonUtils.formatStr2Int(adviceDataTransferObject.getRelationId()));
        advice.setStatus(Integer.valueOf(Constant.ADVICE_STATUS_UNREAD));
        advice.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        advice.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        return advice;
    }
}
