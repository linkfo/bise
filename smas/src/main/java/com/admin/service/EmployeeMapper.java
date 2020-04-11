package com.admin.service;

import com.admin.domain.EmployeeEntity;
import com.admin.utils.PageUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {
    PageUtils queryPage(Map<String,Object> params);

    @Select("select * from employee ")
    List<EmployeeEntity> findAll();
    @Select("select emid,password from employee where emid=#{emid} and password=#{password}")
    EmployeeEntity findUser(@Param("emid") String emid,@Param("password") String password);
    @Select("select emid,password,bankid from employee")
    List<EmployeeEntity> findTest();
    @Insert("INSERT INTO smas.employee (`emid`, `password`, `name`, `age`, `gender`, `identity`, `bankid`, `tel`, `department`, `position`,`note`) " +
            "values (#{emid},#{password},#{name},#{age},#{gender},#{identity},#{bankid},#{tel},#{department},#{position},#{note});")
       int save(EmployeeEntity enity);

}
