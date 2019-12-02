package com.superbar.chat.dao.dao.impl;

import com.superbar.chat.dao.dao.IDao;
import com.superbar.chat.dao.dos.mapper.IAdviceMapper;
import com.superbar.chat.dao.entity.Advice;
import com.superbar.chat.dao.entity.MessageEntity;
import com.superbar.chat.exception.DataBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * <p>Application Name : AdviceDao </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/23
 * @Version : v1.0
 */
@Component
public class AdviceDao implements IDao<Advice> {

    private static final Logger log = LoggerFactory.getLogger(AdviceDao.class);

    @Autowired(required = false)
    private IAdviceMapper iAdviceMapper;

    @Override
    public Integer insert(Advice advice) {
        Integer result = 0;
        if (!ObjectUtils.isEmpty(advice)) {
            try {
                result = iAdviceMapper.insertAdvice(advice);
            } catch (Exception e) {
                log.error("The AdviceDao execute insert method happends exception.", e);
                result = 0;
                throw new DataBaseException("The AdviceDao execute insert method happends exception.", e);
            }
        }
        return result;
    }

    @Override
    public Integer updateByKey(Advice advice) {
        Integer result = 0;
        if (!ObjectUtils.isEmpty(advice)) {
            try {
                result = iAdviceMapper.updateAdviceByKey(advice);
            } catch (Exception e) {
                log.error("The AdviceDao execute updateByKey method happends exception.", e);
                result = 0;
                throw new DataBaseException("The AdviceDao execute updateByKey method happends exception.", e);
            }
        }
        return result;
    }

    @Override
    public Advice selectByKey(Advice advice) {
        if (!ObjectUtils.isEmpty(advice)) {
            Integer adviceId = advice.getAdviceId();
            Advice adviceNew = new Advice();
            try {
                adviceNew = iAdviceMapper.selectAdvice(adviceId);
            } catch (Exception e) {
                log.error("The AdviceDao execute selectByKey method happends exception.", e);
                adviceNew = new Advice();
                throw new DataBaseException("The AdviceDao execute selectByKey method happends exception.", e);
            }
            return adviceNew;
        } else {
            return new Advice();
        }
    }

    public Integer deleteByKey(Advice advice) {
        Integer result = 0;
        if (!ObjectUtils.isEmpty(advice) && advice.getAdviceId() >= 0) {
            try {
                result = iAdviceMapper.deleteAdviceByKey(advice);
            } catch (Exception e) {
                log.error("The AdviceDao execute deleteByKey method happends exception.", e);
                result = 0;
                throw new DataBaseException("The AdviceDao execute deleteByKey method happends exception.", e);
            }
        }
        return result;
    }

}
