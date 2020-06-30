package com.wllt.qxwl.modules.account.user.dao;

import com.wllt.qxwl.modules.account.user.entity.WlltUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Mapper
public interface WlltUserDao extends BaseMapper<WlltUser> {

    List<WlltUser> find();
}
