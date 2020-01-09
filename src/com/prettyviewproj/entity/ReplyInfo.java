package com.prettyviewproj.entity;

public class ReplyInfo {
	private String replyID;
	private String userID;
	private String commentID;
	private String replyContent;
	private String replyTime;
	private int replyStatus;
	public ReplyInfo() {
		
	}
	public ReplyInfo(String replyID, String userID, String commentID,
			String replyContent, String replyTime, int replyStatus) {

		this.replyID = replyID;
		this.userID = userID;
		this.commentID = commentID;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyStatus = replyStatus;
	}
	
	public ReplyInfo(String userID, String commentID,
			String replyContent, String replyTime) {

		this.userID = userID;
		this.commentID = commentID;
		this.replyContent = replyContent;
		this.replyTime = replyTime;

	}
	
	public String getReplyID() {
		return replyID;
	}
	public void setReplyID(String replyID) {
		this.replyID = replyID;
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
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public int getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(int replyStatus) {
		this.replyStatus = replyStatus;
	}
	
}
