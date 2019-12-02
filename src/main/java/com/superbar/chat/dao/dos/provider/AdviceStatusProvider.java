package com.superbar.chat.dao.dos.provider;

import com.superbar.chat.dao.entity.Advice;
import com.superbar.chat.dao.entity.AdviceStatus;

/**
 * <p>Application Name : AdviceStatusProvider </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/23
 * @Version : v1.0
 */
public class AdviceStatusProvider {

    public String insertAdviceStatus(AdviceStatus adviceStatus) {
        StringBuffer sb = new StringBuffer();

        sb.append("INSERT INTO t_advicestatus (adviceid, touserid, fromuserid, status, ctimestamp, lastutimestamp) VALUES (");
        sb.append(adviceStatus.getAdviceId()).append(",");
        sb.append(adviceStatus.getToUserId()).append(",");
        sb.append(adviceStatus.getFromUserId()).append(",");
        sb.append("'").append(adviceStatus.getStatus()).append("',");
        sb.append("'").append(adviceStatus.getcTimeStamp()).append("',");
        sb.append("'").append(adviceStatus.getLastUTimeStamp()).append("')");

        return sb.toString();
    }

    public String updateAdviceStatusByKey(AdviceStatus adviceStatus) {
        StringBuffer sb = new StringBuffer();

        sb.append("update t_advicestatus set status = '");
        sb.append(adviceStatus.getStatus()).append("',");
        sb.append("lastutimestamp = '").append(adviceStatus.getLastUTimeStamp());
        sb.append("' where adviceid = ").append(adviceStatus.getAdviceId());
        sb.append(" and touserid = ").append(adviceStatus.getToUserId());

        return sb.toString();
    }

    public String deleteAdviceStatusByKey(AdviceStatus adviceStatus) {
        StringBuffer sb = new StringBuffer();

        sb.append("delete from t_advicestatus");
        sb.append("' where adviceid = ").append(adviceStatus.getAdviceId());
        sb.append(" and touserid = ").append(adviceStatus.getToUserId());

        return sb.toString();
    }

    public String selectAdviceStatus(Integer adviceId, Integer toUserId) {
        StringBuffer sb = new StringBuffer();

        sb.append("select adviceid, touserid, fromuserid, status, ctimestamp, lastutimestamp from t_advicestatus");
        sb.append("' where adviceid = ").append(adviceId);
        sb.append(" and touserid = ").append(toUserId);

        return sb.toString();
    }

}
