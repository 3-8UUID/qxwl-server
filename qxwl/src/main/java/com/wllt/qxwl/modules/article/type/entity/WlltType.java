package com.wllt.qxwl.modules.article.type.entity;

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
public class WlltType extends BaseEntity implements Serializable {

//    public WlltType(){};
//    public WlltType(String typeName){
//        this.typeName = typeName;
//    }
    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型关注ID
     */
    private Long typeAttentionId;

    /**
     * 类型评论ID
     */
    private Long typeCommentId;

    /**
     * 类型收藏ID
     */
    private Long typeCollectId;

    /**
     * 用户ID
     */
    private Long userId;


}
