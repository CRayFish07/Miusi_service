package com.miusi.dao;

import java.util.List;

import com.miusi.entity.Market;

public interface MarketDao {
	public void saveMarket(Market market);

	public void removeMarket(Market market);

	public void updateMarket(Market market);

	public Market findMarket();

	public List<Market> findAllMarket();

	public List<Market> appQueryMarket(int id);
}
