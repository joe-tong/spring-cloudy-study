package com.tpp.ms_consumer_hystrix_command.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tpp.ms_consumer_hystrix_command.compent.HystrixCommandDefination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author joe.tpp
 * @date 2019/5/17 18:10
 * @desc
 */
@RestController
@Slf4j
public class CustomerController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("user")
    public String sendMsg() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order", String.class);
        String body = responseEntity.getBody();
        return body;

    }

    /**
     * 通过hystrix命令模式 来进行调用
     *
     * @param userId
     */
    @RequestMapping("/user/{userId}")
    public String queryUserInfo(@PathVariable("userId") Integer userId) {
        //构建调用命令模式
        HystrixCommandDefination tulingHystrixCommand = new HystrixCommandDefination("orderGroupKey", restTemplate, userId);
        String order = tulingHystrixCommand.execute();

        return order;
    }


    /**
     * 通过命令来指定降级方法
     *
     * @param userId 用户ID
     * @return
     */

    @HystrixCommand(fallbackMethod = "getFallback")
    @RequestMapping("/queryUserInfo/{userId}")
    public String queryUser(@PathVariable("userId") Integer userId) throws Exception {
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order/" + userId, String.class);
//        String body = responseEntity.getBody();
//        log.info("查询出的order:{}", body);
//        return body;
        userServiceImpl.getUser();
        return "12";
    }

    public String getFallback(Integer userId) {
        log.info("触发降级方法=根据用户ID{}查询订单服务异常:{}", userId);
        return "-1";
    }
//
//    protected String defautlUserInfoFallBack(String userName) {
//        log.info("触发降级方法=根据用户ID{}查询订单服务异常:{}", userName);
//        return "-1";
//    }
//
//    @HystrixCommand(fallbackMethod = "defautlUserInfoFallBack", commandKey = "queryUserInfoByName")
//    @RequestMapping("/queryUserInfoByName/{userName}")
//    public String queryUserInfoByName(@PathVariable("userName") String userName) {
//        log.info("queryUserInfoByName..............");
//
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order", String.class);
//        String body = responseEntity.getBody();
//        return body;
//    }
//

}
