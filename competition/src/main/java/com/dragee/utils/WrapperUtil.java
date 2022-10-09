package com.dragee.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.base.service.CommonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tys on 1/5/21
 */

public class WrapperUtil {

    public static CommonService commonService = SpringContextUtils.getBean("commonService", CommonService.class);
    public static List<String> fixKeys;

    static {
        fixKeys = new ArrayList<>();
        fixKeys.add("filter");
        fixKeys.add("descending");
        fixKeys.add("sortBy");
        fixKeys.add(CommonConstants.LIMIT);
        fixKeys.add(CommonConstants.START);
    }


    public static <T> IPage<T> getPage (Map<String, Object> params, Class<T> type)  {
        int limit = params.get(CommonConstants.LIMIT) == null
                ? CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ? CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<T> page = new Page<>(start, limit);
        return page;
    }

    /**
     * @param business 业务标志
     * @param params （filter 模糊查询、 sortBy 字段排序、 descending排序方式默认降序， 业务字段）
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> getWrapper (String business, Map<String, Object> params, Class<T> type) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        /*条件过滤*/
        params.keySet().stream().filter(k -> !fixKeys.contains(k)).forEach(k -> wrapper.eq(k, params.get(k)));




        /*搜索框默认筛选*/
        if (params.get("filter") != null) {
            String filter = params.get("filter").toString();
            if ("car".equals(business)) {
                wrapper.and(w->w.like("name", filter).or().like("license", filter).or().like("type", filter));
            } else {
                List<String> fileds = commonService.getFilterField(business);
                for (int i = 0; i < fileds.size(); i++) {
                    wrapper.like(fileds.get(i), filter);
                    if (i < fileds.size() - 1)
                        wrapper.or();
                }
            }

        }


        /*排序如果未传入按sort字段默认降序*/
        if (params.get("sortBy") != null) {
            String sortBy = params.get("sortBy").toString();
            boolean desc = params.get("descending") == null ? true : Boolean.parseBoolean(params.get("descending").toString());
            if (desc)
                wrapper.orderByDesc(sortBy);
            else
                wrapper.orderByAsc(sortBy);
        } else {
            wrapper.orderByDesc("sort");
        }
        return wrapper;
    }

    public static <T> QueryWrapper<T> getWrapper (String business, Map<String, Object> params,
                                                  Map<String, List<String>> inParams, Class<T> type) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        if (inParams != null) {
            inParams.keySet().stream().filter(k -> !fixKeys.contains(k)).forEach(k -> wrapper.in(k, inParams.get(k)));
        }
        /*条件过滤*/
        params.keySet().stream().filter(k -> !fixKeys.contains(k)).forEach(k -> wrapper.eq(k, params.get(k)));


        /*搜索框默认筛选*/
        if (params.get("filter") != null) {
            String filter = params.get("filter").toString();
            List<String> fileds = commonService.getFilterField(business);
            for (int i = 0; i < fileds.size(); i++) {
                wrapper.like(fileds.get(i), filter);
                if (i < fileds.size() - 1)
                    wrapper.or();
            }
        }

        /*排序如果未传入按sort字段默认降序*/
        if (params.get("sortBy") != null) {
            String sortBy = params.get("sortBy").toString();
            boolean desc = params.get("descending") == null ? true : Boolean.parseBoolean(params.get("descending").toString());
            if (desc)
                wrapper.orderByDesc(sortBy);
            else
                wrapper.orderByAsc(sortBy);
        } else {
            wrapper.orderByDesc("sort");
        }
        return wrapper;
    }


    /**
     * @param business 业务标志
     * @param params （filter 过滤、 sortBy 排序、 descending排序方式）
     * @param type
     * @param <T>
     * @return
     */
//    public static <T> QueryWrapper<T> getWrapper (String business, Map<String, Object> params, Class<T> type) {
//        QueryWrapper<T> wrapper = new QueryWrapper<>();
//        /*条件拼接*/
//        if (params.get("filter") != null) {
//            String filter = params.get("filter").toString();
//            List<String> fileds = commonService.getFilterField(business);
//            for (int i = 0; i < fileds.size(); i++) {
//                wrapper.like(fileds.get(i), filter);
//                if (i < fileds.size() - 1)
//                    wrapper.or();
//            }
//        }
//        /*排序*/
//        if (params.get("sortBy") != null) {
//            String sortBy = params.get("sortBy").toString();
//            boolean desc = params.get("descending").toString() == null? true : Boolean.parseBoolean(params.get("descending").toString());
//            if (desc)
//                wrapper.orderByDesc(sortBy);
//            else
//                wrapper.orderByAsc(sortBy);
//        } else {
//            wrapper.orderByDesc("sort");
//        }
//        return wrapper;
//    }

    /** 获取条件sql
     * @param business 业务名
     * @param filterParams 过滤条件
     * @param otherParams 其他过滤条件
     * @param isCreateMan 是否根据createBy过滤
     * @return
     */
    public static String getConditionSql (String business,
                                          Map<String, Object> filterParams,
                                          Map<String, Object> otherParams,
                                          boolean isCreateMan) {
        StringBuffer conditionSql = new StringBuffer(" ");
        if (isCreateMan)
            conditionSql.append(" and createBy = '" + LoginUserUtil.getLoginUserId() + "'");
        /*条件过滤*/
        if (otherParams != null) {
            otherParams.keySet().forEach(k ->
                    conditionSql.append(" and " + k + " = '" + otherParams.get(k) + "'")
            );
        }
        /*页面过滤*/
        if (filterParams.get("filter") != null) {
            String filter = filterParams.get("filter").toString();
            List<String> fileds = commonService.getFilterField(business);
            for (int i = 0; i < fileds.size(); i++) {
                if (i == 0)
                    conditionSql.append(" and (");
                conditionSql.append(fileds.get(i) + " like '%" + filter + "%'");
                if (i < fileds.size() - 1)
                    conditionSql.append(" or ");
                if (i == fileds.size() - 1)
                    conditionSql.append(" ) ");
            }
        }
        /*排序*/
        if (filterParams.get("sortBy") != null) {
            String sortBy = filterParams.get("sortBy").toString();
            boolean desc = filterParams.get("descending").toString() == null? true : Boolean.parseBoolean(filterParams.get("descending").toString());
            conditionSql.append(" order by " + sortBy);
            if (desc)
                conditionSql.append(" desc");
        } else {
            conditionSql.append(" order by sort desc");
        }
        return conditionSql.toString();
    }

}
