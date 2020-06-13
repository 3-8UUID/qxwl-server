package com.wllt.qxwl.modules.post.bo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wllt.qxwl.modules.post.vo.WlltContentVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @program: qxwl_server
 * @description: 请求实体类
 * @author: Tian-Quanyou
 * @create: 2020-06-08 14:25
 **/
@Data
@NoArgsConstructor
public class WlltPostBo extends Page implements Serializable {
    private long serializable = 1L;

    private Long id;
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
    private List<WlltContentVo> contentList;

    /**
     * 文章类型ID
     */
    @NotNull
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
     * 索引项值
     */
    private String searchValue;

}
