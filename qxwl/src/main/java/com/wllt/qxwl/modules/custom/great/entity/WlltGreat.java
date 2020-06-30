package com.wllt.qxwl.modules.custom.great.entity;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
public class WlltGreat implements Serializable {



    /**
     * 赞ID
     */
    private Long greatId;

    /**
     * 赞主题类型ID
     */
    private Long typeId;

    /**
     * 赞评论ID
     */
    private Long commentId;

    /**
     * 赞类型：
     * 01普通赞
     * 02搞笑
     * 03感到
     * 04好看
     * 10踩赞
     */
    private String greatType;

    /**
     * 用户ID
     */
    private Long userId;


}
