package com.businessdecision.seampoc.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.businessdecision.seampoc.dao.UserDao;
import com.businessdecision.seampoc.model.User;

/**
 * 
 * @author administrateur
 * 
 */
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements
		UserDao {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);

	/**
	 * constructor
	 */
	public UserDaoImpl() {
		super(User.class);
	}

	/**
	 * constructor
	 * 
	 * @param persistentClass
	 */
	public UserDaoImpl(Class<User> persistentClass) {
		super(persistentClass);
	}

	@SuppressWarnings("unchecked")
	public User getUser(String userName, String password) {
		if (log.isInfoEnabled()) {
			log.info("getUser(username=" + userName + ", password=" + password
					+ ") - start");
		}

		List<User> list = getHibernateTemplate().findByNamedQueryAndNamedParam(
				"getUserByUsernameAndPassword",
				new String[] { "userName", "password" },
				new Object[] { userName, password });

		if (list != null && list.size() > 0 && list.get(0) != null) {
			User returnUser = list.get(0);
			if (log.isInfoEnabled()) {
				log.info("getUser(username=" + userName + ", password="
						+ password + ") - end - return value=" + returnUser);
			}
			return returnUser;
		}

		if (log.isInfoEnabled()) {
			log.info("getUser(username=" + userName + ", password=" + password
					+ ") - end - return value=" + null);
		}
		return null;

	}

}
