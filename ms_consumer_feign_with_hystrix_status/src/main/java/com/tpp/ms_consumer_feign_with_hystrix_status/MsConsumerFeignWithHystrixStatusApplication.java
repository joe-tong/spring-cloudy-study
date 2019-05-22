package com.tpp.ms_consumer_feign_with_hystrix_status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(value = "com.tpp")
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.tpp.ms_consumer_feign_with_hystrix_status","com.tpp.ms_feign_api"})
public class MsConsumerFeignWithHystrixStatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConsumerFeignWithHystrixStatusApplication.class, args);
	}

}
