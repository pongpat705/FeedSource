package com.feedhub;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.feedhub.model.Feed;
import com.feedhub.services.RssServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedHubApplicationTests {

	@Autowired
	private RssServices rssService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void test1() {
		List<Feed> feedList = rssService.getNewsFromRss(1L);
		for (Feed feed : feedList) {
			System.out.println(feed.getTitle());
		}
		assertNotNull(feedList);
	}

}

