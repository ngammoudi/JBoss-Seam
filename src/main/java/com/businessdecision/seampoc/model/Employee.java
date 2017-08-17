package com.businessdecision.seampoc.model;

/**
 * Employee Class that represents employee entity marked as seam component .
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * 
 * @author administrateur
 * 
 */
@Entity
@Scope(ScopeType.SESSION)
@Name("employee")
@Table(name = "employees")
@NamedQueries( { @NamedQuery(name = "getAllEmployees", query = "from Employee ") })
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default constructor
	 */
	public Employee() {

	}

	@Version
	private Long version;

	/** The employee id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/** employee last name */
	@Column(name = "last_name")
	private String lastName;
	/** employee first name */
	@Length(max = 6)
	@Column(name = "first_name")
	private String firstName;
	/** employee mail address */
	@Column(name = "email_address", nullable = false)
	@Email
	@NotNull
	private String emailAddress;
	/** the birth date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthDate", updatable = false)
	private Date birthDate;

	/**
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id to set
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * lastName to set
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * firstName to set
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * emailAdress to set
	 * 
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * 
	 * @return birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * birth date to set
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
