package com.superbar.chat.controller.eny;

/**
 * <p>Application Name : ControllerResponse </p>
 * <p>Application Description : 控制层响应结构类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/24
 * @Version : v1.0
 */
public class ControllerResponse {

    /**
     * 0：成功  1：未知  2：失败
     */
    private Integer resCode;

    /**
     * 除resCode=0外，其他应resCode应给resMessage赋异常提示小心
     */
    private String resMessage;

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

    public Object getResObject() {
        return resObject;
    }

    public void setResObject(Object resObject) {
        this.resObject = resObject;
    }

    @Override
    public String toString() {
        return "ControllerResponse{" +
                "resCode=" + resCode +
                ", resMessage='" + resMessage + '\'' +
                ", resObject=" + resObject +
                '}';
    }
}
