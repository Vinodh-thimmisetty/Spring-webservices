package com.vinodh.webservices.springwebservices.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinodh.webservices.springwebservices.domain.Greeting;

@RestController // @Controller + @Response body
public class GreetingController {

	@GetMapping(value = "/samplegreeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "vinodh") String name) {
		return new Greeting(new AtomicLong().incrementAndGet(), name);
	}
}
