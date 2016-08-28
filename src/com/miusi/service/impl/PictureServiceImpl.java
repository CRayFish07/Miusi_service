package com.miusi.service.impl;

import java.util.List;

import com.miusi.dao.PictureDao;
import com.miusi.entity.Picture;
import com.miusi.service.PictureService;

public class PictureServiceImpl implements PictureService {
	private PictureDao pictureDao;

	public PictureDao getPictureDao() {
		return pictureDao;
	}

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	@Override
	public void savePicture(Picture picture) {
		// TODO Auto-generated method stub
		this.pictureDao.savePicture(picture);
	}

	@Override
	public List<Picture> findAllPicture() {
		// TODO Auto-generated method stub
		return this.pictureDao.findAllPicture();
	}

	@Override
	public void removePicture(Picture picture) {
		// TODO Auto-generated method stub
		this.pictureDao.removePicture(picture);
	}

	@Override
	public void updatePicture(Picture picture) {
		// TODO Auto-generated method stub
		this.pictureDao.updatePicture(picture);
	}

	@Override
	public Picture findPictureById(int id) {
		// TODO Auto-generated method stub
		return this.pictureDao.findPictureById(id);
	}

	@Override
	public List<Picture> appQueryPicture(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSeriesPicture(int id) {
		// TODO Auto-generated method stub
		this.pictureDao.removeSeriesPicture(id);
	}

	@Override
	public List<Picture> findBySeriesId(int id) {
		// TODO Auto-generated method stub
		return this.pictureDao.findBySeriesId(id);
	}
}
