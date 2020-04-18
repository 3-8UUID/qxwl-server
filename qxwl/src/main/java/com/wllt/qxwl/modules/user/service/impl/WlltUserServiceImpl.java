package com.wllt.qxwl.modules.user.service.impl;

import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.wllt.qxwl.modules.user.dao.WlltUserDao;
import com.wllt.qxwl.modules.user.service.IWlltUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Service
public class WlltUserServiceImpl extends ServiceImpl<WlltUserDao, WlltUser> implements IWlltUserService {

    @Autowired
    private WlltUserDao wlltUserDao;

    @Override
    public List<WlltUser> find(WlltUser wlltUser) {

        return wlltUserDao.find();
    }
}
