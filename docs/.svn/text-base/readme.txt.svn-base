需求说明：
	1.数据收集：
		收集：
			每天爬取百度接口的股票数据及股指数据
				接口地址：http://apis.baidu.com/apistore/stockservice/stock
					参数： 
						header： 
							apikey： 859443543e3b1da73fa701240a01ba8a
						param:
							stockid：股票编号sz0（深证）、sz3（创业板）、sh6（上证）
			每天抓取迅动平台诊断评分和建议 
				接口地址：http://www.xdstock.com/stock/RP0000A0100BLogic.do?r=2609486329216718044&stkCode=000829
		清洗：
			对无效股票数据进行过滤，有效数据分别存入stockinfo（股票）、stockindex（股指）表中
	2.数据处理：
		分类打标签：
			5日内均价
			macd是否出现金叉并且出现在0轴位置上方
			涨跌幅比例
			停牌及非停牌股票
			30天内最低点价位
			60天内最低点价位
			90天内最低点价位
	3.数据分析：
		筛选
			收盘价站上5日均线，并且macd在0轴上方并是金叉形态、非停牌股票
	4.报表



openningPrice为0并且closeingPrice不为0，则该股票属于停牌。

 JSON返回示例 :

{
  errNum: 0,     //返回错误码
  errMsg: "成功", //返回错误信息
  retData: {
      stockinfo: {
      name: "科大讯飞", //股票名称
      code: "sz002230", //股票代码，SZ指在深圳交易的股票
      date: "2014-09-22", //当前显示股票信息的日期
      time: "09:26:11",   //具体时间
      OpenningPrice: 27.34, //今日开盘价
      closingPrice: 27.34,  //昨日收盘价
      currentPrice: 27.34,  //当前价格
      hPrice: 27.34,        //今日最高价
      lPrice: 27.34,       //今日最低价
      competitivePrice: 27.30, //买一报价
      auctionPrice: 27.34,   //卖一报价
      totalNumber: 47800,    //成交的股票数
      turnover: 1306852.00,  //成交额，以元为单位
      buyOne: 6100,      //买一 
      buyOnePrice: 27.30, //买一价格
      buyTwo: 7500,  //买二
      buyTwoPrice: 27.29, //买二价格
      buyThree: 2000,   //买三
      buyThreePrice: 27.27,  //买三价格
      buyFour: 100,    //买四
      buyFourPrice: 27.25, //买四价格
      buyFive: 5700,     //买五
      buyFivePrice: 27.22,  //买五价格
      sellOne: 10150,       //卖一
      sellOnePrice: 27.34,  //卖一价格
      sellTwo: 15200,      //卖二
      sellTwoPrice: 27.35,  //卖二价格
      sellThree: 5914,     //卖三
      sellThreePrice: 27.36, //卖三价格
      sellFour: 400,        //卖四
      sellFourPrice: 27.37,  //卖四价格
      sellFive: 3000,       //卖五
      sellFivePrice: 27.38   //卖五价格
   },
   market: {    //大盘指数
      shanghai: {
          name: "上证指数",
          curdot: 2323.554, // 当前价格
          curprice: -5.897,  //当前价格涨幅
          rate: -0.25,    // 涨幅率
          dealnumber: 11586,  //交易量，单位为手（一百股）
          turnover: 98322   //成交额，万元为单位
      },
     shenzhen: {
          name: "深证成指",
          curdot: 8036.871,
          curprice: -10.382,
          rate: -0.13,
          dealnumber: 1083562,
          turnover: 126854
      }
   },
   klinegraph: {  //K线图
       minurl: "http://image.sinajs.cn/newchart/min/n/sz002230.gif", //分时K线图
       dayurl: "http://image.sinajs.cn/newchart/daily/n/sz002230.gif", //日K线图
       weekurl: "http://image.sinajs.cn/newchart/weekly/n/sz002230.gif", //周K线图
       monthurl: "http://image.sinajs.cn/newchart/monthly/n/sz002230.gif" //月K线图
   }
  }
}

备注 :

请将apikey作为参数添加到header中；
当返回{"errNum":300003,"errMsg":"url is not parse"} 时，请校验是否传入apikey；
SZ指在深证交易所上市的股票代码，SH指在上海交易所上市的股票代码；
当list=1，则stockid=股票代码1，股票代码2，股票代码3，...
当list=其它值，则stockid=股票代码1