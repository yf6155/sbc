package com.superbar.chat.exception;

/**
 * <p>Application Name : DataBaseException </p>
 * <p>Application Description : 数据库异常 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/29
 * @Version : v1.0
 */
public class DataBaseException extends RuntimeException {

    public DataBaseException() {
        super();
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }

    public DataBaseException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
