package com.landary.kmss.rabbitmq.topicConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 帅
 * @Date 2020/6/11 21:48
 * @Description 通配符模式
 **/
@Configuration
public class TopicRabbitConfig {
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("exchange.topic");
    }

    @Bean
    public Queue topicQueue1(){
        return new AnonymousQueue();
    }

    @Bean
    public Queue topicQueue2(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding topicBind1a(TopicExchange topicExchange,Queue topicQueue1){
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("*.orange.*");
    }

    @Bean
    public Binding topicBind1b(TopicExchange topicExchange,Queue topicQueue1){
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("*.*.rabbit");
    }

    @Bean
    public Binding topicBind2a(TopicExchange topicExchange,Queue topicQueue2){
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("lazy.#");
    }

    @Bean
    public TopicReceiver topicReceiver(){
        return new TopicReceiver();
    }

    @Bean
    public TopicSender topicSender(){
        return new TopicSender();
    }
}
