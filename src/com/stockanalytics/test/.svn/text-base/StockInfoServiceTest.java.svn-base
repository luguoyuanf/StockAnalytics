package com.stockanalytics.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stockanalytics.bean.RetData;
import com.stockanalytics.bean.StockInfo;
import com.stockanalytics.constants.StockConstants;
import com.stockanalytics.http.HttpPost;
import com.stockanalytics.mapper.StockInfoMapper;
import com.stockanalytics.service.StockInfoService;
import com.stockanalytics.tools.StockTools;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StockInfoServiceTest {

	@Autowired
	private StockInfoService stockInfoService;
	@Autowired
	private HttpPost httpPost;
	@Autowired
	private StockInfoMapper stockInfoMapper;
	String stockId = StockTools.buildID(StockConstants.SZ,1,900);
	String httpUrl = "http://apis.baidu.com/apistore/stockservice/stock";
	String httpArg = "stockid="+stockId;
	
	@Test
	public void batchInsertStockInfoAndStockIndex(){
		stockInfoService.batchInsertStockInfos(httpUrl, httpArg);
	}
	
	@Test
	public void jsonParseTest(){
		JSONObject jos = (JSONObject)JSON.parse(httpPost.send(httpUrl, httpArg));
		String re = jos.get(StockConstants.RE_DATA).toString();
		RetData retData = JSONObject.parseObject(re, RetData.class);
		stockInfoMapper.batchInsertStockInfo(retData.getStockInfo());
		System.out.println(retData);
	}
	
	@Test
	public void getStockInfoTest(){
		
		List<StockInfo> list = stockInfoService.getStockInfo(httpUrl, httpArg);
		System.out.println("size->"+list.size());
		System.out.println(list);
	}
	
	@Test
	public void multiThreadInsertStockInfoTest(){
		stockInfoService.execInsertStockInfo();
	}
	
	@Test
	public void dateTest(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String nowDate = sdf.format(date);
		System.out.println(nowDate);
	}
	
	@Test
	public void updateRate(){
		List<StockInfo> list = stockInfoMapper.findAllStockInfo();
		List<StockInfo> nlist = new ArrayList<StockInfo>();
//		for(int i=0;i<list.size();i++){
//			StockInfo stockInfo = list.get(i);
//			stockInfo.buildRate();
//			nlist.add(stockInfo);
////			list.set(i, stockInfo);
//		}
		StockInfo sto1 = new StockInfo();
		sto1.setId("2015-10-21#sz000882");
		sto1.setCurrentPrice(9.11);
		sto1.setClosingPrice(9.88);
		sto1.buildRate();
		
		StockInfo sto2 = new StockInfo();
		sto2.setId("2015-10-21#sz000881");
		sto2.setCurrentPrice(10.11);
		sto2.setClosingPrice(9.88);
		sto2.buildRate();
		
		nlist.add(sto1);
		nlist.add(sto2);
		
		stockInfoMapper.batchInsertStockInfos(nlist);
	}
	
	@Test
	public void m2(){
		double d = -0.21/20.1;
		String s = String.format("%.4f", d);
		System.out.println(s);
	}
}
