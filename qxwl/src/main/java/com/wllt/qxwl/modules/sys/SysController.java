package com.wllt.qxwl.modules.sys;

import com.wllt.qxwl.comm.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: qxwl_server
 * @description: 资源调转
 * @author: Tian-Quanyou
 * @create: 2020-04-12 15:33
 **/
@Controller
@RequestMapping("/qxwl/sys")
@Slf4j
public class SysController extends BaseController {



    @RequestMapping("/login")
    public String goLogin(){
        log.info("请求IP地址:{}",this.getClientIP());
        return "user/login";
    }

    @RequestMapping("/register")
    public String goRegister(){
        log.info("请求IP地址:{}",this.getClientIP());
        return "user/register";
    }

    @RequestMapping(value = "/index")
    public String wc() {
        log.info("请求IP地址:{}",this.getClientIP());
        return "sys/index";
    }
}
