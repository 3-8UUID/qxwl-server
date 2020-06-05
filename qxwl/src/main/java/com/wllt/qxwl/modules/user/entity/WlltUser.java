package com.wllt.qxwl.modules.user.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Data
public class WlltUser extends BaseEntity {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 地址
     */
    private String address;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 微信号
     */
    private String wxNumber;

    /**
     * 身份证
     */
    private String idCard;


    /**
     * 盐值
     */
    private String salt;
}
