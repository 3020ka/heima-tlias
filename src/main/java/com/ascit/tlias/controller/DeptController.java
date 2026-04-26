package com.ascit.tlias.controller;

import com.ascit.tlias.entity.Dept;
import com.ascit.tlias.result.Result;
import com.ascit.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result getDepts()
    {
        return Result.success(deptService.findAll());
    }
    @DeleteMapping
    public Result<String> deleteDepts(@RequestParam Integer id)
    {
        deptService.deleteDeptsById(id);
        return Result.success();
    }
    @PostMapping
    public Result<String> addDepts(@RequestBody  Dept dept)
    {

        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptService.addDepts(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id)
    {
        return Result.success(deptService.getDeptById(id));
    }
    @PutMapping()
    public Result updateDepts(@RequestBody Dept dept)
    {
        if (dept.getId()==null)
        {
            return Result.error("部门id不能为空");
        }
        if (dept.getName()==null)
        {
            return Result.error("部门名称不能为空");
        }
        deptService.updateById(dept);
        dept.setUpdateTime(LocalDateTime.now());

        return Result.success();
    }


}
