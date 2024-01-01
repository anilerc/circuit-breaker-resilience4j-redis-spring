package com.anilerc.publication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PublicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicationApplication.class, args);
	}

}
