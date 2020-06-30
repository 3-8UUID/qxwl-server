package com.wllt.qxwl.modules.article.source.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.article.source.entity.WlltSource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * (WlltSource)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 16:15:50
 */
public interface WlltSourceService extends IService<WlltSource> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WlltSource queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WlltSource> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param wlltSource 实例对象
     * @return 实例对象
     */
    WlltSource insert(WlltSource wlltSource);

    /**
     * 修改数据
     *
     * @param wlltSource 实例对象
     * @return 实例对象
     */
    WlltSource update(WlltSource wlltSource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    WlltSource createFile(MultipartFile file);
}