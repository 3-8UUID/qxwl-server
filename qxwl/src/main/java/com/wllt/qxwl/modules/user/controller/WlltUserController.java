package com.wllt.qxwl.modules.user.controller;


import com.alibaba.fastjson.JSON;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.wllt.qxwl.modules.user.service.IWlltUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@RestController
@RequestMapping("/qxwl/user/wlltUser")
public class WlltUserController {
    @Autowired
    private IWlltUserService wlltUserService;

    @RequestMapping("/save")
    public String create(){

        WlltUser wlltUser = new WlltUser();
        boolean save = wlltUserService.save(wlltUser);
        if (save){
            return "ok";
        }
        return "no";
    }

    @RequestMapping("/list")
    public String list(){

        WlltUser wlltUser = new WlltUser();
        List<WlltUser> save = wlltUserService.find(wlltUser);


        return JSON.toJSONString(save);
    }

    @RequestMapping("/del")
    public String del(){
        return "已开启rbs";
    }
}
