package com.wllt.qxwl.modules.article.post.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import com.wllt.qxwl.comm.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *  文章  、帖子实体类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Data
public class WlltPost extends BaseEntity implements Serializable {

    /**
     * 文章封面
     */
    private String postTitleImg;

    /**
     * 文章标题
     */
    private String postTitle;

    /**
     * 文章作者
     */
    private String postAuthor;

    /**
     * 文章内容
     */
    private String postContext;

    /**
     * 文章类型ID
     */
    private Long typeId;

    /**
     * 文章资源ID
     */
    private Long postSrcId;

    /**
     * 文章评论ID
     */
    private Long postCommentId;

    /**
     * 文章赞ID
     */
    private Long postGreatId;

    /**
     * 文章链接ID
     */
    private Long postLinkId;

    /**
     * 文章收藏ID
     */
    private Long postCollectId;

    /**
     * 文章关注ID
     */
    private Long postAttentionId;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 发帖时间
     */
    private String postTime = DateUtils.getDateTime();

}
