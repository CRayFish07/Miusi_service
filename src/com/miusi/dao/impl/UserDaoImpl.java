package com.miusi.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.miusi.dao.UserDao;
import com.miusi.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		String queryString = "from User";
		List<User> list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> appQueryUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
