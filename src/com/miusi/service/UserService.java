package com.miusi.service;

import java.util.List;

import com.miusi.entity.User;

public interface UserService {
	public void saveUser(User user);

	public List<User> findAllUser();
  
	public void removeUser(User user);

	public void updateUser(User user);

	public User findUserById(int id);

	public List<User> appQueryUser(int id);
}
