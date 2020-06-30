package com.wllt.qxwl.modules.article.post.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.modules.article.post.bo.WlltPostBo;
import com.wllt.qxwl.modules.article.post.dao.WlltPostDao;
import com.wllt.qxwl.modules.article.post.entity.WlltPost;
import com.wllt.qxwl.modules.article.post.service.WlltPostService;
import com.wllt.qxwl.modules.article.post.vo.WlltPostVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Service
public class WlltPostServiceImpl extends ServiceImpl<WlltPostDao, WlltPost> implements WlltPostService {

    @Override
    public IPage<WlltPostVo> getPageByTypeId(WlltPostBo wlltPostBo) {
        QueryWrapper<WlltPost> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(WlltPost::getStatus, CommonConstant.STATUS_NORMAL);
        wrapper.lambda().eq(WlltPost::getTypeId, wlltPostBo.getTypeId());
        wrapper.lambda().like(WlltPost::getPostTitle, wlltPostBo.getSearchValue());
        int count = count(wrapper);
        if (count <= 0){
            wrapper.lambda().like(WlltPost::getPostTitle, null);
            wrapper.lambda().like(WlltPost::getPostAuthor, wlltPostBo.getSearchValue());
        }
        WlltPostBo page = page(wlltPostBo, wrapper);
        System.out.println("page = " + page);
        return page;
    }

    @Override
    public WlltPost createPost(WlltPostBo postBo) {
        //TODO 上传文章的附件 //初始化点击率
        WlltPost post = new WlltPost();
        BeanUtils.copyProperties(postBo,post);
        boolean save = save(post);
        if (save){
            return post;
        }
        return null;
    }
}
