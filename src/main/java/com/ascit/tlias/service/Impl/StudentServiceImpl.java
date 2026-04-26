package com.ascit.tlias.service.Impl;

import com.ascit.tlias.entity.DTO.StudentDTO;
import com.ascit.tlias.entity.Student;
import com.ascit.tlias.mapper.StudentMapper;
import com.ascit.tlias.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Page<Student> getStudentsByCondition(StudentDTO studentDTO) {
        Page<Student> page = new Page<>(studentDTO.getPage(), studentDTO.getPageSize());

        return studentMapper.getByCondition(page,studentDTO);
    }
}
