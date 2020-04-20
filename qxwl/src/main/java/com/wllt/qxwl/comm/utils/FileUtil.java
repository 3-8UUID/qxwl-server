package com.wllt.qxwl.comm.utils;

import com.wllt.qxwl.comm.enums.FileTypeEnum;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @program: qms_server
 * @description: 文件上传工具类
 * @author: Tian-Quanyou
 * @create: 2020-03-27 14:46
 **/
@Component
public class FileUtil implements Serializable {

    /**
     * @param filePath     文件地址
     * @param saveFilePath 需要上传的文件地址
     * @return 返回是否上传成功
     * @throws
     * @Description: 图片文件上传（非图片则上传失败）
     * @author Tian-Quanyou
     * @date 2020/3/27 14:49
     * @version V1.0
     */
    public static Boolean imageFileupload(String filePath, String saveFilePath) {
        if (null == filePath) {
            return false;
        }
        File file = new File(filePath);
        if (!file.isFile()) {
            //文件不存在
            return false;
        }
        File image = new File(saveFilePath);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            saveFileFromInputStream(inputStream, saveFilePath);
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }

        if (image.exists()) {
            return true;
        }
        System.out.println(123);
        return true;
    }

    /**
     * 将MultipartFile转化为file并保存到服务器上的某地
     */
    public static void saveFileFromInputStream(InputStream stream, String saveFile) throws IOException {
        FileOutputStream fs = new FileOutputStream(saveFile);
        System.out.println("------------" + saveFile);
        byte[] buffer = new byte[1024 * 1024];
        int bytes = 0;
        int byteread = 0;
        while ((byteread = stream.read(buffer)) != -1) {
            bytes += byteread;
            fs.write(buffer, 0, byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
    }

    /**
     * @param filePath 文件地址
     * @return 是否删除成功
     * @throws
     * @Description: ${todo}
     * @author Tian-Quanyou
     * @date 2020/3/30 9:21
     * @version V1.0
     */
    public static boolean deleteServerFile(String filePath) {
        boolean delete_flag = false;
        File file = new File(filePath);
        if (file.exists() && file.isFile() && file.delete()) {
            delete_flag = true;
        }
        return delete_flag;
    }

    /**
     * @param oldPath 老文件绝对位置
     * @param newPath 新文件绝对位置
     * @param delFlag 是否删除老文件
     * @return ${return_type}
     * @throws IOException 文件保存转换失败
     * @Description: 保存转换指定图片
     * @author Tian-Quanyou
     * @date 2020/4/16 15:54
     * @version V1.0
     */
    public static Boolean saveImgFile(@NotNull String oldPath, @NotNull String newPath, @NotNull String FileName, Boolean delFlag) throws IOException {
        File oldImg = new File(oldPath);
        File newFile = new File(newPath);
        String defaultType = FileTypeEnum.FILE_PNG.getValue();
        Boolean flag = false;
        if (!oldImg.exists()) {
            return flag;
        }
        if (!newFile.exists()) {
            newFile.mkdirs();
        }

        String oldImgType = oldPath.substring(oldPath.lastIndexOf(".") + 1).toUpperCase();
        String newImgType = FileName.substring(FileName.lastIndexOf(".") + 1).toUpperCase();
        if (StringUtils.isEmpty(oldImgType) || StringUtils.isEmpty(newImgType)) {
            System.out.println("文件类型不存在");
            return flag;
        }
        File file = new File(newFile + File.separator + FileName);
        if (file.exists()){
            file.delete();
        }
        defaultType = newImgType;
        BufferedImage read = ImageIO.read(oldImg);
        BufferedImage resized = ImageUtil.resizebyaspect(read, read.getHeight(), read.getWidth());
        flag = ImageIO.write(resized, defaultType, file);
        if (!flag) {
            return flag;
        }
        if (null != delFlag && delFlag) {
            return flag = oldImg.delete();
        }
        return flag;
    }


}
