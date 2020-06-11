package com.landary.kmss.rabbitmq.workConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 帅
 * @Date 2020/6/10 21:44
 * @Description TODO
 **/
@Slf4j
public class WorkSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String queueName = "work.hello";
    public void send(int index){
        StringBuilder builder = new StringBuilder("Hello");
        int limitIndex = index % 3+1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(queueName,message);
        log.info(" [x] Sent '{}'",message);
    }
}
