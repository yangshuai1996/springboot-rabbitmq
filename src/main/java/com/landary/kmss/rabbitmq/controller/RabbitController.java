package com.landary.kmss.rabbitmq.controller;

import com.landary.kmss.rabbitmq.common.CommonResult;
import com.landary.kmss.rabbitmq.directConfig.DirectSender;
import com.landary.kmss.rabbitmq.fanoutConfig.FanoutSender;
import com.landary.kmss.rabbitmq.simpleconfig.SimpleSender;
import com.landary.kmss.rabbitmq.topicConfig.TopicReceiver;
import com.landary.kmss.rabbitmq.topicConfig.TopicSender;
import com.landary.kmss.rabbitmq.workConfig.WorkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author 帅
 * @Date 2020/6/10 21:31
 * @Description
 **/
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private SimpleSender simpleSender;
    @Autowired
    private WorkSender workSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private DirectSender directSender;
    @Autowired
    private TopicSender topicSender;
    @GetMapping("/simple")
    public CommonResult simpleTest(){
        for (int i = 0; i < 10; i++) {
            simpleSender.send();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return CommonResult.success(null);
    }
    @GetMapping("/work")
    public CommonResult workTest(){
        for (int i = 0; i < 10; i++) {
            workSender.send(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return CommonResult.success(null);
    }

    @GetMapping("/fanout")
    public CommonResult fanoutTest(){
        for (int i = 0; i < 10; i++) {
            fanoutSender.send(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return CommonResult.success(null);
    }

    @GetMapping("/direct")
    public CommonResult directTest(){
        for (int i = 0; i < 10; i++) {
            directSender.send(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return CommonResult.success(null);
    }

    @GetMapping("/topic")
    public CommonResult topicTest(){
        for (int i = 0; i < 10; i++) {
            topicSender.send(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return CommonResult.success(null);
    }

}
