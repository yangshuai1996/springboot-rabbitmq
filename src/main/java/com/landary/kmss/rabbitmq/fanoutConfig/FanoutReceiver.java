package com.landary.kmss.rabbitmq.fanoutConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @Author 帅
 * @Date 2020/6/10 22:47
 * @Description TODO
 **/
@Slf4j
public class FanoutReceiver {
    @RabbitListener(queues = "#{fanoutQueue1.name}")
    public void receive1(String in){
        receive(in,1);
    }
    @RabbitListener(queues = "#{fanoutQueue2.name}")
    public void receive2(String in){
        receive(in,2);
    }
    private void receive(String in,int receiver){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        log.info("instance {} [x] Received '{}'",receiver,in);
        doWork(in);
        stopWatch.stop();
        log.info("instance {} [x] Done in {}",receiver,stopWatch.getTotalTimeSeconds());
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
