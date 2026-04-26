package com.ascit.tlias.service;

import com.ascit.tlias.entity.EmpExpr;
import com.baomidou.mybatisplus.extension.service.IService;

public interface EmpExprService extends IService<EmpExpr> {
    void removeByEmpId(Integer empId);
}
