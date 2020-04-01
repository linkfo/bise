package com.admin.controller;

import com.admin.domain.EmployeeEntity;
import com.admin.service.EmployeeMapper;
import com.admin.utils.PageUtils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("findAll")
    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> employeeEntities = employeeMapper.findAll();


        return employeeEntities;
    }

    @GetMapping("/queryEmployee/{current}/{size}")
    public PageUtils test(@PathVariable("current") Integer current,@PathVariable("size") Integer size){
        PageUtils pageUtils=new PageUtils();
        IPage<EmployeeEntity> page = new Page<>(current, size);
        employeeMapper.selectPage(page, null);
        pageUtils.setCurrentPage(current);
        pageUtils.setPageSize(size);
        pageUtils.setTotalCount((int) page.getTotal());
        pageUtils.setList(page.getRecords());
        return  pageUtils;













    }


    @GetMapping("findu")
    public List<EmployeeEntity> findu() {
        List<EmployeeEntity> employeeEntities2 = employeeMapper.findUser();
        return employeeEntities2;
    }

    @GetMapping("findt")
    public List<EmployeeEntity> findt() {
        List<EmployeeEntity> employeeEntities3 = employeeMapper.findTest();
        return employeeEntities3;
    }


}
