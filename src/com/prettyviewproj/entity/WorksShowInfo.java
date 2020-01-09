package com.prettyviewproj.entity;

public class WorksShowInfo {
	private String userID;
	
	private String userName;
	
	private String userHeadPhoto;
	
	private int userIDStatus;
	
	private int creatorStatus;
	
	private String worksID;
	
	private String worksName;
	
	private String worksIntroduction;
	
	private String uploadTime;
	
	private String uploadAddress;
	
	private int aditingStatus;
	
	private int worksStatus;
	
	private String worksCategory;
	
	private String collectNum;

	private String fabulousNum;
	
	private String commentNum;

	public WorksShowInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorksShowInfo(String userID, String userName, String userHeadPhoto, int userIDStatus, int creatorStatus,
			String worksID, String worksName, String worksIntroduction, String uploadTime, String uploadAddress,
			int aditingStatus, int worksStatus, String worksCategory, String collectNum, String fabulousNum,
			String commentNum) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userHeadPhoto = userHeadPhoto;
		this.userIDStatus = userIDStatus;
		this.creatorStatus = creatorStatus;
		this.worksID = worksID;
		this.worksName = worksName;
		this.worksIntroduction = worksIntroduction;
		this.uploadTime = uploadTime;
		this.uploadAddress = uploadAddress;
		this.aditingStatus = aditingStatus;
		this.worksStatus = worksStatus;
		this.worksCategory = worksCategory;
		this.collectNum = collectNum;
		this.fabulousNum = fabulousNum;
		this.commentNum = commentNum;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHeadPhoto() {
		return userHeadPhoto;
	}

	public void setUserHeadPhoto(String userHeadPhoto) {
		this.userHeadPhoto = userHeadPhoto;
	}

	public int getUserIDStatus() {
		return userIDStatus;
	}

	public void setUserIDStatus(int userIDStatus) {
		this.userIDStatus = userIDStatus;
	}

	public int getCreatorStatus() {
		return creatorStatus;
	}

	public void setCreatorStatus(int creatorStatus) {
		this.creatorStatus = creatorStatus;
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

	public String getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(String collectNum) {
		this.collectNum = collectNum;
	}

	public String getFabulousNum() {
		return fabulousNum;
	}

	public void setFabulousNum(String fabulousNum) {
		this.fabulousNum = fabulousNum;
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}

	
}
