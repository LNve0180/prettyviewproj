package com.prettyviewproj.entity;

public class CollectShowInfo {
		
	private String collectTime;
	
	private String worksID;
	
	private String worksName;
	
	private String worksIntroduction;
	
	private String uploadTime;
	
	private String uploadAddress;
	
	private int aditingStatus;
	
	private String aditingTime;
	
	private int worksStatus;
	
	private String worksCategory;

	public CollectShowInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectShowInfo(String collectTime, String worksID, String worksName, String worksIntroduction,
			String uploadTime, String uploadAddress, int aditingStatus, String aditingTime, int worksStatus,
			String worksCategory) {
		super();
		this.collectTime = collectTime;
		this.worksID = worksID;
		this.worksName = worksName;
		this.worksIntroduction = worksIntroduction;
		this.uploadTime = uploadTime;
		this.uploadAddress = uploadAddress;
		this.aditingStatus = aditingStatus;
		this.aditingTime = aditingTime;
		this.worksStatus = worksStatus;
		this.worksCategory = worksCategory;
	}

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}

	public String getWorksID() {
		return worksID;
	}

	public void setWorksID(String worksID) {
		this.worksID = worksID;
	}

	public String getWorksName() {
		return worksName;
	}

	public void setWorksName(String worksName) {
		this.worksName = worksName;
	}

	public String getWorksIntroduction() {
		return worksIntroduction;
	}

	public void setWorksIntroduction(String worksIntroduction) {
		this.worksIntroduction = worksIntroduction;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUploadAddress() {
		return uploadAddress;
	}

	public void setUploadAddress(String uploadAddress) {
		this.uploadAddress = uploadAddress;
	}

	public int getAditingStatus() {
		return aditingStatus;
	}

	public void setAditingStatus(int aditingStatus) {
		this.aditingStatus = aditingStatus;
	}

	public String getAditingTime() {
		return aditingTime;
	}

	public void setAditingTime(String aditingTime) {
		this.aditingTime = aditingTime;
	}

	public int getWorksStatus() {
		return worksStatus;
	}

	public void setWorksStatus(int worksStatus) {
		this.worksStatus = worksStatus;
	}

	public String getWorksCategory() {
		return worksCategory;
	}

	public void setWorksCategory(String worksCategory) {
		this.worksCategory = worksCategory;
	}
	
}
