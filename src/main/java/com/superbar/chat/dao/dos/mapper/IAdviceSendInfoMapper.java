package com.superbar.chat.dao.dos.mapper;

import com.superbar.chat.dao.dos.provider.AdviceSendInfoProvider;
import com.superbar.chat.dao.entity.AdviceSendInfo;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface IAdviceSendInfoMapper {

    /**
     * 查询接收用户的通知公告消息列表
     *
     * @param toUserId
     * @param status
     * @return
     */
    @SelectProvider(type = AdviceSendInfoProvider.class, method = "selectAdviceSendInfoList")
    @ResultType(AdviceSendInfo.class)
    public ArrayList<AdviceSendInfo> selectAdviceSendInfoList(Integer toUserId, String status);

}
