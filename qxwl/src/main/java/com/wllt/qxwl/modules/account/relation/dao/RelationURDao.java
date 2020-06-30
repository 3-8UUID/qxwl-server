package com.wllt.qxwl.modules.account.relation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllt.qxwl.modules.account.relation.entity.RelationUR;
import org.apache.ibatis.annotations.Mapper;

/**
 * (RelationUR)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-06 14:46:24
 */
@Mapper
public interface RelationURDao extends BaseMapper<RelationUR> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RelationUR queryById(Long id);


}