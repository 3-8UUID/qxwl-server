package com.wllt.qxwl.modules.account.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.account.relation.entity.RelationUR;

/**
 * (RelationUR)表服务接口
 *
 * @author makejava
 * @since 2020-06-06 14:46:25
 */
public interface RelationURService extends IService<RelationUR> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RelationUR queryById(Long id);



}