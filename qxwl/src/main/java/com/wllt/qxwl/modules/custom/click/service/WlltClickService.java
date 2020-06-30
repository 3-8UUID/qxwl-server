package com.wllt.qxwl.modules.custom.click.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.custom.click.entity.WlltClick;
import com.wllt.qxwl.modules.article.post.bo.WlltPostBo;

import java.util.List;

/**
 * (WlltClick)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 15:03:49
 */
public interface WlltClickService extends IService<WlltClick> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltClick queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltClick> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param wlltClick 实例对象
     * @return 实例对象
     */
    WlltClick insert(WlltClick wlltClick);

    /**
     * 修改数据
     *
     * @param wlltClick 实例对象
     * @return 实例对象
     */
    WlltClick update(WlltClick wlltClick);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 点击文章
    * @author Tian-Quanyou
    * @date 2020/6/29 16:58
    * @version V1.0
    */
    WlltClick createPost(WlltPostBo postBo);
}