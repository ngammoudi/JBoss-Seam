package com.businessdecision.seampoc.service;

import com.businessdecision.seampoc.model.User;

/**
 * 
 * @author administrateur
 * 
 */
public interface UserService {
	/**
	 * get user by giving userName and password
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	User getUser(String userName, String password);
}
