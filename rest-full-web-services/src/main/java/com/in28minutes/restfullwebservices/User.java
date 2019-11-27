/**
 * 
 */
package com.in28minutes.restfullwebservices;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10661300
 *
 */
@Data
@NoArgsConstructor
@ApiModel(description = "All details about the user.")
@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7575177056349901263L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min = 2,message = "Name should have atleast two characters")
	@ApiModelProperty("Name should have atleast two characters")
	private String name;
	
	@Past
	@ApiModelProperty("Birth Date Should be in Past")
	private Date birthDate;
	

	//mappedBy is mentioned at inverse/reference side of relationship to tell here relationship is there
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
	private List<Post> posts;
	
	/*
	 * This is for Uni-directional Means we can retrieve posts which are part of Users
	 * @OneToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "id")
	 *  private List<Post> posts;
	 */

	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 * @param posts
	 */
	public User(Integer id, @Size(min = 2, message = "Name should have atleast two characters") String name,
			@Past Date birthDate, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.posts = posts;
	}
	
	
}
