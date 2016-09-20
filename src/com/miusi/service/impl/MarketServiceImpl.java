package com.miusi.service.impl;

import java.util.List;

import com.miusi.dao.MarketDao;
import com.miusi.entity.Market;
import com.miusi.service.MarketService;

public class MarketServiceImpl implements MarketService {
	private MarketDao marketDao;

	public MarketDao getMarketDao() {
		return marketDao;
	}

	public void setMarketDao(MarketDao marketDao) {
		this.marketDao = marketDao;
	}

	@Override
	public void saveMarket(Market market) {
		// TODO Auto-generated method stub
		this.marketDao.saveMarket(market);
	}

	@Override
	public List<Market> findAllMarket() {
		// TODO Auto-generated method stub
		return this.marketDao.findAllMarket();
	}

	@Override
	public void removeMarket(Market market) {
		// TODO Auto-generated method stub
		this.marketDao.removeMarket(market);
	}

	@Override
	public void updateMarket(Market market) {
		// TODO Auto-generated method stub
		this.marketDao.updateMarket(market);
	}

	@Override
	public Market findMarket() {
		// TODO Auto-generated method stub
		System.out.println("findMarket");
		return this.marketDao.findMarket();
	}

	@Override
	public List<Market> appQueryMarket(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
