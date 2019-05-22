package com.tpp.ms_consumer_ribbon_01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("user")
    public String sendMsg() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order", String.class);
        String body = responseEntity.getBody();
        return body;

    }

    @GetMapping("/user-balance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MS-PROVIDER-ORDER");
        log.info("serviceId------------>:{},ip:{},port:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
