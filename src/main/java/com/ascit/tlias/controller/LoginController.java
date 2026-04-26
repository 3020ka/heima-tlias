package com.ascit.tlias.controller;

import com.ascit.tlias.entity.Emp;
import com.ascit.tlias.entity.LoginRequest;
import com.ascit.tlias.entity.LoginResponse;
import com.ascit.tlias.result.Result;
import com.ascit.tlias.service.EmpService;
import com.ascit.tlias.utils.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        // 1. 根据用户名查询用户
        LambdaQueryWrapper<Emp> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Emp::getUsername, loginRequest.getUsername());
        Emp emp = empService.getOne(wrapper);

        // 2. 判断用户是否存在
        if (emp == null) {
            return Result.error("用户名不存在");
        }

        // 3. 判断密码是否正确
        if (!emp.getPassword().equals(loginRequest.getPassword())) {
            return Result.error("密码错误");
        }

        // 4. 生成JWT令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", emp.getId());
        claims.put("username", emp.getUsername());
        String token = JwtUtils.generateJwt(claims);

        // 5. 封装返回数据
        LoginResponse loginResponse = new LoginResponse(
                emp.getId(),
                emp.getUsername(),
                emp.getName(),
                token
        );

        return Result.success(loginResponse);
    }
}
