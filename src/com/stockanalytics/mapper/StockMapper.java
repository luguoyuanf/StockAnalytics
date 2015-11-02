package com.stockanalytics.mapper;

import java.util.List;

import com.stockanalytics.bean.Stock;

public interface StockMapper {
	
	public void insertStock(List<Stock> stocks);
	public void insertStock(Stock stock);
	public void updateStock(Stock stock);
	public void updateStock(List<Stock> stock);
}
