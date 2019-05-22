package com.tpp.ms_consumer_feign_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(value = "com.tpp")
public class MsConsumerFeign01Application {

	public static void main(String[] args) {
		SpringApplication.run(MsConsumerFeign01Application.class, args);
	}

}
