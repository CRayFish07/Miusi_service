package com.miusi.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.miusi.dao.CollectDao;
import com.miusi.entity.Collect;

public class CollectDaoImpl extends HibernateDaoSupport implements CollectDao{

	@Override
	public void saveCollect(Collect collect) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(collect);
	}

	@Override
	public void removeCollect(Collect collect) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(collect);
	}

	@Override
	public void updateCollect(Collect collect) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(collect);
	}

	@Override
	public List<Collect> findAllCollect() {
		// TODO Auto-generated method stub
		String queryString = "from Collect";
		List<Collect> list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	@Override
	public Collect findCollectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collect> appQueryCollect(int id) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
