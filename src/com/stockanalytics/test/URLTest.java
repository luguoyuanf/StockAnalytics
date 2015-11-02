package com.stockanalytics.test;

import java.io.IOException;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stockanalytics.http.HttpPost;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class URLTest {

	@Autowired
	private HttpPost httpPost;
	//链接
	String httpUrl = "http://www.xdstock.com/stock/RP0000A0100BLogic.do";
	//参数
	String random = buildRandom(19);
	String stkCode = "&stkCode=300020";
	String httpArg = "r="+random +stkCode;
	
	@Test
	public void dom4jTest(){
		String result = httpPost.send(httpUrl, httpArg);
		String[] strs = result.split("\r\n");
		for(int i=0;i<strs.length;i++){
			String st = strs[i];
			int forStatus = 0;
			if(st.contains("评级") && forStatus == 0){
				System.out.println("下标"+i);
				System.out.println(st+"-------");
				int isSpan = 0; //1表示已经搜索到过了 
				int isDiv = 0; //1表示已经搜索到过了 
				for(int x=0;x<50;x++){
					int index = i+x;
					String content = strs[index];
					
					if(isSpan == 1 && isDiv == 1){
						break;
					}
					
					if(isSpan == 0 && content.matches(".*<span.*")){
						System.out.println("下标->"+index+","+ strs[index+1]+"----");
						isSpan = 1;
					}
					
					if(isDiv == 0 && content.matches(".*</div>.*")){
						System.out.println("下标->"+index+","+ strs[index-1]+"---");
						isDiv = 1;
					}
				}
				
				forStatus = 1;
			}
		}
	}
	
	/*@Test
	public void jsoupTest() throws IOException{
		String result = httpPost.send(httpUrl, httpArg);
		Document doc = Jsoup.parse(result);
		Elements els = doc.getElementsContainingText("评级");
		for(int i=0;i<els.size();i++){
			Element el = els.get(i);
			if(el.toString().contains("评级")){
				System.out.println(i);
				Element jishu = els.get(i+1);
				String pingjia = els.get(i+2).val();
				System.out.println(jishu+","+pingjia);
			}
		}
		
	}*/
	
	@Test
	public void postTest(){
//		//链接
//		String httpUrl = "http://www.xdstock.com/stock/RP0000A0100BLogic.do";
//		//参数
//		String random = buildRandom(19);
//		String stkCode = "&stkCode=000829";
//		String httpArg = "r="+random +stkCode;
		//请求
		String result = httpPost.send(httpUrl, httpArg);
		System.out.println(result);
	}

	private String buildRandom(int num) {
		Random random = new Random();
		String result = "";
		for(int i=0;i<num;i++){
			result += random.nextInt(10);
		}
		return result;
	}
}
