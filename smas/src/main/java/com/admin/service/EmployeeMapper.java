package com.admin.service;

import com.admin.domain.EmployeeEntity;
import com.admin.utils.PageUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {
    PageUtils queryPage(Map<String,Object> params);


    @Select("select * from employee ")
    List<EmployeeEntity> findAll();
    @Select("select emid,password,identity from employee ")
    List<EmployeeEntity> findUser();
    @Select("select emid,password,bankid from employee")
    List<EmployeeEntity> findTest();
}