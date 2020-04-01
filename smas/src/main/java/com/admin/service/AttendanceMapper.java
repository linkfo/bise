package com.admin.service;

import com.admin.domain.AttendanceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AttendanceMapper extends BaseMapper<AttendanceEntity> {
    public List<AttendanceEntity> findAll();
}
