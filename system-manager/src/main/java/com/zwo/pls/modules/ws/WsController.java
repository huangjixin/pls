package com.zwo.pls.modules.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

//@Controller
public class WsController {
 
    /*@Autowired
    private SimpMessagingTemplate messagingTemplate;//通过SimpMessagingTemplate向浏览器发送消息
 
    @MessageMapping("/chat")
    //在Spring MVC中，可以直接在参数中获得Principal，Principal包含了当前用户的信息
    public void handleChat(Principal principal, String msg) {
        //如果发送人是wyf，则发送给wisely，如果发送人是wisely，则发送给wyf
        if (principal.getName().equals("wyf")) {
            //通过convertAndSendToUser向用户发送消息
            //第1个参数：接收消息的用户
            //第2个参数：浏览器订阅的地址
            //第3个参数：消息本身
            messagingTemplate.convertAndSendToUser("wisely",
                    "/queue/notifications", principal.getName() + "-send:"
                            + msg);
        } else {
            messagingTemplate.convertAndSendToUser("wyf",
                    "/queue/notifications", principal.getName() + "-send:"
                            + msg);
        }
    }*/
}