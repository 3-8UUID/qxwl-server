package com.wllt.qxwl.modules.account.attention.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: qxwl_server
 * @description: Bo前端映射实体类
 * @author: Tian-Quanyou
 * @create: 2020-06-30 16:17
 **/
@Data
@NoArgsConstructor
public class WlltAttentionBo implements Serializable {

    private Long id;
    /**
     * 关注帖子ID
     */
    private Long attentionId;
    /**
     * 关注的用户ID
     */
    private Long attentionUserId;
    /**
     * 关注主题类型ID
     */
    private Long attentionTypeId;
    /**
     * 用户ID
     */
    private Long userId;

}
