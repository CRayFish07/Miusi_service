package com.miusi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cache.Cache;

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
	public List<Series> appQuerySeries(int id, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Series series where series.id<" + id
				+ "order by id desc";
		// 创建查询对象   
		Query query = this.getSession().createQuery(hql);
		// 设置起始行数和最大查询行数
		query.setFirstResult(0);
		query.setMaxResults(pageSize); 
		return query.list();
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
		// return list;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("from Series order by id desc");
				q.setFirstResult(0);
				q.setMaxResults(20);
				return q.list();
			}
		});

	}

}
