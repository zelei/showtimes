package com.epam.api.movies.service;

import java.util.concurrent.ExecutionException;

public interface ShowtimeCacheService<T> {

	T get(String key, int date) throws ExecutionException;

}
