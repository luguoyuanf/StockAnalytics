package com.stockanalytics.bean;


/**
 * 
 * @author 唐运
 * 2015年10月21日 下午6:25:02
 * TODO 迅动平台诊断评分和描述
 */
public class XD {
	private String id; //主键
	private String date; //查询日期
	private String code; //股票代码
	private int score;	//得分
	private String desc;	//描述
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
