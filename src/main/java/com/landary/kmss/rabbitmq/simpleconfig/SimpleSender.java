package com.landary.kmss.rabbitmq.simpleconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 帅
 * @Date 2020/6/10 21:25
 * @Description 生产者通过send方法向队列simple.hello中发送消息
 **/
@Slf4j
public class SimpleSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String queueName="simple.hello";

    public void send(){
        String message = "Hello World!";
        rabbitTemplate.convertAndSend(queueName,message);
        log.info(" [x] Send '{}'",message);
    }
}
