package com.wllt.qxwl.modules.custom.click.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllt.qxwl.modules.custom.click.entity.WlltClick;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (WlltClick)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 15:03:47
 */
@Mapper
public interface WlltClickDao extends BaseMapper<WlltClick> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltClick queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltClick> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wlltClick 实例对象
     * @return 对象列表
     */
    List<WlltClick> queryAll(WlltClick wlltClick);


    /**
     * 修改数据
     *
     * @param wlltClick 实例对象
     * @return 影响行数
     */
    int update(WlltClick wlltClick);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}