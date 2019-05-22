package com.tpp.ms_feign_api.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        System.out.println("自定义拦截器");
        template.header("token","123456");
    }
}
