package com.wllt.qxwl.modules.custom.share.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.custom.share.entity.WlltShare;
import com.wllt.qxwl.modules.custom.share.dao.WlltShareDao;
import com.wllt.qxwl.modules.custom.share.service.WlltShareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WlltShare)表服务实现类
 *
 * @author makejava
 * @since 2020-07-01 11:09:38
 */
@Service("wlltShareService")
public class WlltShareServiceImpl extends ServiceImpl<WlltShareDao,WlltShare> implements WlltShareService {
    @Resource
    private WlltShareDao wlltShareDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WlltShare queryById(Long id) {
        return this.wlltShareDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<WlltShare> queryAllByLimit(int offset, int limit) {
        return this.wlltShareDao.queryAllByLimit(offset, limit);
    }

    /**
     * 修改数据
     *
     * @param wlltShare 实例对象
     * @return 实例对象
     */
    @Override
    public WlltShare update(WlltShare wlltShare) {
        this.wlltShareDao.update(wlltShare);
        return this.queryById(wlltShare.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.wlltShareDao.deleteById(id) > 0;
    }
}