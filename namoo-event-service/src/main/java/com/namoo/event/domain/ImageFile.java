package com.namoo.event.domain;

public class ImageFile {
	//
	private String contentType;
	private String fileName;

	//------------------------------------------------
	
	public ImageFile() {
		//
	}
	
	public ImageFile(String contentType, String fileName) {
		//
		this.contentType = contentType;
		this.fileName = fileName;
	}
	//------------------------------------------------
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
