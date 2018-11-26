package com.eureka.Hysterix.main.controller;

import java.io.IOException;
import java.net.URI;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.eureka.Hysterix.main.Proxy.ClientProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ClientController {
	

	private static Logger log = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientProxy funcProxy;
	
	//get the employee data
	@RequestMapping(value = "/getdata", method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
     public Object getEmployee() throws RestClientException, IOException {
    	 log.info("Access /getdata","running the get method");
    	 
    	 Object myRespons = new Object();
    	 myRespons=funcProxy.getEmployee();
    	 
    	 return myRespons;
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
