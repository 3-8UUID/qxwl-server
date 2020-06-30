package com.wllt.qxwl.modules.custom.click.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (WlltClick)实体类
 *
 * @author makejava
 * @since 2020-06-08 15:03:46
 */

@Data
public class WlltClick extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -11729006763024208L;
    /**
    * 点击文章ID
    */
    private Long postId;
    /**
    * 点击人ID
    */
    private Long userId;
    /**
    * 被点击用户ID
    */
    private Long clickUserId;



}