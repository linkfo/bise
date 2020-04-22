package com.admin.controller;

import com.admin.annotation.UserLoginToken;
import com.admin.domain.EmployeeEntity;
import com.admin.service.EmployeeMapper;
import com.admin.service.TokenService;
import com.admin.utils.PageUtils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    TokenService tokenService;

    @UserLoginToken
    @GetMapping("findAll")
    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> employeeEntities = employeeMapper.findAll();
        return employeeEntities;
    }
    //@UserLoginToken
    @GetMapping("/queryEmployee/{current}/{size}")
    public PageUtils test(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageUtils pageUtils = new PageUtils();
        IPage<EmployeeEntity> page = new Page<>(current, size);
        employeeMapper.selectPage(page, null);
        pageUtils.setCurrentPage(current);
        pageUtils.setPageSize(size);
        pageUtils.setTotalCount((int) page.getTotal());
        pageUtils.setList(page.getRecords());
        return pageUtils;

    }

    @PostMapping("/insert")
    public EmployeeEntity insert(@RequestBody EmployeeEntity employeeEntity) {
        int employeeEntity1 = employeeMapper.insert(employeeEntity);
        return employeeEntity;
    }

    @PostMapping("/insertTest")
    public EmployeeEntity save(@RequestBody EmployeeEntity employeeEntity) {
        int employeeEntity1 = employeeMapper.save(employeeEntity);
        return employeeEntity;

    }

    @GetMapping("/update/{id}")
    public EmployeeEntity findById(@PathVariable("id") String id) {
        return employeeMapper.selectById(id);
    }

    @PostMapping("/update")
    public EmployeeEntity update(@RequestBody EmployeeEntity employeeEntity) {
        employeeMapper.updateById(employeeEntity);
        return employeeEntity;
    }

    @DeleteMapping("/delect/{id}")
    public void delect(@PathVariable("id") String id) {
        employeeMapper.deleteById(id);

    }

    @GetMapping("login/{id}/{password}")
    public String login(@PathVariable("id") String id, @PathVariable("password") String password) {
        EmployeeEntity employeeEntities2 = employeeMapper.findUser(id, password);
        if (employeeEntities2 != null) {
            return id;
        } else {
            return "error";
        }
    }


    @PostMapping("/logintest")
    public Serializable login(@RequestBody EmployeeEntity employeeEntity) {
        JSONObject jsonObject = new JSONObject();
        EmployeeEntity userForBase = employeeMapper.selectById(employeeEntity);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(employeeEntity.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                if(userForBase.getNote().equals(employeeEntity.getNote())){
                    jsonObject.put("note",employeeEntity.getNote());
                }
                String token = tokenService.getToken(userForBase);
                jsonObject.put("message", "登录成功");
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

    @GetMapping("findt")
    public List<EmployeeEntity> findt() {
        List<EmployeeEntity> employeeEntities3 = employeeMapper.findTest();
        return employeeEntities3;
    }


}
