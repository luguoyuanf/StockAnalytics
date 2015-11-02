package com.stockanalytics.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

	
	/**
	 * 获得当前日期
	 * @return
	 */
	public static String getNowDate(){
		return getNowDate("yyyy-MM-dd");
	}
	
	/**
	 * 传入日期字符串，转换为yyyy-MM-dd
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String convertDate(String date){
		Date d = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	
	public static String getNowTime(){
		return getNowDate("HH:mm:ss");
	}

	private static String getNowDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);
	}
}
