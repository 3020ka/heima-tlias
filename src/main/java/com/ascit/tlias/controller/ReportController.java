package com.ascit.tlias.controller;

import com.ascit.tlias.entity.EmpJobReport;
import com.ascit.tlias.entity.StudentCountReport;
import com.ascit.tlias.entity.empGenderData;
import com.ascit.tlias.result.Result;
import com.ascit.tlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    
    @GetMapping("empGenderData")
    public Result getEmpGenderData(){
        List<empGenderData> empGenderData = reportService.getEmpGenderData();
        return Result.success(empGenderData);
    }
    
    @GetMapping("empJobData")
    public Result getEmpJobData(){
        EmpJobReport report = reportService.getEmpJobReport();
        return Result.success(report);
    }
    
    @GetMapping("studentDegreeData")
    public Result getStudentDegreeData(){
        return Result.success(reportService.getStudentDegreeData());
    }
    
    @GetMapping("studentCountData")
    public Result getStudentCountData(){
        StudentCountReport report = reportService.getStudentCountReport();
        return Result.success(report);
    }

}
