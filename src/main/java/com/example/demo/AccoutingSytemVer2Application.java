package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(nameGenerator = FQCNGenerator.class)
public class AccoutingSytemVer2Application {

	public static void main(String[] args) {
		SpringApplication.run(AccoutingSytemVer2Application.class, args);
	}

}