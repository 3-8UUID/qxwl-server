package com.wllt.qxwl.modules.account.relation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.account.relation.dao.RelationURDao;
import com.wllt.qxwl.modules.account.relation.entity.RelationUR;
import com.wllt.qxwl.modules.account.relation.service.RelationURService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (RelationUR)表服务实现类
 *
 * @author makejava
 * @since 2020-06-06 14:46:26
 */
@Service
public class RelationURServiceImpl extends ServiceImpl<RelationURDao,RelationUR> implements RelationURService {
    @Resource
    private RelationURDao relationURDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RelationUR queryById(Long id) {
        return this.relationURDao.queryById(id);
    }

}