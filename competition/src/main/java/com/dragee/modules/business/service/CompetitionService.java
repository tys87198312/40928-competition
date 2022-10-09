package com.dragee.modules.business.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.business.entity.CompetitionEntity;
import com.dragee.modules.sys.entity.LoginUser;

import java.util.Map;

/**
 * 用户表
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-11 17:46:45
 */
public interface CompetitionService extends IService<CompetitionEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageXS(Map<String, Object> params, LoginUser user);

    PageUtils queryPagePW(Map<String, Object> params, LoginUser user);
}

