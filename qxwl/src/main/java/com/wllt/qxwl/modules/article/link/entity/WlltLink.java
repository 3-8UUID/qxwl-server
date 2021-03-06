package com.wllt.qxwl.modules.article.link.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Data
public class WlltLink extends BaseEntity implements Serializable {

    /**
     * 链接ID
     */
    private Long linkId;

    /**
     * 链接url
     */
    private String linkUrl;

    /**
     * 评论ID
     */
    private Long commentId;

    /**
     * 用户ID
     */
    private Long userId;


}
