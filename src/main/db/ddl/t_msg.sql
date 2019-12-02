CREATE TABLE `t_msg` (
	`msgid` INT(11) NOT NULL AUTO_INCREMENT COMMENT '消息主键',
	`msgtype` VARCHAR(20) NOT NULL COMMENT '消息类型（对应MessageTypeEnum）' COLLATE 'utf8_general_ci',
	`contenttype` CHAR(1) NOT NULL COMMENT '消息内容类型（1：文本；2：图片）' COLLATE 'utf8_general_ci',
	`textmsg` MEDIUMTEXT NULL COMMENT '文本消息' COLLATE 'utf8_general_ci',
	`fromuserid` INT(11) NOT NULL COMMENT '消息发送用户',
	`touserid` INT(11) NULL DEFAULT NULL COMMENT '消息接收用户',
	`ctimestamp` TIMESTAMP NOT NULL COMMENT '消息创建时间戳',
	`status` CHAR(1) NOT NULL COMMENT '消息状态（0：未发送 2：已发送（在线实时发送） 3：已发送（离线暂存补发））' COLLATE 'utf8_general_ci',
	`lastutimestamp` TIMESTAMP NOT NULL COMMENT '消息最后修改时间戳',
	PRIMARY KEY (`msgid`) USING BTREE,
	INDEX `T_MSG_IDX_01` (`fromuserid`, `touserid`)
)
COMMENT='用户间聊天消息记录表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=6
;
