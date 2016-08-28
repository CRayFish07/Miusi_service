package com.miusi.dao;

import java.util.List;

import com.miusi.entity.Collect;

public interface CollectDao {
	public void saveCollect(Collect collect);

	public void removeCollect(Collect collect);

	public void updateCollect(Collect collect);

	public Collect findCollectById(int id);

	public List<Collect> findAllCollect();

	public List<Collect> appQueryCollect(int id);
}
