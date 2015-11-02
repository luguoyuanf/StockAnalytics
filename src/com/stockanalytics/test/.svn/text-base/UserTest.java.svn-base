package com.stockanalytics.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stockanalytics.bean.User;
import com.stockanalytics.dao.UserMongoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserTest {

	@Autowired
	private UserMongoDao userMongoDao;
	
	//db.user.insert({ _id : "12345_1", name : "sky222", age: 20 })
	@Test
	public void insertUser(){
		long start = System.currentTimeMillis();
		
		List<User> ls = new ArrayList<User>();
		for(int i=0;i<10000;i++){
			User user = new User();
			user.setId("12345_2"+(i+1));
			user.setName("haha1"+(i+1));
			user.setAge(24);
			ls.add(user);
		}
		userMongoDao.insert(ls);
		
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-start)/1000+"秒");
	}
}
