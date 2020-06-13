package com.wllt.qxwl.modules.type.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.constant.RedisConstant;
import com.wllt.qxwl.comm.redis.RedisClient;
import com.wllt.qxwl.modules.type.dao.WlltTypeDao;
import com.wllt.qxwl.modules.type.entity.WlltType;
import com.wllt.qxwl.modules.type.service.WlltTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Service
public class WlltTypeServiceImpl extends ServiceImpl<WlltTypeDao, WlltType> implements WlltTypeService {

    @Autowired
    private RedisClient redisClient;

    @Override
    public List<WlltType> getTypeList() {
        List<WlltType> types = (List<WlltType>) redisClient.get(RedisConstant.KEY_TYPES);
        if (ObjectUtils.isEmpty(types)){
            QueryWrapper<WlltType> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(WlltType::getStatus, CommonConstant.STATUS_NORMAL);
            types = list(wrapper);
            if (!ObjectUtils.isEmpty(types)) {
                redisClient.set(RedisConstant.KEY_TYPES,types);
                return types;
            }
            return null;
        }
        return types;
    }
}
