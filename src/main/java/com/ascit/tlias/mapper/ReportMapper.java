package com.ascit.tlias.mapper;

import com.ascit.tlias.entity.empGenderData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    List<empGenderData> getEmpGenderData();

    List<Map<String, Object>> getJobStats();

    List<empGenderData> getStudentDegreeData();

    List<Map<String, Object>> getClazzStats();
}
