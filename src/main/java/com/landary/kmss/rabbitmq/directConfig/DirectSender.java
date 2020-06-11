package com.landary.kmss.rabbitmq.directConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 帅
 * @Date 2020/6/10 23:18
 * @Description TODO
 **/
@Slf4j
public class DirectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String exchangeName = "exchange.direct";
    private final String[] keys = {"orange","black","green"};
    public void send(int index){
        StringBuilder builder = new StringBuilder("Hello to ");
        int limitIndex = index % 3;
        String key = keys[limitIndex];
        builder.append(key).append(' ');
        builder.append(index + 1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(exchangeName,key,message);
        log.info(" [x] Sent '{}'",message);
    }
}
