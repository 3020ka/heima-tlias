package com.ascit.tlias.entity.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class clazzDTO {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate end;
    private Integer page;
    private Integer pageSize;


}
