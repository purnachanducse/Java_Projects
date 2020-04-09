/**
 * 
 */
package com.security.jwt.pojos;

import java.io.Serializable;

/**
 * @author 10661300
 *
 */
public class AuthenticationResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6949700377248133376L;

	private String jwt;

	/**
	 * 
	 */
	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param jwt
	 */
	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
