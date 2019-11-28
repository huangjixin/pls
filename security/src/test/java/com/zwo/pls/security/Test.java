package com.zwo.pls.security;

//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

import java.util.Base64;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/6/23
 */
public class Test {
    public static void main(String[] args) {
//        StandardPBEStringEncryptor standardPBEStringEncryptor =new StandardPBEStringEncryptor();
//        /*配置文件中配置如下的算法*/
//        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
//        /*配置文件中配置的password*/
//        standardPBEStringEncryptor.setPassword("EWRREWRERWECCCXC");
//        /*要加密的文本*/
//        String name = standardPBEStringEncryptor.encrypt("root");
//        String password =standardPBEStringEncryptor.encrypt("abc123");
//        /*将加密的文本写到配置文件中*/
//        System.out.println("name="+name);
//        System.out.println("password="+password);

        // 用户密码编码；
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePass = passwordEncoder.encode("123456");
        System.out.println(encodePass);

        String content = "security-service:123456";
        String encodeContent = Base64.getEncoder().encodeToString(content.getBytes());
        System.out.println(encodeContent);
        byte[] bs = Base64.getDecoder().decode(encodeContent);
        String res = new String(bs);
        System.out.println(res);
//        Jwt jwt = JwtHelper.decode("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjMyMDYxMjAwNzIsInVzZXJfbmFtZSI6IjEwMDEiLCJhdXRob3JpdGllcyI6WyIqIiwiUk9MRV9BRE1JTiJdLCJqdGkiOiIxZWIxN2E5MC1iZjA1LTQxYzQtOGQwNS04MmQyMWNkZDY2ZGEiLCJjbGllbnRfaWQiOiJzZWN1cml0eS1zZXJ2aWNlIiwic2NvcGUiOlsic2VydmljZSJdfQ.7CFlbuetCI2sTrPqhRJiMXDCEp0hML7s2bSvRe8Cmgs");
        Jwt jwt = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInNlcnZpY2UiXSwiZXhwIjozMjExMjgxMTA3LCJ1c2VyIjp7ImlkIjoiMTAwIiwibG9naW5OYW1lIjoiYWRtaW4iLCJwYXNzd29yZCI6IiQyYSQxMCQzUi82MS5Vc2VSVHp3dll1bHJWS2suS0YwWEJzMmhaQ0hCZDkxRVNzdjZaUkR1bHNRYkFxQyIsInJlYWxOYW1lIjoiIiwiaXNFeHBpcmVkIjowLCJpc0xvY2tlZCI6MCwiaXNFbmFibGVkIjoxLCJ0eXBlIjpudWxsLCJzdGF0dXMiOm51bGwsImNyZWF0ZUJ5IjoiIiwiY3JlYXRlVGltZSI6MTU1NjkwNjM0NjAwMCwidXBkYXRlQnkiOiIiLCJ1cGRhdGVUaW1lIjoxNTcxMDE4MzkwMDAwLCJlbk5hbWUiOiIiLCJlbWFpbCI6IiIsInNleCI6bnVsbCwibW9iaWxlIjoiIiwicGVybWlzc2lvbnMiOlt7ImlkIjoiMSIsInBhcmVudElkIjoiIiwibmFtZSI6Iua1i-ivlSIsImNoaWxkcmVuIjpbXSwicGFyZW50IjpudWxsLCJsZXZlbCI6MCwiaXNFeHBpcmVkIjowLCJpc0xvY2tlZCI6MCwiaXNFbmFibGVkIjoxLCJ0eXBlIjpudWxsLCJzdGF0dXMiOm51bGwsImNyZWF0ZUJ5IjoiIiwiY3JlYXRlVGltZSI6MTU1NjM1MTQxMjAwMCwidXBkYXRlQnkiOiIiLCJ1cGRhdGVUaW1lIjoxNTU2MzUxNDEyMDAwLCJlbk5hbWUiOiIiLCJjb2RlIjoiKiIsImF1dGhvcml0eSI6IioiLCJyb290Ijp0cnVlLCJsZWFmIjp0cnVlfV0sInJvbGVzIjpbXSwiZW5hYmxlZCI6dHJ1ZSwidXNlcm5hbWUiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiIqIn1dLCJhY2NvdW50Tm9uTG9ja2VkIjp0cnVlLCJjcmVkZW50aWFsc05vbkV4cGlyZWQiOnRydWUsImFjY291bnROb25FeHBpcmVkIjp0cnVlfSwiYXV0aG9yaXRpZXMiOlsiKiJdLCJqdGkiOiI5YmM2MGNkMC01NTEwLTQ1MDItOTdlMi0wYmZmNDQ3OTAxNjMiLCJjbGllbnRfaWQiOiJzZWN1cml0eS1zZXJ2aWNlIn0.OXgw0kzdhqddPwIX29vTE7KDCVjb_QY3xxr7AV6ZCdNi2k9MQcZeOCcMp-ED_dSuIRcpHdWRwkDCg7MBxjAj37omuR3t2n927QyptzIog_lMlBd9KRPTy5dNv0VPgQp00sV-rTa6EV7C8KpYJNY1OBqf1OrfZ0NBlJcAvbXFdxuqvYTL8smaMgTPKRGeLAH0nDIZ_9xJJ7zHvRsht1nt-VDmNsdGu7poiFeyKe4xdTi1o3eK_dA_-paXSVTb8Z17ANmKZkwZs0O6By90lRWc7-htBPML1yGLaqiYBBMuoasmHhCojezlwTZstiKFCAF58knOPi1n0EcQtd5IQ_N24Q");
        System.out.println(jwt.getClaims());
    }
}
