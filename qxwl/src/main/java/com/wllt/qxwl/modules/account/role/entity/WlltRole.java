package com.wllt.qxwl.modules.account.role.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (WlltRole)实体类
 *
 * @author makejava
 * @since 2020-06-06 12:57:12
 */
@Data
public class WlltRole extends BaseEntity implements Serializable {

    /**
    * 角色
    */
    private String role;



}