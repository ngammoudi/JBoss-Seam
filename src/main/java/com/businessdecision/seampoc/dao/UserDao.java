package com.businessdecision.seampoc.dao;

import com.businessdecision.seampoc.model.User;

/**
 * 
 * @author administrateur
 * 
 */
public interface UserDao extends GenericDao<User, Integer> {
	/**
	 * get user by giving userName and password
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	User getUser(String userName, String password);

}
