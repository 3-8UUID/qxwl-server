package com.wllt.qxwl.modules.account.attention.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.account.attention.dao.WlltAttentionDao;
import com.wllt.qxwl.modules.account.attention.entity.WlltAttention;
import com.wllt.qxwl.modules.account.attention.service.WlltAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (WlltAttention)表服务实现类
 *
 * @author makejava
 * @since 2020-06-30 16:03:31
 */
@Service
public class WlltAttentionServiceImpl extends ServiceImpl<WlltAttentionDao, WlltAttention> implements WlltAttentionService {
    @Autowired
    private WlltAttentionDao wlltAttentionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WlltAttention queryById(Long id) {
        return this.wlltAttentionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<WlltAttention> queryAllByLimit(int offset, int limit) {
        return this.wlltAttentionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param wlltAttention 实例对象
     * @return 实例对象
     */
    @Override
    public WlltAttention insert(WlltAttention wlltAttention) {
        this.wlltAttentionDao.insert(wlltAttention);
        return wlltAttention;
    }

    /**
     * 修改数据
     *
     * @param wlltAttention 实例对象
     * @return 实例对象
     */
    @Override
    public WlltAttention update(WlltAttention wlltAttention) {
        this.wlltAttentionDao.update(wlltAttention);
        return this.queryById(wlltAttention.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.wlltAttentionDao.deleteById(id) > 0;
    }
}