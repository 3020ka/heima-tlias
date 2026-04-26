package com.ascit.tlias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EmpJobReport {
    private List<String> jobList;
    private List<Integer> dataList;
}
