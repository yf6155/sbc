package com.superbar.chat.dao.dos.mapper;

import com.superbar.chat.dao.dos.provider.AdviceStatusProvider;
import com.superbar.chat.dao.entity.AdviceStatus;
import org.apache.ibatis.annotations.*;

public interface IAdviceStatusMapper {

    /**
     * 通知公告状态数据入库
     *
     * @param adviceStatus
     * @return
     */
    @InsertProvider(type = AdviceStatusProvider.class, method = "insertAdviceStatus")
    public Integer insertAdviceStatus(AdviceStatus adviceStatus);


    /**
     * 更新通知公告
     *
     * @param adviceStatus
     * @return
     */
    @UpdateProvider(type = AdviceStatusProvider.class, method = "updateAdviceStatusByKey")
    public Integer updateAdviceStatusByKey(AdviceStatus adviceStatus);


    /**
     * 删除通知公告状态表
     *
     * @param adviceStatus
     * @return
     */
    @DeleteProvider(type = AdviceStatusProvider.class, method = "deleteAdviceStatusByKey")
    public Integer deleteAdviceStatusByKey(AdviceStatus adviceStatus);

    /**
     * 通过主键查询通知公告状态
     *
     * @param adviceId
     * @return
     */
    @SelectProvider(type = AdviceStatusProvider.class, method = "selectAdviceStatus")
    @ResultType(AdviceStatus.class)
    public AdviceStatus selectAdviceStatus(Integer adviceId, Integer userId);

}
