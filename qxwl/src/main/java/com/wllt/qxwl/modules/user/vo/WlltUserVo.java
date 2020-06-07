package com.wllt.qxwl.modules.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: qxwl_server
 * @description: 用户Vo实体类
 * @author: Tian-Quanyou
 * @create: 2020-06-06 16:48
 **/
@Data
public class WlltUserVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 用户名
     */
    private String username;

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
    private String nickname;

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
     * 盐值
     */
    private String salt;

    /**
     * 目前单独角色
     */
    private List<String> roles;
}
