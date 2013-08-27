package com.epam.api.movies.service.model;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String info;

	private String rating;

	private List<String> times;

	public Movie() {
		super();
	}

	public Movie(String name, String info, String rating, List<String> times) {
		super();
		this.name = name;
		this.info = info;
		this.rating = rating;
		this.times = times;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<String> getTimes() {
		return this.times;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [name=" + this.name + ", info=" + this.info + ", rating=" + this.rating + ", times=" + this.times + "]";
	}

}
