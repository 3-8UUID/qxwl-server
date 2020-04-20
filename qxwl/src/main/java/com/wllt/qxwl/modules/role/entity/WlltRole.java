package com.wllt.qxwl.modules.role.entity;

import java.io.Serializable;

/**
 * (WlltRole)实体类
 *
 * @author makejava
 * @since 2020-04-19 15:16:27
 */
public class WlltRole implements Serializable {
    private static final long serialVersionUID = -38809702055758090L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 角色名
    */
    private String role;
    /**
    * 角色权限
    */
    private String purview;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPurview() {
        return purview;
    }

    public void setPurview(String purview) {
        this.purview = purview;
    }

}