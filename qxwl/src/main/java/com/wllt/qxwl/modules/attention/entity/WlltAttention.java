package com.wllt.qxwl.modules.attention.entity;

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
public class WlltAttention extends BaseEntity {


    /**
     * 关注文章/帖子ID
     */
    private Long attentionId;

    /**
     * 关注的用户ID
     */
    private Long attentionUserId;

    /**
     * 关注类型Id
     */
    private Long attentionTypeId;

    /**
     * 用户ID
     */
    private Long userId;


}
