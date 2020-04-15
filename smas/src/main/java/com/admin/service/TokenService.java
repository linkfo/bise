package com.admin.service;


import com.admin.domain.EmployeeEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service("TokenService")
public class TokenService {

    public String getToken(EmployeeEntity user) {
        Date date=new Date();
        Calendar nowtime =Calendar.getInstance();
        nowtime.add(Calendar.HOUR_OF_DAY,1);
        Date expriesDate=nowtime.getTime();
        System.out.println(date);
        System.out.println(expriesDate);
        String token="";
        token= JWT.create().withAudience(user.getEmid())// 将 user id 保存到 token 里面
                .withIssuedAt(date)
                .withExpiresAt(expriesDate)
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;

    }
}
