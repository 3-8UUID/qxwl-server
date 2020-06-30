package com.wllt.qxwl.modules.article.post.controller;


import com.wllt.qxwl.comm.constant.ResultConstant;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.custom.click.entity.WlltClick;
import com.wllt.qxwl.modules.custom.click.service.WlltClickService;
import com.wllt.qxwl.modules.article.post.bo.WlltPostBo;
import com.wllt.qxwl.modules.article.post.entity.WlltPost;
import com.wllt.qxwl.modules.article.post.service.WlltPostService;
import com.wllt.qxwl.modules.account.user.service.WlltUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@RestController
@RequestMapping("qxwl/post/")
public class WlltPostController {

    @Autowired
    private WlltPostService wlltPostService;

    @Autowired
    private WlltClickService wlltClickService;

    @Autowired
    private WlltUserService wlltUserService;

    /**
     * 发布文章
     * @throws
    * @author Tian-Quanyou
    * @date 2020/6/8 14:53
    * @version V1.0
    */
    @PostMapping("create")
    public Result createPost(@RequestBody WlltPostBo postBo){
        WlltPost post = wlltPostService.createPost(postBo);
        if (ObjectUtils.isEmpty(post)){
            return ResultUtil.fail();
        }
        return ResultUtil.success(post);
    }

    /**
     * 点击文章
     * @throws
    * @author Tian-Quanyou
    * @date 2020/6/8 14:53
    * @version V1.0
    */
    @PostMapping("add/click")
    public Result addPostClick(@RequestBody WlltPostBo postBo){
        WlltClick click = wlltClickService.createPost(postBo);
        if (ObjectUtils.isEmpty(click)){
            return ResultUtil.fail(ResultConstant.RESULT_SAVE_FAIL);
        }
        return ResultUtil.success(click);
    }
}
