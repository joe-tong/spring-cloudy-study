package com.tpp.ms_feign_api.api;

import com.tpp.ms_feign_api.config.MsProviderCustomCfg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author joe.tpp
 * @date 2019/5/20 14:52
 * @desc
 */
@FeignClient(name = "MS-PROVIDER-ORDER",path = "/order")
public interface MsConsumerFeignApi {

    @RequestMapping(value = "/{userId}",method= RequestMethod.GET)
    public String getOrderFeign(@PathVariable("userId") String userId);

//    @RequestLine("GET /{userId}")
//    public String getOrderFeign(@PathVariable("userId") String userId);
}
