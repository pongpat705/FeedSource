package com.feedhub.model;

import java.util.ArrayList;

public class Channel {

	ArrayList < Object > link = new ArrayList < Object > ();
	 private String title;
	 Image ImageObject;
	 private String description;
	 private String language;
	 private String copyright;
	 private String pubDate;
	 ArrayList < Object > item = new ArrayList < Object > ();
	public ArrayList<Object> getLink() {
		return link;
	}
	public void setLink(ArrayList<Object> link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Image getImageObject() {
		return ImageObject;
	}
	public void setImageObject(Image imageObject) {
		ImageObject = imageObject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public ArrayList<Object> getItem() {
		return item;
	}
	public void setItem(ArrayList<Object> item) {
		this.item = item;
	}
	 
}
