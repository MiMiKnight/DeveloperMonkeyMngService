#
/*
 Source Server Type    : MariaDB
 Source Schema         : db_monkey
 Target Server Type    : MariaDB
 Target Server Version : mariadb-10.9.2
 Database Encoding     : utf8mb4
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_moneky_content
-- ----------------------------
DROP TABLE IF EXISTS `t_moneky_content`;
CREATE TABLE `t_moneky_content`  (
                                     `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容ID',
                                     `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
                                     `version` int NOT NULL COMMENT '乐观锁 自增',
                                     `deleted` int NOT NULL DEFAULT 0 COMMENT '逻辑删除\r\n1：删除\r\n0：未删除',
                                     `create_time` datetime(3) NOT NULL COMMENT '创建时间 精确到毫秒',
                                     `update_time` datetime(3) NOT NULL COMMENT '更新时间 精确到毫秒',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
