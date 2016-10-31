package com.miusi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.miusi.dao.UserDao;
import com.miusi.entity.User;
import com.miusi.util.GeneralUtil;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

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
	public User appQueryUser(String imei) {
		// TODO Auto-generated method stub
		String hql = "from User user where user.device_id=" + imei
				+ "order by id desc";
		// 创建查询对象
		Query query = this.getSession().createQuery(hql);
		// 设置起始行数和最大查询行数
		query.setFirstResult(0);
		query.setMaxResults(1);
		if (GeneralUtil.isListEmpty(query.list())) {
			return null;
		}
		return (User) query.list().get(0);
	}

}
