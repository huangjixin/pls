package com.zwo.pls.security;

//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
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


        String content = "security-service:123456";
        String encodeContent = Base64.getEncoder().encodeToString(content.getBytes());
        System.out.println(encodeContent);
        byte[] bs = Base64.getDecoder().decode(encodeContent);
        String res = new String(bs);
        System.out.println(res);
//        Jwt jwt = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjMyMDM3NzA5NjIsInVzZXJfbmFtZSI6IjEwMDEiLCJhdXRob3JpdGllcyI6WyIqIiwiUk9MRV9BRE1JTiJdLCJqdGkiOiI1YmRmMTA5MS1jNDA2LTQzZjctYWRmNS0xYzAwMzQwZjljY2UiLCJjbGllbnRfaWQiOiJzZWN1cml0eS1zZXJ2aWNlIiwic2NvcGUiOlsic2VydmljZSJdfQ.GL8x9losAuVW8cCsi5qh_v3Y5c_JZtjBmT1kI7m8iGmOgFhCdk35JwgEZ3c1K004onNoXL1ly74qQi2G5mCMYoXhnHAU9AIJGH51Cx2lYooA2jGquvMVPxb8nY8o70PkS55lEfJFhtFj51GA_zUezGNcR13tkvpnbXsZOctujt0UBHNUWgDZoSObhL2ySfgQylkP0FkCjpkdxRjzyJtupo8Xa-CR9Cc8iOcaXousDOoxow__t8OzemLZdnitlbrhST80b7vqhwsBxi0DRRcpuFnUa-CQ3IeFsruPJqX9JGrpM_n5ULa-s_0HiWMQEk1CWOJiCVhVSX4F_c4U9LNkvg");
        Jwt jwt = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjMyMDU1OTQzNzcsInVzZXIiOnsiaWQiOiIxIiwibG9naW5OYW1lIjoiYWRtaW4iLCJwYXNzd29yZCI6IiQyYSQxMCRqcmU2bWIxc05OVXFVR2JaVGlVTVVlOWFCejc3NG03NzduV2NBQkJFajBmZUFSdWR5SVV1dSIsInJlYWxOYW1lIjoiIiwiaXNFeHBpcmVkIjowLCJpc0xvY2tlZCI6MCwiaXNFbmFibGVkIjoxLCJ0eXBlIjpudWxsLCJzdGF0dXMiOm51bGwsImNyZWF0ZUJ5IjoiIiwiY3JlYXRlVGltZSI6MTU1ODI5MTU1MTAwMCwidXBkYXRlQnkiOiIiLCJ1cGRhdGVUaW1lIjoxNTYxMjU3MjcxMDAwLCJlbk5hbWUiOiIiLCJlbWFpbCI6IiIsInNleCI6bnVsbCwibW9iaWxlIjoiIiwicGVybWlzc2lvbnMiOlt7ImlkIjoiMSIsInBhcmVudElkIjpudWxsLCJuYW1lIjoiMSIsImNoaWxkcmVuIjpbXSwicGFyZW50IjpudWxsLCJsZXZlbCI6MCwiaXNFeHBpcmVkIjowLCJpc0xvY2tlZCI6MCwiaXNFbmFibGVkIjoxLCJ0eXBlIjpudWxsLCJzdGF0dXMiOm51bGwsImNyZWF0ZUJ5IjpudWxsLCJjcmVhdGVUaW1lIjoxNTU4MjkxNTk4MDAwLCJ1cGRhdGVCeSI6bnVsbCwidXBkYXRlVGltZSI6MTU1ODI5MTU5ODAwMCwiZW5OYW1lIjoiMSIsImNvZGUiOiIqIiwiYXV0aG9yaXR5IjoiKiIsInJvb3QiOnRydWUsImxlYWYiOnRydWV9XSwicm9sZXMiOltdLCJlbmFibGVkIjp0cnVlLCJ1c2VybmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOm51bGwsImFjY291bnROb25FeHBpcmVkIjp0cnVlLCJhY2NvdW50Tm9uTG9ja2VkIjp0cnVlLCJjcmVkZW50aWFsc05vbkV4cGlyZWQiOnRydWV9LCJ1c2VyX25hbWUiOiJhZG1pbiIsImp0aSI6IjZjNzM5NDg3LTkxNGEtNDQxNS1iMDM4LTJmN2UyMTMzNWM0OCIsImNsaWVudF9pZCI6InNlY3VyaXR5LXNlcnZpY2UiLCJzY29wZSI6WyJzZXJ2aWNlIl19.embzjbuGT2GAE6Mpaj9AVyKr7QS5pYfYvlcET-Y6kidcKv6XDCFiUXc42Keirsv7TU86CQp6FwDL5esIJ_wIjSphPjhtgnTGh1vjs-5crpJ4wSZq7ya4Um1yEXeiVxInmSe4ZDQzBI3MYyUvSFfLNdSNBSbWG_H40VhU76gB9OoKiWldqZtc21byWa4U7aAszKIwjdp1AFqj4AcJc1tpHzM7hx_b_dNmsXoa3yP5f67mJZPvdiMTA9cChF6M-1HK2oitoGeKRkugs4gIpwt8zWAFvF_VnFy03RIVrCYM8CSbmsxgtNOIWZwjC4n6vUiZO92anfhUSh43M7ABts2-kg");
        System.out.println(jwt.getClaims());
    }
}
