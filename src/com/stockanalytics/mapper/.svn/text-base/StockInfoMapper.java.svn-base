package com.stockanalytics.mapper;

import java.util.List;
import com.stockanalytics.bean.StockInfo;

/**
 * 
 * @author 唐运
 * 2015年10月19日 上午10:58:02
 * TODO stockinfo表操作Dao
 */
public interface StockInfoMapper {
	//批量插入数据
	public void batchInsertStockInfos(List<StockInfo> stockInfos);
	public void batchInsertStockInfo(StockInfo[] stockInfos);
	//单条插入数据
	public void insertStockInfo(StockInfo stockInfo);
	//通过id查询数据
	public void findStockInfoById(int id);
	//通过股票名称模糊查询数据
	public List<StockInfo> findStockInfoByName(String name);
	//查找所有股票
	public List<StockInfo> findAllStockInfo();
	//更新rate
	public void batchUpdateStockInfoRate(List<StockInfo> list);
} 
