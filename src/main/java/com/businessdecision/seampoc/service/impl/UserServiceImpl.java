package com.businessdecision.seampoc.service.impl;

import org.jboss.seam.annotations.In;

import com.businessdecision.seampoc.dao.UserDao;
import com.businessdecision.seampoc.model.User;
import com.businessdecision.seampoc.service.UserService;

public class UserServiceImpl implements UserService {
	@In
	UserDao userDao;

	public User getUser(String userName, String password) {
		return userDao.getUser(userName, password);
	}

	/**
	 * return the userDao
	 * 
	 * @return
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * the userDao to set
	 * 
	 * @param userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
