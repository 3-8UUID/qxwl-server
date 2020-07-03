package com.wllt.qxwl.modules.article.source.controller;

import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.article.source.entity.WlltSource;
import com.wllt.qxwl.modules.article.source.service.WlltSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * (WlltSource)表控制层
 *
 * @author makejava
 * @since 2020-06-13 16:15:51
 */
@RestController
@RequestMapping("/qxwl/source/")
public class WlltSourceController {
    /**
     * 服务对象
     */
    @Autowired
    private WlltSourceService wlltSourceService;

    /**
     * 附件上传
     * @param file
     * @return
     */
    @RequestMapping("/fileUp")
    public Result createResource(@RequestBody @NotNull MultipartFile file,Long srcId){
        WlltSource wlltSource = wlltSourceService.createFile(file,srcId);
        if (ObjectUtils.isEmpty(wlltSource)){
            return ResultUtil.fail();
        }
        return ResultUtil.success(wlltSource);
    }



}