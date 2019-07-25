package com.zwo.pls.security;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * https://work.weixin.qq.com
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/7/18
 */
public class TestQYWechatAPI extends Thread {
    @Override
    public void run (){
        try {
            System.out.println("hello,123");
            Thread.sleep(Long.valueOf(2000));
        }catch (InterruptedException e){

        }

    }

    public static void main(String[] args) throws JSONException {
       try {
           for (int i = 0; i < 10; i++) {
               TestQYWechatAPI testQYWechatAPI = new TestQYWechatAPI();
               testQYWechatAPI.start();
               testQYWechatAPI.isAlive();
           }
       }catch (Exception e){

       }finally {
           try {
               Thread.sleep(4000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("执行完毕");
       }

    }

    private void alarm(){
        String corpid = "wwdf8f60f186c3bdbf";
        String agentID = "1000002";
        String secret = "S-IrjdC_-3uMSgAbx5Ljae9NbQUlS3s5FIk6n61T4CE";
        String getTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+secret;
        String accessTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
        RestTemplate restTemplate = new RestTemplate();
        Map map = restTemplate.getForObject(getTokenUrl, HashMap.class);
        System.out.println(map.toString());
        String accessToken = (String) map.get("access_token");
        if(accessToken != null){
            accessTokenUrl+=accessToken;
        }

        JSONObject jsonObject = new JSONObject();
        JSONObject contentObject = new JSONObject();
        try {
            contentObject.put("content","Hi，我是自动监控！验布系统一切正常！！");
            jsonObject.put("touser","HuangJiXin");
//            jsonObject.put("touser","@all");
//            jsonObject.put("toparty","1");
            jsonObject.put("msgtype","text");
            jsonObject.put("agentid",agentID);
            jsonObject.put("text",contentObject);
            jsonObject.put("safe","0");
        }catch (Exception e){

        }

        HttpHeaders headers = new HttpHeaders();
        //设置请求媒体数据类型
        headers.setContentType(MediaType.APPLICATION_JSON);
        //设置返回媒体数据类型
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObject.toString(), headers);

        map = restTemplate.postForObject(accessTokenUrl,formEntity,HashMap.class);
        System.out.println(map.toString());
    }
}
