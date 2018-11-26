package com.eureka.Hysterix.main.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="service-hysterix")
public interface ClientProxy {
	@RequestMapping(value="/getEmployee", produces=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	  public ResponseEntity<Object> getEmployee ();

}
