package com.superbar.chat.dao.dos.provider;

/**
 * <p>Application Name : UserProvider </p>
 * <p>Application Description : 用户表SQL配置类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-23
 * @Version : v1.0
 */
public class UserProvider {

    public String selectAllUserList(Integer deleted) {
        StringBuffer sb = new StringBuffer();
        sb.append("select user_id userId from t_user where 1 = 1");
        sb.append(" and deleted = ").append(deleted);
        return sb.toString();
    }

    public String queryChatUserList(Integer userId) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT user_id userId, user_name userName, sns_name snsName, '' password, jm_username jmUserName, '' jmPassword, hx_username hxUserName, '' hxPassword, nick_name nickName, real_name realName, gender gender, age age, ");
        sb.append("birthdate birthDate, constellation constellation, user_icon userIcon, city city, hometown homeTown, personal_profile personalProfile, signature signature, industry industry, job job, is_approve isApprove, is_teacher isTeacher, marita_status maritaStatus, mobile mobile,");
        sb.append("email email, level level, integral integral, laugitude laugitude, latitude latitude, login_status loginStatus, login_date loginDate, registration_id registationId, activated activated, deleted deleted, created_date createdDate, updated_date updatedDate, politcs politcs,");
        sb.append("religions religions, educationSeq educationSeq, careerSeq careerSeq, isStudent isStudent, education education, profession profession, baseAuth baseAuth, eduAuth eduAuth, careerAuth careerAuth, eduInfo eduInfo, careerInfo careerInfo, currentInfo currentInfo,currentAuth currentAuth, school school");
        sb.append(" FROM t_user u WHERE EXISTS(SELECT 1 FROM t_msg m WHERE m.touserid = u.user_id AND m.fromuserid = #{userId})");
        sb.append(" UNION ");
        sb.append("SELECT user_id userId, user_name userName, sns_name snsName, '' password, jm_username jmUserName, '' jmPassword, hx_username hxUserName, '' hxPassword, nick_name nickName, real_name realName, gender gender, age age, ");
        sb.append("birthdate birthDate, constellation constellation, user_icon userIcon, city city, hometown homeTown, personal_profile personalProfile, signature signature, industry industry, job job, is_approve isApprove, is_teacher isTeacher, marita_status maritaStatus, mobile mobile,");
        sb.append("email email, level level, integral integral, laugitude laugitude, latitude latitude, login_status loginStatus, login_date loginDate, registration_id registationId, activated activated, deleted deleted, created_date createdDate, updated_date updatedDate, politcs politcs,");
        sb.append("religions religions, educationSeq educationSeq, careerSeq careerSeq, isStudent isStudent, education education, profession profession, baseAuth baseAuth, eduAuth eduAuth, careerAuth careerAuth, eduInfo eduInfo, careerInfo careerInfo, currentInfo currentInfo,currentAuth currentAuth, school school");
        sb.append(" FROM t_user u WHERE EXISTS(SELECT 1 FROM t_msg m WHERE m.fromuserid = u.user_id AND m.touserid = #{userId})");
        return sb.toString();
    }

    public String queryChatUserListByPage(Integer userId, Integer offset, Integer pageSize) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT user_id userId, user_name userName, sns_name snsName, '' password, jm_username jmUserName, '' jmPassword, hx_username hxUserName, '' hxPassword, nick_name nickName, real_name realName, gender gender, age age, ");
        sb.append("birthdate birthDate, constellation constellation, user_icon userIcon, city city, hometown homeTown, personal_profile personalProfile, signature signature, industry industry, job job, is_approve isApprove, is_teacher isTeacher, marita_status maritaStatus, mobile mobile,");
        sb.append("email email, level level, integral integral, laugitude laugitude, latitude latitude, login_status loginStatus, login_date loginDate, registration_id registationId, activated activated, deleted deleted, created_date createdDate, updated_date updatedDate, politcs politcs,");
        sb.append("religions religions, educationSeq educationSeq, careerSeq careerSeq, isStudent isStudent, education education, profession profession, baseAuth baseAuth, eduAuth eduAuth, careerAuth careerAuth, eduInfo eduInfo, careerInfo careerInfo, currentInfo currentInfo,currentAuth currentAuth, school school");
        sb.append(" FROM t_user u WHERE EXISTS(SELECT 1 FROM t_msg m WHERE m.touserid = u.user_id AND m.fromuserid = #{userId})");
        sb.append(" UNION ");
        sb.append("SELECT user_id userId, user_name userName, sns_name snsName, '' password, jm_username jmUserName, '' jmPassword, hx_username hxUserName, '' hxPassword, nick_name nickName, real_name realName, gender gender, age age, ");
        sb.append("birthdate birthDate, constellation constellation, user_icon userIcon, city city, hometown homeTown, personal_profile personalProfile, signature signature, industry industry, job job, is_approve isApprove, is_teacher isTeacher, marita_status maritaStatus, mobile mobile,");
        sb.append("email email, level level, integral integral, laugitude laugitude, latitude latitude, login_status loginStatus, login_date loginDate, registration_id registationId, activated activated, deleted deleted, created_date createdDate, updated_date updatedDate, politcs politcs,");
        sb.append("religions religions, educationSeq educationSeq, careerSeq careerSeq, isStudent isStudent, education education, profession profession, baseAuth baseAuth, eduAuth eduAuth, careerAuth careerAuth, eduInfo eduInfo, careerInfo careerInfo, currentInfo currentInfo,currentAuth currentAuth, school school");
        sb.append(" FROM t_user u WHERE EXISTS(SELECT 1 FROM t_msg m WHERE m.fromuserid = u.user_id AND m.touserid = #{userId})");
        sb.append(" LIMIT #{pageSize} OFFSET #{offset}");
        return sb.toString();
    }
}
