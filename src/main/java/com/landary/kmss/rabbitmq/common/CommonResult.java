package com.landary.kmss.rabbitmq.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 帅
 * @Date 2020/6/10 21:34
 * @Description TODO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    private Integer code;
    private String msg;
    private Object result;

    public static CommonResult success(Object result){
        return new CommonResult(200,"发送消息成功",result);
     }
}
