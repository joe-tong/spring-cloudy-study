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
@FeignClient(name = "MS-PROVIDER" ,fallback = MsCustomFeignOrderApiFallBack.class,path = "/order")
//@FeignClient(name = "MS-PROVIDER",fallbackFactory =MsCustomFeignOrderApiFallBackFactory.class ,path = "/order")
//@FeignClient(name = "MS-PROVIDER",configuration = MsCustomeFeignApiWithoutHystrixConfg.class,fallbackFactory =MsCustomFeignOrderApiFallBackFactory.class ,path = "/order")
public interface MsConsumerFeignWithHystrixApi {


    @RequestMapping(value = "/{userId}",method= RequestMethod.GET)
    public String queryOrdersByUserId(@PathVariable(value = "userId") Integer userId);
}
