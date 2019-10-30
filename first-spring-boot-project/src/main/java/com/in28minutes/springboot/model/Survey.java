/**
 * 
 */
package com.in28minutes.springboot.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author 10661300
 *
 */
public class Survey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7367186485597849944L;

	private String id;
	private String title;
	private String description;
	private List<Question> questions;
	public Survey(String id, String title, String description, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.questions = questions;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", description=" + description + ", questions=" + questions
				+ "]";
	}
	
}
