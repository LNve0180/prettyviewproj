package com.prettyviewproj.entity;



public class CollectInfo {
	private String userID;
	
	private String worksID;
	
	private String collectTime;

	public CollectInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectInfo(String userID, String worksID, String collectTime) {
		super();
		this.userID = userID;
		this.worksID = worksID;
		this.collectTime = collectTime;
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

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}
	
	
	
}
