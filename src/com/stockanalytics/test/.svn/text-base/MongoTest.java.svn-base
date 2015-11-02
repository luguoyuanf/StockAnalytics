package com.stockanalytics.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stockanalytics.bean.Stock;
import com.stockanalytics.bean.StockInfo;
import com.stockanalytics.bean.User;
import com.stockanalytics.dao.StockInfoMongoDao;
import com.stockanalytics.dao.impl.UserMongoDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MongoTest {

	@Autowired
	private UserMongoDaoImpl userMongoDaoImpl;
	@Autowired
	private StockInfoMongoDao stockInfoMongDao;
	
	
	@Test
	public void createCollectionTest(){
		userMongoDaoImpl.createCollection();
	}
	
	@Test
	public void insertUserTest(){
		User user = new User();
		user.setId("12345");
		user.setName("sky");
		user.setAge(20);
		userMongoDaoImpl.insert(user);
	}
	
	@Test
	public void insertUserSTest(){
		List<User> ls = new ArrayList<User>();
		for(int i=0;i<10000;i++){
			User user1 = new User();
			user1.setId("12345_"+(i+1));
			user1.setName("sky"+(i+1));
			user1.setAge(20);
			ls.add(user1);
		}
		userMongoDaoImpl.insert(ls);
	}
	
	@Test
	public void findAllStockInfoCodeAndNameTest(){
		long start = System.currentTimeMillis();
		List<StockInfo> stocks = stockInfoMongDao.findAllStockInfoCodeAndName();
		Set<Stock> set = new HashSet<Stock>();
		
		for(StockInfo st:stocks){
			Stock s = new Stock(st.getName()+"#"+st.getCode(),st.getName(),st.getCode());
			set.add(s);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("总共记录："+set.size());
		System.out.println("耗时："+(end-start)/1000+"秒");
	}
}
