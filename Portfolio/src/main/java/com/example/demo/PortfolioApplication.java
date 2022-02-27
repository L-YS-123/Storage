package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.mapper.LoginMapper;

@SpringBootApplication
@MapperScan(value = {"com.example.demo.mapper"})
public class PortfolioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
