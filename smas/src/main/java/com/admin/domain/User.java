package com.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("employee")
public class User {
    // 主键
    private String emid;
    // 密码
    private String password;

    public String getemid() {
        return emid;
    }

    public void setemid(String emid) {
        this.emid = emid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "emid='" + emid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
