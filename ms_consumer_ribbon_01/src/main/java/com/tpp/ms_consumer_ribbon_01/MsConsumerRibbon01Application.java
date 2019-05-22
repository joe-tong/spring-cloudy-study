package com.tpp.ms_consumer_ribbon_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsConsumerRibbon01Application {

	public static void main(String[] args) {
		SpringApplication.run(MsConsumerRibbon01Application.class, args);
	}

}
