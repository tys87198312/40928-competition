package com.dragee.modules.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.base.dao.PublishLogDao;
import com.dragee.modules.base.entity.PublishLogEntity;
import com.dragee.modules.base.service.PublishLogService;
import com.dragee.utils.WrapperUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("publishLogService")
public class PublishLogServiceImpl extends ServiceImpl<PublishLogDao, PublishLogEntity> implements PublishLogService {


    @Resource
    private PublishLogDao publishLogDao;

    private String business = "publishLog";
    /**
    * 列表
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<PublishLogEntity> wrapper =
                WrapperUtil.getWrapper(business, params, PublishLogEntity.class);
        int limit = params.get(CommonConstants.LIMIT) == null
                ? CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ? CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<PublishLogEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select());
        return new PageUtils(page);
    }
}