/**
 * 
 */
package com.in28minutes.restfullwebservices.pojos;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10661300
 *
 */
@Data
@NoArgsConstructor
public class UserDetailsBasedOnParamsPojo {
	
	private Integer id;
	private String userName;
	private Date birthDate;
}
