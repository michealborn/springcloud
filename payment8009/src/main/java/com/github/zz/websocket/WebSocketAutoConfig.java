package com.github.zz.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketAutoConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/zzwebsocket")
                .setAllowedOrigins("*")
                .withSockJS();
    }

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/toAll"); //订阅Broker名称
//    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //服务器向客户端发起一对一信息时，必须以此api为前缀
//        registry.setUserDestinationPrefix("/toUser");
        //客户端订阅此api开头的消息
        registry.enableSimpleBroker("/user");

        //服务端订阅此api开头的消息
        registry.setApplicationDestinationPrefixes("/toServer");
    }
}
