package com.wllt.qxwl.modules.account.attention.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (WlltAttention)实体类
 *
 * @author makejava
 * @since 2020-06-30 16:03:29
 */
@Data
@NoArgsConstructor
public class WlltAttention extends BaseEntity{

    /**
    * 关注帖子ID
    */
    private Long attentionId;
    /**
    * 关注的用户ID
    */
    private Long attentionUserId;
    /**
    * 关注主题类型ID
    */
    private Long attentionTypeId;
    /**
    * 用户ID
    */
    private Long userId;

}