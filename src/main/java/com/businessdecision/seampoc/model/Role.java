package com.businessdecision.seampoc.model;

/**
 * Role class that represent role entity marked as seam component
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Name("roles")
@Table(name = "roles")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default constructor
	 */
	public Role() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/** securityName */
	@Column(name = "security_name")
	private String securityName;

	/**
	 * @return Returns the id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Returns the securityName.
	 */
	public String getSecurityName() {
		return securityName;
	}

	/**
	 * @param securityName
	 *            The securityName to set.
	 */
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

}
