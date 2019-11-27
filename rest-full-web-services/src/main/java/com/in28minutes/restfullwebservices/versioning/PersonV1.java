package com.in28minutes.restfullwebservices.versioning;

public class PersonV1 {
	
	private String name;

	/**
	 * 
	 */
	public PersonV1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param name
	 */
	public PersonV1(String name) {
		super();
		this.name = name;
	}

}
