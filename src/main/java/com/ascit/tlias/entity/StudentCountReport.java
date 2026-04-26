package com.ascit.tlias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentCountReport {
    private List<String> clazzList;
    private List<Integer> dataList;
}
