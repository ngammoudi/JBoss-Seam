package com.businessdecision.seampoc.model;

/**
 * User class the represents user entity marked as seam component
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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
@Name("users")
@Table(name = "users")
@NamedQuery(name = "getUserByUsernameAndPassword", query = "from User u where u.userName =:userName and u.password =:password ")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default constructor
	 */
	public User() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/** the user name. is use to identify the user. */
	@Column(name = "user_name")
	@Length(min = 6)
	@NotNull
	private String userName;

	/** the user password. */
	@Column(name = "user_password")
	@Length(min = 6)
	@NotNull
	private String password;
	/** the role */
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	/**
	 * 
	 * 
	 * @return return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * 
	 * @return return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * 
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * 
	 * @return return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * 
	 * 
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
