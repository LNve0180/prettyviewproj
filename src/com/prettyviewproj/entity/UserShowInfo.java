package com.prettyviewproj.entity;

public class UserShowInfo {
	private String userID;
	
	private String userName;
	
	private String userSex;
	
	private String userOccupation;
	
	private String userHeadPhoto;
	
	private String userIntroduction;
	
	private int userIDStatus;
	
	private int creatorStatus;
	
	private String careNum;
	
	private String fansNum;

	public UserShowInfo(String userID, String userName, String userSex, String userOccupation, String userHeadPhoto,
			String userIntroduction, int userIDStatus, int creatorStatus, String careNum, String fansNum) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userSex = userSex;
		this.userOccupation = userOccupation;
		this.userHeadPhoto = userHeadPhoto;
		this.userIntroduction = userIntroduction;
		this.userIDStatus = userIDStatus;
		this.creatorStatus = creatorStatus;
		this.careNum = careNum;
		this.fansNum = fansNum;
	}

	public UserShowInfo() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserOccupation() {
		return userOccupation;
	}

	public void setUserOccupation(String userOccupation) {
		this.userOccupation = userOccupation;
	}

	public String getUserHeadPhoto() {
		return userHeadPhoto;
	}

	public void setUserHeadPhoto(String userHeadPhoto) {
		this.userHeadPhoto = userHeadPhoto;
	}

	public String getUserIntroduction() {
		return userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
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

	public String getCareNum() {
		return careNum;
	}

	public void setCareNum(String careNum) {
		this.careNum = careNum;
	}

	public String getFansNum() {
		return fansNum;
	}

	public void setFansNum(String fansNum) {
		this.fansNum = fansNum;
	}
	
}
