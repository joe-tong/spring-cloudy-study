package com.tpp.ms_consumer_feign_01.controller;

import com.tpp.ms_feign_api.api.MsConsumerFeignApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author joe.tpp
 * @date 2019/5/17 18:10
 * @desc
 */
@RestController
public class CustomerController {
    private final static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MsConsumerFeignApi msConsumerFeignApi;

    /**
     * 默认轮询负载均衡
     *
     * @return
     */
    @GetMapping("user")
    public String sendMsg() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order", String.class);
        String body = responseEntity.getBody();
        return body;

    }


    /**
     * feign自定义参数
     */
    @GetMapping("/user-feign")
    public String sendMsgByFeign() {
        String order = msConsumerFeignApi.getOrderFeign("feign-user");
        return order;
    }

}
