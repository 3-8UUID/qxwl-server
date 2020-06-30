package com.wllt.qxwl.modules.article.comment.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: qxwl_server
 * @description: Bo请求实体类
 * @author: Tian-Quanyou
 * @create: 2020-06-29 17:32
 **/
@Data
@NoArgsConstructor
public class WlltCommentBo implements Serializable {
    private long serializable = 1L;

    private Long id;
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
}
