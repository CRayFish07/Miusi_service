package com.miusi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cache.Cache;

import com.miusi.dao.PictureDao;
import com.miusi.entity.Picture;

public class PictureDaoImpl extends HibernateDaoSupport implements PictureDao {

	@Override
	public void savePicture(Picture picture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(picture);
	}

	@Override
	public void removePicture(Picture picture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(picture);
	}

	@Override
	public void updatePicture(Picture picture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(picture);
	}

	@Override
	public List<Picture> findAllPicture() {
		// TODO Auto-generated method stub
		String queryString = "from Picture";
		List<Picture> list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	@Override
	public Picture findPictureById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Picture> appQueryPicture(int id, int seriesId, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Picture picture where picture.id<" + id
				+ "and picture.series_id=" + seriesId + " order by id desc";
		// 创建查询对象
		Query query = this.getSession().createQuery(hql);
		// 设置起始行数和最大查询行数
		query.setFirstResult(0);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public void removeSeriesPicture(int id) {
		// TODO Auto-generated method stub
		List<Picture> list = this.getHibernateTemplate().find(
				"from Picture p where p.series_id=" + id);
		this.getHibernateTemplate().deleteAll(list);
	}

	@Override
	public List<Picture> findBySeriesId(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(
				"from Picture p where p.series_id=" + id);
	}

	@Override
	public List<Picture> findRecommend() {
		// TODO Auto-generated method stub
		if ((Cache.rand == 0)
				|| (Cache.rand != System.currentTimeMillis()
						/ (60 * 60 * 1000 * 24))) {
			Cache.rand = System.currentTimeMillis() / (60 * 60 * 1000 * 24);
			String hql = "from Picture order by Rand()";
			// 创建查询对象
			Query query = this.getSession().createQuery(hql);
			// 设置起始行数和最大查询行数
			query.setFirstResult(0);
			query.setMaxResults(30);
			// 返回前10条记录。
			Cache.recommendList = query.list();
		}
		return Cache.recommendList;
	}

}
