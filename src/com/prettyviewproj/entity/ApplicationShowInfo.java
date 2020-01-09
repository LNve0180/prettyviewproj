package com.prettyviewproj.entity;

public class ApplicationShowInfo {
	
	private String applicationID;
	
	private String userID;
	
	private String userRealName;
	
	private String userIDCardNum;
	
	private String cardPhotoFace;
	
	private String cardPhotoBack;
	
	private int creatorApplyStatus;
	
	private String applicationTime;
	
	private String userName;
	
	private String userSex;

	public ApplicationShowInfo() {
		
	}

	public ApplicationShowInfo(String applicationID, String userID, String userRealName, String userIDCardNum,
			String cardPhotoFace, String cardPhotoBack, int creatorApplyStatus, String applicationTime, String userName,
			String userSex) {
		this.applicationID = applicationID;
		this.userID = userID;
		this.userRealName = userRealName;
		this.userIDCardNum = userIDCardNum;
		this.cardPhotoFace = cardPhotoFace;
		this.cardPhotoBack = cardPhotoBack;
		this.creatorApplyStatus = creatorApplyStatus;
		this.applicationTime = applicationTime;
		this.userName = userName;
		this.userSex = userSex;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserIDCardNum() {
		return userIDCardNum;
	}

	public void setUserIDCardNum(String userIDCardNum) {
		this.userIDCardNum = userIDCardNum;
	}

	public String getCardPhotoFace() {
		return cardPhotoFace;
	}

	public void setCardPhotoFace(String cardPhotoFace) {
		this.cardPhotoFace = cardPhotoFace;
	}

	public String getCardPhotoBack() {
		return cardPhotoBack;
	}

	public void setCardPhotoBack(String cardPhotoBack) {
		this.cardPhotoBack = cardPhotoBack;
	}

	public int getCreatorApplyStatus() {
		return creatorApplyStatus;
	}

	public void setCreatorApplyStatus(int creatorApplyStatus) {
		this.creatorApplyStatus = creatorApplyStatus;
	}

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
	
	
}
