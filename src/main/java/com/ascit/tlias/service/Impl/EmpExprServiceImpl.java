package com.ascit.tlias.service.Impl;

import com.ascit.tlias.entity.EmpExpr;
import com.ascit.tlias.mapper.EmpExprMapper;
import com.ascit.tlias.service.EmpExprService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Service;

@Service
public class EmpExprServiceImpl extends ServiceImpl<EmpExprMapper, EmpExpr> implements EmpExprService {
@Autowired
private EmpExprMapper empExprMapper;
    @Override
    public void removeByEmpId(Integer id) {
        empExprMapper.deleteByEmpId(id);
    }
}
