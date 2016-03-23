package com.codependent.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
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
	public void sendLog(@RequestParam(required=false) String message, @RequestParam(required=false) Level level){
		message = message != null ? message : "NO MESSAGE";
		if(level == null){
			logger.info(message);
		}else{
			switch(level){
			case TRACE:
				logger.trace(message);
				break;
			case DEBUG:
				logger.debug(message);
				break;
			case INFO:
				logger.info(message);
				break;
			case WARN:
				logger.warn(message);
				break;
			case ERROR:
				logger.error(message);
				break;
			default:
				logger.info(message);
			}
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GraylogAppApplication.class, args);
	}
}
