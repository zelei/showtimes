package com.epam.api.movies.config;


import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.api.movies.service.ShowtimeCacheService;
import com.epam.api.movies.service.ShowtimeService;
import com.epam.api.movies.service.impl.GoogleShowtimeService;
import com.epam.api.movies.service.impl.JSONShowtimeCacheService;

@Configuration
public class ServiceConfig {

	@Bean
	public ShowtimeService createShowtimeService() {
		return new GoogleShowtimeService();
	}

	@Bean
	public ShowtimeCacheService<String> createJSONShowtimeCacheService(ShowtimeService showtimeService) {
		return new JSONShowtimeCacheService(showtimeService, 1000, 1, TimeUnit.MINUTES);
	}

}
