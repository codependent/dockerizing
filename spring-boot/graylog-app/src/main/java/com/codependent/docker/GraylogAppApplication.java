package com.codependent.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GraylogAppApplication {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping
	@ResponseStatus(HttpStatus.OK)
	public void sendLog(@RequestParam(required=false) String message){
		if(message == null){
			logger.info("NO MESSAGE");
		}else{
			logger.info(message);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GraylogAppApplication.class, args);
	}
}
