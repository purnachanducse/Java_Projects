/**
 * 
 */
package com.in28minutes.restfullwebservices;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10661300
 *
 */
@Data
@Entity
@NoArgsConstructor
public class Post implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	private String description;
	
	//Owner side of Bi-directional always many side is the owner side and we need to specify @JoinColumn here
	//Here physical changes to DB will be happen
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = User.class,cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")//Here user_id is foreign key we just named it in table
	@JsonIgnore
	private User user;

	/**
	 * @param postId
	 * @param description
	 * @param user
	 */
	public Post(Integer postId, String description, User user) {
		super();
		this.postId = postId;
		this.description = description;
		this.user = user;
	}

	
}
