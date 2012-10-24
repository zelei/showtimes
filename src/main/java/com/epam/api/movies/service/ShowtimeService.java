package com.epam.api.movies.service;

import java.util.Collection;

import com.epam.api.movies.service.model.Theater;

public interface ShowtimeService {

	Collection<Theater> getShowtimes(String city, String local, int date) throws Exception;

}
