package com.shop.config;
import com.shop.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if(token==null || !token.startsWith("Bearer ")){
            response.setStatus(401);
            return false;
        }
        try{
            String realToken = token.replace("Bearer ","");
            JwtUtil.getUserId(realToken);
            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
    }
}