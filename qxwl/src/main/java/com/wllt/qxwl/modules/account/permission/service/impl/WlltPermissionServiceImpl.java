package com.wllt.qxwl.modules.account.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.account.permission.entity.WlltPermission;
import com.wllt.qxwl.modules.account.permission.dao.WlltPermissionDao;
import com.wllt.qxwl.modules.account.permission.service.WlltPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WlltPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-06-06 12:56:35
 */
@Service
public class WlltPermissionServiceImpl extends ServiceImpl<WlltPermissionDao,WlltPermission> implements WlltPermissionService {
    @Resource
    private WlltPermissionDao wlltPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WlltPermission queryById(Long id) {
        return this.wlltPermissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<WlltPermission> queryAllByLimit(int offset, int limit) {
        return this.wlltPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param wlltPermission 实例对象
     * @return 实例对象
     */
    @Override
    public WlltPermission insert(WlltPermission wlltPermission) {
        this.wlltPermissionDao.insert(wlltPermission);
        return wlltPermission;
    }

    /**
     * 修改数据
     *
     * @param wlltPermission 实例对象
     * @return 实例对象
     */
    @Override
    public WlltPermission update(WlltPermission wlltPermission) {
        this.wlltPermissionDao.update(wlltPermission);
        return this.queryById(wlltPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.wlltPermissionDao.deleteById(id) > 0;
    }
}