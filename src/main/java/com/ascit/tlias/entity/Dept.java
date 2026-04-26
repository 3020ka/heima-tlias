package com.ascit.tlias.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@TableName("dept")
public class Dept {
    @TableField
    private Integer id;

    @TableField
    private String name;

    @TableField
    private LocalDateTime createTime;

    @TableField
    private LocalDateTime updateTime;
}
