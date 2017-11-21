package com.vinodh.webservices.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.vinodh.webservices.springwebservices.dao",
		"com.vinodh.webservices.springwebservices.repository" })
@Import(value = TestDBConfig.class)
public class TestSpringAppConfig {

}
