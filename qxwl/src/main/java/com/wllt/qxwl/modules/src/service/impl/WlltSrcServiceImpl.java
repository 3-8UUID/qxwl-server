package com.wllt.qxwl.modules.src.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.modules.src.dao.WlltSrcDao;
import com.wllt.qxwl.modules.src.entity.WlltSrc;
import com.wllt.qxwl.modules.src.service.WlltSrcService;
import com.wllt.qxwl.modules.user.service.WlltUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Service
public class WlltSrcServiceImpl extends ServiceImpl<WlltSrcDao, WlltSrc> implements WlltSrcService {

    @Autowired
    private WlltUserService wlltUserService;

    @Override
    public WlltSrc createFile(MultipartFile file) {
      /*  WlltUser loginUser = wlltUserService.getLoginUser();

        long srcId = SnowFlakeUtils.getFlowIdInstance().nextId();
        WlltSrc wlltSrc = new WlltSrc();
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toUpperCase();
        String filePath = CommonConstant.UPLOAD_PATH + "/image/" + srcId + "/" + wlltSrc.getId() +"."+ type;
        wlltSrc.setSrcUrl(filePath);
        wlltSrc.setSrcSuffix(type);
        wlltSrc.setUserId(loginUser.getId());
        wlltSrc.set
        String type = attachBo.getFileName().substring(attachBo.getFileName().lastIndexOf(".")).toUpperCase();
        File desFile = new File(filePath + sysAttach.getAttachName() + type);
        if (!desFile.getParentFile().exists()) {
            desFile.mkdirs();
        }
        try {
            attachBo.getMultipartFile().transferTo(desFile);
            //如果非PNG格式则转换成png格式
            if (!".PNG".equals(type)) {
                BufferedImage read = ImageIO.read(desFile);
                BufferedImage resized = ImageUtil.resizebyaspect(read, read.getHeight(), read.getWidth());
                File newFile = new File(sysAttach.getAttachLocation() + sysAttach.getAttachName() + ".PNG");
                boolean b = ImageIO.write(resized, "PNG", newFile);
                if (b) {
                    desFile.delete();
                }
            }
        } catch (IllegalStateException | IOException ex) {
            log.error("uploadIMG失败", ex);
        }
        save(sysAttach);
        return sysAttach;*/
        return null;
    }
}
