package com.biswo.myspringapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@ImportResource("classpath:applicationContext.xml")
public class MySpringAppApplication {

	private static ApplicationContext applicationContext;
	private static final Logger LOGGER = LogManager.getLogger(MySpringAppApplication.class);

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(MySpringAppApplication.class, args);

		LOGGER.debug("Application Started...");

		/*
		 * CountriesCacheService
		 * countriesCacheService=(CountriesCacheService)applicationContext.
		 * getBean("countriesCacheService");
		 * 
		 * Set<Long> keySet = LongStream.rangeClosed(1,
		 * 3).boxed().collect(Collectors.toSet());
		 * 
		 * 
		 * System.out.println(countriesCacheService.isCacheMiss());
		 * 
		 * List<Country> results = countriesCacheService.getAllCountry(keySet);
		 * 
		 * System.out.println(countriesCacheService.isCacheMiss());
		 * 
		 * results = countriesCacheService.getAllCountry(keySet);
		 * 
		 * System.out.println(countriesCacheService.isCacheMiss());
		 * 
		 * Country country=countriesCacheService.getTheSpecificContry(4l);
		 * System.out.println(countriesCacheService.isCacheMiss());
		 * System.out.println(country);
		 * 
		 * countriesCacheService.getTheSpecificContry(4l);
		 * System.out.println(countriesCacheService.isCacheMiss());
		 * System.out.println(country);
		 * 
		 * countriesCacheService.removeCourty(country);
		 * System.out.println(countriesCacheService.isCacheMiss());
		 */

	}
}
