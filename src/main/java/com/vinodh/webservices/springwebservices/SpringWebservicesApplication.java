package com.vinodh.webservices.springwebservices;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebservicesApplication.class, args);
		/*ApplicationContext applicationContext = SpringApplication.run(SpringWebservicesApplication.class, args);
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);*/
	}
}
