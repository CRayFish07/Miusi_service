package com.miusi.service;

import java.util.List;

import com.miusi.entity.Market;

public interface MarketService {
	public void saveMarket(Market market);

	public List<Market> findAllMarket();
  
	public void removeMarket(Market market);

	public void updateMarket(Market market);

	public Market findMarket();

	public List<Market> appQueryMarket(int id);
}
