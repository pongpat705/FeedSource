package com.feedhub.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feedhub.entity.FeedSource;
import com.feedhub.model.ResponseModel;
import com.feedhub.repository.FeedSourceRepository;

@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	private FeedSourceRepository feedRepos;
	
	@RequestMapping(value="/insert/title", method=RequestMethod.POST)
	public ResponseModel<String> insertData(@RequestBody FeedSource feedSource){
		String result = "";
		String response = "OK";
		if(StringUtils.isEmpty(feedSource.getTitle())) {
			response = "ERROR";
			result = "title is empty";
		}
		
		if(StringUtils.isEmpty(feedSource.getUrl())) {
			response = "ERROR";
			result = "url is empty";
		}
		
		String regExp = "(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";
		if(!regExp.matches(feedSource.getUrl())) {
			response = "ERROR";
			result = "url not match";
		}
		if("OK".equals(response)) {
			try {
				feedRepos.save(feedSource);
			} catch (Exception e) {
				// TODO: handle exception
				response = "ERROR";
				result = e.getMessage();
			}			
		}
		
		ResponseModel<String> res = new ResponseModel<>();
		res.setData(result);
		res.setResponse(response);
		
		return res;
		
	}
	
	@RequestMapping(value="/delete/{sourceId}", method=RequestMethod.POST)
	public ResponseModel<String> deleteData(@PathVariable Long sourceId){
		String result = "";
		String response = "OK";
		
		try {
			feedRepos.deleteById(sourceId);
		} catch (Exception e) {
			// TODO: handle exception
			response = "ERROR";
			result = e.getMessage();
		}
		
		
		ResponseModel<String> res = new ResponseModel<>();
		res.setData(result);
		res.setResponse(response);
		
		return res;
		
	}
	
	@RequestMapping(value="/get/all")
	public ResponseModel<List<FeedSource>> getAllData(){
		List<FeedSource> data = new ArrayList<>();
		String response = "OK";
		try {
		
			data = feedRepos.findAll();
			
		} catch (Exception e) {
			response = "ERROR";
		}
		
		ResponseModel<List<FeedSource>> res = new ResponseModel<>();
		res.setData(data);
		res.setResponse(response);
		
		return res;
	}
	
}
