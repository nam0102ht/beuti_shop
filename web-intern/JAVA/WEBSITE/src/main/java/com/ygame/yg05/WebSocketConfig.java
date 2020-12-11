/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    @Override
    //cấu hình socket khi kết nối với stomp
    public void registerStompEndpoints(StompEndpointRegistry registry) {
            registry.addEndpoint("/comment_blog").withSockJS();
    }

    @Override
//Cấu hình nơi admin gửi đến /app/receive-mesages, client nhận ở topic/message
    public void configureMessageBroker(MessageBrokerRegistry registry) {
            registry.enableSimpleBroker("/topic");
            registry.setApplicationDestinationPrefixes("/app");
    }

}
