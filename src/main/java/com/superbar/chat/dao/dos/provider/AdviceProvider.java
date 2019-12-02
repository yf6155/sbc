package com.superbar.chat.dao.dos.provider;

import com.superbar.chat.dao.entity.Advice;

/**
 * <p>Application Name : AdviceProvider </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/23
 * @Version : v1.0
 */
public class AdviceProvider {

    public String insertAdvice(Advice advice) {
        StringBuffer sb = new StringBuffer();

        sb.append("INSERT INTO t_advice (fromuserid, advicetype, advicesendtype, advicecontent, relationid, deleted, status, created_date, updated_date) VALUES (");
        sb.append(advice.getFromUserId()).append(",");
        sb.append("'").append(advice.getAdviceType()).append("',");
        sb.append("'").append(advice.getAdviceSendType()).append("',");
        sb.append("'").append(advice.getAdviceContent()).append("',");
        sb.append(advice.getRelationId()).append(",");
        sb.append(advice.getDeleted()).append(",");
        sb.append(advice.getStatus()).append(",");
        sb.append("'").append(advice.getCreatedDate()).append("',");
        sb.append("'").append(advice.getUpdatedDate()).append("')");

        return sb.toString();
    }

    public String updateAdviceByKey(Advice advice) {
        StringBuffer sb = new StringBuffer();

        sb.append("update t_advice set deleted = '");
        sb.append(advice.getDeleted()).append("',");
        sb.append("status = '").append(advice.getStatus());
        sb.append("' where adviceid = ").append(advice.getAdviceId());

        return sb.toString();
    }

    public String deleteAdviceByKey(Advice advice) {
        StringBuffer sb = new StringBuffer();

        sb.append("delete from t_advice");
        sb.append("' where adviceid = ").append(advice.getAdviceId());

        return sb.toString();
    }

    public String selectAdvice(Integer adviceId) {
        StringBuffer sb = new StringBuffer();

        sb.append("select adviceid, fromuserid, advicetype, advicesendtype, advicecontent, relationid, deleted, status, created_date, updated_date from t_advice");
        sb.append("' where adviceid = ").append(adviceId);

        return sb.toString();
    }

}
