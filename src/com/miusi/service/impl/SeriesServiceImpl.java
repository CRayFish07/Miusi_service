package com.miusi.service.impl;

import java.util.List;

import com.miusi.dao.SeriesDao;
import com.miusi.entity.Series;
import com.miusi.service.SeriesService;

public class SeriesServiceImpl implements SeriesService {
	private SeriesDao seriesDao;

	public SeriesDao getSeriesDao() {
		return seriesDao;
	}

	public void setSeriesDao(SeriesDao seriesDao) {
		this.seriesDao = seriesDao;
	}

	@Override
	public void saveSeries(Series series) {
		// TODO Auto-generated method stub
		seriesDao.saveSeries(series);
	}

	@Override
	public List<Series> findAllSeries() {
		// TODO Auto-generated method stub
		return this.seriesDao.findAllSeries();
	}

	@Override
	public List<Series> appQuerySeries(int id) {
		// TODO Auto-generated method stub
		return this.seriesDao.appQuerySeries(id);
	}

	@Override
	public void removeSeries(Series series) {
		// TODO Auto-generated method stub
		this.seriesDao.removeSeries(series);
	}

	@Override
	public void updateSeries(Series series) {
		// TODO Auto-generated method stub
		this.seriesDao.updateSeries(series);
	}

	@Override
	public Series findSeriesById(int id) {
		// TODO Auto-generated method stub
		return this.seriesDao.findSeriesById(id);
	}

	@Override
	public int findMaxId() {
		// TODO Auto-generated method stub
		return this.seriesDao.findMaxId();
	}

	@Override
	public List<Series> findLast20Series() {
		// TODO Auto-generated method stub
		return this.seriesDao.findLast20Series();
	}

}
