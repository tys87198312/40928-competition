package com.dragee.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.business.dao.CompetitionDao;
import com.dragee.modules.business.entity.CompetitionEntity;
import com.dragee.modules.business.service.CompetitionService;
import com.dragee.modules.sys.entity.LoginUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("competitionService")
public class CompetitionServiceImpl extends ServiceImpl<CompetitionDao, CompetitionEntity> implements CompetitionService {



    private String business = "user";

    @Resource
    private CompetitionDao competitionDao;
    /**
    * 列表
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<CompetitionEntity> wrapper = new QueryWrapper<>();
        if (params.get("filter") != null) {
            String filter = params.get("filter").toString();
            wrapper.and(w->w.like("title", filter).or().like("startTime", filter).or().like("statusMean", filter));
        }
        int limit = params.get(CommonConstants.LIMIT) == null
                ?CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ?CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<CompetitionEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select());
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageXS(Map<String, Object> params, LoginUser user) {
        int limit = params.get(CommonConstants.LIMIT) == null
                ?CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ?CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());

        PageHelper.startPage(start, limit);
        List<CompetitionEntity> list = this.baseMapper.listXS(user.getUserId(), params.get("filter") == null ? null : params.get("filter").toString());
        PageInfo<CompetitionEntity> pageInfo = new PageInfo<>(list);
        return new PageUtils(pageInfo);
    }


    @Override
    public PageUtils queryPagePW(Map<String, Object> params, LoginUser user) {
        int limit = params.get(CommonConstants.LIMIT) == null
                ?CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ?CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());

        PageHelper.startPage(start, limit);
        List<CompetitionEntity> list = this.baseMapper.listPW(user.getUserId(), params.get("filter") == null ? null : params.get("filter").toString());
        PageInfo<CompetitionEntity> pageInfo = new PageInfo<>(list);
        return new PageUtils(pageInfo);
    }


}
