package com.stockanalytics.test;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stockanalytics.bean.StockInfo;
import com.stockanalytics.bean.User;
import com.stockanalytics.mapper.StockInfoMapper;
import com.stockanalytics.service.StockInfoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class DBTest {
	
	@Autowired
	SqlSessionFactory sqlSessionFaction;
	@Autowired
	StockInfoMapper stockInfoMapper;
	@Autowired
	StockInfoService stockInfoService;
	
	@Test
	public void db(){
		SqlSession sqlSession = sqlSessionFaction.openSession();
		User user = (User)sqlSession.selectOne("User.findUserById",1);
		System.out.println(user);
	}
	
	@Test
	public void insertStockInfoTest(){
		StockInfo stockInfo = new StockInfo();
		stockInfo.setId("2015-10-19#test1");
		stockInfo.setCode("test001");
		stockInfo.setName("Test");
		stockInfo.setDate("2015-10-19");
		stockInfoMapper.insertStockInfo(stockInfo);
	}
	
	@Test
	public void batchInsertStockInfosTest(){
		ArrayList<StockInfo> ls = new ArrayList<StockInfo>();
		for(int i=1;i<=100;i++){
			StockInfo stockInfo = new StockInfo();
			stockInfo.setId("2015-10-19#test"+i);
			stockInfo.setCode("test"+i);
			stockInfo.setName("Test"+i);
			stockInfo.setDate("2015-10-19");
			ls.add(stockInfo);
		}
		stockInfoService.batchInsertStockInfos(ls);
	}
	
}
