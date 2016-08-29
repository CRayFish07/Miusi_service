package com.miusi.service;

import java.util.List;

import com.miusi.entity.Picture;

public interface PictureService {
	public void savePicture(Picture picture);

	public List<Picture> findAllPicture();

	public void removePicture(Picture picture);

	public void updatePicture(Picture picture);

	public Picture findPictureById(int id);

	public List<Picture> appQueryPicture(int id, int seriesId, int pageSize);

	public void removeSeriesPicture(int id);

	public List<Picture> findBySeriesId(int id);

	public List<Picture> findRecommend();

}
