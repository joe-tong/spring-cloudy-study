package com.tpp.ms_provider_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author joe.tpp
 * @date 2019/5/20 9:49
 * @desc
 */
@RestController
public class OrderController {

    @GetMapping("order")
    public String getOrder() {
        return "order_1";
    }

    @GetMapping("order/{userId}")
    public String getOrderFeign(@PathVariable("userId") String userId){
        return "order_feign_01: "+userId;
    }
}
