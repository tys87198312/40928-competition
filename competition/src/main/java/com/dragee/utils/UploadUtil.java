package com.dragee.utils;

import com.dragee.config.exception.BusinessErrorType;
import com.dragee.config.exception.BusinessException;
import com.dragee.modules.sys.entity.FilesEntity;
import com.dragee.modules.sys.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 文件上传工具类
 *
 * @author tys on 11/9/20
 */
@Component
public class UploadUtil {

    private static FilesService filesService;

    @Autowired
    public void setSysFilesService(FilesService filesService) {
        UploadUtil.filesService = filesService;
    }

    /**
     * 删除
     *
     * @param files
     */
    public static void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**单文件上传
     * @param mfile 文件
     * @param filePath 路径
     * @param module 模块名
     * @param fileId 多文件id
     */
    public static void uploadOne(MultipartFile mfile, String filePath, String module, Long fileId){
        String path = filePath + "/" +mfile.getOriginalFilename();
        File newFile = new File(filePath + "/" +mfile.getOriginalFilename());
        File dirFile = new File(filePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        try {
            mfile.transferTo(newFile);
        } catch (IOException e) {
            System.err.println("------文件上传异常-----");
            e.printStackTrace();
        }
        FilesEntity fileInfo = new FilesEntity()
                .setFileName(mfile.getOriginalFilename())
                .setFilePath(path)
                .setModules(module)
                .setFileId(fileId);
        UploadUtil.filesService.saveOrUpdate(fileInfo);
    }


    /**多文件上传
     * @param mfiles 文件s
     * @param filePath 路径
     * @param module 模块名
     * @param fileId 多文件id
     */
    public static void uploadArray(MultipartFile[] mfiles, String filePath, String module, Long fileId) {
        Arrays.asList(mfiles).forEach( m -> UploadUtil.uploadOne(m, filePath, module, fileId));
    }

    /**随机数产生fileid
     * @return
     */
    public static Long createFileId(){
        return System.currentTimeMillis();
    }

    public static String getFileName(Date date)
    {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSSS");

        return df.format(date);
    }

    public static String makeRelatedFileName(String inspection, String taskid)
    {
        return inspection + File.separator + taskid;
    }

    public static void download (String fileName, String filePath, HttpServletResponse response) {
        File file = new File(filePath);
        if (!file.exists())
            throw new BusinessException(BusinessErrorType.FILE_NOT_EXISTS);
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            response.resetBuffer();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/force-download;charset=UTF-8");
            response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
