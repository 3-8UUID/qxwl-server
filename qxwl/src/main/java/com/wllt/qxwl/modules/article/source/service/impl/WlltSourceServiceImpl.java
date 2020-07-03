package com.wllt.qxwl.modules.article.source.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.utils.SnowFlakeUtils;
import com.wllt.qxwl.modules.account.user.entity.WlltUser;
import com.wllt.qxwl.modules.account.user.service.WlltUserService;
import com.wllt.qxwl.modules.article.source.dao.WlltSourceDao;
import com.wllt.qxwl.modules.article.source.entity.WlltSource;
import com.wllt.qxwl.modules.article.source.service.WlltSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
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
    public WlltSource createFile(MultipartFile file, Long srcId) {

        WlltUser loginUser = wlltUserService.getLoginUser();
        srcId = ObjectUtils.isEmpty(srcId)?SnowFlakeUtils.getFlowIdInstance().nextId():srcId;
        WlltSource source = new WlltSource();
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toUpperCase();
        String filePath = CommonConstant.UPLOAD_PATH +
                CommonConstant.IMG_PREFIX + loginUser.getId() + "/" + srcId + "/" + source.getId();
        //资源访问路径
        String readPath = CommonConstant.DOWNLOAD_PATH +
                CommonConstant.IMG_PREFIX + loginUser.getId() + "/" + srcId + "/" + source.getId();
        source.setSrcUrl(readPath);
        source.setSrcSuffix(type);
        source.setSrcType(CommonConstant.TYPE_IMG);
        source.setUserId(loginUser.getId());
        source.setSrcId(srcId);
        source.setSrcDown(0);
        String des_str = filePath + "." + type;
        File desFile = new File(des_str);
        if (!desFile.getParentFile().exists()) {
            desFile.getParentFile().mkdirs();
        }
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