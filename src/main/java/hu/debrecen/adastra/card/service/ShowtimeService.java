package hu.debrecen.adastra.card.service;

import hu.debrecen.adastra.card.service.model.Theater;

import java.util.Collection;

public interface ShowtimeService {

	Collection<Theater> getShowtimes(String city, int date) throws Exception;

}
