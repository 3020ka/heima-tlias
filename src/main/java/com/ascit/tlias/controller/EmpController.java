package com.ascit.tlias.controller;

import com.ascit.tlias.entity.Emp;
import com.ascit.tlias.entity.queryString;
import com.ascit.tlias.result.PageResult;
import com.ascit.tlias.result.Result;
import com.ascit.tlias.service.EmpService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Builder;
import org.apache.ibatis.annotations.Delete;
import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired private EmpService empService;
    @GetMapping
    public Result getEmps(queryString queryString)
    {
        if (queryString.getPage()==null)
        {
            queryString.setPage(1);
        }
        if (queryString.getPageSize()==null)
        {
            queryString.setPageSize(10);
        }

        Page<Emp> page=empService.getEmps(queryString);
       PageResult pageResult=new PageResult( page.getTotal(),page.getRecords());

        return Result.success(pageResult);
    }
    @DeleteMapping
    public Result deleteEmps(@RequestParam List<Integer> ids){
        empService.deleteEmps(ids);
        return Result.success();

    }
    @PostMapping
    public Result addEmps(@RequestBody Emp emp){

        
        if (emp.getUsername()==null)
        {
            return Result.error("用户名不能为空");
        }
        if (emp.getGender()==null)
        {
            return Result.error("性别不能为空");
        }
        if (emp.getName()==null)
        {
            return Result.error("姓名不能为空");
        }
        empService.addEmp(emp);

        return Result.success();

    }

    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id)

    {
        Emp emp=empService.getById(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp)


    {
        if (emp.getExprList()==null){
            emp.setExprList(new ArrayList<>());
        }
        empService.updateEmpById(emp);
        return Result.success();
    }
    @GetMapping("/list")
    public Result getEmpList()
    {
        return Result.success(empService.list());
    }

}
