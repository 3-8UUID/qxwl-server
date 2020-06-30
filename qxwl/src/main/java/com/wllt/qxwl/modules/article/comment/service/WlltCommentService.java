package com.wllt.qxwl.modules.article.comment.service;

import com.wllt.qxwl.modules.article.comment.bo.WlltCommentBo;
import com.wllt.qxwl.modules.article.comment.entity.WlltComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
public interface WlltCommentService extends IService<WlltComment> {

    /**
     * 添加或修改评论
    * @throws
    * @author Tian-Quanyou
    * @date 2020/6/29 17:41
    * @version V1.0
    */
    WlltComment createOrModify(WlltCommentBo wlltCommentBo);
}
