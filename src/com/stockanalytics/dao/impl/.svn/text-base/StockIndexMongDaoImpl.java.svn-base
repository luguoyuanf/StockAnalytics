package com.stockanalytics.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.stockanalytics.bean.StockIndex;
import com.stockanalytics.dao.StockIndexMongoDao;



@Repository
public class StockIndexMongDaoImpl  implements StockIndexMongoDao{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void insertStockInex(Collection<StockIndex> collection) {
		for(StockIndex s:collection){
			insertStockIndex(s);
		}
	}

	@Override
	public void insertStockIndex(StockIndex stockIndex) {
		this.mongoTemplate.save(stockIndex);
	}
	
	
}
