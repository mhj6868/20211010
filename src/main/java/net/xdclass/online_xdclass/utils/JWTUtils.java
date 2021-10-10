package net.xdclass.online_xdclass.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.online_xdclass.model.entity.User;

import java.util.Date;

public class JWTUtils {
    //一周过期
    public  static  final  long  EXPIRE=60000*60*24*7;
    //加密秘钥
    public  static  final String SECRET="xdclass.net168";
    //令牌前缀
    public  static  final String TOKEN_PREFIX="xdclass";
    //subject
    public  static  final String SUBJECT="xdclass";


    //根据用户信息，生成令牌
    public  static  String geneJsonWebToken(User user){
        String token=Jwts.builder().setSubject(SUBJECT)
                .claim("head_img",user.getHeadImg())
                .claim("id",user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();

        token=TOKEN_PREFIX+token;

        return token;
    }
//校验token的方法
    public  static Claims checkJWT(String token){
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;
        }catch (Exception e){
            return  null;
        }
    }
}
