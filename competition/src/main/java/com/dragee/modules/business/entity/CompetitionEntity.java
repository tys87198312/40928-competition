package com.dragee.modules.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dragee.config.NotNull;
import com.dragee.config.resolver.LongJsonDeserializer;
import com.dragee.config.resolver.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-26 14:52:45
 */
@Data
@TableName("t_competition")
public class CompetitionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * userId
     */
    @TableId
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    /**
     * 名字
     */
    @NotNull("标题")
    private String title;
    /**
     * 用户名
     */
    @NotNull("开始时间")
    private Date startTime;

    @TableField(exist = false)
    private String isJoin;


    private Integer status;

    private String statusMean;

    private String judgePerson;

    private String scoreStandard;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 用户角色
     */
    @TableField(exist = false)
    private String role;

}