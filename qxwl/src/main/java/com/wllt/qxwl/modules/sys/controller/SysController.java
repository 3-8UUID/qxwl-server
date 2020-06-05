package com.wllt.qxwl.modules.sys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * //TODO 把请求地址存redis 再定时永久化
 * @program: qxwl_server
 * @description: 公共资源调转
 * @author: Tian-Quanyou
 * @create: 2020-04-12 15:33
 **/
@Controller
@RequestMapping("/qxwl/sys")
@Slf4j
public class SysController{


    @RequestMapping("/toLogin")
    public String goLogin(){
        return "user/login";
    }

    @RequestMapping("/toRegister")
    public String goRegister(){
        return "user/register";
    }

    @RequestMapping(value = "/index")
    public String wc() {
        return "sys/index";
    }


}
