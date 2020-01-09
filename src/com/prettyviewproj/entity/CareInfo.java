package com.prettyviewproj.entity;

public class CareInfo {
	private String userID;
	private String caredID;
	public CareInfo(String userID, String caredID) {
		super();
		this.userID = userID;
		this.caredID = caredID;
	}
	public CareInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCaredID() {
		return caredID;
	}
	public void setCaredID(String caredID) {
		this.caredID = caredID;
	}
	
}
