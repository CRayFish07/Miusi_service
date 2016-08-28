package com.miusi.service.impl;

import java.util.List;

import com.miusi.dao.UserDao;
import com.miusi.entity.User;
import com.miusi.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.saveUser(user);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.findAllUser();
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.removeUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.updateUser(user);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return this.userDao.findUserById(id);
	}

	@Override
	public List<User> appQueryUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
