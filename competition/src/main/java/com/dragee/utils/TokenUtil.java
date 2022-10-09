package com.dragee.utils;

import com.dragee.config.exception.AuthErrorType;
import com.dragee.config.exception.AuthException;
import com.dragee.constants.AuthConstants;
import com.dragee.modules.sys.entity.LoginUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.gson.io.GsonSerializer;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/** token工具类
 * @author tys on 11/9/20
 */
public class TokenUtil {
    public static SecretKey key = Keys.hmacShaKeyFor(AuthConstants.JWT_SIGN.getBytes());
    /** 从请求中获取token
     * @param req
     * @return
     */
    public static String getToken (HttpServletRequest req) {
        String token = req.getHeader(AuthConstants.JWT_TOKEN_HEADER);
        if (token == null || "".equals(token)) {
            return null;
        }
        return token.replace(AuthConstants.JWT_TOKEN_PREFIX, "");
    }
    /** 创建token
     * @param expiredTime 过期时间 这里不设置过期时间 由数据库保存失效时间
     * @return
     */
    public static String createToken (LoginUser loginUser, Long expiredTime) {
        return Jwts.builder()
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .setHeaderParam("TYP", "JWT")
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime))
                .setSubject(loginUser.getUsername())
                .claim("info", loginUser)
                .signWith(key)
                .compact();
    }
    /** 解析token
     * @param token
     * @return
     */
    public static LoginUser parseToken (String token) {
        Object info = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("info");
        ObjectMapper om = new ObjectMapper();
        LoginUser loginUser = om.convertValue(info, LoginUser.class);
        loginUser.setToken(token);
        return loginUser;
    }

    /** 校验token
     * @param token
     * @return
     */
    public static void checkToken (String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parse(token);
        } catch (SignatureException e) {
            throw new AuthException(AuthErrorType.SIGNATURE_ERROR);
        } catch (ExpiredJwtException e) {
            throw new AuthException(AuthErrorType.TOKEN_EXPIRED);
        }
    }


    public static void main(String[] args) {
        @Data
        @AllArgsConstructor
        class Dragee {
            private String name;
            private int age;
        }

//        String token = Jwts.builder()
//                .setHeaderParam("TYP", "JWT")
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2))
//                .setSubject("dragee")
//                .claim("info", new Dragee("dragee", 18))
//                .signWith(key)
//                .compact();
//
//        System.out.println(token);

        for (int i = 0; i < 100; i++ ){
            String token = Jwts.builder()
                    .setHeaderParam("TYP", "JWT")
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2))
                    .setSubject("dragee")
                    .claim("info", new Dragee("dragee", 18))
                    .signWith(key)
                    .compact();

            System.out.println(token);
        }
//        String tokenStr = "eyJUWVAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjM0MDAxMjYsInN1YiI6ImRyYWdlZSIsImluZm8iOnsibmFtZSI6ImRyYWdlZSIsImFnZSI6MTh9fQ.9XhdSPfrFlgx4Hd3c64h9SPzp-zhzUCl2-ODCaXQ7Nw";
//        SecretKey key2 = Keys.hmacShaKeyFor("JdL6sB4SXKU6wc3ZL2KLULzBCcbfzCg6sD5xNoPp8Oc=".getBytes());
//        try {
//            Jwts.parserBuilder().setSigningKey(key).build().parse(tokenStr);
//        } catch (SignatureException e) {
//            throw new AuthException(AuthErrorType.SIGNATURE_ERROR);
//        } catch (ExpiredJwtException e) {
//            throw new AuthException(AuthErrorType.TOKEN_EXPIRED);
//        }


        //SignatureException
        //ExpiredJwtException
    }

}
