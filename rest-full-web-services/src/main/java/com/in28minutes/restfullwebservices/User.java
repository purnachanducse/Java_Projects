/**
 * 
 */
package com.in28minutes.restfullwebservices;

import java.io.Serializable;
import java.util.Date;

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
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7575177056349901263L;
	
	private Integer id;
	
	@Size(min = 2,message = "Name should have atleast two characters")
	@ApiModelProperty("Name should have atleast two characters")
	private String name;
	
	@Past
	@ApiModelProperty("Birth Date Should be in Past")
	private Date birthDate;
	
	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 */
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
}
