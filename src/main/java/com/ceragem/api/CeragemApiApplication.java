package com.ceragem.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CeragemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeragemApiApplication.class, args);
	}

}
