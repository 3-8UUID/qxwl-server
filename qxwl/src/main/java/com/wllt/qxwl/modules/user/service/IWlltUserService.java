package com.wllt.qxwl.modules.user.service;

import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
public interface IWlltUserService extends IService<WlltUser> {

    List<WlltUser> find(WlltUser wlltUser);
}
