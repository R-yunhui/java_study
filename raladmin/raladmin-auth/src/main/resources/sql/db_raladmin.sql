-- 用户表
create table db_user
(
	id            int           comment '主键ID',
    user_id       char(32)      not null comment '用户ID',
    user_name     varchar(33)   not null comment '用户名',
    pass_word     varchar(100)  not null comment '用户密码',
    age           int           null comment '年龄',
    gender        int           null comment '性别',
    email         varchar(100)  not null comment '邮箱',
    phone_number  varchar(33)   null comment '手机号码',
    status        int default 1 not null comment '状态 1 - 启用  2 - 禁用  3 - 删除',
    create_time   datetime      not null comment '创建时间',
    create_user   char(32)      not null comment '创建人',
    update_time   datetime      not null comment '修改时间',
    update_user   char(32)      not null comment '修改人'
)
    comment '用户表';

alter table db_user
    add primary key (id);

-- 用户 - 角色表
create table db_user_role
(
	id            int           comment '主键ID',
    user_id       char(32)      not null comment '用户ID',
    role_id		  char(32)      not null comment '角色ID',
    status        int default 1 not null comment '状态 1 - 启用  2 - 禁用  3 - 删除',
    create_time   datetime      not null comment '创建时间',
    create_user   char(32)      not null comment '创建人',
    update_time   datetime      not null comment '修改时间',
    update_user   char(32)      not null comment '修改人'
)
    comment '用户 - 角色表';

alter table db_user_role
	add primary key(id);

-- 角色表
create table db_role
(
	id              int           comment '主键ID',
    role_id         char(32)      not null comment '角色ID',
    role_name       varchar(15)   not null comment '角色名',
	remark          varchar(300)  not null comment '备注',
    status          int default 1 not null comment '状态 1 - 启用 2 - 禁用 3 - 已删除',
    create_user     char(32)      not null comment '创建人',
    create_time     datetime      not null comment '创建时间',
    update_user     char(32)      not null comment '修改人',
    update_time     datetime      not null comment '创建时间'
)
    comment '角色表';

alter table db_role
    add primary key (id);

-- 权限表
create table db_authority
(
	id             int           comment '主键ID',
    authority_id   char(32)      not null comment '权限ID',
	permission_url text          not null comment '允许访问的url',
    remark         varchar(100)  not null comment '备注',
    status         int default 1 not null comment '状态  1 - 启用  2 - 禁用  3 - 已删除',
    create_time    datetime      not null comment '创建时间',
    create_user    char(32)      not null comment '创建人',
    update_time    datetime      not null comment '修改时间',
    update_user    char(32)      not null comment '修改人'
)
    comment '权限表';

alter table db_authority
    add primary key (id);

-- 角色 - 权限表
create table db_role_authority
(
	id            int           comment '主键ID',
    role_id       char(32)      not null comment '角色ID',
    authority_id  char(32)      not null comment '权限ID',
    status        int default 1 not null comment '状态 1 - 启用  2 - 禁用  3 - 删除',
    create_time   datetime      not null comment '创建时间',
    create_user   char(32)      not null comment '创建人',
    update_time   datetime      not null comment '修改时间',
    update_user   char(32)      not null comment '修改人'
)
    comment '角色 - 权限表';

alter table db_role_authority
	add primary key(id)





