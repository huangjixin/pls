package com.zwo.pls.security;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * https://work.weixin.qq.com
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/7/18
 */
public class TestQYWechatAPI {
    public static void main(String[] args) throws JSONException {
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

        /*CloseableHttpClient httpclient = HttpClients.createDefault();
        httpPost = new HttpPost(url+token);
        httpPost.setHeader(CONTENT_TYPE, contentType);
        httpPost.setEntity(new StringEntity(data, charset));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        String resp;
        try {
            HttpEntity entity = response.getEntity();
            resp = EntityUtils.toString(entity, charset);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }*/

        JSONObject jsonObject = new JSONObject();
        JSONObject contentObject = new JSONObject();
        try {
            contentObject.put("content","Hi，我是自动监控！验布系统一切正常！！");
            jsonObject.put("touser","HuangJiXin");
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
