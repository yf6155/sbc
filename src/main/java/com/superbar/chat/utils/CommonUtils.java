package com.superbar.chat.utils;

import org.springframework.util.StringUtils;

/**
 * <p>Application Name : CommonUtils </p>
 * <p>Application Description :  </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/25
 * @Version : v1.0
 */
public class CommonUtils {

    /**
     * 字符串转换为Integer
     *
     * @param inStr
     * @return
     */
    public static Integer formatStr2Int(String inStr) {
        if (StringUtils.isEmpty(inStr)) {
            return 0;
        } else {
            return Integer.valueOf(inStr);
        }
    }
}
