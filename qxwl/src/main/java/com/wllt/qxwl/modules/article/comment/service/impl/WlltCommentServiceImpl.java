package com.wllt.qxwl.modules.article.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.article.comment.bo.WlltCommentBo;
import com.wllt.qxwl.modules.article.comment.dao.WlltCommentDao;
import com.wllt.qxwl.modules.article.comment.entity.WlltComment;
import com.wllt.qxwl.modules.article.comment.service.WlltCommentService;
import com.wllt.qxwl.modules.account.user.entity.WlltUser;
import com.wllt.qxwl.modules.account.user.service.WlltUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Service
public class WlltCommentServiceImpl extends ServiceImpl<WlltCommentDao, WlltComment> implements WlltCommentService {

    @Autowired
    private WlltUserService wlltUserService;


    @Override
    public WlltComment createOrModify(WlltCommentBo wlltCommentBo) {
        Long id = wlltCommentBo.getId();
        WlltComment comment = new WlltComment();
        if (ObjectUtils.isEmpty(id)) {
            WlltUser loginUser = wlltUserService.getLoginUser();
            comment.setCommentContext(wlltCommentBo.getCommentContext());
            comment.setCollectId(wlltCommentBo.getCollectId());
            //TODO 若是设有图片评论
            //comment.setCommentSrcId(wlltCommentBo.getCommentSrcId());
            comment.setCommentId(wlltCommentBo.getCommentId());
            comment.setUserId(loginUser.getId());
            if (save(comment)) {
                return comment;
            }
        } else {
            UpdateWrapper<WlltComment> updateWrapper = new UpdateWrapper<>();
            updateWrapper.lambda().eq(WlltComment::getId, id);
            updateWrapper.lambda().set(WlltComment::getCommentContext,wlltCommentBo.getCommentContext());
            updateWrapper.lambda().set(WlltComment::getCommentSrcId,wlltCommentBo.getCommentSrcId());
            BeanUtils.copyProperties(wlltCommentBo,comment);
            if (update(updateWrapper)){
                return comment;
            }
        }
        return null;
    }
}
