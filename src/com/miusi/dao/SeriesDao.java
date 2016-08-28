package com.miusi.dao;

import java.util.List;

import com.miusi.entity.Series;

public interface SeriesDao {
	public void saveSeries(Series series);

	public void removeSeries(Series series);

	public void updateSeries(Series series);

	public Series findSeriesById(int id);

	public List<Series> findAllSeries();

	public List<Series> appQuerySeries(int id);
	
	public int findMaxId();

	public List<Series> findLast20Series();
}
