package com.superbar.chat.dao.dos.mapper;

import com.superbar.chat.dao.dos.provider.MessageProvider;
import com.superbar.chat.dao.entity.MessageEntity;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface IMessageMapper {
    /**
     * 通过主键查询消息
     *
     * @param msgId
     * @return
     */
    @SelectProvider(type = MessageProvider.class, method = "selectMessageEntityByKey")
    public MessageEntity selectMessageEntity(Integer msgId);

    /**
     * 通过接收用户id和状态查询消息列表
     *
     * @param userId
     * @param status
     * @return
     */
    @SelectProvider(type = MessageProvider.class, method = "selectMessageEntityList")
    @ResultType(MessageEntity.class)
    public ArrayList<MessageEntity> selectMessageEntityList(Integer userId, String status);

    /**
     * 消息入库
     *
     * @param messageEntity
     * @return
     */
    @InsertProvider(type = MessageProvider.class, method = "insertMessageEntity")
    @Options(keyProperty = "msgId", keyColumn = "msgId", useGeneratedKeys = true)
    public Integer insertMessageEntity(MessageEntity messageEntity);

    /**
     * 更新消息状态和最后更新时间戳
     *
     * @param messageEntity
     * @return
     */
    @UpdateProvider(type = MessageProvider.class, method = "updateMessageEntitySendInfoByKey")
    public Integer updateMessageEntitySendInfoByKey(MessageEntity messageEntity);

    /**
     * 更新消息
     *
     * @param messageEntity
     * @return
     */
    @UpdateProvider(type = MessageProvider.class, method = "updateMessageEntityByKey")
    public Integer updateMessageEntityByKey(MessageEntity messageEntity);

}
