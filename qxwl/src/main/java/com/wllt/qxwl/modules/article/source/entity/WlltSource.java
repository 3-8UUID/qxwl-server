package com.wllt.qxwl.modules.article.source.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (WlltSource)实体类
 *
 * @author makejava
 * @since 2020-06-13 16:15:49
 */
@Data
public class WlltSource extends BaseEntity implements Serializable {
    /**
    * 资源ID-文章-评论
    */
    private Long srcId;
    /**
    * 资源访问路径
    */
    private String srcUrl;
    /**
    * 资源类型 101图片 102文件 103视频
    */
    private Integer srcType;
    /**
    * 资源后缀名
    */
    private String srcSuffix;
    /**
    * 资源下载数（version1.5）
    */
    private Integer srcDown;
    /**
    * 所属用户ID
    */
    private Long userId;


}