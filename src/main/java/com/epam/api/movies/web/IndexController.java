package com.epam.api.movies.web;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.api.movies.service.ShowtimeCacheService;

@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ShowtimeCacheService<String> showtimeService;

	@RequestMapping(value = { "/api/showtimes" }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String index(@RequestParam("near") String near, @RequestParam(value = "date", defaultValue = "0") int date) throws Exception {
		IndexController.LOGGER.debug("Get data from cache. Key: {}", near);
		return this.showtimeService.get(near, date);
	}

	@RequestMapping(value = { "", "/index" }, method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}
}
