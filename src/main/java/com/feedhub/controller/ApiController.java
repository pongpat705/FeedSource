package com.feedhub.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedhub.entity.FeedSource;
import com.feedhub.model.Feed;
import com.feedhub.model.ResponseModel;
import com.feedhub.repository.FeedSourceRepository;
import com.feedhub.services.RssServices;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeedSourceRepository feedRepos;
	
	@Autowired
	private RssServices rssService;
	
	@RequestMapping(value="/getTitleList")
	public ResponseModel<List<FeedSource>> getTitleList(){
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
	
	@RequestMapping(value="/getNewsList/{sourceId}")
	public ResponseModel<List<Feed>> getNewsList(@PathVariable Long sourceId){
		List<Feed> data = new ArrayList<>();
		String response = "OK";
		try {
			log.info("get news list by title {} ",sourceId);
			data = rssService.getNewsFromRss(sourceId);
			
		} catch (Exception e) {
			response = "ERROR";
		}
		
		ResponseModel<List<Feed>> res = new ResponseModel<>();
		res.setData(data);
		res.setResponse(response);
		
		return res;
	}

}
