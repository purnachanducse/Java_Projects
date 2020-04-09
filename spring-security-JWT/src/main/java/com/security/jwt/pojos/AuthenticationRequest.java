/**
 * 
 */
package com.security.jwt.pojos;

import java.io.Serializable;

/**
 * @author 10661300
 *
 */
public class AuthenticationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7303333355005055854L;

	private String userName;
	private String password;

	/**
	 * 
	 */
	public AuthenticationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 * @param password
	 */
	public AuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
