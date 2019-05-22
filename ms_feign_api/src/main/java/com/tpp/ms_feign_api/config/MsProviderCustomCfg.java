package com.tpp.ms_feign_api.config;

import com.tpp.ms_feign_api.interceptor.FeignInterceptor;
import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;


public class MsProviderCustomCfg {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }



    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options feignRequestOptions() {
        return new Request.Options(30000, 30000);
    }

    @Bean
    public RequestInterceptor interceptor() {
        return new FeignInterceptor();
    }
}
