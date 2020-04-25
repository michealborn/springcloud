package com.github.zz.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class WebsocketImpl {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/fromWeb")
    public String getMessageFromWeb(Message<MessageData> message){
        MessageData payload = message.getPayload();
        System.out.println(message.toString());
        System.out.println(payload.toString());
        return "success";
    }

    @MessageMapping("/fromdevice")
    public String getMessageFromDevice(Message<MessageData> message){
        MessageData payload = message.getPayload();
        System.out.println(message.toString());
        System.out.println(payload.toString());
        return "success";
    }


    @GetMapping("/toUser")
    @ResponseBody
    public String sendMessageToUser(){
        MessageData payload = new MessageData();
        //默认还会加上"/user/"，完整的路径为/user/ali/y
        simpMessagingTemplate.convertAndSendToUser("ali","","payload");
        return "aa";
    }

    @GetMapping(value = "/payment/lb")
    @ResponseBody
    public String getLB(){
        return new Date().toString();
    }

}
