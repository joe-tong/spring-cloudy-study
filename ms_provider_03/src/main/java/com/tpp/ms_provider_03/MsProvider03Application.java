package com.tpp.ms_provider_03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProvider03Application {

	public static void main(String[] args) {
		SpringApplication.run(MsProvider03Application.class, args);
	}

}
