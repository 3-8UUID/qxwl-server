package com.wllt.qxwl.modules.article.source.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.utils.SnowFlakeUtils;
import com.wllt.qxwl.modules.article.source.dao.WlltSourceDao;
import com.wllt.qxwl.modules.article.source.entity.WlltSource;
import com.wllt.qxwl.modules.article.source.service.WlltSourceService;
import com.wllt.qxwl.modules.account.user.entity.WlltUser;
import com.wllt.qxwl.modules.account.user.service.WlltUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * (WlltSource)表服务实现类
 *
 * @author makejava
 * @since 2020-06-13 16:15:51
 */
@Service
public class WlltSourceServiceImpl extends ServiceImpl<WlltSourceDao, WlltSource> implements WlltSourceService {
    @Resource
    private WlltSourceDao wlltSourceDao;

    @Autowired
    private WlltUserService wlltUserService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WlltSource queryById(Long id) {
        return this.wlltSourceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<WlltSource> queryAllByLimit(int offset, int limit) {
        return this.wlltSourceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param wlltSource 实例对象
     * @return 实例对象
     */
    @Override
    public WlltSource insert(WlltSource wlltSource) {
        this.wlltSourceDao.insert(wlltSource);
        return wlltSource;
    }

    /**
     * 修改数据
     *
     * @param wlltSource 实例对象
     * @return 实例对象
     */
    @Override
    public WlltSource update(WlltSource wlltSource) {
        this.wlltSourceDao.update(wlltSource);
        return this.queryById(wlltSource.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.wlltSourceDao.deleteById(id) > 0;
    }

    @Override
    public WlltSource createFile(MultipartFile file) {
        WlltUser loginUser = wlltUserService.getLoginUser();
        long srcId = SnowFlakeUtils.getFlowIdInstance().nextId();
        WlltSource source = new WlltSource();
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toUpperCase();
        String filePath = CommonConstant.UPLOAD_PATH + CommonConstant.IMG_PREFIX + srcId + "/";
        source.setSrcUrl(filePath);
        source.setSrcSuffix(type);
        source.setUserId(loginUser.getId());

        File desFile = new File(filePath + source.getId() + "." + type);
        if (!desFile.getParentFile().exists()) {
            desFile.getParentFile().mkdirs();
        }
        System.out.println(file.isEmpty());
        try {
            file.transferTo(desFile);
        } catch (IllegalStateException | IOException ex) {
            log.error("uploadIMG失败", ex);
        }
        boolean save = save(source);
        if (save) {
            return source;
        }
        return null;
    }
}