package com.ascit.tlias.mapper;

import com.ascit.tlias.entity.EmpExpr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpExprMapper extends BaseMapper<EmpExpr> {
    void deleteByEmpId(Integer id);


}
