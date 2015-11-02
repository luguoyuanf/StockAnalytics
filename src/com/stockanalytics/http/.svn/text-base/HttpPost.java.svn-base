package com.stockanalytics.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.stockanalytics.constants.StockConstants;

/**
 * 
 * @author 唐运
 * 2015年10月19日 下午2:01:56
 * TODO 用于Http协议Post请求
 */

@Component("httpPost")
public class HttpPost {
	private Logger logger = Logger.getLogger(HttpPost.class);
	
	public String send(String httpUrl,String httpArg){
		final String loginfo = "httpUrl="+httpUrl+",httpArg="+httpArg;
		PrintWriter out = null;
	    String result = null;
	    httpUrl = httpUrl + "?" + httpArg + StockConstants.BAIDU_API_IS_MULTI_QUERY;

		try {
			URL url = new URL(httpUrl);
	        URLConnection connection = url.openConnection();
	        // 设置通用的请求属性
	        connection.setRequestProperty("accept", "*/*");
	        connection.setRequestProperty("content-type", "application/x-www-form-urlencoded"); 
	        connection.setRequestProperty("connection", "Keep-Alive");
	        connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	        connection.setRequestProperty("apikey",  "859443543e3b1da73fa701240a01ba8a");
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        //获取URLConnection对象对应的输出流
	        out = new PrintWriter(connection.getOutputStream());
	        //发送请求参数
	        out.print(httpArg+"&apikey=859443543e3b1da73fa701240a01ba8a");
	        out.flush();
	        out.close();
	        // 获取相应码
	        int respCode = ((HttpURLConnection) connection).getResponseCode();
	        
	        if (respCode == 200)
	        {
	            return ConvertStream2Json(connection.getInputStream());
	        }
			
			logger.info("Post请求成功！"+loginfo);
		} catch (Exception e) {
			logger.error("Post请求失败！"+loginfo);
			e.printStackTrace();
		}
		return result;
	}
	
	private String ConvertStream2Json(InputStream inputStream)
    {
        String jsonStr = "";
        // ByteArrayOutputStream相当于内存输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        // 将输入流转移到内存输出流中
        try
        {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1)
            {
                out.write(buffer, 0, len);
            }
            // 将内存流转换为字符串
            jsonStr = new String(out.toByteArray());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonStr;
    }
	
	public Map<String,String> getXD(String httpUrl,String httpArg){
		Map<String, String> resultMap = new HashMap<String,String>();
		String result = send(httpUrl, httpArg);
		String score = "";
		String desc = "";
		//切割字符串，每行一个元素
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
					//得分
					if(isSpan == 0 && content.matches(".*<span.*")){
						score = strs[index+1]; 
//						System.out.println("下标->"+index+","+ score+"----");
						isSpan = 1;
					}
					
					if(isDiv == 0 && content.matches(".*</div>.*")){
						desc = strs[index-1];
//						System.out.println("下标->"+index+","+ strs[index-1]+"---");
						isDiv = 1;
					}
				}
				
				forStatus = 1;
			}
		}
		
		if(!score.equals("") && !score.equals("0") && !desc.contains("停牌") ){
			resultMap.put("score", score);
		}
		
		return !resultMap.isEmpty()?resultMap:null;
	}
	
}
