package com.tpp.ms_feign_api.api;

import com.tpp.ms_feign_api.config.MsCustomeFeignApiWithoutHystrixConfg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author joe.tpp
 * @date 2019/5/21 11:09
 * @desc
 */
@FeignClient(name = "MS-PROVIDER-04" ,fallback = MsCustomFeignOrderApiFallBack02.class,path = "/order")
//@FeignClient(name = "MS-PROVIDER-04",fallbackFactory =MsCustomFeignOrderApiFallBackFactory.class ,path = "/order")
//@FeignClient(name = "MS-PROVIDER-04",configuration = MsCustomeFeignApiWithoutHystrixConfg.class,fallbackFactory =MsCustomFeignOrderApiFallBackFactory.class ,path = "/order")
public interface MsConsumerFeignWithHystrixApi02 {


    @RequestMapping(value = "/{userId}",method= RequestMethod.GET)
    public String queryOrdersByUserId2(@PathVariable(value = "userId") Integer userId);
}
