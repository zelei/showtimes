package com.epam.api.movies.config;

import hu.debrecen.adastra.card.service.ShowtimeCacheService;
import hu.debrecen.adastra.card.service.ShowtimeService;
import hu.debrecen.adastra.card.service.impl.GoogleShowtimeService;
import hu.debrecen.adastra.card.service.impl.JSONShowtimeCacheService;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
