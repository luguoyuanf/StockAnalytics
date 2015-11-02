package com.stockanalytics.mapper;

import java.util.List;

import com.stockanalytics.bean.StockIndex;

public interface StockIndexMapper {
	
	//查询所有数据股指数据
	public List<StockIndex> findAllStockIndex();
	//通过ID查询股指数据
	public StockIndex findStockIndexById(String id);
	//通过股指名称模糊查询
	public List<StockIndex> findStockIndexByName(String name);
	//单条插入股指数据
	public void insertStockIndex(StockIndex stockIndex);
	//批量插入股指数据
	public void batchInsertStockIndex(List<StockIndex> stockIndex);
}
