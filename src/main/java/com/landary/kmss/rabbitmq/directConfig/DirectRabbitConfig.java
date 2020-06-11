package com.landary.kmss.rabbitmq.directConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 帅
 * @Date 2020/6/10 23:01
 * @Description 路由模式
 * 路由模式是可以根据路由键选择性给多个消费者发送消息的模式，它包含一个生产者、两个消费者、两个队列和一个交换机。
 * 两个消费者同时绑定到不同的队列上去，两个队列通过路由键绑定到交换机上去，生产者发送消息到交换机，交换机通过路由键
 * 转发到不同队列，队列绑定的消费者接收并消费消息
 **/
@Configuration
public class DirectRabbitConfig {
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("exchange.direct");
    }
    @Bean
    public Queue directQueue1(){
        return new AnonymousQueue();
    }
    @Bean
    public Queue directQueue2(){
        return new AnonymousQueue();
    }
    @Bean
    public Binding directBinding1a(DirectExchange directExchange,Queue directQueue1){
        return BindingBuilder.bind(directQueue1).to(directExchange).with("orange");
    }
    @Bean
    public Binding directBinding1b(DirectExchange directExchange,Queue directQueue1){
        return BindingBuilder.bind(directQueue1).to(directExchange).with("black");
    }
    @Bean
    public Binding directBinding2a(DirectExchange directExchange,Queue directQueue2){
        return BindingBuilder.bind(directQueue2).to(directExchange).with("green");
    }
    @Bean
    public Binding directBinding2b(DirectExchange directExchange,Queue directQueue2){
        return BindingBuilder.bind(directQueue2).to(directExchange).with("black");
    }
    @Bean
    public DirectReceiver receiver(){
        return new DirectReceiver();
    }
    @Bean
    public DirectSender directSender(){
        return new DirectSender();
    }
}
