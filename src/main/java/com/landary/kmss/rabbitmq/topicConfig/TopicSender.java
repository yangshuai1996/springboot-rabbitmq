package com.landary.kmss.rabbitmq.topicConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 帅
 * @Date 2020/6/11 21:54
 * @Description TODO
 **/
@Slf4j
public class TopicSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String exchangeName = "exchange.topic";

    private final String[] keys = {"quick.orange.rabbit","lazy.orange.elephant","quick.orange.fox","lazy.brown.fox",
    "lazy.pink.rabbit","quick.brown.fox"};

    public void send(int index){
        StringBuilder builder = new StringBuilder("Hello to ");
        int limitIndex = index%keys.length;
        String key = keys[limitIndex];
        builder.append(key).append(' ');
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(exchangeName,key,message);
        log.info(" [x] Sent '{}'",message);
    }
}
