package com.prettyviewproj.entity;


public class ApplicationInfo {
	
	private String applicationID;
	
	private String userID;
	
	private String userRealName;
	
	private String userIDCardNum;
	
	private String cardPhotoFace;
	
	private String cardPhotoBack;
	
//	private Timestamp applicationTime;
	
	private int creatorApplyStatus;
	
	private String applicationTime;
	
	private String userName;
	
	public ApplicationInfo() {
		
	}
	public ApplicationInfo(String applicationID, String userID,
			String userRealName, String userIDCardNum, String cardPhotoFace,
			String cardPhotoBack, String applicationTime,
			int creatorApplyStatus) {
		
		this.applicationID = applicationID;
		
		this.userID = userID;
		
		this.userRealName = userRealName;
		
		this.userIDCardNum = userIDCardNum;
		
		this.cardPhotoFace = cardPhotoFace;
		
		this.cardPhotoBack = cardPhotoBack;
		
		this.applicationTime = applicationTime;
		
		this.creatorApplyStatus = creatorApplyStatus;
		
	}
	//重写一个
	public ApplicationInfo( String userID,
			String userRealName, String userIDCardNum, String cardPhotoFace,
			String cardPhotoBack, String applicationTime) {
		
		this.userID = userID;
		
		this.userRealName = userRealName;
		
		this.userIDCardNum = userIDCardNum;
		
		this.cardPhotoFace = cardPhotoFace;
		
		this.cardPhotoBack = cardPhotoBack;
		
		this.applicationTime = applicationTime;
		
	}
			
	public ApplicationInfo(String applicationID, String userID,
			String userRealName, String userIDCardNum, String cardPhotoFace,
			String cardPhotoBack, String applicationTime,
			int creatorApplyStatus,String userName) {
		
		this.applicationID = applicationID;
		
		this.userID = userID;
		
		this.userRealName = userRealName;
		
		this.userIDCardNum = userIDCardNum;
		
		this.cardPhotoFace = cardPhotoFace;
		
		this.cardPhotoBack = cardPhotoBack;
		
		this.applicationTime = applicationTime;
		
		this.creatorApplyStatus = creatorApplyStatus;
		
		this.userName = userName;
		
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
	
	public String getCardPhotoFace()
	{
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
	
	public String getApplicationTime() {
		
		return applicationTime;
		
	}
	
	public void setApplicationTime(String applicationTime) {
		
		this.applicationTime = applicationTime;
		
	}
	
	public int getCreatorApplyStatus() {
		
		return creatorApplyStatus;
		
	}
	public void setCreatorApplyStatus(int creatorApplyStatus) {
		
		this.creatorApplyStatus = creatorApplyStatus;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
