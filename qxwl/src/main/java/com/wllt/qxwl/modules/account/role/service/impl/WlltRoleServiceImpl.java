package com.wllt.qxwl.modules.account.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.enums.RoleEnum;
import com.wllt.qxwl.modules.account.relation.entity.RelationUR;
import com.wllt.qxwl.modules.account.relation.service.RelationURService;
import com.wllt.qxwl.modules.account.role.entity.WlltRole;
import com.wllt.qxwl.modules.account.role.dao.WlltRoleDao;
import com.wllt.qxwl.modules.account.role.service.WlltRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WlltRole)表服务实现类
 *
 * @author makejava
 * @since 2020-06-06 12:57:15
 */
@Service("wlltRoleService")
public class WlltRoleServiceImpl extends ServiceImpl<WlltRoleDao, WlltRole> implements WlltRoleService {
    @Resource
    private WlltRoleDao wlltRoleDao;

    @Autowired
    private RelationURService relationURService;

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
     * @param limit  查询条数
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

    @Override
    public Boolean addRole(Long userId, Integer roleCodes) {
//        for (int i = 0; i < roleCodes.length; i++) {
//
//        }
        RoleEnum roleEnum = RoleEnum.getByCode(roleCodes);
        QueryWrapper<WlltRole> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(WlltRole::getRole, roleEnum.getValue());
        wrapper.lambda().eq(WlltRole::getStatus, CommonConstant.STATUS_NORMAL);
        WlltRole wlltRole = getOne(wrapper);
        if (ObjectUtils.isEmpty(wlltRole)) {
            return false;
        }
        RelationUR ur = new RelationUR();
        ur.setRoleId(wlltRole.getId());
        ur.setUserId(userId);
        return relationURService.save(ur);
    }
}