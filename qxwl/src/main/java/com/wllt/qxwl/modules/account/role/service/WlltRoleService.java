package com.wllt.qxwl.modules.account.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.account.role.entity.WlltRole;

import java.util.List;

/**
 * (WlltRole)表服务接口
 *
 * @author makejava
 * @since 2020-06-06 12:57:15
 */
public interface WlltRoleService extends IService<WlltRole> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltRole queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<WlltRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param wlltRole 实例对象
     * @return 实例对象
     */
    WlltRole insert(WlltRole wlltRole);

    /**
     * 修改数据
     *
     * @param wlltRole 实例对象
     * @return 实例对象
     */
    WlltRole update(WlltRole wlltRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 添加角色
     *
     * @param roleCode 角色代码
     * @param userId   用户ID
     * @author Tian-Quanyou
     * @date 2020/6/6 14:38
     * @version V1.0
     */
    Boolean addRole(Long userId, Integer roleCode);
}