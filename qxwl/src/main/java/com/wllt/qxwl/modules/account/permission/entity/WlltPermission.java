package com.wllt.qxwl.modules.account.permission.entity;

import com.wllt.qxwl.comm.base.BaseEntity;

import java.io.Serializable;

/**
 * (WlltPermission)实体类
 *
 * @author makejava
 * @since 2020-06-06 12:56:33
 */
public class WlltPermission extends BaseEntity implements Serializable {

    /**
    * 路由
    */
    private String url;
    /**
    * 权限
    */
    private String permission;

}