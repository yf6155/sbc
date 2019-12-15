package com.superbar.chat.controller.eny;

/**
 * <p>Application Name : QueryResultResponse </p>
 * <p>Application Description : 查询结果集响应类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/12/15
 * @Version : v1.0
 */
public class QueryResultResponse {

    /**
     * 0：成功  1：未知  2：失败
     */
    private Integer resCode;

    /**
     * 除resCode=0外，其他应resCode应给resMessage赋异常提示小心
     */
    private String resMessage;

    /**
     * 查询结果集总条数
     */
    private Integer totalCnt;

    /**
     * 返回对象，按需要组装
     */
    private Object resObject;

    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public Object getResObject() {
        return resObject;
    }

    public void setResObject(Object resObject) {
        this.resObject = resObject;
    }

    @Override
    public String toString() {
        return "QueryResultResponse{" +
                "resCode=" + resCode +
                ", resMessage='" + resMessage + '\'' +
                ", totalCnt=" + totalCnt +
                ", resObject=" + resObject +
                '}';
    }
}
