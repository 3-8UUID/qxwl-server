package com.wllt.qxwl.modules.article.type.controller;


import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.article.type.entity.WlltType;
import com.wllt.qxwl.modules.article.type.service.WlltTypeService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@RestController
@RequestMapping("/qxwl/type")
public class WlltTypeController {

    @Autowired
    private WlltTypeService wlltTypeService;


    @RequestMapping("/create")
    public Result createByAdmin(){
        ArrayList<WlltType> list = Lists.newArrayList();
//        list.add(new WlltType("推荐"));
//        list.add(new WlltType("关注"));
//        list.add(new WlltType("文峰宝塔"));
//        list.add(new WlltType("清溪水库"));
//        list.add(new WlltType("清溪果产"));
//        list.add(new WlltType("博物馆"));
//        list.add(new WlltType("瑶族文化"));
//        list.add(new WlltType("其他"));
        boolean b = wlltTypeService.saveBatch(list);
        if (b){
            return ResultUtil.success(list);
        }
        return ResultUtil.fail();
    }
}
