package com.feedhub.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.digester.rss.Channel;
import org.apache.commons.digester.rss.Item;
import org.apache.commons.digester.rss.RSSDigester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.feedhub.entity.FeedSource;
import com.feedhub.model.Feed;
import com.feedhub.repository.FeedSourceRepository;

@Service
public class RssServices {

	@Autowired FeedSourceRepository feedRepos;
	
	public List<Feed> getNewsFromRss(Long sourceId) {

		List<Feed> result = new ArrayList<>();
		Optional<FeedSource> feedSource = feedRepos.findById(sourceId);
		if(null != feedSource) {
			String feedurl = feedSource.get().getUrl();
					try {
						RSSDigester digester=new RSSDigester();
						String feed = feedurl;
						URL url=new URL(feed);
						HttpURLConnection httpSource = (HttpURLConnection)url.openConnection();
						Channel channel=
						    (Channel)digester.parse(httpSource.getInputStream());
						if (channel==null) {
						    throw new Exception("can't communicate with " + url);
						}
						Item rssItems[]=channel.findItems();
						for (int i=0;i<rssItems.length;i++) {
							System.out.println(rssItems[i].getTitle());
							Feed x1 = new Feed();
							x1.setDescription(rssItems[i].getDescription());
							x1.setTitle(rssItems[i].getTitle());
							x1.setTimeStamp(channel.getPubDate());
							result.add(x1);
						}
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
		}
		 		return result;
	}
	
}
