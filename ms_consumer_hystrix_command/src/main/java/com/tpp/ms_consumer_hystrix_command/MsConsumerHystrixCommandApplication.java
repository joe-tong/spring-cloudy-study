package com.tpp.ms_consumer_hystrix_command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsConsumerHystrixCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConsumerHystrixCommandApplication.class, args);
	}

}
