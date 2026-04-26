package com.ascit.tlias.entity.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeptDTO {
    @NotBlank(message = "部门名称不能为空")
    private String name;
}
