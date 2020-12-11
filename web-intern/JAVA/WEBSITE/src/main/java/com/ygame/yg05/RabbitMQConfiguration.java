/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05;

import com.ygame.yg05.listener.NotifiactionMessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
//    public static final String MQ_MESSAGES_QUEUE = "messageNotification";
//    public static final String SPRING_BOOT_EXCHANGE =  "spring-boot-exchange";
//    
//    @Bean
//    Queue queue(){
//        return new Queue(MQ_MESSAGES_QUEUE, false);
//    }
//    @Bean
//    TopicExchange topicExchange(){
//        return new TopicExchange(SPRING_BOOT_EXCHANGE);
//    }
//    @Bean
//    Binding binding(Queue queue, TopicExchange topicExchange){
//        return BindingBuilder.bind(queue).to(topicExchange).with(MQ_MESSAGES_QUEUE);
//    }
//    
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, 
//            MessageListenerAdapter messageListenAdapter){
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(MQ_MESSAGES_QUEUE);
//        container.setMessageListener(messageListenAdapter);
//        return container;
//    }
//    @Bean
//    MessageListenerAdapter listenAdapter(NotifiactionMessageListener reciver){
//        return new MessageListenerAdapter(reciver, "receiveMessage");
//    }
}
