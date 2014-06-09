package com.namoo.event.domain;


public class Event {
	//
	private int id;
	private String name;
	private String openDate;
	private String summaryDes;
	private String description;
	private ImageFile smallImg;
	private ImageFile largeImg;
	
	//---------------------------------------------------------
	
	public Event() {
		//
	}
	
	//---------------------------------------------------------
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getSummaryDes() {
		return summaryDes;
	}
	public void setSummaryDes(String summaryDes) {
		this.summaryDes = summaryDes;
	}
	public ImageFile getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(ImageFile smallImg) {
		this.smallImg = smallImg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ImageFile getLargeImg() {
		return largeImg;
	}
	public void setLargeImg(ImageFile largeImg) {
		this.largeImg = largeImg;
	}
}
