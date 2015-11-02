package com.stockanalytics.bean;

import java.util.Arrays;

public class RetData {
	private StockInfo[] stockInfo;
	private Market market;
	
	public StockInfo[] getStockInfo() {
		return stockInfo;
	}
	public void setStockInfo(StockInfo[] stockInfo) {
		this.stockInfo = stockInfo;
	}
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	@Override
	public String toString() {
		return "RetData [stockInfo=" + Arrays.toString(stockInfo) + ", market="
				+ market + "]";
	}
	
}
