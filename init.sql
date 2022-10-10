/*
 Navicat Premium Data Transfer

 Source Server         : mysql_my
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : competition

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 09/10/2022 17:41:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_dic
-- ----------------------------
DROP TABLE IF EXISTS `base_dic`;
CREATE TABLE `base_dic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `value` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `text` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典含义',
  `enName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典类型英文名',
  `chName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典类型中文含义',
  `sort` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1347431955632984081 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_dic
-- ----------------------------
INSERT INTO `base_dic` VALUES (1, '1', '数据采集', 'plan_type', '作业类型', 0);
INSERT INTO `base_dic` VALUES (2, '2', '打草', 'plan_type', '作业类型', 1);
INSERT INTO `base_dic` VALUES (3, '3', '喷药', 'plan_type', '作业类型', 2);
INSERT INTO `base_dic` VALUES (4, '4', '采摘', 'plan_type', '作业类型', 3);
INSERT INTO `base_dic` VALUES (5, '1', 'geojson', 'layer_type', '图层类型', 0);
INSERT INTO `base_dic` VALUES (6, '2', 'png/jpg', 'layer_type', '图层类型', 1);
INSERT INTO `base_dic` VALUES (7, 'online', '已上线', 'car_status', '车状态', 0);
INSERT INTO `base_dic` VALUES (8, 'offline', '未上线', 'car_status', '车状态', 1);
INSERT INTO `base_dic` VALUES (9, 'working', '作业中', 'car_status', '车状态', 2);
INSERT INTO `base_dic` VALUES (10, 'routing', '路线生成中', 'car_status', '车状态', 3);
INSERT INTO `base_dic` VALUES (11, 'sys_update', '系统升级', 'notice_type', '公告类型', 0);
INSERT INTO `base_dic` VALUES (100, NULL, NULL, 'test_demo', '测试', 1);
INSERT INTO `base_dic` VALUES (130, 'sys_notice', '系统公告', 'message_type', '消息类型', 0);
INSERT INTO `base_dic` VALUES (131, 'car_maintain', '车辆维保', 'message_type', '消息类型', 1);
INSERT INTO `base_dic` VALUES (1347431955632984066, '测试12', '测试12', 'test12', '测试12', 1610087786956);
INSERT INTO `base_dic` VALUES (1347431955632984067, 'w1', '加水', 'home_type', '返场类型', NULL);
INSERT INTO `base_dic` VALUES (1347431955632984068, 'p1', '回家', 'home_type', '返场类型', NULL);
INSERT INTO `base_dic` VALUES (1347431955632984069, 'e1', '充电', 'home_type', '返场类型', NULL);
INSERT INTO `base_dic` VALUES (1347431955632984070, 'o1', '加油', 'home_type', '返场类型', NULL);
INSERT INTO `base_dic` VALUES (1347431955632984071, '03ad5ded-1c78-4f4f-8d45-edbbc1405df5', '高地隙', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984072, '0b85fb5f-aa4f-4a61-9a43-a1165c877593', 'T002', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984073, '2c685b1e-1b76-4ae4-9abc-b3504003f1b6', 'sxnd002', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984074, '392af8df-9754-4234-a6fb-c07fe8f36c82', '测试小车', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984075, '5d7a333d-9fdf-4227-96e1-0085b77412d5', 'sim_car1', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984076, '7922b730-a58a-44ff-a3c4-40aa547eda8c', 'H002', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984077, '8696c085-9182-44fe-94e2-0b74999e5f89', 'TX2', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984078, 'b3f607a1-0299-4556-b55d-75b10152b230', '电子研发测试', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984079, 'eb9c45a3-48ba-4875-b8f1-2eedccf74236', 'test_car', 'cars_test1', 'test1的车列表', 0);
INSERT INTO `base_dic` VALUES (1347431955632984080, 'bec102db-c9dd-44b5-9ae4-7862407bd557', '1000PT21B001', 'cars_test1', 'test1的车列表', 0);

-- ----------------------------
-- Table structure for base_error_log
-- ----------------------------
DROP TABLE IF EXISTS `base_error_log`;
CREATE TABLE `base_error_log`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `method` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提交方式',
  `url` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `errorCode` int(11) NULL DEFAULT NULL COMMENT '错误码',
  `errorMsg` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `clientId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端ID',
  `loginUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `params` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `sort` bigint(20) NULL DEFAULT 0 COMMENT '排序值',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '异常表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_error_log
-- ----------------------------

-- ----------------------------
-- Table structure for base_login_log
-- ----------------------------
DROP TABLE IF EXISTS `base_login_log`;
CREATE TABLE `base_login_log`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `clientId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端ID',
  `operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `operatorTime` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `sort` bigint(20) NULL DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for base_query
-- ----------------------------
DROP TABLE IF EXISTS `base_query`;
CREATE TABLE `base_query`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `business` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '业务类型',
  `support` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支持字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '查询关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_query
-- ----------------------------
INSERT INTO `base_query` VALUES (1, 'roles', 'enName');
INSERT INTO `base_query` VALUES (2, 'roles', 'chName');
INSERT INTO `base_query` VALUES (3, 'car', 'name');
INSERT INTO `base_query` VALUES (4, 'car', 'license');
INSERT INTO `base_query` VALUES (5, 'car', 'statuSense');
INSERT INTO `base_query` VALUES (7, 'user', 'name');
INSERT INTO `base_query` VALUES (8, 'user', 'username');
INSERT INTO `base_query` VALUES (9, 'publishLog', 'topic');
INSERT INTO `base_query` VALUES (10, 'publishLog', 'msg');
INSERT INTO `base_query` VALUES (11, 'farm', 'farmCode');
INSERT INTO `base_query` VALUES (12, 'farm', 'name');
INSERT INTO `base_query` VALUES (13, 'plan', 'name');
INSERT INTO `base_query` VALUES (14, 'instruction', 'code');
INSERT INTO `base_query` VALUES (15, 'instruction', 'workType');
INSERT INTO `base_query` VALUES (16, 'instruction', 'planName');
INSERT INTO `base_query` VALUES (17, 'instruction', 'carLicense');
INSERT INTO `base_query` VALUES (18, 'instruction', 'carName');
INSERT INTO `base_query` VALUES (19, 'msgCenter', 'carLicense');
INSERT INTO `base_query` VALUES (20, 'msgCenter', 'carName');
INSERT INTO `base_query` VALUES (21, 'carDynamic', 'license');
INSERT INTO `base_query` VALUES (22, 'carDynamic', 'carName');
INSERT INTO `base_query` VALUES (23, 'dic', 'text');
INSERT INTO `base_query` VALUES (24, 'dic', 'enName');
INSERT INTO `base_query` VALUES (25, 'dic', 'chName');
INSERT INTO `base_query` VALUES (26, 'errorLog', 'errorCode');
INSERT INTO `base_query` VALUES (27, 'errorLog', 'errorMsg');
INSERT INTO `base_query` VALUES (28, 'loginLog', 'clientId');
INSERT INTO `base_query` VALUES (29, 'loginLog', 'operator');
INSERT INTO `base_query` VALUES (30, 'notice', 'title');
INSERT INTO `base_query` VALUES (31, 'notice', 'content');
INSERT INTO `base_query` VALUES (32, 'message', 'title');
INSERT INTO `base_query` VALUES (33, 'message', 'content');

-- ----------------------------
-- Table structure for sys_files
-- ----------------------------
DROP TABLE IF EXISTS `sys_files`;
CREATE TABLE `sys_files`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `modules` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '功能模块',
  `fileId` bigint(20) NULL DEFAULT NULL COMMENT '文件id 用于多对一分组',
  `fileName` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件名字',
  `filePath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件地址',
  `sort` bigint(20) NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '文件信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_files
-- ----------------------------
INSERT INTO `sys_files` VALUES (164757631842174, 'apk', 0, '新正式.apk', '/tmp/upload/apk/20220318/新正式.apk', 1647576318421, '2022-03-18 12:05:18', '姚新帅');
INSERT INTO `sys_files` VALUES (16492287072181495, 'apk', 0, 'webull.apk', '/tmp/upload/apk/20220406/webull.apk', 1649228707218, '2022-04-06 15:05:07', '姚新帅');
INSERT INTO `sys_files` VALUES (16492300426106748, 'apk', 0, '新正式.apk', '/tmp/upload/apk/20220406/新正式.apk', 1649230042610, '2022-04-06 15:27:23', '姚新帅');
INSERT INTO `sys_files` VALUES (1339842836111167490, '/apk', 1608278399845, 'new-test-remote.apk', '/tmp/upload/apk/new-test-remote.apk', 1608278399864, '2020-12-18 02:00:00', '董修辰');
INSERT INTO `sys_files` VALUES (1339844159330193410, '/apk', 1608278715341, 'webull.apk', '/tmp/upload/apk/webull.apk', 1608278715342, '2020-12-18 02:05:15', '董修辰');
INSERT INTO `sys_files` VALUES (1339849939303424002, 'apk', 0, 'new-test-remote.apk', '/tmp/upload/apk/20201218/new-test-remote.apk', 1608280093397, '2020-12-18 02:28:13', '董修辰');
INSERT INTO `sys_files` VALUES (1341903407958695937, 'apk', 0, 'webull.apk', '/tmp/upload/apk/20201224/webull.apk', 1608769678475, '2020-12-23 18:27:58', '董修辰');
INSERT INTO `sys_files` VALUES (1348881701560000514, 'apk', 0, 'new-test-remote.apk', '/tmp/upload/apk/20210112/new-test-remote.apk', 1610433433319, '2021-01-12 00:37:13', '董修辰');
INSERT INTO `sys_files` VALUES (1348884548322209793, 'apk', 0, 'new-test-remote.apk', '/tmp/upload/apk/20210112/new-test-remote.apk', 1610434112041, '2021-01-12 00:48:32', '董修辰');
INSERT INTO `sys_files` VALUES (1348884666890989570, 'apk', 0, 'new-test-remote.apk', '/tmp/upload/apk/20210112/new-test-remote.apk', 1610434140309, '2021-01-12 00:49:00', '董修辰');
INSERT INTO `sys_files` VALUES (1348884958768410625, 'apk', 0, 'webull.apk', '/tmp/upload/apk/20210112/webull.apk', 1610434209899, '2021-01-12 00:50:10', '董修辰');
INSERT INTO `sys_files` VALUES (1348885786870820865, 'apk', 0, 'new-apk.apk', '/tmp/upload/apk/20210112/new-apk.apk', 1610434407334, '2021-01-12 00:53:27', '董修辰');
INSERT INTO `sys_files` VALUES (1348885974830166017, 'apk', 0, 'new-test-remote.apk', '/tmp/upload/apk/20210112/new-test-remote.apk', 1610434452148, '2021-01-12 00:54:12', '董修辰');
INSERT INTO `sys_files` VALUES (1373811101757607938, 'apk', 0, 'test2.apk', '/tmp/upload/apk/20210322/test2.apk', 1616377065493, '2021-03-21 20:37:45', '唐彦胜');
INSERT INTO `sys_files` VALUES (1373894848905482242, 'apk', 0, 'test2.apk', '/tmp/upload/apk/20210322/test2.apk', 1616397032368, '2021-03-22 02:10:32', '唐彦胜');

-- ----------------------------
-- Table structure for sys_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_menus`;
CREATE TABLE `sys_menus`  (
  `menuId` bigint(20) NOT NULL COMMENT '菜单ID',
  `menuName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单名',
  `url` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路径',
  `icon` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片',
  `parentId` bigint(20) NULL DEFAULT NULL COMMENT '父菜单',
  `parentName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '父菜单',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单类型',
  `perms` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否启用',
  `sort` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`menuId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menus
-- ----------------------------
INSERT INTO `sys_menus` VALUES (10, '系统监控', NULL, 'mdi-monitor', NULL, NULL, '0', 'monitor', '启用', 98);
INSERT INTO `sys_menus` VALUES (1606108916347, '系统管理', NULL, 'mdi-cog', NULL, NULL, '0', 'settings', '启用', 99);
INSERT INTO `sys_menus` VALUES (1606108916348, '地图管理', NULL, 'mdi-map', NULL, NULL, '0', 'map', '启用', 98);
INSERT INTO `sys_menus` VALUES (1606108916349, '作业管理', NULL, 'mdi-play', NULL, NULL, '0', 'execution', '启用', 98);
INSERT INTO `sys_menus` VALUES (1606109916162, '菜单管理', '/menu', 'mdi-playlist-edit', 1606108916347, '系统管理', '1', 'sys:menus:list', '启用', 0);
INSERT INTO `sys_menus` VALUES (1606110019888, '查看', NULL, NULL, 1606109916162, '菜单管理', '2', 'sys:menus:info', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606110022592, '新增', NULL, NULL, 1606109916162, '菜单管理', '2', 'sys:menus:save', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606110024758, '修改', NULL, NULL, 1606109916162, '菜单管理', '2', 'sys:menus:update', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606110026770, '删除', NULL, '1', 1606109916162, '菜单管理', '2', 'sys:menus:delete', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606110215948, '用户管理', '/user', 'mdi-account-cog-outline', 1606108916347, '系统管理', '1', 'sys:user:list', '启用', 1);
INSERT INTO `sys_menus` VALUES (1606110341358, '查看', NULL, NULL, 1606110215948, '用户管理', '2', 'sys:user:info', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606110341402, '新增', NULL, NULL, 1606110215948, '用户管理', '2', 'sys:user:save', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606110341434, '修改', NULL, NULL, 1606110215948, '用户管理', '2', 'sys:user:update', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606110341464, '删除', NULL, NULL, 1606110215948, '用户管理', '2', 'sys:user:delete', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606371334082, '农场配置', '/farm', 'mdi-map-outline', 1606108916348, NULL, '1', 'fms:farm:list', '启用', 0);
INSERT INTO `sys_menus` VALUES (1606371361318, '查看', NULL, NULL, 1606371334082, '农场表', '2', 'fms:farm:info', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606371361345, '新增', NULL, NULL, 1606371334082, '农场表', '2', 'fms:farm:save', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606371361366, '修改', NULL, NULL, 1606371334082, '农场表', '2', 'fms:farm:update', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1606371361389, '删除', NULL, NULL, 1606371334082, '农场表', '2', 'fms:farm:delete', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607150211985, '车辆管理', '/car', 'mdi-car-cog', 1606108916349, '作业管理', '1', 'fms:car:list', '启用', 0);
INSERT INTO `sys_menus` VALUES (1607150232034, '查看', NULL, NULL, 1607150211985, '车辆管理', '2', 'fms:car:info', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607150232055, '新增', NULL, NULL, 1607150211985, '车辆管理', '2', 'fms:car:save', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607150232076, '修改', NULL, NULL, 1607150211985, '车辆管理', '2', 'fms:car:update', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607150232097, '删除', NULL, NULL, 1607150211985, '车辆管理', '2', 'fms:car:delete', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607654959579, '作业计划', '/plan', 'mdi-vector-polyline-edit', 1606108916349, '作业管理', '1', 'fms:plan:list', '启用', 0);
INSERT INTO `sys_menus` VALUES (1607654987555, '查看', NULL, NULL, 1607654959579, '作业计划', '2', 'fms:plan:info', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607654987585, '新增', NULL, NULL, 1607654959579, '作业计划', '2', 'fms:plan:save', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607654987611, '修改', NULL, NULL, 1607654959579, '作业计划', '2', 'fms:plan:update', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607654987635, '删除', NULL, NULL, 1607654959579, '作业计划', '2', 'fms:plan:delete', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607752934035, '指令列表', '/instruction', 'mdi-format-list-checkbox', 1606108916349, '作业管理', '1', 'fms:instruction:list', '启用', 0);
INSERT INTO `sys_menus` VALUES (1607752974228, '查看', NULL, NULL, 1607752934035, '指令列表', '2', 'fms:instruction:info', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607752974265, '新增', NULL, NULL, 1607752934035, '指令列表', '2', 'fms:instruction:save', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607752974297, '修改', NULL, NULL, 1607752934035, '指令列表', '2', 'fms:instruction:update', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1607752974324, '删除', NULL, NULL, 1607752934035, '指令列表', '2', 'fms:instruction:delete', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1608088050343, '车辆动态', '/car-activity', 'mdi-car-traction-control', 1606108916349, '作业管理', '1', 'fms:cardynamic:list', '启用', 0);
INSERT INTO `sys_menus` VALUES (1608101539612, '消息中心', '/message-center', 'mdi-message-text-outline', 1606108916349, '作业管理', '1', 'fms:msgcenter:list', '启用', 0);
INSERT INTO `sys_menus` VALUES (1608110856845, 'APP上传', '/app-upload', 'mdi-cloud-upload-outline', 1606108916347, '作业管理', '1', 'app:upload', '启用', 1);
INSERT INTO `sys_menus` VALUES (1608110856846, 'APP下载', '/app-download', 'mdi-cloud-download-outline', 1606108916347, '系统管理', '1', 'app:download', '启用', 1);
INSERT INTO `sys_menus` VALUES (1608877877551, '新增', NULL, NULL, 1339022668158201860, '角色管理', '2', 'sysroles:save', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1608877877593, '修改', NULL, NULL, 1339022668158201860, '角色管理', '2', 'sysroles:update', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1608877877634, '删除', NULL, NULL, 1339022668158201860, '角色管理', '2', 'sysroles:delete', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1608877877669, '菜单配置', NULL, NULL, 1339022668158201860, '角色管理', '2', 'sysroles:configmenus', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1608877877720, '农场车辆配置', NULL, NULL, 1339022668158201860, '角色管理', '2', 'sysroles:configframcar', '启用', NULL);
INSERT INTO `sys_menus` VALUES (1339022668158201857, '111', '111', '111', 0, '111', '111', '111', '', 1608082856584);
INSERT INTO `sys_menus` VALUES (1339022668158201860, '角色管理', '/role', 'mdi-shield-account-outline', 1606108916347, '系统管理', '1', 'sys:role', '启用', 1);
INSERT INTO `sys_menus` VALUES (1339022668158201861, '历史发布', '/publish-log', 'mdi-history', 10, '系统监控', '1', 'fms:publishLog', '启用', 1);
INSERT INTO `sys_menus` VALUES (1345901470272352258, '测试', '/test', 'fa fa-car', NULL, '系统监控', '1', 'sys', NULL, 1609722890811);
INSERT INTO `sys_menus` VALUES (1345901856026685441, '测试', '/test', 'fa fa-car', NULL, '系统管理', '1', 'sys:test:add', NULL, 1609722982782);
INSERT INTO `sys_menus` VALUES (1345902436686131202, 'asdasd', 'asddsadas', 'adasd', NULL, '系统管理', '1', 'asdsad', NULL, 1609723121222);
INSERT INTO `sys_menus` VALUES (1345902862986801154, 'sadasd', 'asdasd', 'asdsad', NULL, '系统管理', '1', 'asdasd', NULL, 1609723222859);
INSERT INTO `sys_menus` VALUES (1345906773818855425, '1212', '1212', '121', NULL, '系统管理', '1', '1212', NULL, 1609724155275);
INSERT INTO `sys_menus` VALUES (1345969104217063426, '测试内容', NULL, 'fa fa-home', 1339022578525925377, NULL, '1', 'sys:test:add1', '启用', 1609739015999);
INSERT INTO `sys_menus` VALUES (1345969294852374529, '测试1', NULL, 'fa fa-menu', NULL, NULL, '1', 'sys:test:add2', '启用', 1609739061450);
INSERT INTO `sys_menus` VALUES (1345969472242073602, '测试23', NULL, 'fa fa-menu', 1339022578525925377, NULL, '1', 'sys:menu:add', '启用', 1609739103743);
INSERT INTO `sys_menus` VALUES (1347363524065763329, '异常日志', '/error-log', 'mdi-bug', 10, NULL, '1', 'sys:error:get', '启用', 1610071471598);
INSERT INTO `sys_menus` VALUES (1347372537138634754, '登录日志', '/login-log', 'mdi-account-network', 10, NULL, '1', 'sys:log:watch', '启用', 1610073620483);
INSERT INTO `sys_menus` VALUES (1347424159831134209, '字典管理', '/dictionary', 'mdi-view-list-outline', 10, NULL, '1', 'sys:dic:watch', '启用', 1610085928292);
INSERT INTO `sys_menus` VALUES (1349163016654131201, '农场管理', '/farm-map', 'mdi-google-maps', NULL, NULL, '1', 'fms:farm:list', '启用', 1610500504064);
INSERT INTO `sys_menus` VALUES (1349163825974448130, '农场管理', '/farm-map', 'mdi-google-maps', 1606108916348, NULL, '1', 'fms:farm:list', '启用', 1610500697022);
INSERT INTO `sys_menus` VALUES (1356410988487909378, '农地作业', '/production', 'mdi-tractor', 1606108916349, NULL, '1', 'production', '启用', 1612228555211);
INSERT INTO `sys_menus` VALUES (1366286029145989121, '系统公告', '/notice', 'mdi-message-cog-outline', 1606108916347, NULL, '1', 'sys:notice', '启用', 1614582948372);
INSERT INTO `sys_menus` VALUES (1367007392105164801, '车辆参数', '/car-params', 'mdi-slot-machine', 1606108916347, NULL, '1', 'fms:car:list', '启用', 1614754934704);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色英文名',
  `roleName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色名',
  `menuId` bigint(20) NULL DEFAULT NULL COMMENT '菜单id',
  `menuName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2075 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (56, 'aaax', 'vbbbx', 10, '系统监控');
INSERT INTO `sys_role_menu` VALUES (57, 'aaax', 'vbbbx', 1339022668158201861, '历史发布');
INSERT INTO `sys_role_menu` VALUES (58, 'aaax', 'vbbbx', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (59, 'aaax', 'vbbbx', 1606371334082, '农场配置');
INSERT INTO `sys_role_menu` VALUES (60, 'aaax', 'vbbbx', 1606371361345, '新增');
INSERT INTO `sys_role_menu` VALUES (61, 'aaax', 'vbbbx', 1606371361318, '查看');
INSERT INTO `sys_role_menu` VALUES (473, 'webull_carpoint_group', '悟牛车端', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (474, 'webull_carpoint_group', '悟牛车端', 1608101539613, '作业执行');
INSERT INTO `sys_role_menu` VALUES (475, 'webull_carpoint_group', '悟牛车端', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (476, 'webull_carpoint_group', '悟牛车端', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (477, 'webull_carpoint_group', '悟牛车端', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (478, 'webull_carpoint_group', '悟牛车端', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (479, 'webull_carpoint_group', '悟牛车端', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (480, 'webull_carpoint_group', '悟牛车端', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (481, 'webull_carpoint_group', '悟牛车端', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (482, 'webull_carpoint_group', '悟牛车端', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (483, 'webull_carpoint_group', '悟牛车端', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (484, 'webull_carpoint_group', '悟牛车端', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (485, 'webull_carpoint_group', '悟牛车端', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (486, 'webull_carpoint_group', '悟牛车端', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (487, 'webull_carpoint_group', '悟牛车端', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (488, 'webull_carpoint_group', '悟牛车端', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (489, 'webull_carpoint_group', '悟牛车端', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (490, 'webull_carpoint_group', '悟牛车端', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (491, 'webull_carpoint_group', '悟牛车端', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (492, 'webull_carpoint_group', '悟牛车端', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (493, 'webull_carpoint_group', '悟牛车端', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (494, 'webull_carpoint_group', '悟牛车端', 1606371334082, '农场配置');
INSERT INTO `sys_role_menu` VALUES (495, 'webull_carpoint_group', '悟牛车端', 1606371361366, '修改');
INSERT INTO `sys_role_menu` VALUES (496, 'webull_carpoint_group', '悟牛车端', 1606371361389, '删除');
INSERT INTO `sys_role_menu` VALUES (497, 'webull_carpoint_group', '悟牛车端', 1606371361345, '新增');
INSERT INTO `sys_role_menu` VALUES (498, 'webull_carpoint_group', '悟牛车端', 1606371361318, '查看');
INSERT INTO `sys_role_menu` VALUES (499, 'webull_carpoint_group', '悟牛车端', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (500, 'webull_carpoint_group', '悟牛车端', 10, '系统监控');
INSERT INTO `sys_role_menu` VALUES (501, 'webull_carpoint_group', '悟牛车端', 1339022668158201861, '历史发布');
INSERT INTO `sys_role_menu` VALUES (502, 'webull_carpoint_group', '悟牛车端', 1347363524065763329, '异常日志');
INSERT INTO `sys_role_menu` VALUES (503, 'webull_carpoint_group', '悟牛车端', 1347372537138634754, '登录日志');
INSERT INTO `sys_role_menu` VALUES (504, 'webull_carpoint_group', '悟牛车端', 1347424159831134209, '字典管理');
INSERT INTO `sys_role_menu` VALUES (505, 'developer', '开发组', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (506, 'developer', '开发组', 1608101539613, '作业执行');
INSERT INTO `sys_role_menu` VALUES (507, 'developer', '开发组', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (508, 'developer', '开发组', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (509, 'developer', '开发组', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (510, 'developer', '开发组', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (511, 'developer', '开发组', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (512, 'developer', '开发组', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (513, 'developer', '开发组', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (514, 'developer', '开发组', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (515, 'developer', '开发组', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (516, 'developer', '开发组', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (517, 'developer', '开发组', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (518, 'developer', '开发组', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (519, 'developer', '开发组', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (520, 'developer', '开发组', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (521, 'developer', '开发组', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (522, 'developer', '开发组', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (523, 'developer', '开发组', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (524, 'developer', '开发组', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (525, 'developer', '开发组', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (526, 'developer', '开发组', 1367007392105164801, '车辆参数');
INSERT INTO `sys_role_menu` VALUES (737, 'vendor_sht', '三合通', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (738, 'vendor_sht', '三合通', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (739, 'vendor_sht', '三合通', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (740, 'vendor_sht', '三合通', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (741, 'vendor_sht', '三合通', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (742, 'vendor_sht', '三合通', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (743, 'vendor_sht', '三合通', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (744, 'vendor_sht', '三合通', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (745, 'vendor_sht', '三合通', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (746, 'vendor_sht', '三合通', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (747, 'vendor_sht', '三合通', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (748, 'vendor_sht', '三合通', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (749, 'vendor_sht', '三合通', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (750, 'vendor_sht', '三合通', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (751, 'vendor_sht', '三合通', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (752, 'vendor_sht', '三合通', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (753, 'vendor_sht', '三合通', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (754, 'vendor_sht', '三合通', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (755, 'vendor_sht', '三合通', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (756, 'vendor_sht', '三合通', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (757, 'vendor_sht', '三合通', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (915, 'vendor_sanht', '三合通', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (916, 'vendor_sanht', '三合通', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (917, 'vendor_sanht', '三合通', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (918, 'vendor_sanht', '三合通', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (919, 'vendor_sanht', '三合通', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (920, 'vendor_sanht', '三合通', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (921, 'vendor_sanht', '三合通', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (922, 'vendor_sanht', '三合通', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (923, 'vendor_sanht', '三合通', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (924, 'vendor_sanht', '三合通', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (925, 'vendor_sanht', '三合通', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (926, 'vendor_sanht', '三合通', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (927, 'vendor_sanht', '三合通', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (928, 'vendor_sanht', '三合通', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (929, 'vendor_sanht', '三合通', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (930, 'vendor_sanht', '三合通', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (931, 'vendor_sanht', '三合通', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (932, 'vendor_sanht', '三合通', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (933, 'vendor_sanht', '三合通', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (934, 'vendor_sanht', '三合通', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (935, 'vendor_sanht', '三合通', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (936, '张三', '李四', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (937, '张三', '李四', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (938, '张三', '李四', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (939, '张三', '李四', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (940, '张三', '李四', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (941, '张三', '李四', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (942, '张三', '李四', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (943, '张三', '李四', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (944, '张三', '李四', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (945, '张三', '李四', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (946, '张三', '李四', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (947, '张三', '李四', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (948, '张三', '李四', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (949, '张三', '李四', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (950, '张三', '李四', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (951, '张三', '李四', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (952, '张三', '李四', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (953, '张三', '李四', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (954, '张三', '李四', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (955, '张三', '李四', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (956, '张三', '李四', 1606371334082, '农场配置');
INSERT INTO `sys_role_menu` VALUES (957, '张三', '李四', 1606371361366, '修改');
INSERT INTO `sys_role_menu` VALUES (958, '张三', '李四', 1606371361389, '删除');
INSERT INTO `sys_role_menu` VALUES (959, '张三', '李四', 1606371361345, '新增');
INSERT INTO `sys_role_menu` VALUES (960, '张三', '李四', 1606371361318, '查看');
INSERT INTO `sys_role_menu` VALUES (961, '张三', '李四', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (962, '张三', '李四', 10, '系统监控');
INSERT INTO `sys_role_menu` VALUES (963, '张三', '李四', 1339022668158201861, '历史发布');
INSERT INTO `sys_role_menu` VALUES (964, '张三', '李四', 1347363524065763329, '异常日志');
INSERT INTO `sys_role_menu` VALUES (965, '张三', '李四', 1347372537138634754, '登录日志');
INSERT INTO `sys_role_menu` VALUES (966, '张三', '李四', 1347424159831134209, '字典管理');
INSERT INTO `sys_role_menu` VALUES (967, '张三', '李四', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (968, '张三', '李四', 1606109916162, '菜单管理');
INSERT INTO `sys_role_menu` VALUES (969, '张三', '李四', 1606110024758, '修改');
INSERT INTO `sys_role_menu` VALUES (970, '张三', '李四', 1606110026770, '删除');
INSERT INTO `sys_role_menu` VALUES (971, '张三', '李四', 1606110022592, '新增');
INSERT INTO `sys_role_menu` VALUES (972, '张三', '李四', 1606110019888, '查看');
INSERT INTO `sys_role_menu` VALUES (973, '张三', '李四', 1608110856845, 'APP上传');
INSERT INTO `sys_role_menu` VALUES (974, '张三', '李四', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (975, '张三', '李四', 1606110215948, '用户管理');
INSERT INTO `sys_role_menu` VALUES (976, '张三', '李四', 1606110341434, '修改');
INSERT INTO `sys_role_menu` VALUES (977, '张三', '李四', 1606110341464, '删除');
INSERT INTO `sys_role_menu` VALUES (978, '张三', '李四', 1606110341402, '新增');
INSERT INTO `sys_role_menu` VALUES (979, '张三', '李四', 1606110341358, '查看');
INSERT INTO `sys_role_menu` VALUES (980, '张三', '李四', 1339022668158201860, '角色管理');
INSERT INTO `sys_role_menu` VALUES (981, '张三', '李四', 1608877877593, '修改');
INSERT INTO `sys_role_menu` VALUES (982, '张三', '李四', 1608877877720, '农场车辆配置');
INSERT INTO `sys_role_menu` VALUES (983, '张三', '李四', 1608877877634, '删除');
INSERT INTO `sys_role_menu` VALUES (984, '张三', '李四', 1608877877551, '新增');
INSERT INTO `sys_role_menu` VALUES (985, '张三', '李四', 1608877877669, '菜单配置');
INSERT INTO `sys_role_menu` VALUES (986, '张三', '李四', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (987, '张三', '李四', 1367007392105164801, '车辆参数');
INSERT INTO `sys_role_menu` VALUES (1256, 'webull_electronic_group', '悟牛电子部', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1257, 'webull_electronic_group', '悟牛电子部', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1258, 'webull_electronic_group', '悟牛电子部', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1259, 'webull_electronic_group', '悟牛电子部', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1260, 'webull_electronic_group', '悟牛电子部', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1261, 'webull_electronic_group', '悟牛电子部', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1262, 'webull_electronic_group', '悟牛电子部', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1263, 'webull_electronic_group', '悟牛电子部', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1264, 'webull_electronic_group', '悟牛电子部', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1265, 'webull_electronic_group', '悟牛电子部', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1266, 'webull_electronic_group', '悟牛电子部', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1267, 'webull_electronic_group', '悟牛电子部', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1268, 'webull_electronic_group', '悟牛电子部', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1269, 'webull_electronic_group', '悟牛电子部', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1270, 'webull_electronic_group', '悟牛电子部', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1271, 'webull_electronic_group', '悟牛电子部', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1272, 'webull_electronic_group', '悟牛电子部', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1273, 'webull_electronic_group', '悟牛电子部', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1274, 'webull_electronic_group', '悟牛电子部', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1275, 'webull_electronic_group', '悟牛电子部', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1276, 'webull_electronic_group', '悟牛电子部', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1277, 'webull_electronic_group', '悟牛电子部', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1278, 'webull_electronic_group', '悟牛电子部', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1279, 'webull_electronic_group', '悟牛电子部', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1280, 'webull_electronic_group', '悟牛电子部', 1367007392105164801, '车辆参数');
INSERT INTO `sys_role_menu` VALUES (1306, 'manager', '管理员', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1307, 'manager', '管理员', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1308, 'manager', '管理员', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1309, 'manager', '管理员', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1310, 'manager', '管理员', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1311, 'manager', '管理员', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1312, 'manager', '管理员', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1313, 'manager', '管理员', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1314, 'manager', '管理员', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1315, 'manager', '管理员', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1316, 'manager', '管理员', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1317, 'manager', '管理员', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1318, 'manager', '管理员', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1319, 'manager', '管理员', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1320, 'manager', '管理员', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1321, 'manager', '管理员', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1322, 'manager', '管理员', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1323, 'manager', '管理员', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1324, 'manager', '管理员', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1325, 'manager', '管理员', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1326, 'manager', '管理员', 1606371334082, '农场配置');
INSERT INTO `sys_role_menu` VALUES (1327, 'manager', '管理员', 1606371361366, '修改');
INSERT INTO `sys_role_menu` VALUES (1328, 'manager', '管理员', 1606371361389, '删除');
INSERT INTO `sys_role_menu` VALUES (1329, 'manager', '管理员', 1606371361345, '新增');
INSERT INTO `sys_role_menu` VALUES (1330, 'manager', '管理员', 1606371361318, '查看');
INSERT INTO `sys_role_menu` VALUES (1331, 'manager', '管理员', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1332, 'manager', '管理员', 10, '系统监控');
INSERT INTO `sys_role_menu` VALUES (1333, 'manager', '管理员', 1339022668158201861, '历史发布');
INSERT INTO `sys_role_menu` VALUES (1334, 'manager', '管理员', 1347363524065763329, '异常日志');
INSERT INTO `sys_role_menu` VALUES (1335, 'manager', '管理员', 1347372537138634754, '登录日志');
INSERT INTO `sys_role_menu` VALUES (1336, 'manager', '管理员', 1347424159831134209, '字典管理');
INSERT INTO `sys_role_menu` VALUES (1337, 'manager', '管理员', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1338, 'manager', '管理员', 1606109916162, '菜单管理');
INSERT INTO `sys_role_menu` VALUES (1339, 'manager', '管理员', 1606110024758, '修改');
INSERT INTO `sys_role_menu` VALUES (1340, 'manager', '管理员', 1606110026770, '删除');
INSERT INTO `sys_role_menu` VALUES (1341, 'manager', '管理员', 1606110022592, '新增');
INSERT INTO `sys_role_menu` VALUES (1342, 'manager', '管理员', 1606110019888, '查看');
INSERT INTO `sys_role_menu` VALUES (1343, 'manager', '管理员', 1608110856845, 'APP上传');
INSERT INTO `sys_role_menu` VALUES (1344, 'manager', '管理员', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1345, 'manager', '管理员', 1606110215948, '用户管理');
INSERT INTO `sys_role_menu` VALUES (1346, 'manager', '管理员', 1606110341434, '修改');
INSERT INTO `sys_role_menu` VALUES (1347, 'manager', '管理员', 1606110341464, '删除');
INSERT INTO `sys_role_menu` VALUES (1348, 'manager', '管理员', 1606110341402, '新增');
INSERT INTO `sys_role_menu` VALUES (1349, 'manager', '管理员', 1606110341358, '查看');
INSERT INTO `sys_role_menu` VALUES (1350, 'manager', '管理员', 1339022668158201860, '角色管理');
INSERT INTO `sys_role_menu` VALUES (1351, 'manager', '管理员', 1608877877593, '修改');
INSERT INTO `sys_role_menu` VALUES (1352, 'manager', '管理员', 1608877877720, '农场车辆配置');
INSERT INTO `sys_role_menu` VALUES (1353, 'manager', '管理员', 1608877877634, '删除');
INSERT INTO `sys_role_menu` VALUES (1354, 'manager', '管理员', 1608877877551, '新增');
INSERT INTO `sys_role_menu` VALUES (1355, 'manager', '管理员', 1608877877669, '菜单配置');
INSERT INTO `sys_role_menu` VALUES (1356, 'manager', '管理员', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1357, 'manager', '管理员', 1367007392105164801, '车辆参数');
INSERT INTO `sys_role_menu` VALUES (1468, 'wenull_test_group', '悟牛测试组', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1469, 'wenull_test_group', '悟牛测试组', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1470, 'wenull_test_group', '悟牛测试组', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1471, 'wenull_test_group', '悟牛测试组', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1472, 'wenull_test_group', '悟牛测试组', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1473, 'wenull_test_group', '悟牛测试组', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1474, 'wenull_test_group', '悟牛测试组', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1475, 'wenull_test_group', '悟牛测试组', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1476, 'wenull_test_group', '悟牛测试组', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1477, 'wenull_test_group', '悟牛测试组', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1478, 'wenull_test_group', '悟牛测试组', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1479, 'wenull_test_group', '悟牛测试组', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1480, 'wenull_test_group', '悟牛测试组', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1481, 'wenull_test_group', '悟牛测试组', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1482, 'wenull_test_group', '悟牛测试组', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1483, 'wenull_test_group', '悟牛测试组', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1484, 'wenull_test_group', '悟牛测试组', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1485, 'wenull_test_group', '悟牛测试组', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1486, 'wenull_test_group', '悟牛测试组', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1487, 'wenull_test_group', '悟牛测试组', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1488, 'wenull_test_group', '悟牛测试组', 1606371334082, '农场配置');
INSERT INTO `sys_role_menu` VALUES (1489, 'wenull_test_group', '悟牛测试组', 1606371361366, '修改');
INSERT INTO `sys_role_menu` VALUES (1490, 'wenull_test_group', '悟牛测试组', 1606371361389, '删除');
INSERT INTO `sys_role_menu` VALUES (1491, 'wenull_test_group', '悟牛测试组', 1606371361345, '新增');
INSERT INTO `sys_role_menu` VALUES (1492, 'wenull_test_group', '悟牛测试组', 1606371361318, '查看');
INSERT INTO `sys_role_menu` VALUES (1493, 'wenull_test_group', '悟牛测试组', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1494, 'wenull_test_group', '悟牛测试组', 10, '系统监控');
INSERT INTO `sys_role_menu` VALUES (1495, 'wenull_test_group', '悟牛测试组', 1339022668158201861, '历史发布');
INSERT INTO `sys_role_menu` VALUES (1496, 'wenull_test_group', '悟牛测试组', 1347363524065763329, '异常日志');
INSERT INTO `sys_role_menu` VALUES (1497, 'wenull_test_group', '悟牛测试组', 1347372537138634754, '登录日志');
INSERT INTO `sys_role_menu` VALUES (1498, 'wenull_test_group', '悟牛测试组', 1347424159831134209, '字典管理');
INSERT INTO `sys_role_menu` VALUES (1499, 'wenull_test_group', '悟牛测试组', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1500, 'wenull_test_group', '悟牛测试组', 1606109916162, '菜单管理');
INSERT INTO `sys_role_menu` VALUES (1501, 'wenull_test_group', '悟牛测试组', 1606110024758, '修改');
INSERT INTO `sys_role_menu` VALUES (1502, 'wenull_test_group', '悟牛测试组', 1606110026770, '删除');
INSERT INTO `sys_role_menu` VALUES (1503, 'wenull_test_group', '悟牛测试组', 1606110022592, '新增');
INSERT INTO `sys_role_menu` VALUES (1504, 'wenull_test_group', '悟牛测试组', 1606110019888, '查看');
INSERT INTO `sys_role_menu` VALUES (1505, 'wenull_test_group', '悟牛测试组', 1608110856845, 'APP上传');
INSERT INTO `sys_role_menu` VALUES (1506, 'wenull_test_group', '悟牛测试组', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1507, 'wenull_test_group', '悟牛测试组', 1606110215948, '用户管理');
INSERT INTO `sys_role_menu` VALUES (1508, 'wenull_test_group', '悟牛测试组', 1606110341434, '修改');
INSERT INTO `sys_role_menu` VALUES (1509, 'wenull_test_group', '悟牛测试组', 1606110341464, '删除');
INSERT INTO `sys_role_menu` VALUES (1510, 'wenull_test_group', '悟牛测试组', 1606110341402, '新增');
INSERT INTO `sys_role_menu` VALUES (1511, 'wenull_test_group', '悟牛测试组', 1606110341358, '查看');
INSERT INTO `sys_role_menu` VALUES (1512, 'wenull_test_group', '悟牛测试组', 1339022668158201860, '角色管理');
INSERT INTO `sys_role_menu` VALUES (1513, 'wenull_test_group', '悟牛测试组', 1608877877593, '修改');
INSERT INTO `sys_role_menu` VALUES (1514, 'wenull_test_group', '悟牛测试组', 1608877877720, '农场车辆配置');
INSERT INTO `sys_role_menu` VALUES (1515, 'wenull_test_group', '悟牛测试组', 1608877877634, '删除');
INSERT INTO `sys_role_menu` VALUES (1516, 'wenull_test_group', '悟牛测试组', 1608877877551, '新增');
INSERT INTO `sys_role_menu` VALUES (1517, 'wenull_test_group', '悟牛测试组', 1608877877669, '菜单配置');
INSERT INTO `sys_role_menu` VALUES (1518, 'wenull_test_group', '悟牛测试组', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1519, 'wenull_test_group', '悟牛测试组', 1367007392105164801, '车辆参数');
INSERT INTO `sys_role_menu` VALUES (1545, 'HZAU', '华中农大', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1546, 'HZAU', '华中农大', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1547, 'HZAU', '华中农大', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1548, 'HZAU', '华中农大', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1549, 'HZAU', '华中农大', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1550, 'HZAU', '华中农大', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1551, 'HZAU', '华中农大', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1552, 'HZAU', '华中农大', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1553, 'HZAU', '华中农大', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1554, 'HZAU', '华中农大', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1555, 'HZAU', '华中农大', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1556, 'HZAU', '华中农大', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1557, 'HZAU', '华中农大', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1558, 'HZAU', '华中农大', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1559, 'HZAU', '华中农大', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1560, 'HZAU', '华中农大', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1561, 'HZAU', '华中农大', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1562, 'HZAU', '华中农大', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1563, 'HZAU', '华中农大', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1564, 'HZAU', '华中农大', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1565, 'HZAU', '华中农大', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1566, 'HZAU', '华中农大', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1567, 'HZAU', '华中农大', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1568, 'HZAU', '华中农大', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1569, 'wenull_market_group', '悟牛市场部', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1570, 'wenull_market_group', '悟牛市场部', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1571, 'wenull_market_group', '悟牛市场部', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1572, 'wenull_market_group', '悟牛市场部', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1573, 'wenull_market_group', '悟牛市场部', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1574, 'wenull_market_group', '悟牛市场部', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1575, 'wenull_market_group', '悟牛市场部', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1576, 'wenull_market_group', '悟牛市场部', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1577, 'wenull_market_group', '悟牛市场部', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1578, 'wenull_market_group', '悟牛市场部', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1579, 'wenull_market_group', '悟牛市场部', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1580, 'wenull_market_group', '悟牛市场部', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1581, 'wenull_market_group', '悟牛市场部', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1582, 'wenull_market_group', '悟牛市场部', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1583, 'wenull_market_group', '悟牛市场部', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1584, 'wenull_market_group', '悟牛市场部', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1585, 'wenull_market_group', '悟牛市场部', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1586, 'wenull_market_group', '悟牛市场部', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1587, 'wenull_market_group', '悟牛市场部', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1588, 'wenull_market_group', '悟牛市场部', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1589, 'wenull_market_group', '悟牛市场部', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1590, 'wenull_market_group', '悟牛市场部', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1591, 'wenull_market_group', '悟牛市场部', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1592, 'wenull_market_group', '悟牛市场部', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1593, 'wenull_business_group', '悟牛运营组', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1594, 'wenull_business_group', '悟牛运营组', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1595, 'wenull_business_group', '悟牛运营组', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1596, 'wenull_business_group', '悟牛运营组', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1597, 'wenull_business_group', '悟牛运营组', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1598, 'wenull_business_group', '悟牛运营组', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1599, 'wenull_business_group', '悟牛运营组', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1600, 'wenull_business_group', '悟牛运营组', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1601, 'wenull_business_group', '悟牛运营组', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1602, 'wenull_business_group', '悟牛运营组', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1603, 'wenull_business_group', '悟牛运营组', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1604, 'wenull_business_group', '悟牛运营组', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1605, 'wenull_business_group', '悟牛运营组', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1606, 'wenull_business_group', '悟牛运营组', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1607, 'wenull_business_group', '悟牛运营组', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1608, 'wenull_business_group', '悟牛运营组', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1609, 'wenull_business_group', '悟牛运营组', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1610, 'wenull_business_group', '悟牛运营组', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1611, 'wenull_business_group', '悟牛运营组', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1612, 'wenull_business_group', '悟牛运营组', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1613, 'wenull_business_group', '悟牛运营组', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1614, 'wenull_business_group', '悟牛运营组', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1615, 'wenull_business_group', '悟牛运营组', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1616, 'wenull_business_group', '悟牛运营组', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1617, 'Chongqing AAS', '重庆农科院', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1618, 'Chongqing AAS', '重庆农科院', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1619, 'Chongqing AAS', '重庆农科院', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1620, 'Chongqing AAS', '重庆农科院', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1621, 'Chongqing AAS', '重庆农科院', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1622, 'Chongqing AAS', '重庆农科院', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1623, 'Chongqing AAS', '重庆农科院', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1624, 'Chongqing AAS', '重庆农科院', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1625, 'Chongqing AAS', '重庆农科院', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1626, 'Chongqing AAS', '重庆农科院', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1627, 'Chongqing AAS', '重庆农科院', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1628, 'Chongqing AAS', '重庆农科院', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1629, 'Chongqing AAS', '重庆农科院', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1630, 'Chongqing AAS', '重庆农科院', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1631, 'Chongqing AAS', '重庆农科院', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1632, 'Chongqing AAS', '重庆农科院', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1633, 'Chongqing AAS', '重庆农科院', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1634, 'Chongqing AAS', '重庆农科院', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1635, 'Chongqing AAS', '重庆农科院', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1636, 'Chongqing AAS', '重庆农科院', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1637, 'Chongqing AAS', '重庆农科院', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1638, 'Chongqing AAS', '重庆农科院', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1639, 'Chongqing AAS', '重庆农科院', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1640, 'Chongqing AAS', '重庆农科院', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1689, 'sdtu', '山东理工大学', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1690, 'sdtu', '山东理工大学', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1691, 'sdtu', '山东理工大学', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1692, 'sdtu', '山东理工大学', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1693, 'sdtu', '山东理工大学', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1694, 'sdtu', '山东理工大学', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1695, 'sdtu', '山东理工大学', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1696, 'sdtu', '山东理工大学', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1697, 'sdtu', '山东理工大学', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1698, 'sdtu', '山东理工大学', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1699, 'sdtu', '山东理工大学', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1700, 'sdtu', '山东理工大学', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1701, 'sdtu', '山东理工大学', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1702, 'sdtu', '山东理工大学', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1703, 'sdtu', '山东理工大学', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1704, 'sdtu', '山东理工大学', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1705, 'sdtu', '山东理工大学', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1706, 'sdtu', '山东理工大学', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1707, 'sdtu', '山东理工大学', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1708, 'sdtu', '山东理工大学', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1709, 'sdtu', '山东理工大学', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1710, 'sdtu', '山东理工大学', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1711, 'sdtu', '山东理工大学', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1712, 'test', '试用角色', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1713, 'test', '试用角色', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1714, 'test', '试用角色', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1715, 'test', '试用角色', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1716, 'test', '试用角色', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1717, 'test', '试用角色', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1718, 'test', '试用角色', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1719, 'test', '试用角色', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1720, 'test', '试用角色', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1721, 'test', '试用角色', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1722, 'test', '试用角色', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1723, 'test', '试用角色', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1724, 'test', '试用角色', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1725, 'test', '试用角色', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1726, 'test', '试用角色', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1727, 'test', '试用角色', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1728, 'test', '试用角色', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1729, 'test', '试用角色', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1730, 'test', '试用角色', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1731, 'test', '试用角色', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1732, 'test', '试用角色', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1733, 'test', '试用角色', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1734, 'test', '试用角色', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1758, 'xinjiang', '新疆喀什', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1759, 'xinjiang', '新疆喀什', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1760, 'xinjiang', '新疆喀什', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1761, 'xinjiang', '新疆喀什', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1762, 'xinjiang', '新疆喀什', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1763, 'xinjiang', '新疆喀什', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1764, 'xinjiang', '新疆喀什', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1765, 'xinjiang', '新疆喀什', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1766, 'xinjiang', '新疆喀什', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1767, 'xinjiang', '新疆喀什', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1768, 'xinjiang', '新疆喀什', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1769, 'xinjiang', '新疆喀什', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (1770, 'xinjiang', '新疆喀什', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1771, 'xinjiang', '新疆喀什', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1772, 'xinjiang', '新疆喀什', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1773, 'xinjiang', '新疆喀什', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1774, 'xinjiang', '新疆喀什', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1775, 'xinjiang', '新疆喀什', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1776, 'xinjiang', '新疆喀什', 10, '系统监控');
INSERT INTO `sys_role_menu` VALUES (1777, 'xinjiang', '新疆喀什', 1339022668158201861, '历史发布');
INSERT INTO `sys_role_menu` VALUES (1778, 'xinjiang', '新疆喀什', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1779, 'xinjiang', '新疆喀什', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1780, 'xinjiang', '新疆喀什', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1781, 'vendor_pdwy', '派德伟业', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1782, 'vendor_pdwy', '派德伟业', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1783, 'vendor_pdwy', '派德伟业', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1784, 'vendor_pdwy', '派德伟业', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1785, 'vendor_pdwy', '派德伟业', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1786, 'vendor_pdwy', '派德伟业', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1787, 'vendor_pdwy', '派德伟业', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1788, 'vendor_pdwy', '派德伟业', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1789, 'vendor_pdwy', '派德伟业', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1813, 'sichun_zizhong', '四川资中', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1814, 'sichun_zizhong', '四川资中', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1815, 'sichun_zizhong', '四川资中', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1816, 'sichun_zizhong', '四川资中', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1817, 'sichun_zizhong', '四川资中', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1818, 'sichun_zizhong', '四川资中', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1819, 'sichun_zizhong', '四川资中', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1820, 'sichun_zizhong', '四川资中', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1821, 'sichun_zizhong', '四川资中', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1822, 'sichun_zizhong', '四川资中', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1823, 'sichun_zizhong', '四川资中', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1824, 'sichun_zizhong', '四川资中', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1825, 'sichun_zizhong', '四川资中', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1826, 'sichun_zizhong', '四川资中', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1827, 'sichun_zizhong', '四川资中', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1828, 'sichun_zizhong', '四川资中', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1829, 'sichun_zizhong', '四川资中', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1830, 'sichun_zizhong', '四川资中', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1831, 'sichun_zizhong', '四川资中', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1832, 'sichun_zizhong', '四川资中', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1833, 'sichun_zizhong', '四川资中', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1834, 'sichun_zizhong', '四川资中', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1835, 'sichun_zizhong', '四川资中', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1925, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1926, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1927, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1928, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1929, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1930, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1931, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1932, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1933, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (1934, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1935, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1936, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1937, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1938, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1939, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (1940, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (1941, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1942, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1943, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1944, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1945, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1946, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1947, 'guangzhou_yunfuyalou', '广州云浮崖楼', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (1967, 'jinkui', '金葵', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (1968, 'jinkui', '金葵', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (1969, 'jinkui', '金葵', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (1970, 'jinkui', '金葵', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (1971, 'jinkui', '金葵', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (1972, 'jinkui', '金葵', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (1973, 'jinkui', '金葵', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (1974, 'jinkui', '金葵', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (1975, 'jinkui', '金葵', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (1976, 'jinkui', '金葵', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (1977, 'jinkui', '金葵', 1608088050343, '车辆动态');
INSERT INTO `sys_role_menu` VALUES (1978, 'jinkui', '金葵', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (1979, 'jinkui', '金葵', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (1980, 'jinkui', '金葵', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (1981, 'jinkui', '金葵', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (1982, 'jinkui', '金葵', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (1983, 'jinkui', '金葵', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (1984, 'jinkui', '金葵', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (1985, 'jinkui', '金葵', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (1986, 'jinkui', '金葵', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (2008, 'dangshan', '砀山果园场', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (2009, 'dangshan', '砀山果园场', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (2010, 'dangshan', '砀山果园场', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (2011, 'dangshan', '砀山果园场', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (2012, 'dangshan', '砀山果园场', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (2013, 'dangshan', '砀山果园场', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (2014, 'dangshan', '砀山果园场', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (2015, 'dangshan', '砀山果园场', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (2016, 'dangshan', '砀山果园场', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (2017, 'dangshan', '砀山果园场', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (2018, 'dangshan', '砀山果园场', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (2019, 'dangshan', '砀山果园场', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (2020, 'dangshan', '砀山果园场', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (2021, 'dangshan', '砀山果园场', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (2022, 'dangshan', '砀山果园场', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (2023, 'dangshan', '砀山果园场', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (2024, 'dangshan', '砀山果园场', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (2025, 'dangshan', '砀山果园场', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (2026, 'dangshan', '砀山果园场', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (2027, 'dangshan', '砀山果园场', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (2028, 'dangshan', '砀山果园场', 1366286029145989121, '系统公告');
INSERT INTO `sys_role_menu` VALUES (2052, 'pdwy', 'pdwy', 1606108916349, '作业管理');
INSERT INTO `sys_role_menu` VALUES (2053, 'pdwy', 'pdwy', 1607654959579, '作业计划');
INSERT INTO `sys_role_menu` VALUES (2054, 'pdwy', 'pdwy', 1607654987611, '修改');
INSERT INTO `sys_role_menu` VALUES (2055, 'pdwy', 'pdwy', 1607654987635, '删除');
INSERT INTO `sys_role_menu` VALUES (2056, 'pdwy', 'pdwy', 1607654987585, '新增');
INSERT INTO `sys_role_menu` VALUES (2057, 'pdwy', 'pdwy', 1607654987555, '查看');
INSERT INTO `sys_role_menu` VALUES (2058, 'pdwy', 'pdwy', 1607752934035, '指令列表');
INSERT INTO `sys_role_menu` VALUES (2059, 'pdwy', 'pdwy', 1607752974297, '修改');
INSERT INTO `sys_role_menu` VALUES (2060, 'pdwy', 'pdwy', 1607752974324, '删除');
INSERT INTO `sys_role_menu` VALUES (2061, 'pdwy', 'pdwy', 1607752974265, '新增');
INSERT INTO `sys_role_menu` VALUES (2062, 'pdwy', 'pdwy', 1607752974228, '查看');
INSERT INTO `sys_role_menu` VALUES (2063, 'pdwy', 'pdwy', 1608101539612, '消息中心');
INSERT INTO `sys_role_menu` VALUES (2064, 'pdwy', 'pdwy', 1607150211985, '车辆管理');
INSERT INTO `sys_role_menu` VALUES (2065, 'pdwy', 'pdwy', 1607150232076, '修改');
INSERT INTO `sys_role_menu` VALUES (2066, 'pdwy', 'pdwy', 1607150232097, '删除');
INSERT INTO `sys_role_menu` VALUES (2067, 'pdwy', 'pdwy', 1607150232055, '新增');
INSERT INTO `sys_role_menu` VALUES (2068, 'pdwy', 'pdwy', 1607150232034, '查看');
INSERT INTO `sys_role_menu` VALUES (2069, 'pdwy', 'pdwy', 1356410988487909378, '农地作业');
INSERT INTO `sys_role_menu` VALUES (2070, 'pdwy', 'pdwy', 1606108916348, '地图管理');
INSERT INTO `sys_role_menu` VALUES (2071, 'pdwy', 'pdwy', 1349163825974448130, '农场管理');
INSERT INTO `sys_role_menu` VALUES (2072, 'pdwy', 'pdwy', 1606108916347, '系统管理');
INSERT INTO `sys_role_menu` VALUES (2073, 'pdwy', 'pdwy', 1608110856846, 'APP下载');
INSERT INTO `sys_role_menu` VALUES (2074, 'pdwy', 'pdwy', 1366286029145989121, '系统公告');

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles`  (
  `roleId` bigint(20) NOT NULL COMMENT '角色ID',
  `enName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '英文名',
  `chName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '中文名',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `remark` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `sort` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES (1606111911941, 'wenull_market_group', '悟牛市场部', '2020-12-11 12:41:54', '姚新帅', '如果还有什么换行符的话，\n那么显示会正确吗？', 0);
INSERT INTO `sys_roles` VALUES (1606111911942, 'wenull_business_group', '悟牛运营组', '2020-12-11 12:41:54', '姚新帅', NULL, 0);
INSERT INTO `sys_roles` VALUES (1606111911944, 'manager', '管理员', '2020-12-11 12:41:54', '姚新帅', NULL, 0);
INSERT INTO `sys_roles` VALUES (1606111911948, 'developer', '开发组', '2020-12-11 12:41:54', '姚新帅', NULL, 0);
INSERT INTO `sys_roles` VALUES (16243567326378634, 'test', '试用角色', '2021-06-22 05:12:13', '姚新帅', NULL, 1624356732637);
INSERT INTO `sys_roles` VALUES (16273461538774663, 'xinjiang', '新疆喀什', '2021-07-26 19:35:54', '姚新帅', '新疆喀什', 1627346153877);
INSERT INTO `sys_roles` VALUES (16337643687715140, 'sichun_zizhong', '四川资中', '2021-10-09 02:26:09', '姚新帅', '派得伟业', 1633764368771);
INSERT INTO `sys_roles` VALUES (16342860121549359, 'guangzhou_yunfuyalou', '广州云浮崖楼', '2021-10-15 03:20:12', '姚新帅', '派得伟业', 1634286012154);
INSERT INTO `sys_roles` VALUES (16430041616406643, 'jinkui', '金葵', '2022-01-24 14:02:42', '姚新帅', NULL, 1643004161640);
INSERT INTO `sys_roles` VALUES (16560316290316593, 'dangshan', '砀山果园场', '2022-06-24 08:47:09', '姚新帅', NULL, 1656031629031);
INSERT INTO `sys_roles` VALUES (16562258440318088, 'pdwy', 'pdwy', '2022-06-26 14:44:04', '姚新帅', '派得伟业总账号', 1656225844031);
INSERT INTO `sys_roles` VALUES (1368110817773359105, 'webull_electronic_group', '悟牛电子部', '2021-03-06 02:06:52', '董修辰', NULL, 1615018011885);
INSERT INTO `sys_roles` VALUES (1368742916473753602, 'webull_carpoint_group', '悟牛车端', '2021-03-07 19:58:36', '董修辰', NULL, 1615168715959);
INSERT INTO `sys_roles` VALUES (1372798931892703233, 'vendor_sanht', '三合通', '2021-03-19 01:35:45', '董修辰', NULL, 1616135745391);
INSERT INTO `sys_roles` VALUES (1387326456505307137, 'HZAU', '华中农大', '2021-04-28 03:42:57', '姚新帅', NULL, 1619599377167);
INSERT INTO `sys_roles` VALUES (1394169718000062466, 'Chongqing AAS', '重庆农科院', '2021-05-17 00:55:38', '姚新帅', NULL, 1621230937849);
INSERT INTO `sys_roles` VALUES (1397433388314398721, 'sdtu', '山东理工大学', '2021-05-26 01:04:17', '姚新帅', NULL, 1622009057490);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `userId` bigint(20) NOT NULL COMMENT 'userId',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名字',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公司',
  `dept` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门',
  `createBy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updateBy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '修改人',
  `updateTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `sort` bigint(20) NULL DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `roleName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (16652847061873, '选手1', 'xs_1', 'fe0df439d0f168dedbffe04f3c83916566a528763e1acfd0b1d96603f9cada59', '15069072532', NULL, '1', NULL, NULL, '观众1', '2022-10-09 11:05:06', NULL, NULL, NULL, '1', '选手');
INSERT INTO `sys_user` VALUES (166522203384453, '系统管理员', 'admin', 'fe0df439d0f168dedbffe04f3c83916566a528763e1acfd0b1d96603f9cada59', '15069072532', NULL, '180@qq.com', NULL, NULL, '试用用户', '2022-10-08 17:40:34', NULL, NULL, NULL, '1', '系统管理员');
INSERT INTO `sys_user` VALUES (166522213342582, '观众1', 'gz_1', 'fe0df439d0f168dedbffe04f3c83916566a528763e1acfd0b1d96603f9cada59', '15069072532', NULL, '1@qq.com', NULL, NULL, '试用用户', '2022-10-08 17:42:13', NULL, NULL, NULL, '1', '观众');
INSERT INTO `sys_user` VALUES (166522214299885, '观众2', 'gz_2', 'fe0df439d0f168dedbffe04f3c83916566a528763e1acfd0b1d96603f9cada59', '15069072532', NULL, '1@qq.com', NULL, NULL, '试用用户', '2022-10-08 17:42:23', '试用用户', '2022-10-08 17:43:59', NULL, '1', '观众');
INSERT INTO `sys_user` VALUES (166528473144383, '选手2', 'xs_2', 'fe0df439d0f168dedbffe04f3c83916566a528763e1acfd0b1d96603f9cada59', '15069072532', NULL, '1', NULL, NULL, '观众1', '2022-10-09 11:05:31', NULL, NULL, NULL, '1', '选手');
INSERT INTO `sys_user` VALUES (166528474960840, '评委1', 'pw_1', 'fe0df439d0f168dedbffe04f3c83916566a528763e1acfd0b1d96603f9cada59', '15069072532', NULL, '1', NULL, NULL, '观众1', '2022-10-09 11:05:50', NULL, NULL, NULL, '1', '评委');
INSERT INTO `sys_user` VALUES (166528476942583, '评委2', 'pw_2', 'fe0df439d0f168dedbffe04f3c83916566a528763e1acfd0b1d96603f9cada59', '15069072532', NULL, '1', NULL, NULL, '观众1', '2022-10-09 11:06:09', NULL, NULL, NULL, '1', '评委');
INSERT INTO `sys_user` VALUES (166528480259565, '主办方1', 'zbf_1', 'fe0df439d0f168dedbffe04f3c83916566a528763e1acfd0b1d96603f9cada59', '15069072532', NULL, '1', NULL, NULL, '观众1', '2022-10-09 11:06:43', NULL, NULL, NULL, '1', '主办方');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色英文名',
  `roleName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色名',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '用户Id',
  `userName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 230 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (4, NULL, NULL, 1605755285019, NULL);
INSERT INTO `sys_user_role` VALUES (5, NULL, NULL, 1605755285017, NULL);
INSERT INTO `sys_user_role` VALUES (6, NULL, NULL, 1605755285019, NULL);
INSERT INTO `sys_user_role` VALUES (7, NULL, NULL, 1605755285017, NULL);
INSERT INTO `sys_user_role` VALUES (8, NULL, NULL, 1605755285019, NULL);
INSERT INTO `sys_user_role` VALUES (9, NULL, NULL, 1605755285017, NULL);
INSERT INTO `sys_user_role` VALUES (10, NULL, NULL, 1605755285019, NULL);
INSERT INTO `sys_user_role` VALUES (11, NULL, NULL, 1605755285017, NULL);
INSERT INTO `sys_user_role` VALUES (26, '1606111911941', '悟牛市场部', 1605755285019, '董修辰');
INSERT INTO `sys_user_role` VALUES (27, '1606111911941', '悟牛市场部', 1605755285017, '于雪玉');
INSERT INTO `sys_user_role` VALUES (28, '1606111911941', '悟牛市场部', 1605755285094, '唐彦胜');
INSERT INTO `sys_user_role` VALUES (48, 'webull_electronic_group', '悟牛电子部', 1368111059738562562, '姚伟');
INSERT INTO `sys_user_role` VALUES (59, 'vendor_sht', '三合通', 1372714886789861377, '三合通');
INSERT INTO `sys_user_role` VALUES (80, 'vendor_sanht', '三合通', 1372714886789861377, '三合通');
INSERT INTO `sys_user_role` VALUES (83, '张三', '李四', 1372748353669959682, '张三');
INSERT INTO `sys_user_role` VALUES (95, 'manager', '管理员', 1368742568371687425, '隋来吉');
INSERT INTO `sys_user_role` VALUES (96, 'manager', '管理员', 1605755285019, '董修辰');
INSERT INTO `sys_user_role` VALUES (97, 'manager', '管理员', 1374172322847526914, '毛睿');
INSERT INTO `sys_user_role` VALUES (98, 'manager', '管理员', 1605755285094, '唐彦胜');
INSERT INTO `sys_user_role` VALUES (99, 'manager', '管理员', 1605755285017, '于雪玉');
INSERT INTO `sys_user_role` VALUES (100, 'manager', '管理员', 1374172804462678017, '朱海波');
INSERT INTO `sys_user_role` VALUES (127, 'developer', '开发组', 1368742568371687425, '隋来吉');
INSERT INTO `sys_user_role` VALUES (128, 'developer', '开发组', 1605755285019, '董修辰');
INSERT INTO `sys_user_role` VALUES (129, 'developer', '开发组', 1374172322847526914, '毛睿');
INSERT INTO `sys_user_role` VALUES (130, 'developer', '开发组', 1605755285094, '唐彦胜');
INSERT INTO `sys_user_role` VALUES (131, 'developer', '开发组', 1605755285017, '于雪玉');
INSERT INTO `sys_user_role` VALUES (155, 'HZAU', '华中农大', 1387325227255468034, '宋鹏');
INSERT INTO `sys_user_role` VALUES (159, 'Chongqing AAS', '重庆农科院', 1394167010706853890, '徐卫');
INSERT INTO `sys_user_role` VALUES (164, 'sdtu', '山东理工大学', 1397434258217242626, '山东理工大学');
INSERT INTO `sys_user_role` VALUES (165, 'test', '试用角色', 16243569454778749, '试用用户');
INSERT INTO `sys_user_role` VALUES (189, 'wenull_business_group', '悟牛运营组', 1392716627576885250, '房克');
INSERT INTO `sys_user_role` VALUES (190, 'wenull_business_group', '悟牛运营组', 1394176235831037953, '尹本强');
INSERT INTO `sys_user_role` VALUES (191, 'wenull_test_group', '悟牛测试组', 1371648904893829121, '姚新帅');
INSERT INTO `sys_user_role` VALUES (192, 'wenull_test_group', '悟牛测试组', 16316846733388163, '黄家兴');
INSERT INTO `sys_user_role` VALUES (193, 'xinjiang', '新疆喀什', 1373929467533070337, '李同祥');
INSERT INTO `sys_user_role` VALUES (203, 'manager', '管理员', 1368742673048932354, '栾田静');
INSERT INTO `sys_user_role` VALUES (216, 'jinkui', '金葵', 16430041988378987, '刘健');
INSERT INTO `sys_user_role` VALUES (217, 'wenull_market_group', '悟牛市场部', 16522348860025770, '时立光');
INSERT INTO `sys_user_role` VALUES (225, 'pdwy', 'pdwy', 16337424358593893, '派德伟业');
INSERT INTO `sys_user_role` VALUES (226, 'dangshan', '砀山果园场', 16560316042477211, '砀山果园场');
INSERT INTO `sys_user_role` VALUES (228, 'sichun_zizhong', '四川资中', 16337642798367821, '柳国栋');
INSERT INTO `sys_user_role` VALUES (229, 'guangzhou_yunfuyalou', '广州云浮崖楼', 16342858275929914, '谢灿基');

-- ----------------------------
-- Table structure for t_competition
-- ----------------------------
DROP TABLE IF EXISTS `t_competition`;
CREATE TABLE `t_competition`  (
  `id` bigint(20) NOT NULL COMMENT 'userId',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `startTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `judgePerson` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '评分人',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态（1、2、3、4）',
  `statusMean` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态（未开始、进行中、等待打分、完成）',
  `scoreStandard` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打分标准',
  `createBy` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updateBy` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `updateTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `sort` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '比赛实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_competition
-- ----------------------------
INSERT INTO `t_competition` VALUES (166528309618232, '哈哈哈', '2022-10-09 00:22:00', '评委1', 3, '完成', '士大夫大师傅', '观众1', '2022-10-09 10:38:16', '评委1', '2022-10-09 16:00:59', NULL);
INSERT INTO `t_competition` VALUES (166529485504616, '测试比赛', '2022-10-09 13:55:00', '', 2, '等待打分', NULL, '评委1', '2022-10-09 13:54:15', NULL, NULL, NULL);
INSERT INTO `t_competition` VALUES (166529521131322, '测试2', '2022-09-15 00:00:00', '', 4, '失效', NULL, '评委1', '2022-10-09 14:00:11', NULL, NULL, NULL);
INSERT INTO `t_competition` VALUES (166529522681974, '测试3', '2022-10-10 00:00:00', '', 1, '未开始', NULL, '评委1', '2022-10-09 14:00:27', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_judge_join
-- ----------------------------
DROP TABLE IF EXISTS `t_judge_join`;
CREATE TABLE `t_judge_join`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `competitionId` bigint(20) NULL DEFAULT NULL,
  `userId` bigint(20) NULL DEFAULT NULL,
  `userName` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参赛表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_judge_join
-- ----------------------------
INSERT INTO `t_judge_join` VALUES (2, 166528309618232, 166528476942583, '评委2');
INSERT INTO `t_judge_join` VALUES (3, 166528309618232, 166528474960840, '评委1');
INSERT INTO `t_judge_join` VALUES (4, 166529485504616, 166528474960840, '评委1');
INSERT INTO `t_judge_join` VALUES (5, 166529522681974, 166528474960840, '评委1');

-- ----------------------------
-- Table structure for t_user_join
-- ----------------------------
DROP TABLE IF EXISTS `t_user_join`;
CREATE TABLE `t_user_join`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `competitionId` bigint(20) NULL DEFAULT NULL,
  `userId` bigint(20) NULL DEFAULT NULL,
  `userName` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参赛表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_join
-- ----------------------------
INSERT INTO `t_user_join` VALUES (13, 166528309618232, 166528473144383, '选手2', 1);
INSERT INTO `t_user_join` VALUES (14, 166528309618232, 166522214299885, '观众2', 12);
INSERT INTO `t_user_join` VALUES (15, 166528309618232, 166522213342582, '观众1', 1);
INSERT INTO `t_user_join` VALUES (22, 166528309618232, 16652847061873, '选手1', 0);

SET FOREIGN_KEY_CHECKS = 1;
