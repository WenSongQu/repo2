 create table content
(
    uid         varchar(36)                                       not null comment '唯一uid',
    name        varchar(255)                                      null comment '名字',
    type        tinyint(1)                                        not null comment '类型',
    title       varchar(255)                                      null comment '标题',
    titleshort  varchar(255)                                      null comment '短标题',
    summary     varchar(1000)                                     null comment '简介',
    content     mediumtext                                        null comment '内容',
    data        varchar(1000)                                     null comment '以json的方式记录',
    imgtitle    varchar(255)                                      null comment '标题图片',
    imglittle   varchar(255)                                      null comment '小图',
    imgmedium   varchar(255)                                      null comment '中图',
    imgbig      varchar(255)                                      null comment '大图',
    imgoriginal varchar(255)                                      null comment '原图',
    status      tinyint(1) unsigned default 1                     not null comment '状态(0禁用1启用)',
    createtime  timestamp           default '0000-00-00 00:00:00' not null comment '创建时间',
    updatetime  timestamp           default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint uid
        unique (uid)
)
    comment '内容表';

alter table content
    add primary key (uid);

create table message
(
    uid          char(32)                                  not null comment '唯一ID',
    fromuseruid  char(32)                                  null comment '来自谁UID',
    fromuseroid  int                                       null comment '来自谁OID',
    fromusername varchar(100)                              null comment '来自谁NAME',
    touseruid    varchar(32)                               null comment '评论给谁的uid',
    touseroid    int                                       null comment '发给谁OID',
    tousername   varchar(100)                              null comment '发给谁NAME',
    useravatar   varchar(200)                              null comment '会员头像or网站头像',
    title        varchar(200)                              null comment '标题',
    content      varchar(4000)                             null comment '内容',
    href         varchar(100)                              null comment '链接',
    state        tinyint(1)                                null comment '未读、已读、已删除',
    type         tinyint(1)                                null comment '消息类型',
    site         tinyint(1)                                null comment '来自哪个项目',
    sn           varchar(10) default ''                    null comment '编号',
    data         varchar(255)                              null comment '其他数据json格式',
    status       tinyint(1)  default 1                     null comment '状态(0禁用1启用)',
    createtime   timestamp   default '0000-00-00 00:00:00' not null comment '创建时间',
    updatetime   timestamp   default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint uid
        unique (uid)
);

alter table message
    add primary key (uid);

create table news
(
    uid        varchar(36)                                       not null comment '唯一ID',
    fromuid    varchar(36)                                       not null comment '发送者id',
    touid      varchar(36)                                       not null comment '接收者id',
    title      varchar(2000)                                     null comment '标题',
    content    varchar(2000)                                     null comment '内容',
    href       varchar(255)                                      null comment '链接地址',
    type       tinyint(1) unsigned default 0                     null comment '消息类型',
    isread     tinyint(1)          default 0                     not null comment '消息状态(0未读1已读)',
    status     tinyint(1)          default 1                     not null comment '状态(0禁用1启用)',
    createtime timestamp           default '0000-00-00 00:00:00' not null comment '创建时间',
    updatetime timestamp           default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint uid
        unique (uid)
)
    comment '消息表' charset = utf8mb4;

alter table news
    add primary key (uid);

create table `order`
(
    uid        varchar(36)                              not null comment '唯一ID',
    useruid    varchar(36)                              null comment '用户唯一ID',
    sn         varchar(60)                              null comment '订单编号',
    name       varchar(36)                              not null comment '订单名称',
    memo       varchar(255)                             null comment '备忘录',
    money      decimal(10, 2)                           null comment '订单总金额',
    state      tinyint(1) default 0                     not null comment '订单状态（初始化|失败|成功|未付款|已付款|取消订单|已过期|管理员退票|已删除）',
    status     tinyint(1) default 1                     null comment '订单状态(0已删除1未删除)',
    createtime timestamp  default '0000-00-00 00:00:00' not null comment '下单时间',
    updatetime timestamp  default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint ordersn
        unique (sn),
    constraint uid
        unique (uid)
)
    comment '订单';

alter table `order`
    add primary key (uid);

create table ordergoods
(
    uid        varchar(36)                               not null comment '唯一ID',
    orderuid   varchar(36)                               not null comment '订单ID',
    useruid    varchar(36)                               null comment '用户唯一ID',
    refuid     varchar(36)                               null comment '商品的uid',
    sn         varchar(36)                               null comment '商品编号(挑战编号|视频编号)',
    name       varchar(255)                              null comment '商品名称',
    type       tinyint(1)                                null comment '商品类型(视频|门票|挑战)',
    count      smallint(5) default 1                     null comment '商品个数',
    unitprice  decimal(10, 2)                            null comment '单价',
    totalprice decimal(10, 2)                            null comment '总价',
    status     tinyint(1)  default 1                     null comment '状态(0禁用1启用)',
    createtime timestamp   default '0000-00-00 00:00:00' not null comment '购买时间',
    updatetime timestamp   default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint uid
        unique (uid)
)
    comment '订单商品';

alter table ordergoods
    add primary key (uid);

create table orderlog
(
    uid        varchar(36)                               not null comment '唯一ID',
    logsn      varchar(36)                               not null comment '流水号',
    orderuid   varchar(36) default '0'                   null comment '订单的uid',
    ordersn    varchar(60)                               null comment '订单编号',
    useruid    varchar(36)                               null comment '用户唯一ID',
    name       varchar(36)                               not null comment '订单日志名称',
    statefrom  tinyint(1)  default 0                     not null comment '原状态',
    stateto    tinyint(1)  default 0                     not null comment '现状态',
    status     tinyint(1)  default 1                     null comment '状态(0禁用1启用)',
    createtime timestamp   default '0000-00-00 00:00:00' not null comment '创建时间',
    updatetime timestamp   default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint logsn
        unique (logsn),
    constraint uid
        unique (uid)
)
    comment '订单日志';

alter table orderlog
    add primary key (uid);

create table score
(
    uid        varchar(36)                                       not null comment '唯一ID',
    useruid    varchar(36)                                       not null comment '用户uid',
    total      int                                               null comment '总积分(某个类型的总积分)',
    type       tinyint(1)                                        not null comment '分数类型（写文章获得，转载文章获得，积分晋级） 取用 in',
    status     tinyint(1) unsigned default 1                     not null comment '状态(0禁用1启用)',
    createtime timestamp           default '0000-00-00 00:00:00' not null comment '创建时间',
    updatetime timestamp           default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint uid
        unique (uid)
)
    comment '动态表';

alter table score
    add primary key (uid);

create table scoredetail
(
    uid        varchar(36)                                       not null comment '唯一ID',
    useruid    varchar(36)                                       not null comment '用户uid',
    score      int                                               not null comment '变动积分',
    site       tinyint(1)                                        not null comment '变动的站点，对应ESite枚举',
    refuid     varchar(255)                                      null comment '获得积分与消费积分事件uid',
    type       tinyint(1)                                        null comment '分数类型（写文章获得，转载文章获得，积分晋级）',
    status     tinyint(1) unsigned default 1                     not null comment '状态(0原创1非原创)',
    createtime timestamp           default '0000-00-00 00:00:00' not null comment '创建时间',
    updatetime timestamp           default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint uid
        unique (uid)
)
    comment '动态表';

alter table scoredetail
    add primary key (uid);

create table tradedetail
(
    uid           varchar(36)                                           not null comment '唯一ID',
    useruid       varchar(36)                                           not null comment '用户uid',
    tradeeventuid varchar(36)                                           null comment '交易事件uid(pk|申请答辩)',
    money         decimal(10, 2) unsigned default 0.00                  null comment '金额',
    accountcurr   decimal(10, 2) unsigned default 0.00                  null comment '余额',
    sn            varchar(36)                                           not null comment '流水号',
    orderuid      varchar(36)                                           null comment '订单Uid',
    type          tinyint(1)                                            not null comment '交易类型(充值、视频收入、扣除挑战费、作为裁判奖励、购买视频、购买门票、购买道具、取消门票、管理员退票、申请答辩、冻结挑战费用、解冻挑战费用、挑战获胜奖励、特批增加金额、特批减少金额)',
    name          varchar(100)                                          not null comment '操作名称(扣除挑战费、作为裁判奖励、购买视频、购买门票、购买道具、取消门票、管理员退票、申请答辩、冻结挑战费用、解冻挑战费用、挑战获胜奖励、特批增加金额、特批减少金额)',
    site          tinyint(1)                                            null comment '交易来源的平台',
    successtime   datetime                                              null comment '成功时间',
    failedtime    datetime                                              null comment '失败时间',
    memo          varchar(1000)                                         null comment '备注',
    status        tinyint(1)              default 1                     not null comment '状态(0禁用1启用)',
    createtime    timestamp               default '0000-00-00 00:00:00' not null comment '创建时间',
    updatetime    timestamp               default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    constraint uid
        unique (uid)
)
    comment '交易明细';

alter table tradedetail
    add primary key (uid);

create table user
(
    oid           int(11) unsigned auto_increment,
    uid           varchar(36)                                           not null comment '唯一uid',
    usersn        varchar(255)                                          null comment '会员号',
    email         varchar(255)                                          null,
    newemail      varchar(255)                                          null comment '新邮箱',
    phone         varchar(50)                                           null comment '电话',
    openid        varchar(100)                                          null comment '第三方身份id',
    mobile        varchar(50)                                           null comment '手机',
    validcode     varchar(50)                                           null comment '邮箱验证码',
    password      varchar(36)                                           null,
    paypwd        varchar(36)                                           null comment '支付密码',
    resetpwd      varchar(36)                                           null comment '重置密码VALUE',
    account       decimal(10, 2) unsigned default 0.00                  null comment '账户余额',
    freezeaccount decimal(10, 2) unsigned default 0.00                  null comment '冻结金额',
    totalpay      decimal(10, 2) unsigned default 0.00                  null comment '累计支出',
    totalincome   decimal(10, 2) unsigned default 0.00                  null comment '累计收入',
    type          int                                                   null comment '用户类别，如会员、学员、裁判、专家等',
    channelfrom   tinyint(1) unsigned                                   null comment '来自渠道(缴费|特批|邀请)',
    channelid     varchar(50)                                           null comment '最后登录设备',
    logincount    int(11) unsigned        default 0                     null comment '登录次数',
    lastlogintime datetime                                              null comment '最后登录时间',
    lastloginip   varchar(50)             default '127.0.0.1'           null comment '最后登录IP',
    data          varchar(255)                                          null comment '存放其他状态信息',
    status        tinyint(1) unsigned     default 1                     not null comment '状态',
    createtime    timestamp               default '0000-00-00 00:00:00' not null comment '开户时间',
    updatetime    timestamp               default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    primary key (oid, uid),
    constraint oid
        unique (oid),
    constraint uid
        unique (uid)
)
    comment '用户表';

create table userinfo
(
    uid          varchar(36)                             not null comment '唯一uid',
    name         varchar(100)                            null comment '真实姓名,2-4个汉字',
    nickname     varchar(100)                            null comment '用户英文名',
    showname     varchar(100)                            null comment '会员名',
    idtype       int       default 0                     null comment '证件类型',
    identityid   varchar(255)                            null comment '身份证号',
    gender       tinyint(1) unsigned                     null comment '性别(1:男2:女)',
    birthday     date                                    null comment '出生年月日',
    college      varchar(255)                            null comment '毕业院校',
    address      varchar(255)                            null comment '现居地址',
    qq           varchar(100)                            null comment 'QQ',
    wx           varchar(100)                            null comment '微信',
    sina         varchar(100)                            null comment '新浪微博',
    aisle        int                                     null comment '注册通道',
    othernicks   varchar(100)                            null comment '第三方登录昵称',
    otheravatar  varchar(100)                            null comment '第三方登录头像',
    country      varchar(100)                            null,
    soldier      varchar(100)                            null comment '士兵证',
    passport     varchar(100)                            null comment '护照',
    msn          varchar(100)                            null comment 'MSN',
    freeze       int       default 0                     null comment '用户冻结状态',
    avatarbig    varchar(100)                            null comment '个人头像180x180',
    avatar       varchar(255)                            null comment '中头像90x90',
    avatarlittle varchar(255)                            null comment '小头像36x36',
    original     varchar(255)                            null comment '原图',
    summary      varchar(1000)                           null comment '自我简介最多150字',
    job          varchar(255)                            null comment '职位',
    department   varchar(255)                            null comment '部门',
    company      varchar(255)                            null comment '供职单位',
    domain       varchar(255)                            null comment '二级域名',
    honor        varchar(1000)                           null comment '个人荣誉使用 ，以json格式存储(list(map))',
    education    varchar(1000)                           null comment '教育经历使用，以json格式存储(list(map))',
    work         varchar(1000)                           null comment '工作经历使用，以json格式存储(list(map))',
    createtime   timestamp default '0000-00-00 00:00:00' not null comment '创建时间',
    updatetime   timestamp default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '最后更新时间',
    oid          int                                     not null,
    status       int                                     null,
    constraint uid
        unique (uid)
)
    comment '用户信息表';

alter table userinfo
    add primary key (uid);

create table visitor
(
    uid        varchar(36)                               not null comment '唯一ID',
    loginip    varchar(36)                               null comment '登陆IP',
    nickname   varchar(100)                              null comment '游客昵称',
    avatar     varchar(255)                              null comment '游客头像',
    createtime timestamp   default '0000-00-00 00:00:00' not null comment '创建时间',
    useruid    varchar(36) default ''                    null comment '关联用户uid',
    constraint uid
        unique (uid)
)
    comment '游客';

alter table visitor
    add primary key (uid);


