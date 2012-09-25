package hu.debrecen.adastra.card.service;

import java.util.concurrent.ExecutionException;

public interface ShowtimeCacheService<T> {

	T get(String key, int date) throws ExecutionException;

}
