package com.zwo.pls.security;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
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
        Jwt jwt = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjMxODQ2OTEzNDcsInVzZXJfbmFtZSI6IjEiLCJqdGkiOiJlYjQwNGY2YS1hMDViLTRhNjYtYTgzMS04OTFlNmQ0M2FlNjUiLCJjbGllbnRfaWQiOiJzZWN1cml0eS1zZXJ2aWNlIiwic2NvcGUiOlsic2VydmljZSJdfQ.fGY9jPftqFbkhcv3Z66J77bNH1KIjO8C4X6ZMpyWp_8FWEBoLqz72uRChBbqsFVZIZe8LvppBGj7To6vafsEE-l6A_NM616zeGGUDhDPmBV0ymJIrWsNOGLT2WgFj5xrOYZvxsXuXjTcg_OiOKw7EcRFnbSZjlViHRZ9NBvxmHd1-I6m_Krms40JobwK5eyXZgSTm863Zc2GZXyFAIhxXHkG7erRPnHHZlueekSeNYd2w8QgNE_E59qEandYQ-SUW3Xs-zrWCImvaUgbh1It9Rgjpo1CWgJ5pVANQQt1uMiKlacbJ_-omS48RLUchmMsUb4jwtnClwYmM56b-KTiXw");
        System.out.println(jwt.getClaims());
    }
}
