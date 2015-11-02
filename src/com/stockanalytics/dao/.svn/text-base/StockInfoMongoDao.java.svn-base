package com.stockanalytics.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stockanalytics.bean.StockInfo;

@Transactional
public interface StockInfoMongoDao {

	
	public abstract void insertStockInfo(StockInfo stockInfo);
	
	public abstract void insertStockInfo(List<StockInfo> stockInfos);
	
	public abstract List<StockInfo> findAllStockInfoCodeAndName();
	
}
