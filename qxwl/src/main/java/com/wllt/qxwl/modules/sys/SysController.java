package com.wllt.qxwl.modules.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: qxwl_server
 * @description: 资源调转
 * @author: Tian-Quanyou
 * @create: 2020-04-12 15:33
 **/
@Controller
@RequestMapping("/sys")
public class SysController {

    @RequestMapping("/login")
    public String goLogin(){
        return "user/login";
    }

    @RequestMapping("/register")
    public String goRegister(){
        return "user/register";
    }

    @RequestMapping(value = "index")
    public String wc() {
        return "sys/index";
    }
}
