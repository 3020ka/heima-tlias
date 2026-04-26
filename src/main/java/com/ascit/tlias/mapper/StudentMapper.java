package com.ascit.tlias.mapper;

import com.ascit.tlias.entity.DTO.StudentDTO;
import com.ascit.tlias.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    Page<Student> getByCondition(Page<Student> page, StudentDTO studentDTO);
}
