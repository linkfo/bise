package com.admin.controller;

import com.admin.domain.User;
import com.admin.service.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("findAll")
    public List<User> findAll(){
        return userMapper.queryUserList();

    }
    @GetMapping("findAll/page")
    public PageInfo<User> getPages(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<User> users = userMapper.queryUserList();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

}
