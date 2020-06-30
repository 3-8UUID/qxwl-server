package com.wllt.qxwl.modules.account.role.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllt.qxwl.modules.account.role.entity.WlltRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (WlltRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-06 12:57:13
 */
@Mapper
public interface WlltRoleDao extends BaseMapper<WlltRole> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wlltRole 实例对象
     * @return 对象列表
     */
    List<WlltRole> queryAll(WlltRole wlltRole);


    /**
     * 修改数据
     *
     * @param wlltRole 实例对象
     * @return 影响行数
     */
    int update(WlltRole wlltRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


}