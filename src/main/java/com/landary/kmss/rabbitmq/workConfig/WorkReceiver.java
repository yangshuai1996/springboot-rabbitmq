package com.landary.kmss.rabbitmq.workConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @Author 帅
 * @Date 2020/6/10 21:49
 * @Description TODO
 **/
@RabbitListener(queues = "work.hello")
@Slf4j
public class WorkReceiver {
    private final int instance;
    public  WorkReceiver(int i){
        this.instance = i;
    }
    @RabbitHandler
    public void receive(String msg){
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance {} [X] Received '{}'",this.instance , msg);
        doWork(msg);
        watch.stop();
        log.info("instance {} [x] Done in {}s",this.instance,watch.getTotalTimeSeconds());
    }

    private void doWork(String msg){
        for (char ch:msg.toCharArray()){
            if(ch == '.'){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
