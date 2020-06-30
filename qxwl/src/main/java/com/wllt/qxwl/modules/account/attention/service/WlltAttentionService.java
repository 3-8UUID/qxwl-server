package com.wllt.qxwl.modules.account.attention.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.account.attention.entity.WlltAttention;
import java.util.List;

/**
 * (WlltAttention)表服务接口
 *
 * @author makejava
 * @since 2020-06-30 16:03:31
 */
public interface WlltAttentionService extends IService<WlltAttention> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltAttention queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltAttention> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param wlltAttention 实例对象
     * @return 实例对象
     */
    WlltAttention insert(WlltAttention wlltAttention);

    /**
     * 修改数据
     *
     * @param wlltAttention 实例对象
     * @return 实例对象
     */
    WlltAttention update(WlltAttention wlltAttention);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}