package com.ascit.tlias.mapper;

import com.ascit.tlias.entity.OperateLog;
import com.ascit.tlias.entity.OperateLogDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper extends BaseMapper<OperateLog> {

    @Select("SELECT ol.*, e.name AS operateEmpName " +
            "FROM operate_log ol " +
            "LEFT JOIN emp e ON ol.operate_emp_id = e.id " +
            "ORDER BY ol.operate_time DESC " +
            "LIMIT #{offset}, #{pageSize}")
    List<OperateLogDTO> selectLogPage(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    @Select("SELECT COUNT(*) FROM operate_log")
    Long selectTotal();
}
