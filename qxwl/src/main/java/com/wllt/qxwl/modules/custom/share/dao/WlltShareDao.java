package com.wllt.qxwl.modules.custom.share.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllt.qxwl.modules.custom.share.entity.WlltShare;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (WlltShare)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-01 11:09:37
 */
public interface WlltShareDao extends BaseMapper<WlltShare> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltShare queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltShare> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wlltShare 实例对象
     * @return 对象列表
     */
    List<WlltShare> queryAll(WlltShare wlltShare);


    /**
     * 修改数据
     *
     * @param wlltShare 实例对象
     * @return 影响行数
     */
    int update(WlltShare wlltShare);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}