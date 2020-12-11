/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.producer;

import com.ygame.yg05.entity_cometics.NotificationJson;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerMQ {
    
    @Autowired
    private AmqpTemplate amqpTemplate;
    
    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;
    
    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;
    
    public void produceMsg(NotificationJson notic){
        amqpTemplate.convertAndSend(exchange, routingKey, notic);
    }
}
