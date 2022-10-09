package com.dragee.modules.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dragee.common.R;
import com.dragee.config.exception.BusinessErrorType;
import com.dragee.config.exception.BusinessException;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.sys.entity.FilesEntity;
import com.dragee.modules.sys.service.FilesService;
import com.dragee.utils.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * 消息发布历史
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-12-16 17:26:05
 */
@RestController
@RequestMapping("base/apk")
@Api(tags = "apk上传下载")
public class ApkController {

    @Value("${webull.mapUploadPath}")
    private String rootPath;
    @Autowired
    private FilesService filesService;

    /**
     * 列表
     */
    @PostMapping("upload")
    @ApiOperation("上传")
    public R upload(MultipartFile file){
        if (file == null)
            throw new BusinessException(BusinessErrorType.INVALID_PARAMS);
        if (!file.getOriginalFilename().endsWith("apk"))
            throw new BusinessException(BusinessErrorType.FILE_NOTSUPPORT_TYPE);
        String path = rootPath + CommonConstants.APK_DIR + "/" + LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        UploadUtil.uploadOne(file, path, "apk", 0L);
        return R.ok();
    }

    /**
     * 列表
     */
    @GetMapping("download")
    @ApiOperation("下载")
    public void download(@ApiIgnore HttpServletResponse response){
        List<FilesEntity> files = filesService.list(new QueryWrapper<FilesEntity>()
                .eq("fileId", 0)
                .eq("modules", "apk")
                .orderByDesc("sort"));
        if (files.size() == 0) {
            throw new BusinessException(BusinessErrorType.FILE_NOT_EXISTS);
        }
        UploadUtil.download(files.get(0).getFileName(), files.get(0).getFilePath(), response);
    }



}
