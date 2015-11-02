package com.stockanalytics.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stockanalytics.service.StockService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StockTest {
	
	@Autowired
	private StockService stockService;
	
	@Test
	public void insertStockTest(){
		stockService.getStockInfoToStock();
	}

}
