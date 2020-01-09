package com.prettyviewproj.entity;

import java.sql.Timestamp;

public class AnnouncementInfo {
	
	private String announcementID;
	
	private String adminID;
	
	private String announcementContent;
	
	private String announcementTheme;
	
	private String announcementTime;
	
	private int announcementStatus;
	
	private String announcementCategory;
	
	private String adminName;
	
	private String adminHeadPhoto;
	
	public AnnouncementInfo() {
		
	}
	
	public AnnouncementInfo(String announcementID, String adminID,
			String announcementContent, String announcementTheme,
			String announcementTime, int announcementStatus) {
		
		this.announcementID = announcementID;
		
		this.adminID = adminID;
		
		this.announcementContent = announcementContent;
		
		this.announcementTheme = announcementTheme;
		
		this.announcementTime = announcementTime;
		
		this.announcementStatus = announcementStatus;
		
	}
	
	public AnnouncementInfo(String adminID,
			String announcementContent, String announcementTheme,
			String announcementTime,String announcementCategory) {
		
		this.adminID = adminID;
		
		this.announcementContent = announcementContent;
		
		this.announcementTheme = announcementTheme;
		
		this.announcementTime = announcementTime;
		
		this.announcementCategory = announcementCategory;
		
	}
	
	public AnnouncementInfo(String announcementID, String adminID,
			String announcementContent, String announcementTheme,
			String announcementTime,String announcementCategory,
			int announcementStatus,String adminName,String adminHeadPhoto) {

				this.announcementID = announcementID;
				
				this.adminID = adminID;
				
				this.announcementContent = announcementContent;
				
				this.announcementTheme = announcementTheme;
				
				this.announcementTime = announcementTime;
				
				this.announcementCategory = announcementCategory;
				
				this.adminName = adminName;
				
				this.adminHeadPhoto = adminHeadPhoto;
				
				this.announcementStatus = announcementStatus;

			}
	
	public String getAnnouncementID() {
		
		return announcementID;
		
	}
	
	public void setAnnouncementID(String announcementID) {
		
		this.announcementID = announcementID;
		
	}
	
	public String getAdminID() {
		
		return adminID;
		
	}
	
	public void setAdminID(String adminID) {
		
		this.adminID = adminID;
		
	}
	
	public String getAnnouncementContent() {
		
		return announcementContent;
		
	}
	
	public void setAnnouncementContent(String announcementContent) {
		
		this.announcementContent = announcementContent;
		
	}
	
	public String getAnnouncementTheme() {
		
		return announcementTheme;
		
	}
	
	public void setAnnouncementTheme(String announcementTheme) {
		
		this.announcementTheme = announcementTheme;
		
	}
	
	public String getAnnouncementTime() {
		
		return announcementTime;
		
	}
	
	public void setAnnouncementTime(String announcementTime) {
		
		this.announcementTime = announcementTime;
		
	}
	
	public int getAnnouncementStatus() {
		
		return announcementStatus;
		
	}
	
	public void setAnnouncementStatus(int announcementStatus) {
		
		this.announcementStatus = announcementStatus;
		
	}
	
	public String getAnnouncementCategory() {
		
		return announcementCategory;
		
	}
	
	public void setAnnouncementCategory(String announcementCategory) {
		
		this.announcementCategory = announcementCategory;
		
	}
	
	public String getAdminName() {
		
		return adminName;
		
	}
	
	public void setAdminName(String adminName) {
		
		this.adminName = adminName;
		
	}
	
	public String getAdminHeadPhoto() {
		
		return adminHeadPhoto;
		
	}
	public void setAdminHeadPhoto(String adminHeadPhoto) {
		
		this.adminHeadPhoto = adminHeadPhoto;
		
	}
	
	
}
