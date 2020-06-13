package com.wllt.qxwl.modules.post.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.post.bo.WlltPostBo;
import com.wllt.qxwl.modules.post.entity.WlltPost;
import com.wllt.qxwl.modules.post.vo.WlltPostVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
public interface WlltPostService extends IService<WlltPost> {

    /**
     * 获取文章分页信息
    * @throws
    * @author Tian-Quanyou
    * @date 2020/6/8 14:20
    * @version V1.0
    */
    IPage<WlltPostVo> getPageByTypeId(WlltPostBo wlltPostBo);

    /**
     * 发布文章
    * @throws
    * @author Tian-Quanyou
    * @date 2020/6/8 14:54
    * @version V1.0
    */
    WlltPost createPost(WlltPostBo postBo);
}
