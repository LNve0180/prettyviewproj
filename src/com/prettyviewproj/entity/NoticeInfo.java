package com.prettyviewproj.entity;

public class NoticeInfo {
	
	private String noticeID;
	
	private String adminID;
	
	private String noticeContent;
	
	private String noticeTheme;

	private String noticeTime;
	
	private int noticeStatus;
	
	private String adminName;
	
	private String userID;
	
	public NoticeInfo() {

	}
	
	public NoticeInfo(String adminID, String noticeContent, String noticeTheme, String noticeTime, int noticeStatus,
			String userID) {
		this.adminID = adminID;
		this.noticeContent = noticeContent;
		this.noticeTheme = noticeTheme;
		this.noticeTime = noticeTime;
		this.noticeStatus = noticeStatus;
		this.userID = userID;
	}
	
	public NoticeInfo(String noticeID, String adminID, String noticeContent,
			String noticeTheme, String noticeTime,
			int noticeStatus ) {
		
		this.noticeID = noticeID;
		this.adminID = adminID;
		this.noticeContent = noticeContent;
		this.noticeTheme = noticeTheme;
		this.noticeTime = noticeTime;
		this.noticeStatus = noticeStatus;
	}

	public NoticeInfo(String noticeID,String adminID, String noticeContent, String noticeTheme, String noticeTime, int noticeStatus,
			String adminName) {
		
		this.noticeID = noticeID;
		
		this.adminID = adminID;
		
		this.noticeContent = noticeContent;
		
		this.noticeTheme = noticeTheme;
		
		this.noticeTime = noticeTime;
		
		this.noticeStatus = noticeStatus;
		
		this.adminName = adminName;
	}


	public String getNoticeID() {
		
		return noticeID;
		
	}
	public void setNoticeID(String noticeID) {
		
		this.noticeID = noticeID;
		
	}
	
	public String getAdminID() {
		
		return adminID;
		
	}
	public void setAdminID(String adminID) {
		
		this.adminID = adminID;
		
	}
	
	public String getNoticeContent() {
		
		return noticeContent;
	}
	
	public void setNoticeContent(String noticeContent) {
		
		this.noticeContent = noticeContent;
		
	}
	
	public String getNoticeTheme() {
		
		return noticeTheme;
	}
	public void setNoticeTheme(String noticeTheme) {
		
		this.noticeTheme = noticeTheme;
		
	}

	public String getNoticeTime() {
		
		return noticeTime;
		
	}
	public void setNoticeTime(String noticeTime) {
		
		this.noticeTime = noticeTime;
		
	}
	
	public int getNoticeStatus() {
		
		return noticeStatus;
	}
	
	public void setNoticeStatus(int noticeStatus) {
		
		this.noticeStatus = noticeStatus;
		
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	
}
