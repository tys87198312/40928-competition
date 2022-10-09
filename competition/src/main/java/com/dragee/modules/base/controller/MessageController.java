package com.dragee.modules.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dragee.common.PageUtils;
import com.dragee.common.R;
import com.dragee.modules.base.entity.MessageEntity;
import com.dragee.modules.base.service.MessageService;
import com.dragee.utils.LoginUserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 系统消息表
 * 对消息的状态处理分为以下几步：
 * 1、发送过来的消息status为0，sendTime为插入时间
 * 2、点击铃铛 status为1，消息已查阅，设置receiveTime
 * 3、点击某一条消息是status为2，消息已读，设置readTime
 * 4、点击删除消息时将status设为3，表示消息已删除，并设置archiveTime
 *
 * @author
 * @email @mail.com
 * @date 2021-01-27 15:38:12
 */
@RestController
@RequestMapping("base/message")
@Api(tags = "系统消息表")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("系统消息表列表")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = messageService.queryPage(params);
        return R.ok().put("data", page);
    }

    /**
     * 点击铃铛查询所有
     */
    @GetMapping("/refer-message")
    @ApiOperation("查阅消息")
    public R referMessage() {
        List<MessageEntity> data = messageService.selectSentMessage();
        return R.ok().put("data", data);
    }


    @ApiOperation("读消息")
    @PostMapping("/read")
    public R readMessage(@RequestBody Long[] ids) {
        if (null != ids && ids.length > 0) {
            for (Long id : ids) {
                System.out.println(id + "---------------id---------------");
                messageService.readMessage(id);
            }
        }
        return R.ok();
    }

    /**
     * 一键已读
     */
    @ApiOperation("一键已读功能")
    @PostMapping("/read-all")
    public R readAllByUserid() {
        Long userId = LoginUserUtil.getLoginUserId();
        messageService.readAllByUserid(userId);
        return R.ok();
    }

    /**
     * 存档消息，隐藏消息
     */
    @PostMapping("/archive")
    @ApiOperation("存档系统消息表")
    public R archiveMessage(@RequestBody Long[] ids) {
        if (ids != null && ids.length > 0) {
            for (Long id : ids) {
                messageService.archiveMessage(id);
            }
        }
        return R.ok();
    }

    /**
     * 接受消息
     */
    @PostMapping("/receive")
    @ApiOperation("接受消息")
    public R receiveMessage(@RequestBody Long[] ids) {
        if (ids != null && ids.length > 0) {
            for (Long id : ids) {
                messageService.receiveMessage(id);
            }
        }
        return R.ok();
    }


    /**
     * 重新将已存档文件改为未存档状态
     */
    @PostMapping("/unarchive/message")
    @ApiOperation("还原已存档消息")
    public R unarchiveMessage(@RequestBody Long[] ids) {
        if (null != ids && ids.length > 0) {
            for (Long id : ids) {
                messageService.unarchiveMessage(id);
            }
        }
        return R.ok();
    }


    /**
     * 查看某用户所有未存档消息
     */
    @GetMapping("/unarchive-messages")
    @ApiOperation("查看某个用户的未存档消息")
    public R unarchiveMessageForOneUser() {
        Long userIdTemp = LoginUserUtil.getLoginUserId();
        String userId = String.valueOf(userIdTemp);
        List<MessageEntity> messageEntities = messageService.list(new QueryWrapper<MessageEntity>().eq("receiverId", userId).ne("status", 3).orderByDesc("sendTime"));
        return R.ok().put("data", messageEntities);
    }

    /**
     * 信息
     */
    @GetMapping("/detail/{id}")
    @ApiOperation("系统消息表信息")
    public R info(@PathVariable("id") Long id) {
        MessageEntity message = messageService.getById(id);
        //点击查看某条信息后，将status变为2，并设置readTime的值
        MessageEntity entity = new MessageEntity();
        BeanUtils.copyProperties(message, entity);
        entity.setStatus(2);
        entity.setReadTime(new Date());
        messageService.updateById(entity);
        return R.ok().put("data", message);
    }

}
