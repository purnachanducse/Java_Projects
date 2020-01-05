/**
 * 
 */
package com.fastcollab.userdetails.common.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 10661300
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDetailsSearchResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8171788304817830210L;
	
	private String userId;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String mobileNum;
	private String emailId;
	private String profilePicUrl;
}
