package com.stockanalytics.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stockanalytics.bean.RetData;
import com.stockanalytics.bean.Stock;
import com.stockanalytics.bean.StockIndex;
import com.stockanalytics.bean.StockInfo;
import com.stockanalytics.constants.StockConstants;
import com.stockanalytics.dao.StockIndexMongoDao;
import com.stockanalytics.dao.StockInfoMongoDao;
import com.stockanalytics.dao.StockMongoDao;
import com.stockanalytics.http.HttpPost;
import com.stockanalytics.mapper.StockIndexMapper;
import com.stockanalytics.mapper.StockInfoMapper;
import com.stockanalytics.tools.DateTools;
import com.stockanalytics.tools.StockTools;

@Service("stockInfoService")
public class StockInfoService {
	
	@Autowired
	private StockInfoMapper stockInfoMapper;
	@Autowired
	private HttpPost httpPost;
	@Autowired
	private StockIndexMapper stockIndexMapper;
	private Logger logger = Logger.getLogger(StockInfoService.class);
	private final int sum = 3000;
	private final int num = 500;
	@Autowired
	private StockInfoMongoDao stockInfoMongDao;
	@Autowired
	private StockMongoDao stockMongoDao;
	@Autowired
	private StockIndexMongoDao stockIndexMongoDao;
	
	
	/**
	 * 爬取指定股票代码数据
	 */
	public void getStockInfoToMongo(){
		
		//查询出股票代码
		List<Stock> sts = stockMongoDao.findAllStock();
		//请求股票接口并保存mongo数据库
		int size = sts.size();
		int num = 500;
		int remain = size % num;
		int cnt = size / num;
		for(int i=0;i<=cnt;i++){
			StringBuffer sb = new StringBuffer();
			sb.append(StockConstants.BAIDU_API_STOCKID);
			int start = i*num;
			if(i<cnt){
				int end = (i+1)*num;
				for(int x=start;x<end;x++){
					Stock stock = sts.get(x);
					if(x == end-1){
						sb.append(stock.getCode());
					}else{
						sb.append(stock.getCode()+",");
					}
				}
				batchInsertStockInfos(StockConstants.BAIDU_API_URL, sb.toString());
			}else if(remain !=0){
				for(int x=start;x<size;x++){
					Stock stock = sts.get(x);
					if(x == size-1){
						sb.append(stock.getCode());
					}else{
						sb.append(stock.getCode()+",");
					}
				}
				batchInsertStockInfos(StockConstants.BAIDU_API_URL, sb.toString());
			}
		}
		
	}
	
	/**
	 * 批量插入
	 * @param stockInfos 
	 * @return 0表示失败，1表示插入成功
	 */
	public int batchInsertStockInfos(List<StockInfo> stockInfos){
		int status = 0;
		if(null == stockInfos || stockInfos.size() == 0){
			logger.error("stockInfos为null或者是空的，请检查传入数据。");
			return status;
		}
		try {
			stockInfoMapper.batchInsertStockInfos(stockInfos);
			logger.info("StockInfo批量插入成功.");
			status = 1;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return status;
	}
	
	/**
	 * 插入单条数据
	 * @param stockInfo
	 * @return
	 */
	public int insertStockInfo(StockInfo stockInfo){
		int status = 0;
		if(null == stockInfo){
			logger.error("StockInfo为空，请检查传入数据。");
			return status;
		}
		try {
			stockInfoMapper.insertStockInfo(stockInfo);
			logger.info("StockInfo插入成功.");
			status = 1;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return status;
	}
	
	public List<StockInfo> getStockInfo(StockInfo[] stockInfos){
		return getStockInfoList(stockInfos);
	}
	
	/**
	 * 传入参数去抓取股票数据，返回list
	 * @param httpUrl
	 * @param httpArg
	 * @return 
	 */
	public List<StockInfo> getStockInfo(String httpUrl,String httpArg){
		RetData retData = getRetData(httpUrl, httpArg);
		//转换为List返回
		return getStockInfoList(retData.getStockInfo());
	}

	private List<StockInfo> getStockInfoList(StockInfo[] stockInfos) {
		List<StockInfo> list = Arrays.asList(stockInfos);
		List<StockInfo> nList = new ArrayList<StockInfo>();
		for(int i=0;i<list.size();i++){
			StockInfo stockInfo = list.get(i);
			String name = stockInfo.getName();
			if(null == name || "null".equals(name) || "".equals(name)){
				continue;
			}else{
				String date = stockInfo.getDate();
				String code = stockInfo.getCode();
				stockInfo.setId(date+"#"+code);
				//设置涨跌幅比例
				stockInfo.buildRate();
				nList.add(stockInfo);
				
			}
		}
		
		return nList;
	}
	
	
	/**
	 * 抓取JSON数据转换为RetData对象
	 * @param httpUrl
	 * @param httpArg
	 * @return
	 */
	public RetData getRetData(String httpUrl, String httpArg) {
		//获取所有数据
		JSONObject all = (JSONObject) JSON.parse(httpPost.send(httpUrl, httpArg));
		//获取retData数据
		String jarr = all.get(StockConstants.RE_DATA).toString();
		//提取股票数据
		RetData retData = JSONObject.parseObject(jarr, RetData.class);
		return retData;
	}
	
	
	
	/**
	 * 抓取数据保存到mysql中
	 * @param httpUrl
	 * @param httpArg
	 */
	public int batchInsertStockInfos(String httpUrl,String httpArg){
		RetData retData = getRetData(httpUrl,httpArg);
		try {
			HashSet<StockIndex> set = new HashSet<StockIndex>();
			//批量插入StockIndex
			set .add(retData.getMarket().getShenzhen());
			set.add(retData.getMarket().getShanghai());
			List<StockIndex> stockIndexList = new ArrayList<StockIndex>();
			stockIndexBuildId(stockIndexList,set);
//			stockIndexMapper.batchInsertStockIndex(stockIndexList);
			//插入mongodb
			stockIndexMongoDao.insertStockInex(stockIndexList);
			logger.info("StockIndex插入完成--->"+stockIndexList);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("StockIndex插入失败："+e.getMessage()+retData.getMarket());
			e.printStackTrace();
		}
		
		try {
			//批量插入StockInfo
			StockInfo[] stockInfoArr = retData.getStockInfo();
			List<StockInfo> stockInfos = getStockInfo(stockInfoArr);
			//插入到MongoDB
			stockInfoMongDao.insertStockInfo(stockInfos);
//			return batchInsertStockInfos(stockInfos);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/***
	 * 补齐ID和日期
	 * @param stockIndexList
	 * @param set
	 */
	
	private void stockIndexBuildId(List<StockIndex> stockIndexList,Set<StockIndex> set) {
		// TODO Auto-generated method stub
		for(StockIndex sti:set){
			String nowDate = DateTools.getNowDate();
			String name = sti.getName();
			//补齐id和日期
			sti.setDate(nowDate);
			sti.setId(nowDate+"#"+name);
			stockIndexList.add(sti);
		}
	}

	/**
	 * 执行抓取数据写入库中
	 */
	public void execInsertStockInfo(){
		try {
//			batchInsertStockInfo(sum, num, StockConstants.SH, StockConstants.BAIDU_API_URL);
//			batchInsertStockInfo(sum, num, StockConstants.SZ, StockConstants.BAIDU_API_URL);
//			batchInsertStockInfo(sum, num, StockConstants.CYB, StockConstants.BAIDU_API_URL);
			getStockInfoToMongo();
			logger.info("execInsertStockInfo 执行完成。。");
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void batchInsertStockInfo(int sum,int num,String flag,String httpUrl){
		try {
			for(int i=1;i<=sum/num;i++){
				int start = 0;
				int end = 0;
				
				if(i==1){
					start = i;
				}else{
					start = (i - 1) * num + 1; //生成ID 1-500
				}
				
				end = i*num;
				String httpArg = StockConstants.BAIDU_API_STOCKID+StockTools.buildID(flag, start, end);
				int status = batchInsertStockInfos(httpUrl, httpArg);
				if(status == 1){
					logger.info(flag+":"+start+"~"+end+"插入成功！");
				}else{
					logger.error(flag+":"+start+"~"+end+"插入失败！");
				}
			
			}
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
		}
	}
}
