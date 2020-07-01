package com.wllt.qxwl.modules.custom.share.controller;

import com.wllt.qxwl.modules.custom.share.entity.WlltShare;
import com.wllt.qxwl.modules.custom.share.service.WlltShareService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (WlltShare)表控制层
 *
 * @author makejava
 * @since 2020-07-01 11:09:39
 */
@RestController
@RequestMapping("wlltShare")
public class WlltShareController {
    /**
     * 服务对象
     */
    @Resource
    private WlltShareService wlltShareService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WlltShare selectOne(Long id) {
        return this.wlltShareService.queryById(id);
    }

}