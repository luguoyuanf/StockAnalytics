package com.stockanalytics.dao;

import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;
import com.stockanalytics.bean.StockIndex;

@Transactional
public interface StockIndexMongoDao {

	public abstract void insertStockInex(Collection<StockIndex> collection);
	public abstract void insertStockIndex(StockIndex stockIndex);
	
}
