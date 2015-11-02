package com.stockanalytics.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stockanalytics.bean.Stock;
import com.stockanalytics.bean.StockInfo;
import com.stockanalytics.dao.StockInfoMongoDao;
import com.stockanalytics.dao.StockMongoDao;

@Service("stockService")
public class StockService {

	@Autowired
	private StockInfoMongoDao stockInfoMongoDao;
	@Autowired
	private StockMongoDao stockMongoDao;
	
	/**
	 * 获取所有股票数据，去重保存到Stock中
	 */
	
	public void getStockInfoToStock(){
		List<StockInfo> sti = stockInfoMongoDao.findAllStockInfoCodeAndName();
		Set<Stock> sts = new HashSet<Stock>();
		
		for(StockInfo s:sti){
			Stock stock = new Stock(s.getName()+"#"+s.getCode(),s.getName(),s.getCode());
			sts.add(stock);
		}
		
		stockMongoDao.insertStock(sts);
	}
	
}
