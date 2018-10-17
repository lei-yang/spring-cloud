-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.23-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 wechat 的数据库结构
CREATE DATABASE IF NOT EXISTS `wechat` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `wechat`;

-- 导出  表 wechat.wx_user_info 结构
CREATE TABLE IF NOT EXISTS `wx_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `subscribe` tinyint(4) DEFAULT NULL COMMENT '是否订阅该公众号标识 0:用户没有关注该公众号，拉取不到其余信息',
  `openid` varchar(50) DEFAULT NULL COMMENT '标识对当前公众号唯一',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别描述信息：1:男 2:女 0:未知等',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `country` varchar(50) DEFAULT NULL COMMENT '国家',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `language` varchar(50) DEFAULT NULL COMMENT '用户的语言',
  `head_img_url` varchar(50) DEFAULT NULL COMMENT '头像',
  `subscribe_time` int(11) DEFAULT NULL COMMENT '关注时间,多次关注,则取最后关注时间',
  `unionId` varchar(50) DEFAULT NULL COMMENT '将公众号绑定到微信开放平台帐号',
  `remark` varchar(50) DEFAULT NULL COMMENT '运营者对粉丝的备注',
  `groupid` int(11) DEFAULT NULL COMMENT '用户所在的分组ID',
  `tagid_list` varchar(50) DEFAULT NULL COMMENT '标签ID列表',
  `subscribe_scene` varchar(50) DEFAULT NULL COMMENT '关注的渠道来源',
  `qr_scene` varchar(50) DEFAULT NULL COMMENT '扫码场景',
  `qr_scene_str` varchar(50) DEFAULT NULL COMMENT '扫码场景描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信用户信息表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
