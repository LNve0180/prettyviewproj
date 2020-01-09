package com.prettyviewproj.entity;

public class UserInfo {
	private String userID;
	
	private String userPassword;
	
	private String userName;
	
	private String userSex;
	
	private String userOccupation;
	
	private String userEmail;
	
	private String userHeadPhoto;
	
	private String userIntroduction;
	
	private String userPhone;
	
	private int userIDStatus;
	
	private int creatorStatus;
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserInfo(String userID, String userPassword, String userName,
			String userSex, String userOccupation, String userEmail,
			String userHeadPhoto, String userIntroduction, String userPhone,
			int userIDStatus, int creatorStatus) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSex = userSex;
		this.userOccupation = userOccupation;
		this.userEmail = userEmail;
		this.userHeadPhoto = userHeadPhoto;
		this.userIntroduction = userIntroduction;
		this.userPhone = userPhone;
		this.userIDStatus = userIDStatus;
		this.creatorStatus = creatorStatus;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	
	public String getUserPhone() {
		return userPhone;
	}
	
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
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
	
	
}
