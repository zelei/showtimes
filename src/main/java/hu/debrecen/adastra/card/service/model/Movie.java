package hu.debrecen.adastra.card.service.model;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String info;

	private List<String> times;

	public Movie() {
		super();
	}

	public Movie(String name, String info, List<String> times) {
		super();
		this.name = name;
		this.info = info;
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

	@Override
	public String toString() {
		return "Movie [name=" + this.name + ", info=" + this.info + ", times=" + this.times + "]";
	}

}
