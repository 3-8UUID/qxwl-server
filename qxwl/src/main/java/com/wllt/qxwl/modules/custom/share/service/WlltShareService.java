package com.wllt.qxwl.modules.custom.share.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.custom.share.entity.WlltShare;
import java.util.List;

/**
 * (WlltShare)表服务接口
 *
 * @author makejava
 * @since 2020-07-01 11:09:38
 */
public interface WlltShareService extends IService<WlltShare> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltShare queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltShare> queryAllByLimit(int offset, int limit);

    /**
     * 修改数据
     *
     * @param wlltShare 实例对象
     * @return 实例对象
     */
    WlltShare update(WlltShare wlltShare);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}