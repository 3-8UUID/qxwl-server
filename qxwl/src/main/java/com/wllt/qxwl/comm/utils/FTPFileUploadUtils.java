///*
//package com.wllt.qxwl.comm.utils;
//
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPReply;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//*/
///**
// * @program: qxwl_server
// * @description: ftp文件上传工具类
// * @author: Tian-Quanyou
// * @create: 2020-06-15 15:45
// **//*
//
//public class FTPFileUploadUtils {
//    //ftp服务器ip地址
//    private static final String FTP_ADDRESS = "ftp://47.102.208.247:21";
//    //用户名
//    private static final String FTP_USERNAME = "WLLT_FTP";
//    //密码
//    private static final String FTP_PASSWORD = "ftproot";
//    //图片路径
//    private static final String FTP_BASEPATH = "/images/";
//
//    public static boolean uploadFile(String originFileName, InputStream input){
//        boolean success = false;
//        FTPClient ftp = new FTPClient();
//        ftp.setControlEncoding("GBK");
//        try {
//            int reply;
//            // 连接FTP服务器
//            ftp.connect(FTP_ADDRESS);
//            // 登录
//            ftp.login(FTP_USERNAME, FTP_PASSWORD);
//            reply = ftp.getReplyCode();
//            if (!FTPReply.isPositiveCompletion(reply)) {
//                ftp.disconnect();
//                return success;
//            }
//            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
//            ftp.makeDirectory(FTP_BASEPATH );
//            ftp.changeWorkingDirectory(FTP_BASEPATH );
//            ftp.storeFile(originFileName,input);
//            input.close();
//            ftp.logout();
//            success = true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (ftp.isConnected()) {
//                try {
//                    ftp.disconnect();
//                } catch (IOException ioe) {
//                }
//            }
//        }
//        return success;
//    }
//}
//*/
