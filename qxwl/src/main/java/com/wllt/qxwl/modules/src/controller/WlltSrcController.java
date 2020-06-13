package com.wllt.qxwl.modules.src.controller;


import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.src.entity.WlltSrc;
import com.wllt.qxwl.modules.src.service.WlltSrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@RestController
@RequestMapping("/qxwl/src")
public class WlltSrcController {

    @Autowired
    private WlltSrcService wlltSrcService;

    /**
     * 附件上传
     * @param file
     * @return
     */
    @RequestMapping("/fileUp")
    public Result createResource(@RequestBody @NotNull MultipartFile file){
        WlltSrc wlltSrc = wlltSrcService.createFile(file);
        if (ObjectUtils.isEmpty(wlltSrc)){
            return ResultUtil.fail();
        }
        return ResultUtil.success(wlltSrc);
    }

}
