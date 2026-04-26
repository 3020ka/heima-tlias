package com.ascit.tlias.service.Impl;

import com.ascit.tlias.entity.OperateLog;
import com.ascit.tlias.entity.OperateLogDTO;
import com.ascit.tlias.mapper.OperateLogMapper;
import com.ascit.tlias.service.OperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public List<OperateLogDTO> getLogPage(Integer page, Integer pageSize) {
        Integer offset = (page - 1) * pageSize;
        return operateLogMapper.selectLogPage(offset, pageSize);
    }

    @Override
    public Long getTotal() {
        return operateLogMapper.selectTotal();
    }
}
