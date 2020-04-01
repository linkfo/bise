package com.admin.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;


@Data
@TableName("employee")
public class EmployeeEntity implements Serializable {

    private String emid;
    // 密码
    private String password;

    private String name;

    private String age;

    private String gender;

    private String identity;

    private String bankid;

    private String tel;

    private String department;

    private String position;

    private String note;


}
