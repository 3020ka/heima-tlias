package com.ascit.tlias.service.Impl;

import com.ascit.tlias.entity.clazz;
import com.ascit.tlias.entity.DTO.clazzDTO;
import com.ascit.tlias.mapper.clazzMapper;
import com.ascit.tlias.service.clazzService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clazzServiceImpl extends ServiceImpl<clazzMapper, clazz> implements clazzService {
    @Autowired
    private clazzMapper clazzMapper;
    public Page<clazz> getPageByCondition(clazzDTO clazzDTo) {

        Page<clazz> pageParam = new Page<>(clazzDTo.getPage(),clazzDTo.getPageSize());

       
      return clazzMapper.getPageByCondition(clazzDTo.getName(),clazzDTo.getBegin(),clazzDTo.getEnd(),pageParam);
    }
}
