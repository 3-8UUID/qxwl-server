package com.wllt.qxwl.modules.account.permission.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllt.qxwl.modules.account.permission.entity.WlltPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (WlltPermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-06 12:56:34
 */
@Mapper
public interface WlltPermissionDao extends BaseMapper<WlltPermission> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltPermission queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltPermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wlltPermission 实例对象
     * @return 对象列表
     */
    List<WlltPermission> queryAll(WlltPermission wlltPermission);


    /**
     * 修改数据
     *
     * @param wlltPermission 实例对象
     * @return 影响行数
     */
    int update(WlltPermission wlltPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}