package com.prettyviewproj.entity;

public class WorksReviewInfo {
	private String worksID;
	private String worksName;
	private String reportNum;
	
	public WorksReviewInfo() {

	}
	public WorksReviewInfo(String worksID, String worksName, String reportNum) {
		this.worksID = worksID;
		this.worksName = worksName;
		this.reportNum = reportNum;
	}
	public String getWorksID() {
		return worksID;
	}
	public void setWorksID(String worksID) {
		this.worksID = worksID;
	}
	public String getWorksName() {
		return worksName;
	}
	public void setWorksName(String worksName) {
		this.worksName = worksName;
	}
	public String getReportNum() {
		return reportNum;
	}
	public void setReportNum(String reportNum) {
		this.reportNum = reportNum;
	}
}
