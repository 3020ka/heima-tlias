package com.ascit.tlias.service;

import com.ascit.tlias.entity.Emp;
import com.ascit.tlias.entity.queryString;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface EmpService extends IService<Emp> {

    Page<Emp> getEmps(queryString queryString);

    void deleteEmps(List<Integer> ids);

    void addEmp(Emp emp);

    void updateEmpById(Emp emp);
}
