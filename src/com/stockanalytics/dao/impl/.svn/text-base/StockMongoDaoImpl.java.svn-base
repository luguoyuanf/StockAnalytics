package com.stockanalytics.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.stockanalytics.bean.Stock;
import com.stockanalytics.dao.StockMongoDao;

@Repository
public class StockMongoDaoImpl implements StockMongoDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Stock> findAllStock() {
		return this.mongoTemplate.findAll(Stock.class);
	}

	@Override
	public void insertStock(Collection<Stock> collection) {
		for(Stock s:collection){
			this.insertStock(s);
		}
	}

	@Override
	public void insertStock(Stock stock) {
		// TODO Auto-generated method stub
		this.mongoTemplate.save(stock);
	}

}
