package com.wllt.qxwl.modules.account.message.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wllt.qxwl.comm.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (WlltMessage)实体类
 *
 * @author makejava
 * @since 2020-07-01 11:08:37
 */
@Data
@NoArgsConstructor
public class WlltMessage extends BaseEntity implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = -37137907238142455L;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 操作时间
    */
    private Date operateTime;
    /**
    * 文章ID
    */
    private Long postId;
    /**
    * 点赞ID
    */
    private Long greatId;
    /**
    * 评论ID
    */
    private Long commentId;
    /**
    * 分享ID
    */
    private Long shareId;
    /**
    * 点击ID
    */
    private Long clickId;
    /**
    * 收藏ID
    */
    private Long collectId;
    /**
    * 关注ID
    */
    private Long attentionId;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 是否查看：0未读消息 1已查阅
    */
    private Integer isRead;

}