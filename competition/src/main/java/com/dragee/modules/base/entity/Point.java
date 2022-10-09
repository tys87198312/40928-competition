package com.dragee.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Point {
    @TableId
    private String id;
    private String name;
    private float x;
    private float y;
}
