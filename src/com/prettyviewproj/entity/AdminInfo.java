package com.prettyviewproj.entity;

public class AdminInfo {
	private String adminID;
	
	private String adminPassword;
	
	private String adminName;
	
	private String adminSex;
	
	private String adminEmail;
	
	private String adminHeadPhoto;
	
	private String adminPhone;
	
	public AdminInfo(){
		
	}
	
	public AdminInfo(String adminID, String adminPassword, String adminName,
			String adminSex, String adminEmail, String adminHeadPhoto,
			String adminPhone) {
		this.adminID = adminID;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
		this.adminSex = adminSex;
		this.adminEmail = adminEmail;
		this.adminHeadPhoto = adminHeadPhoto;
		this.adminPhone = adminPhone;
	}
	
	public String getAdminID() {
		return adminID;
	}
	
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getAdminSex() {
		return adminSex;
	}
	
	public void setAdminSex(String adminSex) {
		this.adminSex = adminSex;
	}
	
	public String getAdminEmail() {
		return adminEmail;
	}
	
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	
	public String getAdminHeadPhoto() {
		return adminHeadPhoto;
	}
	
	public void setAdminHeadPhoto(String adminHeadPhoto) {
		this.adminHeadPhoto = adminHeadPhoto;
	}
	
	public String getAdminPhone() {
		return adminPhone;
	}
	
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	
	
}
