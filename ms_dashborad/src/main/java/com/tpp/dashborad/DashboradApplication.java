package com.tpp.dashborad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboradApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboradApplication.class, args);
	}

}
