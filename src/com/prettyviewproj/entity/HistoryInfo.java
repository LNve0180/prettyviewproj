package com.prettyviewproj.entity;


public class HistoryInfo {
	
	private String userID;
	
	private String worksID;
	
	private String historyTime;

	private String worksName;
	
	private String worksCatrgory;
	
	private String userName;//作者的
	
	private String uploadAddress;
	
	private String userheadPhoto;
	
	private String worksIntroduction;
	
	
	
	public HistoryInfo(String userID, String worksID, String historyTime) {
		
		this.userID = userID;
		
		this.worksID = worksID;
		
		this.historyTime = historyTime;
		
	}
	
	public HistoryInfo(String worksID, String historyTime,
			String worksName,String worksCatrgory,String userName,String uploadAddress,
			String userheadPhoto,String worksIntroduction) {
		
		this.worksID = worksID;
		
		this.historyTime = historyTime;
		
		this.worksName = worksName;
		
		this.worksCatrgory = worksCatrgory;
		
		this.userName = userName;
		
		this.uploadAddress = uploadAddress;
		
		this.userheadPhoto = userheadPhoto;
		
		this.worksIntroduction = worksIntroduction;
		
	}
	
	public HistoryInfo() {
		
		
	}
	
	public String getUserID() {
		
		return userID;
		
	}
	
	public void setUserID(String userID) {
		
		this.userID = userID;
		
	}
	
	public String getWorksID() {
		
		return worksID;
		
	}
	
	public void setWorksID(String worksID) {
		
		this.worksID = worksID;
		
	}
	
	public String getHistoryTime() {
		
		return historyTime;
		
	}
	
	public void setHistoryTime(String historyTime) {
		
		this.historyTime = historyTime;
		
	}
	
	public String getWorksName() {
		
		return worksName;
		
	}

	public void setWorksName(String worksName) {
		
		this.worksName = worksName;
		
	}

	public String getWorksCatrgory() {
		
		return worksCatrgory;
		
	}

	public void setWorksCatrgory(String worksCatrgory) {
		
		this.worksCatrgory = worksCatrgory;
		
	}

	public String getUserName() {
		
		return userName;
		
	}

	public void setUserName(String userName) {
		
		this.userName = userName;
		
	}

	public String getUploadAddress() {
		
		return uploadAddress;
		
	}

	public void setUploadAddress(String uploadAddress) {
		
		this.uploadAddress = uploadAddress;
		
	}

	public String getUserheadPhoto() {
		
		return userheadPhoto;
		
	}

	public void setUserheadPhoto(String userheadPhoto) {
		
		this.userheadPhoto = userheadPhoto;
		
	}

	public String getWorksIntroduction() {
		
		return worksIntroduction;
		
	}

	public void setWorksIntroduction(String worksIntroduction) {
		
		this.worksIntroduction = worksIntroduction;
		
	}
	
}
