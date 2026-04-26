package com.ascit.tlias.controller;

import com.ascit.tlias.entity.OperateLogDTO;
import com.ascit.tlias.result.Result;
import com.ascit.tlias.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private OperateLogService operateLogService;

    @GetMapping("/page")
    public Result getLogPage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        List<OperateLogDTO> rows = operateLogService.getLogPage(page, pageSize);
        Long total = operateLogService.getTotal();
        
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("rows", rows);
        
        return Result.success(data);
    }
}
