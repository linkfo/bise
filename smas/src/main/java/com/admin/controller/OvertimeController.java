package com.admin.controller;

import com.admin.domain.AttendanceEntity;
import com.admin.domain.OvertimeLeaveEntity;
import com.admin.service.AttendanceMapper;
import com.admin.service.OvertimeLeaveMapper;
import com.admin.utils.PageUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Overtime")
public class OvertimeController {
    @Autowired
    private OvertimeLeaveMapper overtimeLeaveMapper;


    @GetMapping("/queryOvertime/{current}/{size}")
    public PageUtils test(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageUtils pageUtils = new PageUtils();
        IPage<OvertimeLeaveEntity> page = new Page<>(current, size);
        overtimeLeaveMapper.selectPage(page, null);
        pageUtils.setCurrentPage(current);
        pageUtils.setPageSize(size);
        pageUtils.setTotalCount((int) page.getTotal());
        pageUtils.setList(page.getRecords());
        return pageUtils;

    }

    @PostMapping("/insert")
    public OvertimeLeaveEntity insert(@RequestBody OvertimeLeaveEntity overtimeLeaveEntity) {
        int OvertimeLeaveEntity1 = overtimeLeaveMapper.insert(overtimeLeaveEntity);
        return overtimeLeaveEntity;
    }






}
