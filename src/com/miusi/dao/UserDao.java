package com.miusi.dao;

import java.util.List;

import com.miusi.entity.User;

public interface UserDao {
	public void saveUser(User user);

	public void removeUser(User user);

	public void updateUser(User user);

	public User findUserById(int id);

	public List<User> findAllUser();

	public User appQueryUser(String imei);
}
