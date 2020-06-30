package com.wllt.qxwl.modules.article.collect.entity;

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
public class WlltCollect extends BaseEntity {


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
