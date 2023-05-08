package com.example.skirefka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SkiRefkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkiRefkaApplication.class, args);
	}

}
