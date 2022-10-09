package com.dragee.modules.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.base.dao.LoginLogDao;
import com.dragee.modules.base.entity.LoginLogEntity;
import com.dragee.modules.base.service.LoginLogService;
import com.dragee.modules.sys.service.MenusService;
import com.dragee.utils.WrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service("loginLogService")
@Transactional(readOnly = true)
public class LoginLogServiceImpl extends ServiceImpl<LoginLogDao, LoginLogEntity> implements LoginLogService {


    @Resource
    private LoginLogDao loginLogDao;

    @Autowired
    private MenusService menusService;

    private String business = "loginLog";
    /**
    * 列表
     *
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<LoginLogEntity> wrapper =
                WrapperUtil.getWrapper(business, params, LoginLogEntity.class);
        int limit = params.get(CommonConstants.LIMIT) == null
                ? CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ? CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());

        IPage<LoginLogEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select());

        return new PageUtils(page);
    }
}