package com.shop.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET = "shopSecretKey123";
    private static final long EXPIRY = 1000*60*60*2;

    //生成token
    public static String createToken(Integer userId){
        return Jwts.builder()
                .setSubject(userId.toString())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRY))
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }
    //解析token
    public static Integer getUserId(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getSubject());
    }
}