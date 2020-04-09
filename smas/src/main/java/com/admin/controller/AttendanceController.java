package com.admin.controller;

import com.admin.domain.AttendanceEntity;
import com.admin.domain.EmployeeEntity;
import com.admin.service.AttendanceMapper;
import com.admin.utils.PageUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {
    @Autowired
    private AttendanceMapper attendanceMapper;

    @GetMapping("findAll")
    public List<AttendanceEntity> findAll() {
        List<AttendanceEntity> attendanceEntities = attendanceMapper.findAll();
        return attendanceEntities;
    }

    @GetMapping("/queryAttendance/{current}/{size}")
    public PageUtils test(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageUtils pageUtils = new PageUtils();
        IPage<AttendanceEntity> page = new Page<>(current, size);
        attendanceMapper.selectPage(page, null);
        pageUtils.setCurrentPage(current);
        pageUtils.setPageSize(size);
        pageUtils.setTotalCount((int) page.getTotal());
        pageUtils.setList(page.getRecords());
        return pageUtils;

    }

    @PostMapping("/insert")
    public AttendanceEntity insert(@RequestBody AttendanceEntity attendanceEntity) {
        int attendanceEntity1 = attendanceMapper.insert(attendanceEntity);
        return attendanceEntity;
    }

    @GetMapping("/update/{id}")
    public AttendanceEntity findById(@PathVariable("id") String id) {
        return attendanceMapper.selectById(id);
    }
    @PostMapping("/update")
    public AttendanceEntity update(@RequestBody AttendanceEntity attendanceEntity){
        attendanceMapper.updateById(attendanceEntity);
        return attendanceEntity;
    }
    @DeleteMapping("/delect/{id}")
    public void delect(@PathVariable("id") String id){
        attendanceMapper.deleteById(id);

    }




}
