CREATE TABLE `t_advice` (
	`adviceid` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`fromuserid` INT(11) NULL DEFAULT NULL COMMENT '通知公告来源用户',
	`advicetype` CHAR(1) NOT NULL COMMENT '通知公告类型（1：系统（公告）  2：无意义（预留） 3：导师申请消息（师生关系的申请跳转对方详情页） 4：动态消息（点赞，评论，@ 跳转相应的动态） 5：关注消息（跳转到我的关注列表）6：导师申请通过（跳转我的导师列表） 7：评论消息（回复，点赞，跳转到相应的评论） 8：回复消息（点赞，跳转到相应的回复））' COLLATE 'utf8mb4_general_ci',
	`advicesendtype` CHAR(1) NOT NULL COMMENT '通知公告发送类型（1：全体通知；2：单人通知）' COLLATE 'utf8mb4_general_ci',
	`advicecontent` MEDIUMTEXT NULL COMMENT '通知公告文本内容' COLLATE 'utf8mb4_general_ci',
	`relationid` INT(11) NULL DEFAULT NULL COMMENT '关联id',
	`deleted` INT(1) NULL DEFAULT NULL COMMENT '是否删除',
	`status` INT(1) NULL DEFAULT NULL COMMENT '读取状态（1：未读取 2：已读取）',
	`created_date` TIMESTAMP NOT NULL COMMENT '通知公告创建时间戳',
	`updated_date` TIMESTAMP NULL DEFAULT NULL COMMENT '通知公告最后更新时间戳',
	PRIMARY KEY (`adviceid`) USING BTREE
)
COMMENT='通知公告表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=10
;
