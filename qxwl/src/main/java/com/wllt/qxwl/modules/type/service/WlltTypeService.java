package com.wllt.qxwl.modules.type.service;

import com.wllt.qxwl.modules.type.entity.WlltType;
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
public interface WlltTypeService extends IService<WlltType> {


    /**
     * 获取类型列表
    * @author Tian-Quanyou
    * @date 2020/6/8 14:11
    * @version V1.0
    */
    List<WlltType> getTypeList();
}
