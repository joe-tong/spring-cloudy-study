package com.tpp.ms_consumer_ribbon_01.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡配置类
 */
@Configuration
public class LbCfg {

    @Bean
    public IRule tulingRandomRule() {
        return new LbRandomRule();
    }

}
