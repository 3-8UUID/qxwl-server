package com.wllt.qxwl.modules.account.message.controller;

import com.wllt.qxwl.modules.account.message.entity.WlltMessage;
import com.wllt.qxwl.modules.account.message.service.WlltMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (WlltMessage)表控制层
 *
 * @author makejava
 * @since 2020-07-01 11:08:40
 */
@RestController
@RequestMapping("/qxwl/message")
public class WlltMessageController {
    /**
     * 服务对象
     */
    @Autowired
    private WlltMessageService wlltMessageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WlltMessage selectOne(Long id) {
        return this.wlltMessageService.queryById(id);
    }

}