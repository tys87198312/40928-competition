package com.dragee.modules.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.base.entity.DicEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-12-01 17:00:35
 */
public interface DicService extends IService<DicEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

    //根据enName查询字典信息
    List<DicEntity> findDic(String enName);
}

