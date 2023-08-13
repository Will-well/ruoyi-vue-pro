-- 学校表
DROP TABLE IF EXISTS `system_university`;
CREATE TABLE `system_university`
(
    `id`                 bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `code`               varchar(32)         DEFAULT NULL COMMENT '大学编码',
    `name`               varchar(32)         DEFAULT NULL COMMENT '大学名称',
    `en_name`            varchar(64)         DEFAULT NULL COMMENT '大学英文名称',
    `logo`               varchar(128)        DEFAULT NULL COMMENT '学校logo',
    `home_pic`           varchar(128)        DEFAULT NULL COMMENT '主页图片',
    `intro`              text                DEFAULT NULL COMMENT '简介',
    `apply_requirements` text                DEFAULT NULL COMMENT '申请要求',
    `country`            varchar(32)         DEFAULT NULL COMMENT '所属国家',
    `tuition_fee`        decimal(10, 2)      DEFAULT '0.00' COMMENT '学费',
    `enrollment_method`  varchar(32)         DEFAULT NULL COMMENT '招生方式',
    `employment`         varchar(512)        DEFAULT NULL COMMENT '就业',
    `sheng_shuo`         varchar(512)        DEFAULT NULL COMMENT '申硕情况',
    `qs`                 int(10)             DEFAULT NULL COMMENT '排名',
    `sort`               int(10)             DEFAULT NULL COMMENT '排序',
    `create_time`        timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `creator`            varchar(64)         DEFAULT '' COMMENT '创建者',
    `updater`            varchar(64)         DEFAULT '' COMMENT '更新者',
    `deleted`            bit(1)     NOT NULL DEFAULT b'0' COMMENT '是否删除:1-已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='学校表';

-- 专业表
DROP TABLE IF EXISTS `system_major`;
CREATE TABLE `system_major`
(
    `id`                     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `university_id`          varchar(32)         DEFAULT NULL COMMENT '大学id',
    `university_name`        varchar(32)         DEFAULT NULL COMMENT '大学名称',
    `top_category`           varchar(64)         DEFAULT NULL COMMENT '一级分类',
    `category`               varchar(64)         DEFAULT NULL COMMENT '二级分类',
    `major_name`             varchar(64)         DEFAULT NULL COMMENT '专业名称',
    `major_intro`            text                DEFAULT NULL COMMENT '专业介绍',
    `employment_orientation` varchar(256)        DEFAULT NULL COMMENT '就业方向',
    `special_requirements`   varchar(256)        DEFAULT NULL COMMENT '特殊要求',
    `sort`                   int(10)             DEFAULT NULL COMMENT '排序',
    `create_time`            timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`            timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `creator`                varchar(64)         DEFAULT '' COMMENT '创建者',
    `updater`                varchar(64)         DEFAULT '' COMMENT '更新者',
    `deleted`                bit(1)     NOT NULL DEFAULT b'0' COMMENT '是否删除:1-已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='专业表';


-- wx用户表
DROP TABLE IF EXISTS `system_wx_user`;
CREATE TABLE `system_wx_user`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `wx_id`         varchar(32)         DEFAULT NULL COMMENT 'open_id',
    `login_token`   varchar(32)         DEFAULT NULL COMMENT '登录token',
    `real_name`     varchar(32)         DEFAULT NULL COMMENT '真实姓名',
    `sex` TINYINT DEFAULT NULL COMMENT '性别',
    `age` TINYINT DEFAULT NULL COMMENT '年龄',
    `nickname`      varchar(64)         DEFAULT NULL COMMENT '用户昵称',
    `phone`         varchar(32)         DEFAULT NULL COMMENT '脱敏手机号',
    `encrypt_phone` varchar(32)         DEFAULT NULL COMMENT '加密手机号',
    `create_time`   timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `creator`       varchar(64)         DEFAULT '' COMMENT '创建者',
    `updater`       varchar(64)         DEFAULT '' COMMENT '更新者',
    `deleted`       bit(1)     NOT NULL DEFAULT b'0' COMMENT '是否删除:1-已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='wx用户表';


-- 用户咨询表
DROP TABLE IF EXISTS `system_consultation`;
CREATE TABLE `system_consultation`
(
    `id`                  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `child_name`          varchar(32)         DEFAULT NULL COMMENT '孩子姓名',
    `major`               varchar(64)         DEFAULT NULL COMMENT '专业名称',
    `province_city`       varchar(64)         DEFAULT NULL COMMENT '省市',
    `grade`               varchar(256)        DEFAULT NULL COMMENT '年级',
    `estimated_score`     decimal(10, 1)      DEFAULT '0.0' COMMENT '分数或预估',
    `english_score`       decimal(10, 1)      DEFAULT '0.0' COMMENT '英语分数',
    `math_score`          decimal(10, 1)      DEFAULT '0.0' COMMENT '数学分数',
    `intended_major`      varchar(32)         DEFAULT NULL COMMENT '意向专业',
    `intended_area`       varchar(32)         DEFAULT NULL COMMENT '意向地区',
    `intended_university` varchar(32)         DEFAULT NULL COMMENT '意向学校',
    `intended_country`    varchar(16)         DEFAULT NULL COMMENT '意向国家',
    `budget`              decimal(10, 1)      DEFAULT '0.00' COMMENT '预算',
    `contact_phone`       varchar(32)         DEFAULT NULL COMMENT '联系方式',
    `user_name`           varchar(32)         DEFAULT NULL COMMENT '用户姓名',
    `create_time`         timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `creator`             varchar(64)         DEFAULT '' COMMENT '创建者',
    `updater`             varchar(64)         DEFAULT '' COMMENT '更新者',
    `deleted`             bit(1)     NOT NULL DEFAULT b'0' COMMENT '是否删除:1-已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户咨询表';

-- 资讯表
DROP TABLE IF EXISTS `system_information`;
CREATE TABLE `system_information`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `pic`         varchar(64)         DEFAULT NULL COMMENT '资讯图片',
    `title`       varchar(64)         DEFAULT NULL COMMENT '资讯标题',
    `content`     text                DEFAULT NULL COMMENT '资讯内容',
    `sort`        int(10)             DEFAULT NULL COMMENT '排序',
    `create_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `creator`     varchar(64)         DEFAULT '' COMMENT '创建者',
    `updater`     varchar(64)         DEFAULT '' COMMENT '更新者',
    `deleted`     bit(1)     NOT NULL DEFAULT b'0' COMMENT '是否删除:1-已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='资讯表';

-- 移除不必要功能页面入口
update system_menu set deleted = 1 where id in ('1254', '2159', '2160', '1117', '1281', '1185', '2262', '2000', '2072', '2030', '2084');

-- 菜单 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status, component_name
)
VALUES (
           '学校管理', '', 2, 0, 1,
           'university', '', 'system/university/index', 0, 'University'
       );

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '学校查询', 'system:university:query', 3, 1, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '学校创建', 'system:university:create', 3, 2, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '学校更新', 'system:university:update', 3, 3, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '学校删除', 'system:university:delete', 3, 4, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '学校导出', 'system:university:export', 3, 5, @parentId,
           '', '', '', 0
       );


-- 菜单 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status, component_name
)
VALUES (
           '专业管理', '', 2, 0, 1,
           'major', '', 'system/major/index', 0, 'Major'
       );

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '专业查询', 'system:major:query', 3, 1, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '专业创建', 'system:major:create', 3, 2, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '专业更新', 'system:major:update', 3, 3, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '专业删除', 'system:major:delete', 3, 4, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '专业导出', 'system:major:export', 3, 5, @parentId,
           '', '', '', 0
       );

-- 菜单 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status, component_name
)
VALUES (
           'wx用户管理', '', 2, 0, 1,
           'wx-user', '', 'system/wxUser/index', 0, 'WxUser'
       );

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           'wx用户查询', 'system:wx-user:query', 3, 1, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           'wx用户创建', 'system:wx-user:create', 3, 2, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           'wx用户更新', 'system:wx-user:update', 3, 3, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           'wx用户删除', 'system:wx-user:delete', 3, 4, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           'wx用户导出', 'system:wx-user:export', 3, 5, @parentId,
           '', '', '', 0
       );


-- 菜单 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status, component_name
)
VALUES (
           '用户咨询管理', '', 2, 0, 1,
           'consultation', '', 'system/consultation/index', 0, 'Consultation'
       );

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '用户咨询查询', 'system:consultation:query', 3, 1, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '用户咨询创建', 'system:consultation:create', 3, 2, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '用户咨询更新', 'system:consultation:update', 3, 3, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '用户咨询删除', 'system:consultation:delete', 3, 4, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '用户咨询导出', 'system:consultation:export', 3, 5, @parentId,
           '', '', '', 0
       );

-- 菜单 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status, component_name
)
VALUES (
           '资讯管理', '', 2, 0, 1,
           'information', '', 'system/information/index', 0, 'Information'
       );

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '资讯查询', 'system:information:query', 3, 1, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '资讯创建', 'system:information:create', 3, 2, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '资讯更新', 'system:information:update', 3, 3, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '资讯删除', 'system:information:delete', 3, 4, @parentId,
           '', '', '', 0
       );
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
           '资讯导出', 'system:information:export', 3, 5, @parentId,
           '', '', '', 0
       );
