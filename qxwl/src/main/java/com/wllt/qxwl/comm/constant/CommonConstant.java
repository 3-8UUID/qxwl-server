package com.wllt.qxwl.comm.constant;

/**
 * 常量
 * @author Devil
 */
public interface CommonConstant {

    String PARAM_IN = "入参";

    String PARAM_OUT = "出参";

    /**
     * 默认用户
     */
    String DEFAULT_USER = "admin";

    /**
     * 用户默认头像
     */
    String USER_DEFAULT_AVATAR = "http://47.102.208.247//download/image/man.png";

    /**
     * 用户登录注册标志1用户名+密码
     */
    Integer USER_FLAG_NAME = 1;

    /**
     * 用户登录注册标志1手机号+密码
     */
    Integer USER_FLAG_MOBILE = 2;


    /**
     * 用户登录注册标志1邮箱+密码
     */
    Integer USER_FLAG_EMAIL = 3;

    /**
     * 用户登录注册标志1邮箱+密码
     */
    Integer USER_FLAG_WX = 4;

    /**
     * 用户正常状态
     */
    Integer USER_STATUS_NORMAL = 0;

    /**
     * 用户禁用状态
     */
    Integer USER_STATUS_LOCK = 1;

    /**
     * 普通用户
     */
    Integer USER_TYPE_NORMAL = 0;

    /**
     * 管理员
     */
    Integer USER_TYPE_ADMIN = 1;

    /**
     * 全部数据权限
     */
    Integer DATA_TYPE_ALL = 0;

    /**
     * 自定义数据权限
     */
    Integer DATA_TYPE_CUSTOM = 1;

    /**
     * 正常状态
     */
    Integer STATUS_NORMAL = 0;

    /**
     * 禁用状态
     */
    Integer STATUS_DISABLE = 1;



    /**
     * 顶部菜单类型权限
     */
    Integer PERMISSION_NAV = -1;

    /**
     * 页面类型权限
     */
    Integer PERMISSION_PAGE = 0;

    /**
     * 操作类型权限
     */
    Integer PERMISSION_OPERATION = 1;

    /**
     * 1级菜单父id
     */
    String PARENT_ID = "0";

    /**
     * 0级菜单
     */
    Integer LEVEL_ZERO = 0;

    /**
     * 1级菜单
     */
    Integer LEVEL_ONE = 1;

    /**
     * 2级菜单
     */
    Integer LEVEL_TWO = 2;

    /**
     * 3级菜单
     */
    Integer LEVEL_THREE = 3;

    /**
     * 消息发送范围
     */
    Integer MESSAGE_RANGE_ALL = 0;

    /**
     * 未读
     */
    Integer MESSAGE_STATUS_UNREAD = 0;

    /**
     * 已读
     */
    Integer MESSAGE_STATUS_READ = 1;

    /**
     * qq登录
     */
    Integer SOCIAL_TYPE_QQ = 1;

    /**
     * 微博登录
     */
    Integer SOCIAL_TYPE_WEIBO = 2;

    /**
     * 短信验证码key前缀
     */
    String PRE_SMS = "QXWL_PRE_SMS:";

    /**
     * 邮件验证码key前缀
     */
    String PRE_EMAIL = "QXWL_PRE_EMAIL:";

    /**
     * 本地文件存储
     */
    Integer OSS_LOCAL = 0;

    /**
     * 七牛云OSS存储
     */
    Integer OSS_QINIU = 1;



    /**
     * 上传文件地址
     */
    String UPLOAD_PATH = "/opt/app/wllt/qxwl/";

    /**
     * 访问文件的地址
     */
    String DOWNLOAD_PATH = "/download/";


}
