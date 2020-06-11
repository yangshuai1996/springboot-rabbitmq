package com.landary.kmss.rabbitmq.simpleconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 帅
 * @Date 2020/6/10 21:20
 * @Description RabbitMQ5中消息模式第一种：简单模式
 * 它包含一个生产者、一个消费者和一个队列。生产者向队列里发送消息，消费者从队列中获取消息并消费
 **/
@Configuration
public class SimpleRabbitMQConfig {
    @Bean
    public Queue hello(){
        return new Queue("simple.hello");
    }

    @Bean
    public SimpleSender simpleSender(){
        return new SimpleSender();
    }

    @Bean
    public SimpleReceiver simpleReceiver(){
        return new SimpleReceiver();
    }
}
