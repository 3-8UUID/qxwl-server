package com.wllt.qxwl.modules.article.comment.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;
import com.wllt.qxwl.comm.utils.DateUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Data
public class WlltComment extends BaseEntity {

    /**
     * 评论ID
     */
    private Long commentId;

    /**
     * 评论内容
     */
    private String commentContext;

    /**
     * 评论资源ID
     */
    private Long commentSrcId;

    /**
     * 评论赞ID
     */
    private Long commentGreatId;

    /**
     * 评论收藏ID
     */
    private Long collectId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 评论时间
     */
    private String commentTime = DateUtils.getDateTime();
}
