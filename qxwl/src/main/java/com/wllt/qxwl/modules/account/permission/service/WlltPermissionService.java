package com.wllt.qxwl.modules.account.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.account.permission.entity.WlltPermission;
import java.util.List;

/**
 * (WlltPermission)表服务接口
 *
 * @author makejava
 * @since 2020-06-06 12:56:35
 */
public interface WlltPermissionService extends IService<WlltPermission> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltPermission queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param wlltPermission 实例对象
     * @return 实例对象
     */
    WlltPermission insert(WlltPermission wlltPermission);

    /**
     * 修改数据
     *
     * @param wlltPermission 实例对象
     * @return 实例对象
     */
    WlltPermission update(WlltPermission wlltPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}