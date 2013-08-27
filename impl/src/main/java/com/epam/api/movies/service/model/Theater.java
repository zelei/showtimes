package com.epam.api.movies.service.model;

import java.io.Serializable;
import java.util.Collection;

public class Theater implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String address;

	private Collection<Movie> movies;

	public Theater() {
		super();
	}

	public Theater(String name, String address, Collection<Movie> movies) {
		super();
		this.name = name;
		this.address = address;
		this.movies = movies;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(Collection<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Theater [name=" + this.name + ", address=" + this.address + ", movies=" + this.movies + "]";
	}

}
