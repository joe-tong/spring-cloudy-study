package com.tpp.ms_provider_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProvider02Application {

	public static void main(String[] args) {
		SpringApplication.run(MsProvider02Application.class, args);
	}

}
