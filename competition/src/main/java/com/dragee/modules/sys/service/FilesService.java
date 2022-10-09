package com.dragee.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.sys.entity.FilesEntity;

import java.util.Map;

/**
 * 文件信息
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-26 15:41:41
 */
public interface FilesService extends IService<FilesEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

}

