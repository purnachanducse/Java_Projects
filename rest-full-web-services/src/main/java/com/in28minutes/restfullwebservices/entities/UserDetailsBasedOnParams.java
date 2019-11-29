/**
 * 
 */
package com.in28minutes.restfullwebservices.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10661300
 *
 */
@Data
@NoArgsConstructor
@Table(name = "User")
@Entity
@NamedQuery(name = "UserDetailsBasedOnParams.findById",
query = "from UserDetailsBasedOnParams where userId=?1")
@SqlResultSetMapping(name="updateResult", columns = { @ColumnResult(name = "count")})

@NamedNativeQueries(value = { 
		@NamedNativeQuery(name = "updateDescById",query = "update user set NAME = :userName where ID = :id" 
				,resultSetMapping = "updateResult"),
		//@NamedNativeQuery(name = "insertUserQry",query = "insert into user (NAME,BIRTH_DATE) values (:userName,:birthDate)",resultSetMapping = "updateResult")
		//@NamedNativeQuery(name = "insertUserQry",query = "select * from user where NAME =?1)")
})

public class UserDetailsBasedOnParams implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String userName;
	//@Column(name = "BIRTH_DATE")
	private Date birthDate;
	/**
	 * @param userId
	 * @param userName
	 * @param dateOfBirth
	 */
	public UserDetailsBasedOnParams(Integer id, String userName, Date birthDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.birthDate = birthDate;
	}
	
	

}
