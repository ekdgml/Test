package com.namoo.event.web.controller.cmd;


public class EventCommand {
	//
	private String id;
	private String name;
	private String openDate;
	private String summaryDes;
	private String description;
	
	//--------------------------------------------
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
