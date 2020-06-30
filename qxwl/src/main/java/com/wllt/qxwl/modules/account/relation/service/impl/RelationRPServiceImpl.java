package com.wllt.qxwl.modules.account.relation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.account.relation.entity.RelationRP;
import com.wllt.qxwl.modules.account.relation.dao.RelationRPDao;
import com.wllt.qxwl.modules.account.relation.service.RelationRPService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RelationRP)表服务实现类
 *
 * @author makejava
 * @since 2020-06-06 14:47:14
 */
@Service("relationRPService")
public class RelationRPServiceImpl extends ServiceImpl<RelationRPDao,RelationRP> implements RelationRPService {
    @Resource
    private RelationRPDao relationRPDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RelationRP queryById(Long id) {
        return this.relationRPDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RelationRP> queryAllByLimit(int offset, int limit) {
        return this.relationRPDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param relationRP 实例对象
     * @return 实例对象
     */
    @Override
    public RelationRP insert(RelationRP relationRP) {
        this.relationRPDao.insert(relationRP);
        return relationRP;
    }

    /**
     * 修改数据
     *
     * @param relationRP 实例对象
     * @return 实例对象
     */
    @Override
    public RelationRP update(RelationRP relationRP) {
        this.relationRPDao.update(relationRP);
        return this.queryById(relationRP.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.relationRPDao.deleteById(id) > 0;
    }
}