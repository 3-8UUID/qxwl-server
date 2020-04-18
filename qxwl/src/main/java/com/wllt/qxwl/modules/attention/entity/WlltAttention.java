package com.wllt.qxwl.modules.attention.entity;

import com.wllt.qxwl.comm.base.QXWLBaseEntity;
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
public class WlltAttention extends QXWLBaseEntity {


    /**
     * 收藏ID
     */
    private Long attentionId;

    /**
     * 收藏夹名称
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
