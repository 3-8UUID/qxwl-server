package com.wllt.qxwl.comm.utils;


import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: qxwl_server
 * @description:
 * @author: Tian-Quanyou
 * @create: 2020-06-05 17:30
 **/
public class JwtTokenUtil {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String SUBJECT = "congge";

    /**
     * 过期时间一天
     */
    public static final long EXPIRITION = 1000 * 24 * 60 * 60 * 7;

    public static final String APPSECRET_KEY = "congge_secret";

    private static final String ROLE_CLAIMS = "rol";

    private static final String USER_NAME = "username";


    public static String generateJsonWebToken(WlltUser user) {

        if (user.getId() == null || user.getUsername() == null ) {
            return null;
        }

        Map<String,Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, user.getRoles());

        String token = Jwts
                .builder()
                .setSubject(SUBJECT)
                .setClaims(map)
                .claim("id", user.getId())
                .claim("name", user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + CommonConstant.TOKEN_EXPIRY_DATE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
        return token;
    }

    /**
     * 生成token
     * @param username
     * @param role
     * @return
     */
    public static String createToken(String username, List<String> role) {

        Map<String,Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, role);

        String token = Jwts
                .builder()
                .setSubject(username)
                .setClaims(map)
                .claim(USER_NAME,username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + CommonConstant.TOKEN_EXPIRY_DATE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
        return token;
    }

    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取用户名
     * @param token
     * @return
     */
    public static String getUsername(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get(USER_NAME).toString();
    }

    /**
     * 获取用户角色
     * @param token
     * @return
     */
    public static String getUserRole(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get(ROLE_CLAIMS).toString();
    }

    /**
     * 是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

   /* public static void main(String[] args) {
        String name = "admin";
        List<String> role = new ArrayList<>();
        role.add("ROLE_ADMIN");
        role.add("ROLE_USER");
        String token = createToken(name,role);
        System.out.println(token);

        Claims claims = checkJWT(token);
        System.out.println(claims.get("username"));

        System.out.println(getUsername(token));

        System.out.println(getUserRole(token));

        System.out.println(isExpiration(token));

    }*/

}

