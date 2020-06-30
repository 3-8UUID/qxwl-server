package com.wllt.qxwl.modules.account.relation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllt.qxwl.modules.account.relation.entity.RelationRP;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (RelationRP)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-06 14:47:14
 */
@Mapper
public interface RelationRPDao extends BaseMapper<RelationRP> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RelationRP queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RelationRP> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param relationRP 实例对象
     * @return 对象列表
     */
    List<RelationRP> queryAll(RelationRP relationRP);

    /**
     * 新增数据
     *
     * @param relationRP 实例对象
     * @return 影响行数
     */
    int insert(RelationRP relationRP);

    /**
     * 修改数据
     *
     * @param relationRP 实例对象
     * @return 影响行数
     */
    int update(RelationRP relationRP);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}