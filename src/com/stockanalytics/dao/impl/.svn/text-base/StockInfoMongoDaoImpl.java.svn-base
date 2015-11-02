package com.stockanalytics.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.stockanalytics.bean.Stock;
import com.stockanalytics.bean.StockInfo;
import com.stockanalytics.dao.StockInfoMongoDao;

@Repository
public class StockInfoMongoDaoImpl implements StockInfoMongoDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void insertStockInfo(StockInfo stockInfo) {
		// TODO Auto-generated method stub
		this.mongoTemplate.save(stockInfo);
	}

	@Override
	public void insertStockInfo(List<StockInfo> stockInfos) {
		// TODO Auto-generated method stub
		for(StockInfo s:stockInfos){
			insertStockInfo(s);
		}
	}

	@Override
	public List<StockInfo> findAllStockInfoCodeAndName() {
		//查询条件
		DBObject dbObject = new BasicDBObject(); 
		//返回的字段
		DBObject fieldObject = new BasicDBObject();
		fieldObject.put("name", true);
		fieldObject.put("code",true);
		
		Query query = new BasicQuery(dbObject,fieldObject);
		return this.mongoTemplate.find(query , StockInfo.class);
	}

}
