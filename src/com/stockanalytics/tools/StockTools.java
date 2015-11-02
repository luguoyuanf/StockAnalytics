package com.stockanalytics.tools;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.stockanalytics.service.StockInfoService;

public class StockTools {
	final private static int ID_LENGTH = 5;
	@Autowired
	private StockInfoService stockInfoService;
	private static  Logger logger = Logger.getLogger(StockTools.class);
	//生成id
	public static String buildID(String flag,int start,int end){
		StringBuffer sb = new StringBuffer();
		for(;start<=end;start++){
			if(start == end){
				sb.append(flag).append(paddingID(start));
			}else{
				sb.append(flag).append(paddingID(start)).append(",");
			}
		}
		return sb.toString();
	}
	
	//补齐ID
	public static String paddingID(int id){
		int paddingLength = ID_LENGTH-(new StringBuffer().append(id).toString().length());
		StringBuffer num = new StringBuffer();
		for(int i=0;i<paddingLength;i++){
			num.append("0");
		}
		return num.append(id).toString();
	}
	
	
}
