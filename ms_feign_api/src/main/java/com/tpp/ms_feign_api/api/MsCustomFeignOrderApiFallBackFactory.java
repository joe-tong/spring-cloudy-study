package com.tpp.ms_feign_api.api;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by smlz on 2019/4/15.
 */
@Slf4j
@Component
public class MsCustomFeignOrderApiFallBackFactory implements FallbackFactory<MsConsumerFeignWithHystrixApi> {

    @Override
    public MsConsumerFeignWithHystrixApi create(Throwable cause) {

        return new MsConsumerFeignWithHystrixApi() {
            @Override
            public String queryOrdersByUserId(Integer userId) {
                log.info("Factory降级");
                return "-1";
            }
        };
    }
}
