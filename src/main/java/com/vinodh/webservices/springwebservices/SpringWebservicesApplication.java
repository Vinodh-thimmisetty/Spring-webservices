package com.vinodh.webservices.springwebservices;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import com.vinodh.webservices.springwebservices.util.SpringScheduler;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableScheduling
@Slf4j
public class SpringWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebservicesApplication.class, args);
		/*ApplicationContext applicationContext = SpringApplication.run(SpringWebservicesApplication.class, args);
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);*/
	}

	@Bean
	public SpringScheduler springScheduler() {
		return new SpringScheduler();
	}

	@Bean
	public TaskScheduler taskScheduler() {
		return new ConcurrentTaskScheduler();
	}

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public CommandLineRunner commandLineRunner() {
		return x ->
		// This is functional interface i.e., only one method.
		// This helps in loading the Data before application starts
		log.info("first...@@@" + LocalDateTime.now());

	}

}
