package com.superbar.chat.dao.dao.impl;

import com.superbar.chat.dao.dao.IDao;
import com.superbar.chat.dao.dos.mapper.IAdviceMapper;
import com.superbar.chat.dao.dos.mapper.IAdviceSendInfoMapper;
import com.superbar.chat.dao.dos.mapper.IAdviceStatusMapper;
import com.superbar.chat.dao.entity.Advice;
import com.superbar.chat.dao.entity.AdviceSendInfo;
import com.superbar.chat.dao.entity.AdviceStatus;
import com.superbar.chat.exception.DataBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * <p>Application Name : AdviceStatusDao </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/23
 * @Version : v1.0
 */
@Component
public class AdviceStatusDao implements IDao<AdviceStatus> {

    private static final Logger log = LoggerFactory.getLogger(AdviceDao.class);

    @Autowired(required = false)
    private IAdviceStatusMapper iAdviceStatusMapper;

    @Autowired(required = false)
    private IAdviceSendInfoMapper iAdviceSendInfoMapper;

    @Override
    public Integer insert(AdviceStatus adviceStatus) {
        Integer result = 0;
        if (!ObjectUtils.isEmpty(adviceStatus)) {
            try {
                result = iAdviceStatusMapper.insertAdviceStatus(adviceStatus);
            } catch (Exception e) {
                log.error("The AdviceStatusDao execute insert method happends exception.", e);
                result = 0;
                throw new DataBaseException("The AdviceStatusDao execute insert method happends exception.", e);
            }
        }
        return result;
    }

    @Override
    public AdviceStatus selectByKey(AdviceStatus adviceStatus) {
        if (!ObjectUtils.isEmpty(adviceStatus)) {
            Integer adviceId = adviceStatus.getAdviceId();
            Integer toUserId = adviceStatus.getToUserId();
            AdviceStatus adviceStatusNew = new AdviceStatus();
            try {
                adviceStatusNew = iAdviceStatusMapper.selectAdviceStatus(adviceId, toUserId);
            } catch (Exception e) {
                log.error("The AdviceStatusDao execute selectAdviceStatus method happends exception.", e);
                adviceStatusNew = new AdviceStatus();
                throw new DataBaseException("The AdviceStatusDao execute selectAdviceStatus method happends exception.", e);
            }
            return adviceStatusNew;
        } else {
            return new AdviceStatus();
        }
    }

    @Override
    public Integer updateByKey(AdviceStatus adviceStatus) {
        Integer result = 0;
        if (!ObjectUtils.isEmpty(adviceStatus)) {
            try {
                result = iAdviceStatusMapper.updateAdviceStatusByKey(adviceStatus);
            } catch (Exception e) {
                log.error("The AdviceStatusDao execute updateAdviceStatusByKey method happends exception.", e);
                result = 0;
                throw new DataBaseException("The AdviceStatusDao execute updateAdviceStatusByKey method happends exception.", e);
            }
        }
        return result;
    }

    public ArrayList<AdviceSendInfo> selectAdviceSendInfoList(Integer toUserId, String status) {
        ArrayList<AdviceSendInfo> result = new ArrayList<AdviceSendInfo>();

        if (!StringUtils.isEmpty(status)) {
            try {
                result = iAdviceSendInfoMapper.selectAdviceSendInfoList(toUserId, status);
            } catch (Exception e) {
                log.error("The AdviceStatusDao execute updateAdviceStatusByKey method happends exception.", e);
                result = new ArrayList<AdviceSendInfo>();
            }
        }
        return result;
    }
}
