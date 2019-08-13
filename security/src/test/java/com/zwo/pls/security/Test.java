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
        Jwt jwt = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInNlcnZpY2UiXSwiZXhwIjozMjA1ODY1NzI2LCJ1c2VyIjp7ImlkIjoiMSIsImxvZ2luTmFtZSI6ImFkbWluIiwicGFzc3dvcmQiOiIkMmEkMTAkanJlNm1iMXNOTlVxVUdiWlRpVU1VZTlhQno3NzRtNzc3bldjQUJCRWowZmVBUnVkeUlVdXUiLCJyZWFsTmFtZSI6IiIsImlzRXhwaXJlZCI6MCwiaXNMb2NrZWQiOjAsImlzRW5hYmxlZCI6MSwidHlwZSI6bnVsbCwic3RhdHVzIjpudWxsLCJjcmVhdGVCeSI6IiIsImNyZWF0ZVRpbWUiOjE1NTgyOTE1NTEwMDAsInVwZGF0ZUJ5IjoiIiwidXBkYXRlVGltZSI6MTU2MTI1NzI3MTAwMCwiZW5OYW1lIjoiIiwiZW1haWwiOiIiLCJzZXgiOm51bGwsIm1vYmlsZSI6IiIsInBlcm1pc3Npb25zIjpbeyJpZCI6IjEiLCJwYXJlbnRJZCI6bnVsbCwibmFtZSI6ImFkbWluIiwiY2hpbGRyZW4iOltdLCJwYXJlbnQiOm51bGwsImxldmVsIjowLCJpc0V4cGlyZWQiOjAsImlzTG9ja2VkIjowLCJpc0VuYWJsZWQiOjEsInR5cGUiOm51bGwsInN0YXR1cyI6bnVsbCwiY3JlYXRlQnkiOm51bGwsImNyZWF0ZVRpbWUiOjE1NTgyOTE1OTgwMDAsInVwZGF0ZUJ5IjpudWxsLCJ1cGRhdGVUaW1lIjoxNTU4MjkxNTk4MDAwLCJlbk5hbWUiOiIxIiwiY29kZSI6IioiLCJhdXRob3JpdHkiOiIqIiwicm9vdCI6dHJ1ZSwibGVhZiI6dHJ1ZX1dLCJyb2xlcyI6W10sImVuYWJsZWQiOnRydWUsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiIqIn1dLCJ1c2VybmFtZSI6ImFkbWluIiwiYWNjb3VudE5vbkV4cGlyZWQiOnRydWUsImFjY291bnROb25Mb2NrZWQiOnRydWUsImNyZWRlbnRpYWxzTm9uRXhwaXJlZCI6dHJ1ZX0sImF1dGhvcml0aWVzIjpbIioiXSwianRpIjoiMDRhZWY3ZTYtZWJkZS00ZTc0LWFkNTgtZTY1ODJjNjFjMjBlIiwiY2xpZW50X2lkIjoic2VjdXJpdHktc2VydmljZSJ9.UPcp0oR9Ub1MPWFp_gmVqA69roopaB8fUFx3l75zIITPn3k6QULKzP5ZdvNWKFaK11ULbDKCtm-Z72as3NFBiU-E4Ws2PtoSLNujHvkq6Gh6ZVvDD3-mb34o0dypEq0xqM9MeQaSD9wwIz8KOxx0adHlvws9peTM71ApxBXaOFa60-9V9NqcW2aCGzMXFcaDwQVBVvYBlo2l__hLqVz28yZIvzbsBfwpEao4rtaU3rkg0XnZZ1JpXoK6apWDMsBFlyMqkQGdJDyxUXxokBbu8sBfkuGu2SZu70ZyKLzO_h4LSbuhlDtqAmbWSML1ge-ztUabqamYS4KtmUD1guyqew");
        System.out.println(jwt.getClaims());
    }
}
