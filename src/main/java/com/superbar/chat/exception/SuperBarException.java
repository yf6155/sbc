package com.superbar.chat.exception;

import java.io.Serializable;

/**
 * <p>Application Name : SuperBarException </p>
 * <p>Application Description : 异常最终统一包装处理类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/24
 * @Version : v1.0
 */
public class SuperBarException extends DataBaseException {

    public SuperBarException() {
        super();
    }

    public SuperBarException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuperBarException(Throwable cause) {
        super(cause);
    }

    public SuperBarException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
