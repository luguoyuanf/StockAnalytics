package com.stockanalytics.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stockanalytics.tools.IOTools;


@Controller
@RequestMapping("/importStock")
public class ImportStock {

	@Autowired
	private IOTools ioTools;
	
	@RequestMapping("/execImport")
	public @ResponseBody String execImport(){
		
		ioTools.foreachImportMongo();
		return "success";
	}
	
	
}
