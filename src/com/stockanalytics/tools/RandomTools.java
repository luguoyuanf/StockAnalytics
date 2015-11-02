package com.stockanalytics.tools;

import java.util.Random;

/**
 * 
 * @author 唐运
 * 2015年10月21日 下午6:14:20
 * TODO 随机数工具类
 */

public class RandomTools {

	
	/**
	 * 指定数字长度，生成随机数
	 * @param num
	 * @return
	 */
	public static String buildRandom(int num) {
		Random random = new Random();
		String result = "";
		for(int i=0;i<num;i++){
			result += random.nextInt(10);
		}
		return result;
	}
	
}
