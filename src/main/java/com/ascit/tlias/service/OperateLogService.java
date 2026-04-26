package com.ascit.tlias.service;

import com.ascit.tlias.entity.OperateLog;
import com.ascit.tlias.entity.OperateLogDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface OperateLogService extends IService<OperateLog> {

    List<OperateLogDTO> getLogPage(Integer page, Integer pageSize);

    Long getTotal();
}
