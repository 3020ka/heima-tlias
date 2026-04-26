package com.ascit.tlias.service.Impl;

import com.ascit.tlias.entity.Emp;
import com.ascit.tlias.entity.queryString;
import com.ascit.tlias.mapper.EmpMapper;
import com.ascit.tlias.service.EmpExprService;
import com.ascit.tlias.service.EmpService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    
    @Autowired
    private EmpExprService empExprService;  // 注入 EmpExprService

    @Override
    public Page<Emp> getEmps(queryString queryString) {
        Page<Emp> page = new Page<>(queryString.getPage(), queryString.getPageSize());
        return empMapper.getEmpsByPage(page, queryString);
    }

    @Override
    public void deleteEmps(List<Integer> ids) {
        empMapper.deleteBatchIds(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDate.now());
        emp.setUpdateTime(LocalDate.now());
        empMapper.addEmp(emp);
        
        // 插入后，emp.getId() 就能拿到自动生成的 id
        Integer empId = emp.getId();

        // 只有当 exprs 不为 null 且不为空时才处理
        if (emp.getExprList() != null && !emp.getExprList().isEmpty()) {
            emp.getExprList().forEach(expr -> expr.setEmpId(empId));

            empExprService.saveBatch(emp.getExprList());  // 用注入的 service

        } else {
            System.out.println("工作经历为空，不保存！");
        }


    }

    @Override
    public void updateEmpById(Emp emp) {
        emp.setUpdateTime(LocalDate.now());
        updateById(emp);
        empExprService.removeByEmpId(emp.getId());
        if(emp.getExprList()!=null && !emp.getExprList().isEmpty()){
            emp.getExprList().forEach(expr -> expr.setEmpId(emp.getId()));
            empExprService.saveBatch(emp.getExprList());
        }


    }
}
