package com.miusi.service;

import java.util.List;

import com.miusi.entity.Collect;

public interface CollectService {
	public void saveCollect(Collect collect);

	public List<Collect> findAllCollect(); 

	public void updateCollect(Collect collect);

	public Collect findCollectById(int id);

	public void removeCollect(Collect collect);

}
