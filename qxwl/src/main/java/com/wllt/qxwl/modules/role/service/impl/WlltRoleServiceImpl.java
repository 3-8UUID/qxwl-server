package com.wllt.qxwl.modules.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.role.entity.WlltRole;
import com.wllt.qxwl.modules.role.dao.WlltRoleDao;
import com.wllt.qxwl.modules.role.service.WlltRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WlltRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 15:16:31
 */
@Service("wlltRoleService")
public class WlltRoleServiceImpl extends ServiceImpl<WlltRoleDao,WlltRole> implements WlltRoleService {
    @Resource
    private WlltRoleDao wlltRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WlltRole queryById(Long id) {
        return this.wlltRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<WlltRole> queryAllByLimit(int offset, int limit) {
        return this.wlltRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param wlltRole 实例对象
     * @return 实例对象
     */
    @Override
    public WlltRole insert(WlltRole wlltRole) {
        this.wlltRoleDao.insert(wlltRole);
        return wlltRole;
    }

    /**
     * 修改数据
     *
     * @param wlltRole 实例对象
     * @return 实例对象
     */
    @Override
    public WlltRole update(WlltRole wlltRole) {
        this.wlltRoleDao.update(wlltRole);
        return this.queryById(wlltRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.wlltRoleDao.deleteById(id) > 0;
    }
}