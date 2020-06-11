package com.landary.kmss.rabbitmq.simpleconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @Author 帅
 * @Date 2020/6/10 21:28
 * @Description 消费者从队列simple.hello中获取消息
 **/
@RabbitListener(queues = "simple.hello")
@Slf4j
public class SimpleReceiver {

    @RabbitHandler
    public void receive(String msg){
        log.info(" [x] Received '{}'", msg);
    }
}
