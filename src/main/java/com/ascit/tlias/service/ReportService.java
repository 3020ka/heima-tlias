package com.ascit.tlias.service;

import com.ascit.tlias.entity.EmpJobReport;
import com.ascit.tlias.entity.StudentCountReport;
import com.ascit.tlias.entity.empGenderData;

import java.util.List;

public interface ReportService {
    List<empGenderData> getEmpGenderData();

    EmpJobReport getEmpJobReport();

    List<empGenderData> getStudentDegreeData();

    StudentCountReport getStudentCountReport();
}
