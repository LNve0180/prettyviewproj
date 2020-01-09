package com.prettyviewproj.entity;

public class PersonalMessageInfo {
	
	private String userID;
	
	private String whisperedID;
	
	private String whisperContent;
	
	private String whisperTime;
	
	private int whisperStatus;
	
	private String whisperedName;
	
	public PersonalMessageInfo() {
		
		// TODO Auto-generated constructor stub
	}
	public PersonalMessageInfo(String userID, String whisperedID,
			String whisperContent, String whisperTime, int whisperStatus,String whisperedName) {
		
		this.userID = userID;
		
		this.whisperedID = whisperedID;
		
		this.whisperContent = whisperContent;
		
		this.whisperTime = whisperTime;
		
		this.whisperStatus = whisperStatus;
		
	}
	
	public String getUserID() {
		
		return userID;
		
	}
	
	public void setUserID(String userID) {
		
		this.userID = userID;
		
	}
	
	public String getWhisperedID() {
		
		return whisperedID;
		
	}
	
	public void setWhisperedID(String whisperedID) {
		
		this.whisperedID = whisperedID;
		
	}
	
	public String getWhisperContent() {
		
		return whisperContent;
		
	}
	
	public void setWhisperContent(String whisperContent) {
		
		this.whisperContent = whisperContent;
		
	}
	
	public String getWhisperTime() {
		
		return whisperTime;
		
	}
	
	public void setWhisperTime(String whisperTime) {
		
		this.whisperTime = whisperTime;
		
	}
	
	public int getWhisperStatus() {
		
		return whisperStatus;
		
	}
	
	public void setWhisperStatus(int whisperStatus) {
		
		this.whisperStatus = whisperStatus;
		
	}
	public String getWhisperedName() {
		return whisperedName;
	}
	public void setWhisperedName(String whisperedName) {
		this.whisperedName = whisperedName;
	}
	
}
