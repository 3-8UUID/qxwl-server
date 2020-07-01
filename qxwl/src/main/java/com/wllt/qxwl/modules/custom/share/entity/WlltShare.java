package com.wllt.qxwl.modules.custom.share.entity;

import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (WlltShare)实体类
 *
 * @author makejava
 * @since 2020-07-01 11:09:35
 */
@Data
@NoArgsConstructor
public class WlltShare extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -93983990327459423L;
    /**
    * 分享时间
    */
    private Date shareTime;
    /**
    * 分享帖子ID
    */
    private Long postId;
    /**
    * 分享用户ID
    */
    private Long shareUserId;
    /**
    * 分享主题类型ID
    */
    private Long typeId;
    /**
    * 分享评论ID
    */
    private Long commentId;
    /**
    * 操作用户ID
    */
    private Long userId;

}