package com.superbar.chat.dao.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p>Application Name : User </p>
 * <p>Application Description : 用户实体类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-23
 * @Version : v1.0
 */
public class User {

    private Integer userId;

    private String userName;

    private String snsName;

    private String password;

    private String jmUserName;

    private String jmPassword;

    private String hxUserName;

    private String hxPassword;

    private String nickName;

    private String realName;

    private Integer gender;

    private Integer age;

    private Date birthDate;

    private String constellation;

    private String userIcon;

    private String city;

    private String homeTown;

    private String personalProfile;

    private String signature;

    private String industry;

    private String job;

    private Integer isApprove;

    private Integer isTeacher;

    private Integer maritaStatus;

    private String mobile;

    private String email;

    private String level;

    private Integer integral;

    private Double laugitude;

    private Double latitude;

    private Integer loginStatus;

    private Date loginDate;

    private String registationId;

    private Integer activated;

    private Integer deleted;

    private Date createdDate;

    private Timestamp updatedDate;

    private String politcs;

    private String religions;

    private Integer educationSeq;

    private Integer careerSeq;

    private Integer isStudent;

    private String education;

    private String profession;

    private Integer baseAuth;

    private Integer eduAuth;

    private Integer careerAuth;

    private String eduInfo;

    private String careerInfo;

    private String currentInfo;

    private Integer currentAuth;

    private String school;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSnsName() {
        return snsName;
    }

    public void setSnsName(String snsName) {
        this.snsName = snsName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJmUserName() {
        return jmUserName;
    }

    public void setJmUserName(String jmUserName) {
        this.jmUserName = jmUserName;
    }

    public String getJmPassword() {
        return jmPassword;
    }

    public void setJmPassword(String jmPassword) {
        this.jmPassword = jmPassword;
    }

    public String getHxUserName() {
        return hxUserName;
    }

    public void setHxUserName(String hxUserName) {
        this.hxUserName = hxUserName;
    }

    public String getHxPassword() {
        return hxPassword;
    }

    public void setHxPassword(String hxPassword) {
        this.hxPassword = hxPassword;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public Integer getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(Integer isTeacher) {
        this.isTeacher = isTeacher;
    }

    public Integer getMaritaStatus() {
        return maritaStatus;
    }

    public void setMaritaStatus(Integer maritaStatus) {
        this.maritaStatus = maritaStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Double getLaugitude() {
        return laugitude;
    }

    public void setLaugitude(Double laugitude) {
        this.laugitude = laugitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getRegistationId() {
        return registationId;
    }

    public void setRegistationId(String registationId) {
        this.registationId = registationId;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getPolitcs() {
        return politcs;
    }

    public void setPolitcs(String politcs) {
        this.politcs = politcs;
    }

    public String getReligions() {
        return religions;
    }

    public void setReligions(String religions) {
        this.religions = religions;
    }

    public Integer getEducationSeq() {
        return educationSeq;
    }

    public void setEducationSeq(Integer educationSeq) {
        this.educationSeq = educationSeq;
    }

    public Integer getCareerSeq() {
        return careerSeq;
    }

    public void setCareerSeq(Integer careerSeq) {
        this.careerSeq = careerSeq;
    }

    public Integer getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(Integer isStudent) {
        this.isStudent = isStudent;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getBaseAuth() {
        return baseAuth;
    }

    public void setBaseAuth(Integer baseAuth) {
        this.baseAuth = baseAuth;
    }

    public Integer getEduAuth() {
        return eduAuth;
    }

    public void setEduAuth(Integer eduAuth) {
        this.eduAuth = eduAuth;
    }

    public Integer getCareerAuth() {
        return careerAuth;
    }

    public void setCareerAuth(Integer careerAuth) {
        this.careerAuth = careerAuth;
    }

    public String getEduInfo() {
        return eduInfo;
    }

    public void setEduInfo(String eduInfo) {
        this.eduInfo = eduInfo;
    }

    public String getCareerInfo() {
        return careerInfo;
    }

    public void setCareerInfo(String careerInfo) {
        this.careerInfo = careerInfo;
    }

    public String getCurrentInfo() {
        return currentInfo;
    }

    public void setCurrentInfo(String currentInfo) {
        this.currentInfo = currentInfo;
    }

    public Integer getCurrentAuth() {
        return currentAuth;
    }

    public void setCurrentAuth(Integer currentAuth) {
        this.currentAuth = currentAuth;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", snsName='" + snsName + '\'' +
                ", password='" + password + '\'' +
                ", jmUserName='" + jmUserName + '\'' +
                ", jmPassword='" + jmPassword + '\'' +
                ", hxUserName='" + hxUserName + '\'' +
                ", hxPassword='" + hxPassword + '\'' +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", constellation='" + constellation + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", city='" + city + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", personalProfile='" + personalProfile + '\'' +
                ", signature='" + signature + '\'' +
                ", industry='" + industry + '\'' +
                ", job='" + job + '\'' +
                ", isApprove=" + isApprove +
                ", isTeacher=" + isTeacher +
                ", maritaStatus=" + maritaStatus +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", level='" + level + '\'' +
                ", integral=" + integral +
                ", laugitude=" + laugitude +
                ", latitude=" + latitude +
                ", loginStatus=" + loginStatus +
                ", loginDate=" + loginDate +
                ", registationId='" + registationId + '\'' +
                ", activated=" + activated +
                ", deleted=" + deleted +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", politcs='" + politcs + '\'' +
                ", religions='" + religions + '\'' +
                ", educationSeq=" + educationSeq +
                ", careerSeq=" + careerSeq +
                ", isStudent=" + isStudent +
                ", education='" + education + '\'' +
                ", profession='" + profession + '\'' +
                ", baseAuth=" + baseAuth +
                ", eduAuth=" + eduAuth +
                ", careerAuth=" + careerAuth +
                ", eduInfo='" + eduInfo + '\'' +
                ", careerInfo='" + careerInfo + '\'' +
                ", currentInfo='" + currentInfo + '\'' +
                ", currentAuth=" + currentAuth +
                ", school='" + school + '\'' +
                '}';
    }
}
