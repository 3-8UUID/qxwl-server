package com.wllt.qxwl.modules.src.service;

import com.wllt.qxwl.modules.src.entity.WlltSrc;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
public interface WlltSrcService extends IService<WlltSrc> {

    /**文件上传
    * @param file 文件流
    * @return ${return_type}
    * @throws
    * @author Tian-Quanyou
    * @date 2020/6/13 15:17
    * @version V1.0
    */
    WlltSrc createFile(MultipartFile file);
}
