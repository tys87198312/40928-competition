package com.dragee.modules.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.base.dao.ErrorLogDao;
import com.dragee.modules.base.entity.ErrorLogEntity;
import com.dragee.modules.base.service.ErrorLogService;
import com.dragee.utils.WrapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service("errorLogService")
@Transactional(readOnly = true)
public class ErrorLogServiceImpl extends ServiceImpl<ErrorLogDao, ErrorLogEntity> implements ErrorLogService {


    @Resource
    private ErrorLogDao errorLogDao;
    private String business="errorLog";
    /**
    * 列表
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<ErrorLogEntity> wrapper = WrapperUtil.getWrapper(business,params,ErrorLogEntity.class);
        int limit = params.get(CommonConstants.LIMIT) == null
                ?CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ?CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<ErrorLogEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select());
        return new PageUtils(page);
    }
}