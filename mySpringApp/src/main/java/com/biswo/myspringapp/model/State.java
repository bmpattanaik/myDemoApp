package com.biswo.myspringapp.model;

public class State {

	private long id;
	private String name;
	private long countryId;

	public State(long id, String name, long countryId) {
		super();
		this.id = id;
		this.name = name;
		this.countryId = countryId;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getCountryId() {
		return countryId;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", countryId=" + countryId + "]";
	}
	
	
	

}
