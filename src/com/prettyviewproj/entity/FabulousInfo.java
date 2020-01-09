package com.prettyviewproj.entity;

public class FabulousInfo {
	private String userID;
	
	private String worksID;
	
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
	
	public FabulousInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FabulousInfo(String userID, String worksID) {
		super();
		this.userID = userID;
		this.worksID = worksID;
	}
	
}
