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
        Jwt jwt = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjMyMDU4NjQ5NjYsInVzZXIiOnsiaWQiOiIxIiwibG9naW5OYW1lIjoiYWRtaW4iLCJwYXNzd29yZCI6IiQyYSQxMCRqcmU2bWIxc05OVXFVR2JaVGlVTVVlOWFCejc3NG03NzduV2NBQkJFajBmZUFSdWR5SVV1dSIsInJlYWxOYW1lIjoiIiwiaXNFeHBpcmVkIjowLCJpc0xvY2tlZCI6MCwiaXNFbmFibGVkIjoxLCJ0eXBlIjpudWxsLCJzdGF0dXMiOm51bGwsImNyZWF0ZUJ5IjoiIiwiY3JlYXRlVGltZSI6MTU1ODI5MTU1MTAwMCwidXBkYXRlQnkiOiIiLCJ1cGRhdGVUaW1lIjoxNTYxMjU3MjcxMDAwLCJlbk5hbWUiOiIiLCJlbWFpbCI6IiIsInNleCI6bnVsbCwibW9iaWxlIjoiIiwicGVybWlzc2lvbnMiOlt7ImlkIjoiMSIsInBhcmVudElkIjpudWxsLCJuYW1lIjoiYWRtaW4iLCJjaGlsZHJlbiI6W10sInBhcmVudCI6bnVsbCwibGV2ZWwiOjAsImlzRXhwaXJlZCI6MCwiaXNMb2NrZWQiOjAsImlzRW5hYmxlZCI6MSwidHlwZSI6bnVsbCwic3RhdHVzIjpudWxsLCJjcmVhdGVCeSI6bnVsbCwiY3JlYXRlVGltZSI6MTU1ODI5MTU5ODAwMCwidXBkYXRlQnkiOm51bGwsInVwZGF0ZVRpbWUiOjE1NTgyOTE1OTgwMDAsImVuTmFtZSI6IjEiLCJjb2RlIjoiKiIsImF1dGhvcml0eSI6IioiLCJyb290Ijp0cnVlLCJsZWFmIjp0cnVlfV0sInJvbGVzIjpbXSwidXNlcm5hbWUiOiJhZG1pbiIsImVuYWJsZWQiOnRydWUsImFjY291bnROb25FeHBpcmVkIjp0cnVlLCJhY2NvdW50Tm9uTG9ja2VkIjp0cnVlLCJjcmVkZW50aWFsc05vbkV4cGlyZWQiOnRydWUsImF1dGhvcml0aWVzIjpudWxsfSwidXNlcl9uYW1lIjoiYWRtaW4iLCJqdGkiOiI0YzY1ZjZmZC1hYjYzLTQ0ZTEtOTA5YS0wMjA5NThkYzc1YzUiLCJjbGllbnRfaWQiOiJzZWN1cml0eS1zZXJ2aWNlIiwic2NvcGUiOlsic2VydmljZSJdfQ.NTMvM9VT81UivCPVEBY00A94oZ-cB1Det2ZkzgEIsGjilZFf3CGJKUR-kEPLgrV5jJ6JgiT8O2B3h9iScrWkM0GEVUMqeR4QRgkiTBkOLUKg-GfkeH19PihvvmBvakY4esOYP2KN8Brh9ucflNF8oNlKQhbAvWerbYamioLdepqb6uqviG-pZNVG51Wc69EGmefYv5sXRWi-z6s757DfDo-hWo8QTbCiW9eKvI1HW5ydku05YVZTwtRZiKZsn6GHw3kEvRVVIEsMw99XFRZVQJgdpsvYlxHLIKriyVv226-OuMN59oNPxDZHwwxp77M27eiyptw_dhear4lhe-RvHg");
        System.out.println(jwt.getClaims());
    }
}
