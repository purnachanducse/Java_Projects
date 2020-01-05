/**
 * 
 */
package com.fastcollab.flightsearch.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10661300
 *
 */

@NoArgsConstructor
@Data
@Entity
@Table(name="Users")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name="getAllUserDetails",
			procedureName="getCorporateUsers",
			parameters={@StoredProcedureParameter(mode = ParameterMode.IN, name = "searchText", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "corporateId", type = String.class)},
			resultClasses=UserDetailsEntity.class
			)
})
public class UserDetailsEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6328528349897057900L;
	
	
	@Id
	@Column(name="Email")
	private String emailId;
	@Column(name="FirstName")
	private String firstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="Dob")
	private Date dateOfBirth;
	@Column(name="Gender")
	private String Gender;
	@Column(name="Mobile")
	private String mobileNum;
	@Column(name="ProfilePicUrl")
	private String profilePicUrl;
	@Column(name="CompanyID")
	private Integer companyID;
	
}
