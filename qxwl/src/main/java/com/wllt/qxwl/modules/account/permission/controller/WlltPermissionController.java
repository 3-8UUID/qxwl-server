package com.wllt.qxwl.modules.account.permission.controller;

import com.wllt.qxwl.modules.account.permission.entity.WlltPermission;
import com.wllt.qxwl.modules.account.permission.service.WlltPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (WlltPermission)表控制层
 *
 * @author makejava
 * @since 2020-06-06 12:56:35
 */
@RestController
@RequestMapping("wlltPermission")
public class WlltPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private WlltPermissionService wlltPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WlltPermission selectOne(Long id) {
        return this.wlltPermissionService.queryById(id);
    }

}