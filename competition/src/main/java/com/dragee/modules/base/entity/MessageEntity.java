package com.dragee.modules.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dragee.config.resolver.LongJsonDeserializer;
import com.dragee.config.resolver.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统消息表
 * 
 * @author 
 * @email @mail.com
 * @date 2021-01-27 15:38:12
 */
@Data
@TableName("base_message")
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    /**
     * 通知（消息）码
     */
    private String dataId;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息读取状态，0：未查阅，1：已查阅，2：已读，3：隐藏
     */
    private Integer status;

    /**
     * 消息发送者
     */
    private String senderId;

    /**
     * 消息接受者
     */
    private String receiverId;

    /**
     * 
     */
    private String senderName;

    /**
     * 
     */
    private String senderIcon;

    /**
     * 
     */
    private String receiverName;

    /**
     * 
     */
    private String receiverIcon;

    /**
     * 消息的发送时间
     */
    private Date sendTime;

    /**
     * 消息读取时间
     */
    private Date readTime;

    /**
     * 消息的接收时间
     */
    private Date receiveTime;

    /**
     * 排序字段
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer sort;

    /**
     * 插入时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 存档时间
     */
    private Date archiveTime;

    }