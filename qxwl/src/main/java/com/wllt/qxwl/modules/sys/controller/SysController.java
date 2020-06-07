package com.wllt.qxwl.modules.sys.controller;

import com.wllt.qxwl.comm.constant.ResultConstant;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.user.bo.WlltUserBo;
import com.wllt.qxwl.modules.user.service.WlltUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * //TODO 把请求地址存redis 再定时永久化
 *
 * @program: qxwl_server
 * @description: 公共资源调转
 * @author: Tian-Quanyou
 * @create: 2020-04-12 15:33
 **/
@Controller
@RequestMapping("/qxwl/sys/")
@Slf4j
public class SysController {

    @Autowired
    private WlltUserService wlltUserService;

    @RequestMapping("/toLogin")
    public String goLogin() {
        return "user/login";
    }

    @RequestMapping("/toRegister")
    public String goRegister() {
        return "user/register";
    }

    @RequestMapping(value = "/index")
    public String wc() {
        return "sys/index";
    }

    /**
     * 注册
     *
     * @param userBo
     * @return
     */
    @ResponseBody
    @PostMapping("/register")//register
    public Result userRegister(@RequestBody WlltUserBo userBo) {
        Boolean aBoolean = wlltUserService.userRegister(userBo);
        if (aBoolean) {
            return ResultUtil.success(ResultConstant.RESULT_REGISTER_SUCCESS);
        }
        return ResultUtil.fail(ResultConstant.RESULT_REGISTER_FAIL);
    }

}
