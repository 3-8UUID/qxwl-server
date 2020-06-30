package com.wllt.qxwl.modules.account.relation.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (RelationUR)实体类
 *
 * @author makejava
 * @since 2020-06-06 14:46:23
 */
@Data
public class RelationUR extends BaseEntity implements Serializable {
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 角色ID
    */
    private Long roleId;

}