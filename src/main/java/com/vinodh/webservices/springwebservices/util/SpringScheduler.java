package com.vinodh.webservices.springwebservices.util;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringScheduler {

	/**
	 * (cron = "seconds minutes hours day month week-day")
	 * 
	 */
	@Scheduled(cron = "*/30 * * * * *")
	public void currentTime() {
		log.info(Thread.currentThread().getName() + "..................Scheduler starts..............."
				+ LocalDateTime.now());
	}

}
