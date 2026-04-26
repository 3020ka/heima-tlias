package com.ascit.tlias.service;

import com.ascit.tlias.entity.Dept;
import com.ascit.tlias.result.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface DeptService extends IService<Dept> {
    List<Dept> findAll();

    void deleteDeptsById(Integer id);

    void addDepts(Dept dept);

    Dept getDeptById(Integer id);
}
