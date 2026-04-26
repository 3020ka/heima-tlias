package com.ascit.tlias.entity.DTO;

import lombok.Data;

@Data
public class StudentDTO {
    private String name;
    private Integer degree;
    private Integer clazzId;
    private Integer page;
    private Integer pageSize;
}
