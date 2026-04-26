package com.ascit.tlias.controller;

import com.ascit.tlias.entity.DTO.StudentByIdDTO;
import com.ascit.tlias.entity.DTO.StudentDTO;
import com.ascit.tlias.entity.Student;
import com.ascit.tlias.mapper.StudentMapper;
import com.ascit.tlias.result.PageResult;
import com.ascit.tlias.result.Result;
import com.ascit.tlias.service.StudentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result getStudentsByConditon(StudentDTO studentDTO){
        Page<Student> studentPage=studentService.getStudentsByCondition(studentDTO);
        PageResult pageResult=new PageResult(studentPage.getTotal(),studentPage.getRecords());

        return Result.success(pageResult);
    }
    @DeleteMapping("{ids}")
    public Result deleteStudentsByIds(@PathVariable List<Integer> ids){
        studentService.removeByIds(ids);
        return Result.success();
    }
    @PostMapping
    public Result addStudents(@RequestBody Student student){
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        studentService.save(student);
        return Result.success();
    }
    @GetMapping("{id}")
    public Result getStudentsById(@PathVariable Integer id){
        Student student=studentService.getById(id);
        StudentByIdDTO studentByIdDTO=new StudentByIdDTO();
        BeanUtils.copyProperties(student,studentByIdDTO);

        return Result.success(studentByIdDTO);
    }
    @PutMapping
    public Result updateStudents(@RequestBody Student student){
        student.setUpdateTime(new Date());
        studentService.updateById(student);
        return Result.success();
    }
    @PutMapping("violation/{id}/{score}")
    public Result updateStudentsViolation(@PathVariable Integer id,@PathVariable Integer score){
        Student student=studentService.getById(id);
        student.setViolationCount(student.getViolationCount()+1);
        student.setViolationScore(student.getViolationScore()+score);
        student.setUpdateTime(new Date());
        studentService.updateById(student);
        return Result.success();
    }

}
