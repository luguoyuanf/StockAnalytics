package com.stockanalytics.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="stockIndex")
public class StockIndex implements Comparable<StockIndex>{
	@Id
	private String id; //主键 日期#股指名称
	private String name; //名称
	private String cdate; //日期
	private double curdot; //当前价格(指数)
	private double curprice; //当前价格涨幅
	private double rate; //涨幅率  负数为跌，正数为涨
	private int dealnumber; //交易量，单位为手（1手100股）
	private int turnover; //成交额，单位万
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return cdate;
	}
	public void setDate(String date) {
		this.cdate = date;
	}
	public int getDealnumber() {
		return dealnumber;
	}
	public void setDealnumber(int dealnumber) {
		this.dealnumber = dealnumber;
	}
	public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	
	public double getCurdot() {
		return curdot;
	}
	public void setCurdot(double curdot) {
		this.curdot = curdot;
	}
	public double getCurprice() {
		return curprice;
	}
	public void setCurprice(double curprice) {
		this.curprice = curprice;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdate == null) ? 0 : cdate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(curdot);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(curprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + dealnumber;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + turnover;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockIndex other = (StockIndex) obj;
		if (cdate == null) {
			if (other.cdate != null)
				return false;
		} else if (!cdate.equals(other.cdate))
			return false;
		if (Double.doubleToLongBits(curdot) != Double
				.doubleToLongBits(other.curdot))
			return false;
		if (Double.doubleToLongBits(curprice) != Double
				.doubleToLongBits(other.curprice))
			return false;
		if (dealnumber != other.dealnumber)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (turnover != other.turnover)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StockIndex [id=" + id + ", name=" + name + ", date=" + cdate
				+ ", curdot=" + curdot + ", curprice=" + curprice + ", rate="
				+ rate + ", dealnumber=" + dealnumber + ", turnover="
				+ turnover + "]";
	}
	@Override
	public int compareTo(StockIndex sto) {
		if(this.curdot != sto.curdot 
				|| this.curprice != sto.curprice
				|| !this.cdate.equals(sto.cdate)
				|| this.dealnumber != sto.dealnumber
				|| !this.id.equals(sto.id)
				|| !this.name.equals(sto.name)
				|| this.rate != sto.rate
				|| this.turnover != sto.turnover) 
		{
			return -1;
		}
		return 0;
	}
	
	
	
}
