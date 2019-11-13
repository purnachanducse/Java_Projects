/**
 * 
 */
package com.in28minutes.learning.jpa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10661300
 *
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1137134448336716141L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String role;
	
	/**
	 * @param name
	 * @param role
	 */
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
}
