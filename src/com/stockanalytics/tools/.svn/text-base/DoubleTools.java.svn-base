package com.stockanalytics.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DoubleTools {
	
	/**
	 * double指定格式转换
	 * @param d
	 * @param format
	 * @return
	 */
	public static double doubleConvert(double d,int num){
		BigDecimal bd = new BigDecimal(d);
		return  bd.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static double doubleConvert(String d,int num){
		Double dd = (Double)Double.parseDouble(d);
		System.out.println(dd);
		BigDecimal bd = new BigDecimal(new Double(d));
		DecimalFormat df = new DecimalFormat("#.00");
		String format = df.format(bd);
		System.out.println(format);
		return  bd.doubleValue();
	}
}
