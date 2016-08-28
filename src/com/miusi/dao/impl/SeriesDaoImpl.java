package com.miusi.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.miusi.dao.SeriesDao;
import com.miusi.entity.Series;
import com.miusi.util.GeneralUtil;

public class SeriesDaoImpl extends HibernateDaoSupport implements SeriesDao {

	@Override
	public void saveSeries(Series series) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(series);
	}

	@Override
	public void removeSeries(Series series) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(series);
	}

	@Override
	public void updateSeries(Series series) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(series);
	}

	@Override
	public List<Series> findAllSeries() {
		// TODO Auto-generated method stub
		String queryString = "from Series order by id desc";
		List<Series> list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	@Override
	public Series findSeriesById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Series> appQuerySeries(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMaxId() {
		// TODO Auto-generated method stub
		String queryString = "select max(series.id) from  Series series";
		List<Integer> list = this.getHibernateTemplate().find(queryString);
		if (!GeneralUtil.isListEmpty(list)) {
			return list.get(0);
		}
		return 0;
	}

	@Override
	public List<Series> findLast20Series() {
		// TODO Auto-generated method stub
		String queryString = "from Series order by id desc";
		List<Series> list = this.getHibernateTemplate().find(queryString);
		
		return list;
	}

}
