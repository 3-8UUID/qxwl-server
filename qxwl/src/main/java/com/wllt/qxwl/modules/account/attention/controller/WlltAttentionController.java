package com.wllt.qxwl.modules.account.attention.controller;

import com.wllt.qxwl.modules.account.attention.entity.WlltAttention;
import com.wllt.qxwl.modules.account.attention.service.WlltAttentionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (WlltAttention)关注与粉丝
 *
 * @author makejava
 * @since 2020-06-30 16:03:32
 */
@RestController
@RequestMapping("qxwl/attention")
public class WlltAttentionController {
    /**
     * 服务对象
     */
    @Resource
    private WlltAttentionService wlltAttentionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WlltAttention selectOne(Long id) {
        return this.wlltAttentionService.queryById(id);
    }

}