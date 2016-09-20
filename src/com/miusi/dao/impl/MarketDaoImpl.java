package com.miusi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.miusi.dao.MarketDao;
import com.miusi.entity.Market;
import com.miusi.util.GeneralUtil;

public class MarketDaoImpl extends HibernateDaoSupport implements MarketDao {

	@Override
	public void saveMarket(Market show) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(show);
	}

	@Override
	public void removeMarket(Market show) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(show);
	}

	@Override
	public void updateMarket(Market show) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(show);
	}

	@Override
	public List<Market> findAllMarket() {
		// TODO Auto-generated method stub
		String queryString = "from Market";
		List<Market> list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	@Override
	public Market findMarket() {
		// TODO Auto-generated method stub
		String queryString = "from Market";
		List<Market> list = this.getHibernateTemplate().find(queryString);
		return list.get(0);
	}

	@Override
	public List<Market> appQueryMarket(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
