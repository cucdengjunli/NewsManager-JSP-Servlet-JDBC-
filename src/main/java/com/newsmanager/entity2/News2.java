package com.newsmanager.entity2;

import java.util.Date;
import java.util.*;

//新闻表对应的实体类

public class News2 {
	private Integer newsId;
	private String newstitle;
	private String newsContent;
	private String newsStatus;
	private String newsType;
	private Date createTime;
	
	public News2() {
		super();
	}
		
	public News2(Integer newsId, String newstitle, String newsContent, String newsStatus, 
			String newsType, Date createTime) {
		super();
		this.newsId = newsId;
		this.newstitle = newstitle;
		this.newsContent = newsContent;
		this.newsStatus = newsStatus;
		this.newsType = newsType;
		this.createTime = createTime;
	}
		
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsStatus() {
		return newsStatus;
	}
	public void setNewsStatus(String newsStatus) {
		this.newsStatus = newsStatus;
	}
	public String getNewsType() {
		return newsType;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}		
}


