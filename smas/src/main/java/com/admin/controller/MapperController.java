package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.admin.domain.User;
import com.admin.service.UserMapper;

import java.util.List;

@Controller
public class MapperController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    @ResponseBody
    public List<User> queryUser(){
        List<User> users = userMapper.queryUserList();
        return users;
    }

}
