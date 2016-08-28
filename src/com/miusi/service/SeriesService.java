package com.miusi.service;

import java.util.List;

import com.miusi.entity.Series;

public interface SeriesService {
	public void saveSeries(Series series);

	public List<Series> findAllSeries();

	public void removeSeries(Series series);

	public void updateSeries(Series series);

	public Series findSeriesById(int id);

	public List<Series> appQuerySeries(int id);

	public int findMaxId();

	public List<Series> findLast20Series();
}
