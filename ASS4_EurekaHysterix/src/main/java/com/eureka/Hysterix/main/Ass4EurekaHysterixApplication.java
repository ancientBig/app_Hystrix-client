package com.eureka.Hysterix.main;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;


import com.eureka.Hysterix.main.controller.ClientController;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
public class Ass4EurekaHysterixApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		SpringApplication.run(Ass4EurekaHysterixApplication.class, args);
		
		
		ClientController consumerControllerClient= new ClientController();
		
		System.out.println(consumerControllerClient);
		consumerControllerClient.getEmployee();
	}
	
}

