package com.epam.api.movies.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ImportResource("classpath:/META-INF/spring/webmvc-config.xml")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

}
