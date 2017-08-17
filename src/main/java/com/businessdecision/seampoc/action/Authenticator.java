package com.businessdecision.seampoc.action;

import java.io.Serializable;

import javax.persistence.NoResultException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Identity;

import com.businessdecision.seampoc.model.User;
import com.businessdecision.seampoc.service.UserService;

@Name("authenticator")
@Scope(ScopeType.SESSION)
public class Authenticator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3344105683936844728L;

	@Logger
	Log log;
	@In
	Identity identity;
	@In
	UserService userService;

	public boolean authenticate() {
		log.info("authenticate ->, START");
		try {
			User user = userService.getUser(Identity.instance().getUsername(),
					Identity.instance().getPassword())

			;

			if (user.getRole() != null) {

				Identity.instance().addRole(user.getRole().getSecurityName());
			}

			return true;
		} catch (NoResultException ex) {
			FacesMessages.instance().add("Invalid username/password");
			return false;
		}

	}

}
