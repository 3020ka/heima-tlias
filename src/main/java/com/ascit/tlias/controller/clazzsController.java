package com.ascit.tlias.controller;

import com.ascit.tlias.entity.clazz;
import com.ascit.tlias.entity.DTO.clazzDTO;
import com.ascit.tlias.result.PageResult;
import com.ascit.tlias.result.Result;
import com.ascit.tlias.service.Impl.clazzServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/clazzs")
public class clazzsController {
    @Autowired
    private clazzServiceImpl clazzServiceimpl;
    @GetMapping
    public Result getPageByCondition(clazzDTO clazzDTO){
        Page<clazz> page =clazzServiceimpl.getPageByCondition(clazzDTO);
        PageResult pageResult=new PageResult(page.getTotal(),page.getRecords());
      return Result.success(pageResult);
    }
@DeleteMapping("/{id}")
    public Result deleteClazzsById(clazz clazz){
        clazzServiceimpl.removeById(clazz);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getClazzsById(@PathVariable Integer id){
         clazz clazz=clazzServiceimpl.getById(id);
        return Result.success(clazz);
    }
    @PutMapping
    public Result updateClazzs(@RequestBody clazz clazz){
        clazz.setUpdateTime(LocalDate.now());
        clazzServiceimpl.updateById(clazz);
        return Result.success();
    }
    @GetMapping("/list")
    public Result getClazzsList(){
        return Result.success(clazzServiceimpl.list());
    }
    @PostMapping
    public Result addClazzs(@RequestBody clazz clazz){
        clazz.setCreateTime(LocalDate.now());
        clazz.setUpdateTime(LocalDate.now());

        clazzServiceimpl.save(clazz);
        return Result.success();
    }

}
