package com.ascit.tlias.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
@Data
@TableName("clazz")
public class clazz {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private String room;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Integer masterId;
    private Integer subject;
    private LocalDate createTime;
    private LocalDate updateTime;

}
