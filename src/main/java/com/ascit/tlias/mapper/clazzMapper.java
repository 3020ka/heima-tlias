package com.ascit.tlias.mapper;

import com.ascit.tlias.entity.clazz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface clazzMapper extends BaseMapper<clazz> {
    Page<clazz> getPageByCondition(@Param("name") String name, @Param("begin") LocalDate begin, @Param("end") LocalDate end, Page<clazz> pageParam);
}
