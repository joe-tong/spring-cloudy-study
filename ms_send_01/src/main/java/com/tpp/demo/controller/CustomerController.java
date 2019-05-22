package com.tpp.demo.controller;

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
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("user")
    public String sendMsg() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order", String.class);
        String body = responseEntity.getBody();
        return body;

    }

}
