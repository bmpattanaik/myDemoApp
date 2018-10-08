package com.biswo.myspringapp.model;

public class Country {

	private long id;
	private long phonecode;
	private String name;
	private String sortname;
	
	
	public Country(long id, long phonecode, String name, String sortname) {
		super();
		this.id = id;
		this.phonecode = phonecode;
		this.name = name;
		this.sortname = sortname;
	}


	public long getId() {
		return id;
	}


	public long getPhonecode() {
		return phonecode;
	}


	public String getName() {
		return name;
	}


	public String getSortname() {
		return sortname;
	}
	
	
	

}
