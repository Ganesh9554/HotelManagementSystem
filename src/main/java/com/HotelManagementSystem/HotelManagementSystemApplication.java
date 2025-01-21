package com.HotelManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({"com.HotelManagementSystem.Controller","com.HotelManagementSystem.Repository"})
@EnableJpaRepositories("com.HotelManagementSystem.Repository")
@SpringBootApplication(scanBasePackages = {"Controller","Service","Model", "Repository"})
public class HotelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementSystemApplication.class, args);
	}

}
