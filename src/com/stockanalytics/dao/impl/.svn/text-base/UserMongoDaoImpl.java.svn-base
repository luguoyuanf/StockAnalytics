package com.stockanalytics.dao.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.stockanalytics.bean.User;
import com.stockanalytics.dao.UserMongoDao;

@Repository
public class UserMongoDaoImpl implements UserMongoDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void createCollection() {
		// TODO Auto-generated method stub
		if(!this.mongoTemplate.collectionExists(User.class)){
			this.mongoTemplate.createCollection(User.class);
		}
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		this.mongoTemplate.save(user);
	}

	@Override
	public void insert(List<User> users) {
		try {
			for(User u:users){
				insert(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
