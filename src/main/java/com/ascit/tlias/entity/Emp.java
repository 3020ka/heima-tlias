package com.ascit.tlias.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@TableName("emp")
public class Emp {
    @TableId
    private Integer id;
    @TableField
    private String username;
    @TableField
    private String password;
    @TableField
    private String name;
    @TableField
    private Integer gender;
    @TableField
    private String phone;
    @TableField
    private Integer job;
    @TableField
    private Integer salary;
    @TableField
    private String image;
    @TableField
    private LocalDate entryDate;
    @TableField
    private Integer deptId;
    @TableField
    private LocalDate createTime;
    @TableField
    private LocalDate updateTime;
    @TableField(exist = false)
    private String deptName;
    @TableField(exist = false)  // 告诉 MyBatis-Plus 这个字段不是数据库字段
    private List<EmpExpr> exprList;

}
