package com.epam.api.movies.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = { "hu.debrecen.adastra.card" }, excludeFilters = { @Filter(Configuration.class), @Filter(Controller.class) })
@ImportResource(value = { "classpath:/META-INF/spring/application-context.xml" })
@PropertySource(value = { "classpath:/META-INF/application.properties" })
public class MainConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainConfig.class);

}
