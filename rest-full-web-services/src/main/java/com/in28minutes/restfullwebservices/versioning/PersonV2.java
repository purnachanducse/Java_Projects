package com.in28minutes.restfullwebservices.versioning;

public class PersonV2 {

	private Name name;

	
	/**
	 * 
	 */
	public PersonV2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public PersonV2(Name name) {
		super();
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
}
