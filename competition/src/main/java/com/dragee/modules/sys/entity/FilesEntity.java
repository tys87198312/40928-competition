package com.dragee.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dragee.config.resolver.LongJsonDeserializer;
import com.dragee.config.resolver.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件信息
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-26 15:41:41
 */
@Data
@TableName("sys_files")
@Accessors(chain = true)
public class FilesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    /**
     * 功能模块
     */
    private String modules;

    /**
     * 文件id 用于多对一分组
     */
    private Long fileId;

    /**
     * 文件名字
     */
    private String fileName;

    /**
     * 文件地址
     */
    private String filePath;

    /**
     * 排序
     */
    @TableField(fill = FieldFill.INSERT)
    private Long sort;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    }