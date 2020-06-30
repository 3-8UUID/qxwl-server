package com.wllt.qxwl.modules.article.collect.controller;


import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.article.collect.service.WlltCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器 收藏
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@RestController
@RequestMapping("/qxwl/collect/")
public class WlltCollectController {

    @Autowired
    private WlltCollectService wlltCollectService;

    public Result save(){
        return null;
    }
}
