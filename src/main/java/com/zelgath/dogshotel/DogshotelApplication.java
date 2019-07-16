package com.zelgath.dogshotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class DogshotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogshotelApplication.class, args);
	}


}
