package com.dragee.modules.base.controller;

import com.dragee.common.PageUtils;
import com.dragee.common.R;
import com.dragee.config.preventresubmit.LocalResubmitLock;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.base.entity.NoticeEntity;
import com.dragee.modules.base.service.NoticeService;
import com.dragee.utils.LoginUserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;


/**
 * 公告表（用户公告、系统公告）
 *
 * @author
 * @email @mail.com
 * @date 2021-01-27 15:38:12
 */
@RestController
@RequestMapping("base/notice")
@Api(tags = "公告表（用户公告、系统公告）")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 列表，
     */
    @GetMapping
    @ApiOperation("公告表（用户公告、系统公告）列表")
    public R list(@RequestParam Map<String, Object> params) {

        PageUtils page = noticeService.queryPage(params);
        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("公告表（用户公告、系统公告）信息")
    public R info(@PathVariable("id") Long id) {
        NoticeEntity notice = noticeService.getById(id);
        return R.ok().put("data", notice);
    }

    /**
     * 保存
     */
    @LocalResubmitLock(key = "resubmitLock:webull:target[0]")
    @PostMapping
    @ApiOperation("保存公告表（用户公告、系统公告）")
    public R save(@RequestBody NoticeEntity notice) {
        try {
            String username = LoginUserUtil.getLoginUser().getUsername();
            notice.setCreatedBy(username);
            notice.setCreateTime(new Date());
            noticeService.save(notice);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
     * 修改
     * 只能修改未被发送的notice
     */
    @PostMapping("update-all")
    @ApiOperation("修改公告表（用户公告、系统公告）")
    public R update(@RequestBody NoticeEntity notice) {
        if (notice.getSent().equals(CommonConstants.NOT_SEND)) {
            notice.setOperator(LoginUserUtil.getLoginUser().getUsername());
            notice.setUpdateTime(new Date());
            noticeService.updateById(notice);
            return R.ok();
        } else {
            return R.error("通知已发送，不可修改");
        }
    }

    /**
     * 删除
     */
    @DeleteMapping("delete-by-ids")
    @ApiOperation("删除公告表（用户公告、系统公告）")
    public R delete(@RequestBody Long[] ids) {
        noticeService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 发布公告
     *
     * @param ids
     * @return
     */
    @ApiOperation("发送公告")
    @PostMapping("/send")
    public R announceNotice(@RequestBody Long[] ids) {
        Collection<NoticeEntity> noticeEntities = noticeService.listByIds(Arrays.asList(ids));
        if (noticeEntities != null && noticeEntities.size() > 0) {
            for (NoticeEntity noticeEntity : noticeEntities) {
                if (noticeEntity.getSent().equals(CommonConstants.NOT_SEND)) {
                    noticeService.announceNotice(noticeEntity);
                    return R.ok();
                } else {
                    return R.error("notice已经发送过了");
                }
            }
        }
        return R.error("您未选中任何一条通知");
    }

}
