package com.ascit.tlias.mapper;

import com.ascit.tlias.entity.Emp;
import com.ascit.tlias.entity.queryString;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper extends BaseMapper<Emp>{

    Page<Emp> getEmpsByPage(Page<Emp> page, queryString queryString);

    void addEmp(Emp emp);

}
