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

/**
 * 
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-12-01 17:00:35
 */
@Data
@TableName("base_dic")
public class DicEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    /**
     * 字典值
     */
    private String value;

    /**
     * 字典含义
     */
    private String text;

    /**
     * 字典类型英文名
     */
    private String enName;

    /**
     * 字典类型中文含义
     */
    private String chName;

    /**
     * 排序
     */
    @TableField(fill = FieldFill.INSERT)
    private Long sort;

    }