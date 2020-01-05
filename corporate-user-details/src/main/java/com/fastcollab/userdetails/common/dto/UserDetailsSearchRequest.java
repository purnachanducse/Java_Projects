package com.fastcollab.userdetails.common.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 */

/**
 * @author 10661300
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDetailsSearchRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -466477872360116272L;
	
	private String corporateId;
	private String userId;
	private String searchText;
}
