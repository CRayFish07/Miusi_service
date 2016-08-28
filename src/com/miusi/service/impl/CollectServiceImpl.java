package com.miusi.service.impl;

import java.util.List;

import com.miusi.dao.CollectDao;
import com.miusi.entity.Collect;
import com.miusi.service.CollectService;

public class CollectServiceImpl implements CollectService {
	private CollectDao collectDao;

	public CollectDao getCollectDao() {
		return collectDao;
	}

	public void setCollectDao(CollectDao collectDao) {
		this.collectDao = collectDao;
	}

	@Override
	public void saveCollect(Collect collect) {
		// TODO Auto-generated method stub
		this.collectDao.saveCollect(collect);
	}

	@Override
	public List<Collect> findAllCollect() {
		// TODO Auto-generated method stub
		return this.collectDao.findAllCollect();
	}

	@Override
	public void removeCollect(Collect collect) {
		// TODO Auto-generated method stub
		this.collectDao.removeCollect(collect);
	}

	@Override
	public void updateCollect(Collect collect) {
		// TODO Auto-generated method stub
		this.collectDao.updateCollect(collect);
	}

	@Override
	public Collect findCollectById(int id) {
		// TODO Auto-generated method stub
		return this.collectDao.findCollectById(id);
	}

}
