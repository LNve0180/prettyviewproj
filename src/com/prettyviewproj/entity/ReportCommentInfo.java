package com.prettyviewproj.entity;

public class ReportCommentInfo {
	private String userID;
	private String commentID;
	private String reportCommentReason;
	private int  reportCommentStatus;
	private String reportCommentResult;
	private String reportCommentTime;
	
	
	public ReportCommentInfo(String userID, String commentID,
			String reportCommentReason, int reportCommentStatus,
			String reportCommentResult, String reportCommentTime) {
		
		this.userID = userID;
		
		this.commentID = commentID;
		
		this.reportCommentReason = reportCommentReason;
		
		this.reportCommentStatus = reportCommentStatus;
		
		this.reportCommentResult = reportCommentResult;
		
		this.reportCommentTime = reportCommentTime;
		
	}
	
	public ReportCommentInfo(String userID, String commentID,
			String reportCommentReason,String reportCommentTime) {
		
		this.userID = userID;
		
		this.commentID = commentID;
		
		this.reportCommentReason = reportCommentReason;
		
		this.reportCommentTime = reportCommentTime;
		
	}
	
	public ReportCommentInfo() {
		
	}
	
	public String getUserID() {
		
		return userID;
		
	}
	
	public void setUserID(String userID) {
		
		this.userID = userID;
		
	}
	
	public String getCommentID() {
		
		return commentID;
		
	}
	
	public void setCommentID(String commentID) {
		
		this.commentID = commentID;
		
	}
	
	public String getReportCommentReason() {
		
		return reportCommentReason;
		
	}
	
	public void setReportCommentReason(String reportCommentReason) {
		
		this.reportCommentReason = reportCommentReason;
		
	}
	
	public int getReportCommentStatus() {
		
		return reportCommentStatus;
		
	}
	
	public void setReportCommentStatus(int reportCommentStatus) {
		
		this.reportCommentStatus = reportCommentStatus;
		
	}
	
	public String getReportCommentResult() {
		
		return reportCommentResult;
		
	}
	
	public void setReportCommentResult(String reportCommentResult) {
		
		this.reportCommentResult = reportCommentResult;
		
	}
	
	public String getReportCommentTime() {
		
		return reportCommentTime;
		
	}
	
	public void setReportCommentTime(String reportCommentTime) {
		
		this.reportCommentTime = reportCommentTime;
		
	}

	
	
}
