package com.ascit.tlias.service.Impl;

import com.ascit.tlias.entity.Dept;
import com.ascit.tlias.mapper.DeptMapper;
import com.ascit.tlias.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
      return deptMapper.selectList(null);
    }

    @Override
    public void deleteDeptsById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void addDepts(Dept dept) {
        deptMapper.insert(dept);


    }

    @Override
    public Dept getDeptById(Integer id) {
        return deptMapper.selectById( id);

    }
}
