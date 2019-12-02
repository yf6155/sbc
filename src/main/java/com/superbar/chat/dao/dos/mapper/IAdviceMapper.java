package com.superbar.chat.dao.dos.mapper;

import com.superbar.chat.dao.dos.provider.AdviceProvider;
import com.superbar.chat.dao.entity.Advice;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface IAdviceMapper {

    /**
     * 通知公告入库
     *
     * @param advice
     * @return
     */
    @InsertProvider(type = AdviceProvider.class, method = "insertAdvice")
    @Options(keyProperty = "adviceId", keyColumn = "adviceId", useGeneratedKeys = true)
    public Integer insertAdvice(Advice advice);


    /**
     * 更新通知公告
     *
     * @param advice
     * @return
     */
    @UpdateProvider(type = AdviceProvider.class, method = "updateAdviceByKey")
    public Integer updateAdviceByKey(Advice advice);


    /**
     * 删除通知公告
     *
     * @param advice
     * @return
     */
    @DeleteProvider(type = AdviceProvider.class, method = "deleteAdviceByKey")
    public Integer deleteAdviceByKey(Advice advice);

    /**
     * 通过主键查询公告
     *
     * @param adviceId
     * @return
     */
    @SelectProvider(type = AdviceProvider.class, method = "selectAdvice")
    @ResultType(Advice.class)
    public Advice selectAdvice(Integer adviceId);

}
