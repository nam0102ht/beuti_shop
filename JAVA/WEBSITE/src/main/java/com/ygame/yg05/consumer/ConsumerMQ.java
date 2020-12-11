/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.consumer;

import com.ygame.yg05.entity_cometics.NotificationJson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMQ {
    public static final String MQ_MESSAGES_QUEUE = "messageNotification";
    public static final String SPRING_BOOT_EXCHANGE =  "spring-boot-exchange";
    
    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void receiveMessage(NotificationJson json){
        
    }
    
}
