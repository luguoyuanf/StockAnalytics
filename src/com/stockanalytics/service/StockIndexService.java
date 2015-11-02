package com.stockanalytics.service;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockanalytics.bean.StockIndex;
import com.stockanalytics.dao.StockIndexMongoDao;
import com.stockanalytics.mapper.StockIndexMapper;


@Service("stockIndexService")
public class StockIndexService {
	
	@Autowired
	private StockIndexMapper stockIndexMapper;
	private Logger logger = Logger.getLogger(StockIndexService.class);
	@Autowired
	private StockIndexMongoDao stockIndexMongoDao;
	
	public void insertStockIndexToMongo(Collection<StockIndex> c){
		try {
			stockIndexMongoDao.insertStockInex(c);
			logger.info("插入成功--->"+c);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("插入失败--->"+c);
			e.printStackTrace();
		}
	}
	
	/**
	 * 单条插入stockIndex
	 * @param sti
	 */
	public void insertStockIndex(StockIndex sti){
		try {
			stockIndexMapper.insertStockIndex(sti);
			logger.info("插入成功--->"+sti);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量插入stockIndex
	 * @param list
	 */
	public void insertStockIndex(List<StockIndex> list){
		try {
			stockIndexMapper.batchInsertStockIndex(list);
			logger.info("批量插入成功--->"+list);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
