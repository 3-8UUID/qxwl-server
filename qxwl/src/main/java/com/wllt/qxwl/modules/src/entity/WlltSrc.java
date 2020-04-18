package com.wllt.qxwl.modules.src.entity;

import com.wllt.qxwl.comm.base.QXWLBaseEntity;
import lombok.Data;

/**
 * <p>
 * 资源文件类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Data
public class WlltSrc extends QXWLBaseEntity {

    /**
     * 资源ID-文章-评论
     */
    private Long srcId;

    /**
     * 资源路径
     */
    private String srcUrl;

    /**
     * 资源类型 01图片 02文件 03视频
     */
    private Integer srcType;

    /**
     * 资源后缀名
     */
    private String srcSuffix;

    /**
     * 用户ID
     */
    private Long userId;


}
