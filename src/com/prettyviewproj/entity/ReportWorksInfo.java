package com.prettyviewproj.entity;

public class ReportWorksInfo {
	private String userID;
	private String worksID;
	private String reportReason;
	private String reportTime;
	private String reportResult;
	private int reportStatus;
	
	public ReportWorksInfo() {
		
	}
	public ReportWorksInfo(String userID, String worksID, String reportReason,
			String reportTime, String reportResult, int reportStatus) {
		this.userID = userID;
		this.worksID = worksID;
		this.reportReason = reportReason;
		this.reportTime = reportTime;
		this.reportResult = reportResult;
		this.reportStatus = reportStatus;
	}
	
	public ReportWorksInfo(String userID, String worksID, String reportReason, String reportTime) {
		
		this.userID = userID;
		
		this.worksID = worksID;
		
		this.reportReason = reportReason;
		
		this.reportTime = reportTime;
		
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
	
	public String getReportReason() {
		
		return reportReason;
		
	}
	
	public void setReportReason(String reportReason) {
		
		this.reportReason = reportReason;
		
	}
	
	public String getReportTime() {
		
		return reportTime;
		
	}
	
	public void setReportTime(String reportTime) {
		
		this.reportTime = reportTime;
		
	}
	
	public String getReportResult() {
		
		return reportResult;
		
	}
	
	public void setReportResult(String reportResult) {
		
		this.reportResult = reportResult;
		
	}
	
	public int getReportStatus() {
		
		return reportStatus;
		
	}
	
	public void setReportStatus(int reportStatus) {
		
		this.reportStatus = reportStatus;
		
	}
	
}
