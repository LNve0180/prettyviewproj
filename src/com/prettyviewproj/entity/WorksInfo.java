package com.prettyviewproj.entity;


public class WorksInfo {
	private String worksID;
	
	private String userID;
	
	private String worksName;
	
	private String worksIntroduction;
	
	private String uploadTime;
	
	private String uploadAddress;
	
	private int aditingStatus;
	
	private String aditingTime;
	
	private int worksStatus;
	
	private String worksCategory;

	
	
	public WorksInfo(String worksID, String userID, String worksName, String worksIntroduction, String uploadTime,
			String uploadAddress, int aditingStatus, String aditingTime, int worksStatus, String worksCategory) {
		super();
		this.worksID = worksID;
		this.userID = userID;
		this.worksName = worksName;
		this.worksIntroduction = worksIntroduction;
		this.uploadTime = uploadTime;
		this.uploadAddress = uploadAddress;
		this.aditingStatus = aditingStatus;
		this.aditingTime = aditingTime;
		this.worksStatus = worksStatus;
		this.worksCategory = worksCategory;
	}
	

	public WorksInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getWorksID() {
		return worksID;
	}

	public void setWorksID(String worksID) {
		this.worksID = worksID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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
