package com.stockanalytics.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.stockanalytics.bean.StockInfo;
import com.stockanalytics.constants.StockConstants;
import com.stockanalytics.dao.impl.StockInfoMongoDaoImpl;
import com.stockanalytics.mapper.StockInfoMapper;
import com.stockanalytics.tools.DateTools;
import com.stockanalytics.tools.IOTools;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class IOTest {
	@Value("#{commonProperties['import.path']}")
	private String importPath;
	final static String PATH_DIR = "h:/data/stock/";
//	private String PATH_DIR = importPath;
	@Autowired
	private StockInfoMapper stockInfoMapper;
	@Autowired
	private StockInfoMongoDaoImpl stockInfoMongoDaoImpl;
	
	final static int size = 1000;
	@Autowired
	private IOTools ioTools;
	
	@Test
	public void ioToMongoTest(){
		File dir = new File(PATH_DIR);
		File[] files = dir.listFiles();
		long starttime = System.currentTimeMillis();
		for(int i=0;i<files.length;i++){
			long start = System.currentTimeMillis();
			String filePath = PATH_DIR+files[i].getName();
			List<StockInfo> stocks = readFile(filePath);
			stockInfoMongoDaoImpl.insertStockInfo(stocks);
			long end = System.currentTimeMillis();
			System.out.println(filePath+"导入成功，耗时："+(end-start)/1000+"秒");
			new File(filePath).delete();
			System.out.println(filePath+"删除成功！！");
		}
		long endtime = System.currentTimeMillis();
		System.out.println("所有导入完成！耗时："+(endtime-starttime)/1000+"秒");
	}
	
	@Test
	public void ioTest(){
//		System.out.println(importPath);
		ioTools.foreachImportMysql();
	}
	
	@Test
	public void foreachDirTest(){
		File dir = new File(PATH_DIR);
		File[] files = dir.listFiles();
		for(int i=0;i<files.length;i++){
				long start = System.currentTimeMillis();
				String filePath = PATH_DIR+files[i].getName();
				List<StockInfo> stocks = readFile(filePath);
				int rema = stocks.size() % size;
				int num = stocks.size()/size;
				for(int x=0;x<=num;x++){
					List<StockInfo> ls= new ArrayList<StockInfo>();
					if(x < num){
						for(int y=x*size;y<(x+1)*size;y++){
							ls.add(stocks.get(y));
						}
						stockInfoMapper.batchInsertStockInfos(ls);
						System.out.println((x+1)+"次插入成功");
					}else if(rema != 0){
						for(int y=x*size;y<rema;y++){
							ls.add(stocks.get(y));
						}
						stockInfoMapper.batchInsertStockInfos(ls);
						System.out.println("rema"+"次插入成功");
					}
				}
//				stockInfoMapper.batchInsertStockInfos(stocks);
				try {
					new File(filePath).delete();
					System.out.println(filePath+"删除成功");
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(filePath+"删除失败");
					e.printStackTrace();
				}
				long end = System.currentTimeMillis();
				System.out.println(filePath+"导入成功，耗时："+(end-start)/1000+"秒");
		}
	}
	
	@Test
	public void BufferInputStreamTest() throws IOException{
		String path = "h:/data/stock/SZ#000681.txt";
		readFile(path);
	}

	private List<StockInfo> readFile(String path) {
		InputStreamReader isr = null;
		FileInputStream fis = null;
		BufferedReader br = null;
		String line = null;
		String[] lineArr = null;
		int length = 1;
		
		try {
			//创建文件输入流
			fis = new FileInputStream(path);
			//创建输入流Reader，指定字符。因为是Windows文件，所以设置GBK
			isr = new InputStreamReader(fis, "gbk");
			br = new BufferedReader(isr);
			String name = "";
			String code = "";
			String date = "";
			double openningPrice = 0.0;
			//今日收盘价
			double currentPrice = 0.0;
			//最高价
			double hPrice = 0.0;
			//最低价
			double lPrice = 0.0;
			//成交量
			BigDecimal totalNumber = null;
			//成交额
			BigDecimal turnover = null;
			//昨日收盘价
			double closingPrice = 0.0;
			List<StockInfo> stocks = new ArrayList<StockInfo>();
			while((line = br.readLine()) != null){
				StockInfo stockInfo = new StockInfo();
				if(length == 1){
					lineArr = line.split(" ",-1);
					code = lineArr[0];
					name = lineArr[1];
					String codePrifex = code.substring(0, 1);
					if(codePrifex.equals("0")){
						code = StockConstants.SZ_PREFIX+code;
					}else if(codePrifex.equals("3")){
						code = StockConstants.CYB_PREFIX+code;
					}else{
						code = StockConstants.SH_PREFIX+code;
					}
//					jb.put("code", code);
//					jb.put("name", name);
					stockInfo.setCode(code);
					stockInfo.setName(name);
					System.out.println("股票代码："+code);
					System.out.println("股票名称："+name);
				}else if(length > 2){
					lineArr = line.split("\t",-1);
					if(lineArr.length == 7){
						date = DateTools.convertDate(lineArr[0]);
						openningPrice = new Double(lineArr[1]);
						hPrice = new Double(lineArr[2]);
						lPrice = new Double(lineArr[3]);
						currentPrice = new Double(lineArr[4]);
						totalNumber = new BigDecimal(lineArr[5].trim());
						turnover = new BigDecimal(lineArr[6]);
//						System.out.println("日期:"+date+",开盘价:"
//									+openningPrice+",最高价:"+hPrice
//									+",最低价:"+lPrice+",收盘价:"+currentPrice
//									+",成交量:"+totalNumber+",成交额:"+turnover);
						stockInfo.setCode(code);
						stockInfo.setName(name);
						stockInfo.setDate(date);
						stockInfo.setOpenningPrice(openningPrice);
						stockInfo.sethPrice(hPrice);
						stockInfo.setlPrice(lPrice);
						stockInfo.setCurrentPrice(currentPrice);
						stockInfo.setTotalNumber(totalNumber);
						stockInfo.setTurnover(turnover);
						stockInfo.setTime(DateTools.getNowTime());
						if(length == 3){
//							jb.put("closingPrice", currentPrice);
							stockInfo.setClosingPrice(currentPrice);
						}else{
//							jb.put("closingPrice", closingPrice);
							stockInfo.setClosingPrice(closingPrice);
						}
						closingPrice = currentPrice;
						stockInfo.buildRate();
						stockInfo.setId(date+"#"+code);
						stocks.add(stockInfo);
					}
				}
				length++;
				
			}
			return stocks;
		} catch (UnsupportedEncodingException e) {
			//不支持这个编码格式
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			//没有找到文件
			e.printStackTrace();;
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
	
	@Test
	public void ST1(){
		String name = "123455";
		System.out.println(name.substring(0,1));
	}
	
	@Test
	public void ST2(){
		System.out.println(DateTools.getNowTime());
	}
	
	@Test
	public void doubleTest(){
//		System.out.println(DoubleTools.doubleConvert("2313786618", 2));
		System.out.println(Double.parseDouble("2313786618"));
	}
}
