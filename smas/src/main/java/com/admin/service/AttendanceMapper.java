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
    @Insert("INSERT INTO smas.employee  " +
            "values (#{emid},#{password},#{name},#{age},#{gender},#{identity},#{bankid},#{tel},#{department},#{position},#{note});")
    int save(AttendanceEntity enity);
}
