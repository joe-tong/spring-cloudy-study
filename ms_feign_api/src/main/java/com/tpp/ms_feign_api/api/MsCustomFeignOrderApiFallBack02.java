package com.tpp.ms_feign_api.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**降级方法
 * Created by smlz on 2019/4/15.
 */
@Component
@Slf4j
public class MsCustomFeignOrderApiFallBack02 implements MsConsumerFeignWithHystrixApi02 {

    @Override
    public String queryOrdersByUserId2(Integer userId) {
        log.info("通过用户ID:{}查询订单的降级方法",userId);
        return "-1";
    }
}
