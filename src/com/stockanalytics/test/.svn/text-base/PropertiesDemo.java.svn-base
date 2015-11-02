package com.stockanalytics.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stockanalytics.bean.CommonProperties;
import com.stockanalytics.bean.StockInfo;
import com.stockanalytics.mapper.StockInfoMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class PropertiesDemo {
	
	@Value("#{commonProperties['import.path']}")
	private String importPath; 
	@Autowired
	private StockInfoMapper stockInfoMapper;
	
	
	@Test
	public void p1(){
		System.out.println(importPath);
		List<StockInfo> sts = stockInfoMapper.findStockInfoByName("深");
		System.out.println(sts.get(0));
	}
}
