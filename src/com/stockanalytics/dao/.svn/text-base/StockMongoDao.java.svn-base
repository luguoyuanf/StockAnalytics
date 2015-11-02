package com.stockanalytics.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stockanalytics.bean.Stock;

@Transactional
public interface StockMongoDao {
	
	public abstract List<Stock> findAllStock();
	public abstract void insertStock(Collection<Stock> collection);
	public abstract void insertStock(Stock stock);
}
