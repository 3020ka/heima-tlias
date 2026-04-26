package com.ascit.tlias.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("emp_expr")  // 加上表名注解
public class EmpExpr {
    @TableField
    private Integer id;
    @TableField
    private Integer empId;
    @TableField
    private LocalDate begin;
    @TableField
    private LocalDate end;
    @TableField
    private String company;
    @TableField
    private String job;
}
