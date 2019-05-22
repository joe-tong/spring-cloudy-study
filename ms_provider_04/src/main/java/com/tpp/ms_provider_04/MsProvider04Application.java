package com.tpp.ms_provider_04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProvider04Application {

	public static void main(String[] args) {
		SpringApplication.run(MsProvider04Application.class, args);
	}

}
