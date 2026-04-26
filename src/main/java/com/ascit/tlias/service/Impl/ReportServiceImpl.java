package com.ascit.tlias.service.Impl;

import com.ascit.tlias.entity.EmpJobReport;
import com.ascit.tlias.entity.StudentCountReport;
import com.ascit.tlias.entity.empGenderData;
import com.ascit.tlias.mapper.ReportMapper;
import com.ascit.tlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<empGenderData> getEmpGenderData() {
        List<empGenderData> empGenderData = reportMapper.getEmpGenderData();
        return empGenderData;
    }

    @Override
    public EmpJobReport getEmpJobReport() {
        List<Map<String, Object>> jobStats = reportMapper.getJobStats();
        
        Map<Integer, String> jobMapping = new LinkedHashMap<>();
        jobMapping.put(1, "教研主管");
        jobMapping.put(2, "学工主管");
        jobMapping.put(3, "其他");
        jobMapping.put(4, "班主任");
        jobMapping.put(5, "咨询师");
        jobMapping.put(6, "讲师");
        
        List<String> jobList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        
        for (Map.Entry<Integer, String> entry : jobMapping.entrySet()) {
            Integer jobId = entry.getKey();
            String jobName = entry.getValue();
            
            jobList.add(jobName);
            
            Integer count = 0;
            for (Map<String, Object> stat : jobStats) {
                if (jobId.equals(stat.get("job"))) {
                    count = ((Long) stat.get("count")).intValue();
                    break;
                }
            }
            dataList.add(count);
        }
        
        return new EmpJobReport(jobList, dataList);
    }

    @Override
    public List<empGenderData> getStudentDegreeData() {
        List<empGenderData> studentDegreeData = reportMapper.getStudentDegreeData();
        return studentDegreeData;
    }

    @Override
    public StudentCountReport getStudentCountReport() {
        List<Map<String, Object>> clazzStats = reportMapper.getClazzStats();
        
        List<String> clazzList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        
        for (Map<String, Object> stat : clazzStats) {
            String clazzName = (String) stat.get("clazzName");
            Integer count = ((Long) stat.get("count")).intValue();
            
            clazzList.add(clazzName);
            dataList.add(count);
        }
        
        return new StudentCountReport(clazzList, dataList);
    }
}
