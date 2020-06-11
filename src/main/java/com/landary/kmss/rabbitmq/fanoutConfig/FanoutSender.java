package com.landary.kmss.rabbitmq.fanoutConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 帅
 * @Date 2020/6/10 22:43
 * @Description TODO
 **/
@Slf4j
public class FanoutSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String exchangeName = "exchange.fanout";

    public void send(int index){
        StringBuilder stringBuilder = new StringBuilder("Hello");
        int limitIndex = index % 3 +1;
        for (int i = 0; i < limitIndex; i++) {
            stringBuilder.append('.');
        }
        stringBuilder.append(index + 1);
        String message = stringBuilder.toString();
        rabbitTemplate.convertAndSend(exchangeName,"",message);
        log.info(" [x] Sent '{}'", message);
    }
}
