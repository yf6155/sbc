CREATE TABLE `t_advicestatus` (
	`adviceid` INT(11) NOT NULL COMMENT '通知公告id',
	`touserid` INT(11) NOT NULL COMMENT '接收公告用户id',
	`fromuserid` INT(11) NULL DEFAULT NULL COMMENT '来源用户id',
	`status` CHAR(1) NOT NULL COMMENT '通知公告推送状态（0：未推送 1：已推送）' COLLATE 'utf8_general_ci',
	`ctimestamp` TIMESTAMP NOT NULL COMMENT '创建时间戳',
	`lastutimestamp` TIMESTAMP NULL DEFAULT NULL COMMENT '最后更新时间戳',
	PRIMARY KEY (`adviceid`, `touserid`) USING BTREE
)
COMMENT='通知公告状态表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
