package com.epam.api.movies.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.api.movies.service.ShowtimeCacheService;
import com.epam.api.movies.service.ShowtimeService;
import com.epam.api.movies.web.IndexController;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class JSONShowtimeCacheService implements ShowtimeCacheService<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	private LoadingCache<CacheKey, String> cacheHandler;

	public JSONShowtimeCacheService(final ShowtimeService showtimeService, long maximumSize, long expireAfterWriteDuration, TimeUnit expireAfterWriteTimeUnit) {
		super();

		CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder().maximumSize(maximumSize).expireAfterWrite(expireAfterWriteDuration, expireAfterWriteTimeUnit);

		this.cacheHandler = cacheBuilder.build(new CacheLoader<CacheKey, String>() {
			@Override
			public String load(CacheKey key) throws Exception {
				JSONShowtimeCacheService.LOGGER.debug("Reload data. Key: {}", key);
				return new ObjectMapper().writeValueAsString(showtimeService.getShowtimes(key.getNear(), key.getLocal(), key.getDate()));
			}
		});

	}

	@Override
	public String get(String near, String local, int date) throws ExecutionException {
		return this.cacheHandler.get(new CacheKey(near, local, date));
	}

	private class CacheKey {

		private final String near;

		private final String local;

		private final int date;

		public CacheKey(String near, String local, int date) {
			super();
			this.near = near;
			this.local = local;
			this.date = date;
		}

		public String getNear() {
			return this.near;
		}

		public String getLocal() {
			return this.local;
		}

		public int getDate() {
			return this.date;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.getOuterType().hashCode();
			result = prime * result + this.date;
			result = prime * result + ((this.local == null) ? 0 : this.local.hashCode());
			result = prime * result + ((this.near == null) ? 0 : this.near.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			CacheKey other = (CacheKey) obj;
			if (!this.getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (this.date != other.date) {
				return false;
			}
			if (this.local == null) {
				if (other.local != null) {
					return false;
				}
			} else if (!this.local.equals(other.local)) {
				return false;
			}
			if (this.near == null) {
				if (other.near != null) {
					return false;
				}
			} else if (!this.near.equals(other.near)) {
				return false;
			}
			return true;
		}

		private JSONShowtimeCacheService getOuterType() {
			return JSONShowtimeCacheService.this;
		}

		@Override
		public String toString() {
			return "CacheKey [near=" + this.near + ", local=" + this.local + ", date=" + this.date + "]";
		}

	}

}
