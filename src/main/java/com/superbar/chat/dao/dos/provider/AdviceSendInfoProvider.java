package com.superbar.chat.dao.dos.provider;

import com.superbar.chat.dao.entity.Advice;

/**
 * <p>Application Name : AdviceProvider </p>
 * <p>Application Description : 查询通知公告详细信息 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/23
 * @Version : v1.0
 */
public class AdviceSendInfoProvider {


    public String selectAdviceSendInfoList(Integer toUserId, String status) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT a.adviceid adviceId, a.fromuserid fromUserId,b.touserid toUserId, a.advicetype adviceType, a.advicesendtype adviceSendType,");
        sb.append("a.advicecontent adviceContent, a.relationid relationId, a.created_date createdDate, a.updated_date updatedDate,b.ctimestamp cTimeStamp,");
        sb.append("b.lastutimestamp lastUTimeStamp from t_advice a,t_advicestatus b WHERE a.adviceid = b.adviceid AND b.touserid = #{toUserId} ");
        sb.append("AND b.status = #{status}");
        sb.append(" ORDER BY b.ctimestamp");
        return sb.toString();
    }

}
