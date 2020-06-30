package com.wllt.qxwl.modules.account.relation.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (RelationRP)实体类
 *
 * @author makejava
 * @since 2020-06-06 14:47:14
 */
@Data
public class RelationRP extends BaseEntity implements Serializable {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long purviewId;

}