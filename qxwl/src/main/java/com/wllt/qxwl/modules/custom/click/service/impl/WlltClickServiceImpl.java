package com.wllt.qxwl.modules.custom.click.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.custom.click.dao.WlltClickDao;
import com.wllt.qxwl.modules.custom.click.entity.WlltClick;
import com.wllt.qxwl.modules.custom.click.service.WlltClickService;
import com.wllt.qxwl.modules.article.post.bo.WlltPostBo;
import com.wllt.qxwl.modules.account.user.entity.WlltUser;
import com.wllt.qxwl.modules.account.user.service.WlltUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * (WlltClick)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 15:03:49
 */
@Service
public class WlltClickServiceImpl extends ServiceImpl<WlltClickDao,WlltClick> implements WlltClickService {
    @Autowired
    private WlltClickDao wlltClickDao;
    @Autowired
    private WlltUserService wlltUserService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WlltClick queryById(Long id) {
        return this.wlltClickDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<WlltClick> queryAllByLimit(int offset, int limit) {
        return this.wlltClickDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param wlltClick 实例对象
     * @return 实例对象
     */
    @Override
    public WlltClick insert(WlltClick wlltClick) {
        this.wlltClickDao.insert(wlltClick);
        return wlltClick;
    }

    /**
     * 修改数据
     *
     * @param wlltClick 实例对象
     * @return 实例对象
     */
    @Override
    public WlltClick update(WlltClick wlltClick) {
        this.wlltClickDao.update(wlltClick);
        return this.queryById(wlltClick.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.wlltClickDao.deleteById(id) > 0;
    }

    @Override
    public WlltClick createPost(WlltPostBo postBo) {
        WlltUser user = wlltUserService.getLoginUser();
        if (ObjectUtils.isEmpty(user)){
           return null;
        }
        WlltClick click = new WlltClick();
        click.setPostId(user.getId());
        click.setClickUserId(user.getId());
        click.setUserId(postBo.getUserId());
        boolean save = save(click);
        if (save){
            return click;
        }
        return null;
    }
}