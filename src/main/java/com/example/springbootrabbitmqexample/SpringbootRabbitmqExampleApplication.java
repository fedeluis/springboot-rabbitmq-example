package com.example.springbootrabbitmqexample;

import com.example.springbootrabbitmqexample.dto.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRabbitmqExampleApplication {

	@Autowired
	private OrderRepository orderRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqExampleApplication.class, args);
	}

}
