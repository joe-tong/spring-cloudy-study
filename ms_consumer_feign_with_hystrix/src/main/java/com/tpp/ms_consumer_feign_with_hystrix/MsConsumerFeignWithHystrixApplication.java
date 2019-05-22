package com.tpp.ms_consumer_feign_with_hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableFeignClients(value = "com.tpp")
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.tpp.ms_consumer_feign_with_hystrix","com.tpp.ms_feign_api"})
public class MsConsumerFeignWithHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConsumerFeignWithHystrixApplication.class, args);
	}

}
