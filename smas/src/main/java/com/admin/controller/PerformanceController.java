package com.admin.controller;

import com.admin.domain.AttendanceEntity;
import com.admin.domain.PerformanceEntity;
import com.admin.service.AttendanceMapper;
import com.admin.service.PerformanceMapper;
import com.admin.utils.PageUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Performance")
public class PerformanceController {
    @Autowired
    private PerformanceMapper performanceMapper;


    @GetMapping("/queryPerformance/{current}/{size}")
    public PageUtils test(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageUtils pageUtils = new PageUtils();
        IPage<PerformanceEntity> page = new Page<>(current, size);
        performanceMapper.selectPage(page, null);
        pageUtils.setCurrentPage(current);
        pageUtils.setPageSize(size);
        pageUtils.setTotalCount((int) page.getTotal());
        pageUtils.setList(page.getRecords());
        return pageUtils;

    }

    @PostMapping("/insert")
    public PerformanceEntity insert(@RequestBody PerformanceEntity performanceEntity) {
        int performanceEntity1 = performanceMapper.insert(performanceEntity);
        return performanceEntity;
    }

    @GetMapping("/update/{id}")
    public PerformanceEntity findById(@PathVariable("id") String id) {
        return performanceMapper.selectById(id);
    }
    @PostMapping("/update")
    public PerformanceEntity update(@RequestBody PerformanceEntity performanceEntity){
        performanceMapper.updateById(performanceEntity);
        return performanceEntity;
    }
    @DeleteMapping("/delect/{id}")
    public void delect(@PathVariable("id") String id){
        performanceMapper.deleteById(id);

    }




}
