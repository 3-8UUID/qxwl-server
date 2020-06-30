package com.wllt.qxwl.modules.account.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.account.relation.entity.RelationRP;
import java.util.List;

/**
 * (RelationRP)表服务接口
 *
 * @author makejava
 * @since 2020-06-06 14:47:14
 */
public interface RelationRPService extends IService<RelationRP> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RelationRP queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RelationRP> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param relationRP 实例对象
     * @return 实例对象
     */
    RelationRP insert(RelationRP relationRP);

    /**
     * 修改数据
     *
     * @param relationRP 实例对象
     * @return 实例对象
     */
    RelationRP update(RelationRP relationRP);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}