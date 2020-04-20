package com.wllt.qxwl.modules.user.bo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: qxwl_server
 * @description: 前端交互实体对象用户Bo
 * @author: Tian-Quanyou
 * @create: 2020-04-13 10:31
 **/
@Data
public class WlltUserBo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private char[] password;

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
     * 注册登录标志 1：用户名+密码  2：手机+密码 3 邮箱+密码
     */
    private Integer flag;

    /**
     * 加密密码
     */
    private String encryptPwd;

    /**
     * 加密密码
     */
    private List<String> roles;
    /**
     * 盐值
     */
    private String salt;

}
