package com.epam.api.movies.web;

import hu.debrecen.adastra.card.service.ShowtimeCacheService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ShowtimeCacheService<String> showtimeService;

	@RequestMapping(value = { "", "/" }, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String index(@RequestParam("near") String near, @RequestParam(value = "date", defaultValue = "0") int date) throws Exception {
		IndexController.LOGGER.debug("Get data from cache. Key: {}", near);
		return this.showtimeService.get(near, date);
	}
}
