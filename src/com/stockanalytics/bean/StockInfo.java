package com.stockanalytics.bean;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.stockanalytics.tools.DoubleTools;

@Document(collection="stockinfo")
public class StockInfo {
	@Id
	private String id =""; //主键
	private String name = "";//股票名称
	private String code = "";//股票代码，sz：深证、sh：上证、sz3开头创业板
	private String cdate = "";//股票信息日期
	private String ctime = "";//具体时间
	private double openningPrice = 0.00;//今日开盘价
	private double closingPrice = 0.00;//昨日收盘价
	private double currentPrice = 0.00; //当前价格,收盘价格
	private double hPrice = 0.00; //今日最高价
	private double lPrice = 0.00; //今日最低价
	private double competitivePrice = 0.00; //买一报价
	private double auctionPrice = 0.00;//卖一报价
	private BigDecimal totalNumber;  //成交的股票数
	private BigDecimal turnover; //成交额，以元为单位
	private int buyOne = 0; //买一 
	private double buyOnePrice = 0.00;//买一价格
	private int buyTwo = 0;//买二
	private double buyTwoPrice = 0.00;//买二价格
	private int buyThree = 0;//买三
	private double buyThreePrice = 0.00;//买三价格
	private int buyFour = 0;//买四
	private double buyFourPrice = 0.00; //买四价格
	private int buyFive = 0;//买五
	private double buyFivePrice = 0.00; //买五价格
	private int sellOne = 0;//卖一
	private double sellOnePrice = 0.00; //卖一价格
	private int sellTwo = 0; //卖二
	private double sellTwoPrice = 0.00; //卖二价格
	private int sellThree = 0;//卖三
	private double sellThreePrice = 0.00; //卖三价格
	private int sellFour = 0;//卖四
	private double sellFourPrice = 0.00;//卖四价格
	private int sellFive = 0;//卖五
	private double sellFivePrice = 0.00;//卖五价格
	private BigDecimal increase;  //涨幅百分比
	private String minurl = ""; //分时K线
	private String dayurl = ""; //日K线
	private String weekurl = ""; //周K线
	private String monthurl = ""; //月K线
	private double rate = 0.0;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return cdate;
	}
	public void setDate(String date) {
		this.cdate = date;
	}
	public String getTime() {
		return ctime;
	}
	public void setTime(String time) {
		this.ctime = time;
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getOpenningPrice() {
		return openningPrice;
	}
	public void setOpenningPrice(double openningPrice) {
		this.openningPrice = openningPrice;
	}
	public double getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public double gethPrice() {
		return hPrice;
	}
	public void sethPrice(double hPrice) {
		this.hPrice = hPrice;
	}
	public double getlPrice() {
		return lPrice;
	}
	public void setlPrice(double lPrice) {
		this.lPrice = lPrice;
	}
	public double getCompetitivePrice() {
		return competitivePrice;
	}
	public void setCompetitivePrice(double competitivePrice) {
		this.competitivePrice = competitivePrice;
	}
	public double getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(double auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	
	public BigDecimal getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(BigDecimal totalNumber) {
		this.totalNumber = totalNumber;
	}
	public BigDecimal getTurnover() {
		return turnover;
	}
	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}
	public int getBuyOne() {
		return buyOne;
	}
	public void setBuyOne(int buyOne) {
		this.buyOne = buyOne;
	}
	public double getBuyOnePrice() {
		return buyOnePrice;
	}
	public void setBuyOnePrice(double buyOnePrice) {
		this.buyOnePrice = buyOnePrice;
	}
	public int getBuyTwo() {
		return buyTwo;
	}
	public void setBuyTwo(int buyTwo) {
		this.buyTwo = buyTwo;
	}
	public double getBuyTwoPrice() {
		return buyTwoPrice;
	}
	public void setBuyTwoPrice(double buyTwoPrice) {
		this.buyTwoPrice = buyTwoPrice;
	}
	public int getBuyThree() {
		return buyThree;
	}
	public void setBuyThree(int buyThree) {
		this.buyThree = buyThree;
	}
	public double getBuyThreePrice() {
		return buyThreePrice;
	}
	public void setBuyThreePrice(double buyThreePrice) {
		this.buyThreePrice = buyThreePrice;
	}
	public int getBuyFour() {
		return buyFour;
	}
	public void setBuyFour(int buyFour) {
		this.buyFour = buyFour;
	}
	public double getBuyFourPrice() {
		return buyFourPrice;
	}
	public void setBuyFourPrice(double buyFourPrice) {
		this.buyFourPrice = buyFourPrice;
	}
	public int getBuyFive() {
		return buyFive;
	}
	public void setBuyFive(int buyFive) {
		this.buyFive = buyFive;
	}
	public double getBuyFivePrice() {
		return buyFivePrice;
	}
	public void setBuyFivePrice(double buyFivePrice) {
		this.buyFivePrice = buyFivePrice;
	}
	public int getSellOne() {
		return sellOne;
	}
	public void setSellOne(int sellOne) {
		this.sellOne = sellOne;
	}
	public double getSellOnePrice() {
		return sellOnePrice;
	}
	public void setSellOnePrice(double sellOnePrice) {
		this.sellOnePrice = sellOnePrice;
	}
	public int getSellTwo() {
		return sellTwo;
	}
	public void setSellTwo(int sellTwo) {
		this.sellTwo = sellTwo;
	}
	public double getSellTwoPrice() {
		return sellTwoPrice;
	}
	public void setSellTwoPrice(double sellTwoPrice) {
		this.sellTwoPrice = sellTwoPrice;
	}
	public int getSellThree() {
		return sellThree;
	}
	public void setSellThree(int sellThree) {
		this.sellThree = sellThree;
	}
	public double getSellThreePrice() {
		return sellThreePrice;
	}
	public void setSellThreePrice(double sellThreePrice) {
		this.sellThreePrice = sellThreePrice;
	}
	public int getSellFour() {
		return sellFour;
	}
	public void setSellFour(int sellFour) {
		this.sellFour = sellFour;
	}
	public double getSellFourPrice() {
		return sellFourPrice;
	}
	public void setSellFourPrice(double sellFourPrice) {
		this.sellFourPrice = sellFourPrice;
	}
	public int getSellFive() {
		return sellFive;
	}
	public void setSellFive(int sellFive) {
		this.sellFive = sellFive;
	}
	public double getSellFivePrice() {
		return sellFivePrice;
	}
	public void setSellFivePrice(double sellFivePrice) {
		this.sellFivePrice = sellFivePrice;
	}
	public BigDecimal getIncrease() {
		return increase;
	}
	public void setIncrease(BigDecimal increase) {
		this.increase = increase;
	}
	public String getMinurl() {
		return minurl;
	}
	public void setMinurl(String minurl) {
		this.minurl = minurl;
	}
	public String getDayurl() {
		return dayurl;
	}
	public void setDayurl(String dayurl) {
		this.dayurl = dayurl;
	}
	public String getWeekurl() {
		return weekurl;
	}
	public void setWeekurl(String weekurl) {
		this.weekurl = weekurl;
	}
	public String getMonthurl() {
		return monthurl;
	}
	public void setMonthurl(String monthurl) {
		this.monthurl = monthurl;
	}
	
	
	public void buildRate(){
		//(今天的价格-昨天的价格)/昨天的价格=涨跌幅比例
		rate = currentPrice == 0 ? 0.0000 :DoubleTools.doubleConvert((currentPrice-closingPrice)/closingPrice,4);
	}
	
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(auctionPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + buyFive;
		temp = Double.doubleToLongBits(buyFivePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + buyFour;
		temp = Double.doubleToLongBits(buyFourPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + buyOne;
		temp = Double.doubleToLongBits(buyOnePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + buyThree;
		temp = Double.doubleToLongBits(buyThreePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + buyTwo;
		temp = Double.doubleToLongBits(buyTwoPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cdate == null) ? 0 : cdate.hashCode());
		temp = Double.doubleToLongBits(closingPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		temp = Double.doubleToLongBits(competitivePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ctime == null) ? 0 : ctime.hashCode());
		temp = Double.doubleToLongBits(currentPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dayurl == null) ? 0 : dayurl.hashCode());
		temp = Double.doubleToLongBits(hPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((increase == null) ? 0 : increase.hashCode());
		temp = Double.doubleToLongBits(lPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((minurl == null) ? 0 : minurl.hashCode());
		result = prime * result
				+ ((monthurl == null) ? 0 : monthurl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(openningPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sellFive;
		temp = Double.doubleToLongBits(sellFivePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sellFour;
		temp = Double.doubleToLongBits(sellFourPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sellOne;
		temp = Double.doubleToLongBits(sellOnePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sellThree;
		temp = Double.doubleToLongBits(sellThreePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sellTwo;
		temp = Double.doubleToLongBits(sellTwoPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((totalNumber == null) ? 0 : totalNumber.hashCode());
		result = prime * result
				+ ((turnover == null) ? 0 : turnover.hashCode());
		result = prime * result + ((weekurl == null) ? 0 : weekurl.hashCode());
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
		StockInfo other = (StockInfo) obj;
		if (Double.doubleToLongBits(auctionPrice) != Double
				.doubleToLongBits(other.auctionPrice))
			return false;
		if (buyFive != other.buyFive)
			return false;
		if (Double.doubleToLongBits(buyFivePrice) != Double
				.doubleToLongBits(other.buyFivePrice))
			return false;
		if (buyFour != other.buyFour)
			return false;
		if (Double.doubleToLongBits(buyFourPrice) != Double
				.doubleToLongBits(other.buyFourPrice))
			return false;
		if (buyOne != other.buyOne)
			return false;
		if (Double.doubleToLongBits(buyOnePrice) != Double
				.doubleToLongBits(other.buyOnePrice))
			return false;
		if (buyThree != other.buyThree)
			return false;
		if (Double.doubleToLongBits(buyThreePrice) != Double
				.doubleToLongBits(other.buyThreePrice))
			return false;
		if (buyTwo != other.buyTwo)
			return false;
		if (Double.doubleToLongBits(buyTwoPrice) != Double
				.doubleToLongBits(other.buyTwoPrice))
			return false;
		if (cdate == null) {
			if (other.cdate != null)
				return false;
		} else if (!cdate.equals(other.cdate))
			return false;
		if (Double.doubleToLongBits(closingPrice) != Double
				.doubleToLongBits(other.closingPrice))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Double.doubleToLongBits(competitivePrice) != Double
				.doubleToLongBits(other.competitivePrice))
			return false;
		if (ctime == null) {
			if (other.ctime != null)
				return false;
		} else if (!ctime.equals(other.ctime))
			return false;
		if (Double.doubleToLongBits(currentPrice) != Double
				.doubleToLongBits(other.currentPrice))
			return false;
		if (dayurl == null) {
			if (other.dayurl != null)
				return false;
		} else if (!dayurl.equals(other.dayurl))
			return false;
		if (Double.doubleToLongBits(hPrice) != Double
				.doubleToLongBits(other.hPrice))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (increase == null) {
			if (other.increase != null)
				return false;
		} else if (!increase.equals(other.increase))
			return false;
		if (Double.doubleToLongBits(lPrice) != Double
				.doubleToLongBits(other.lPrice))
			return false;
		if (minurl == null) {
			if (other.minurl != null)
				return false;
		} else if (!minurl.equals(other.minurl))
			return false;
		if (monthurl == null) {
			if (other.monthurl != null)
				return false;
		} else if (!monthurl.equals(other.monthurl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(openningPrice) != Double
				.doubleToLongBits(other.openningPrice))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (sellFive != other.sellFive)
			return false;
		if (Double.doubleToLongBits(sellFivePrice) != Double
				.doubleToLongBits(other.sellFivePrice))
			return false;
		if (sellFour != other.sellFour)
			return false;
		if (Double.doubleToLongBits(sellFourPrice) != Double
				.doubleToLongBits(other.sellFourPrice))
			return false;
		if (sellOne != other.sellOne)
			return false;
		if (Double.doubleToLongBits(sellOnePrice) != Double
				.doubleToLongBits(other.sellOnePrice))
			return false;
		if (sellThree != other.sellThree)
			return false;
		if (Double.doubleToLongBits(sellThreePrice) != Double
				.doubleToLongBits(other.sellThreePrice))
			return false;
		if (sellTwo != other.sellTwo)
			return false;
		if (Double.doubleToLongBits(sellTwoPrice) != Double
				.doubleToLongBits(other.sellTwoPrice))
			return false;
		if (totalNumber == null) {
			if (other.totalNumber != null)
				return false;
		} else if (!totalNumber.equals(other.totalNumber))
			return false;
		if (turnover == null) {
			if (other.turnover != null)
				return false;
		} else if (!turnover.equals(other.turnover))
			return false;
		if (weekurl == null) {
			if (other.weekurl != null)
				return false;
		} else if (!weekurl.equals(other.weekurl))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StockInfo [id=" + id + ", name=" + name + ", code=" + code
				+ ", cdate=" + cdate + ", ctime=" + ctime + ", openningPrice="
				+ openningPrice + ", closingPrice=" + closingPrice
				+ ", currentPrice=" + currentPrice + ", hPrice=" + hPrice
				+ ", lPrice=" + lPrice + ", competitivePrice="
				+ competitivePrice + ", auctionPrice=" + auctionPrice
				+ ", totalNumber=" + totalNumber + ", turnover=" + turnover
				+ ", buyOne=" + buyOne + ", buyOnePrice=" + buyOnePrice
				+ ", buyTwo=" + buyTwo + ", buyTwoPrice=" + buyTwoPrice
				+ ", buyThree=" + buyThree + ", buyThreePrice=" + buyThreePrice
				+ ", buyFour=" + buyFour + ", buyFourPrice=" + buyFourPrice
				+ ", buyFive=" + buyFive + ", buyFivePrice=" + buyFivePrice
				+ ", sellOne=" + sellOne + ", sellOnePrice=" + sellOnePrice
				+ ", sellTwo=" + sellTwo + ", sellTwoPrice=" + sellTwoPrice
				+ ", sellThree=" + sellThree + ", sellThreePrice="
				+ sellThreePrice + ", sellFour=" + sellFour
				+ ", sellFourPrice=" + sellFourPrice + ", sellFive=" + sellFive
				+ ", sellFivePrice=" + sellFivePrice + ", increase=" + increase
				+ ", minurl=" + minurl + ", dayurl=" + dayurl + ", weekurl="
				+ weekurl + ", monthurl=" + monthurl + ", rate=" + rate + "]";
	}
	
	
}
