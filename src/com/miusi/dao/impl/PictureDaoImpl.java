package com.miusi.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
	public List<Picture> appQueryPicture(int id, int group_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSeriesPicture(int id) {
		// TODO Auto-generated method stub
		List<Picture> list = this.getHibernateTemplate().find(
				"from Picture p where p.series_id=" + id);
		this.getHibernateTemplate().deleteAll(list);
		;
	}

	@Override
	public List<Picture> findBySeriesId(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(
				"from Picture p where p.series_id=" + id);
	}

}
