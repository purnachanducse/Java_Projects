/**
 * 
 */
package com.security.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 10661300
 *
 */
@Entity
@Table(name = "users",schema = "accounts")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7442357827368661332L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String userName;
	private String password;
	private String roles;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	/**
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [" + (id != null ? "id=" + id + ", " : "")
				+ (userName != null ? "userName=" + userName + ", " : "")
				+ (password != null ? "password=" + password + ", " : "") + (roles != null ? "roles=" + roles : "")
				+ "]";
	}
	
	
}

