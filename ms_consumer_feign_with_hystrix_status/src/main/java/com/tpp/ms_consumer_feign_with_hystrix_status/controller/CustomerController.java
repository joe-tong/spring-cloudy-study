package com.tpp.ms_consumer_feign_with_hystrix_status.controller;

import com.tpp.ms_feign_api.api.MsConsumerFeignWithHystrixApi;
import com.tpp.ms_feign_api.api.MsConsumerFeignWithHystrixApi02;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    RestTemplate restTemplate;

    @Autowired
    MsConsumerFeignWithHystrixApi msConsumerFeignWithHystrixApi;

    @Autowired
    MsConsumerFeignWithHystrixApi02 msConsumerFeignWithHystrixApi02;

    @GetMapping("user")
    public String sendMsg() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order", String.class);
        String body = responseEntity.getBody();
        return body;

    }

    @GetMapping("user-hystrix")
    public String sendHystrixMsg() {
        String order = msConsumerFeignWithHystrixApi02.queryOrdersByUserId2(1);
        return order;
    }

    @GetMapping("user-feign-hystrix/{userId}")
    public String getUser(@PathVariable(value = "userId") Integer userId) {
        String body = msConsumerFeignWithHystrixApi.queryOrdersByUserId(userId);
        return body;
    }

}
