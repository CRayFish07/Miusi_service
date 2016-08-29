package com.miusi.dao;

import java.util.List;

import com.miusi.entity.Picture;

public interface PictureDao {
	public void savePicture(Picture picture);

	public void removePicture(Picture picture);

	public void updatePicture(Picture picture);

	public Picture findPictureById(int id);

	public List<Picture> findAllPicture();

	public List<Picture> appQueryPicture(int id, int seriesId, int pageSize);

	public void removeSeriesPicture(int id);

	public List<Picture> findBySeriesId(int id);

	public List<Picture> findRecommend();
}
