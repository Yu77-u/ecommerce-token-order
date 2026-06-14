package com.shop.controller;
import com.shop.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,String> param){
        Map<String,Object> result = new HashMap<>();
        String username = param.get("username");
        String password = param.get("password");
        //模拟校验账号密码
        if("admin".equals(username)&&"123456".equals(password)){
            String token = JwtUtil.createToken(1);
            result.put("code",200);
            result.put("data",token);
        }else{
            result.put("code",500);
            result.put("msg","账号密码错误");
        }
        return result;
    }
}