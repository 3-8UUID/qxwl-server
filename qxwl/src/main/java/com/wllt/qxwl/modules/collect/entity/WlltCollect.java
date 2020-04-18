package com.wllt.qxwl.modules.collect.entity;

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
public class WlltCollect extends QXWLBaseEntity {


    /**
     * 收藏ID
     */
    private Long collectId;

    /**
     * 收藏夹名称
     */
    private String collectName;

    /**
     * 收藏评论ID
     */
    private Long collectCommentId;

    /**
     * 用户ID
     */
    private Long userId;


}
