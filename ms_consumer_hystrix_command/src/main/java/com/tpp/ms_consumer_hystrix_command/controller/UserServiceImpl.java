package com.tpp.ms_consumer_hystrix_command.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author joe.tpp
 * @date 2019/5/21 10:50
 * @desc
 */
@Component
@Slf4j
public class UserServiceImpl {

    @HystrixCommand(fallbackMethod="getUserFallback")
    public String getUser()throws Exception{
        int i=1/0;
        return "1";
    }

    public String getUserFallback(Integer userId, Throwable throwable) {
        log.info("触发降级方法=根据用户ID{}查询订单服务异常:{}", userId);
        return "-1";
    }
}
