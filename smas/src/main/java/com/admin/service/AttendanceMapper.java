package com.admin.service;

import com.admin.domain.AttendanceEntity;
import com.admin.domain.EmployeeEntity;
import com.admin.utils.PageUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface AttendanceMapper extends BaseMapper<AttendanceEntity> {
    PageUtils queryPage(Map<String,Object> params);

    @Select("select * from attendance ")
    List<AttendanceEntity> findAll();
    @Insert("INSERT INTO smas.attendance  " +
            "values (#{atid},#{enid},#{name},#{day},#{am},#{pm},#{note});")
    int save(AttendanceEntity enity);
}
