package com.ascit.tlias.service;

import com.ascit.tlias.entity.DTO.StudentDTO;
import com.ascit.tlias.entity.Student;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface StudentService extends IService<Student> {
    Page<Student> getStudentsByCondition(StudentDTO studentDTO);
}
