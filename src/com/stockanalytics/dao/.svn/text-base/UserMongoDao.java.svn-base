package com.stockanalytics.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stockanalytics.bean.User;


@Transactional
public interface UserMongoDao {

	
	public abstract void createCollection();
	
	public abstract void insert(User user);
	
	public abstract void insert(List<User> users);
}
