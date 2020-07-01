package com.wllt.qxwl.modules.account.message.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllt.qxwl.modules.account.message.entity.WlltMessage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (WlltMessage)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-01 11:08:39
 */

public interface WlltMessageDao extends BaseMapper<WlltMessage> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltMessage queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltMessage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wlltMessage 实例对象
     * @return 对象列表
     */
    List<WlltMessage> queryAll(WlltMessage wlltMessage);



    /**
     * 修改数据
     *
     * @param wlltMessage 实例对象
     * @return 影响行数
     */
    int update(WlltMessage wlltMessage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}