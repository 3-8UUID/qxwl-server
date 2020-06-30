package com.wllt.qxwl.modules.custom.anon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wllt.qxwl.comm.constant.ResultConstant;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.article.post.bo.WlltPostBo;
import com.wllt.qxwl.modules.article.post.service.WlltPostService;
import com.wllt.qxwl.modules.article.post.vo.WlltPostVo;
import com.wllt.qxwl.modules.article.type.entity.WlltType;
import com.wllt.qxwl.modules.article.type.service.WlltTypeService;
import com.wllt.qxwl.modules.account.user.bo.WlltUserBo;
import com.wllt.qxwl.modules.account.user.service.WlltUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * //TODO 把请求地址存redis 再定时永久化
 *
 * @program: qxwl_server
 * @description: 公共资源 匿名访问 控制层
 * @author: Tian-Quanyou
 * @create: 2020-04-12 15:33
 **/
@RestController
@RequestMapping("/qxwl/anon/")
@Slf4j
public class AnonController {

    @Autowired
    private WlltUserService wlltUserService;

    @Autowired
    private WlltTypeService wlltTypeService;

    @Autowired
    private WlltPostService wlltPostService;

//    @RequestMapping("/toLogin")
//    public String goLogin() {
//        return "user/login";
//    }
//
//    @RequestMapping("/toRegister")
//    public String goRegister() {
//        return "user/register";
//    }
//
//    @RequestMapping(value = "/index")
//    public String wc() {
//        return "sys/index";
//    }

    /**
     * 注册
     *
     * @param userBo
     * @return
     */
    @PostMapping("/register")//register
    public Result userRegister(@RequestBody WlltUserBo userBo) {
        Boolean aBoolean = wlltUserService.userRegister(userBo);
        if (aBoolean) {
            return ResultUtil.success(ResultConstant.RESULT_REGISTER_SUCCESS);
        }
        return ResultUtil.fail(ResultConstant.RESULT_REGISTER_FAIL);
    }

    /**
     * 获取类型列表
     *
     * @return
     */
    @PostMapping("/getTypeList")
    public Result getTypeList() {
        List<WlltType> list = wlltTypeService.getTypeList();
        return ResultUtil.success(list);
    }

    @PostMapping("/getPostPage")
    public Result getPostPage(@RequestBody @Validated WlltPostBo wlltPostBo) {
        IPage<WlltPostVo> postPage = wlltPostService.getPageByTypeId(wlltPostBo);
        return ResultUtil.success(postPage);
    }




}
