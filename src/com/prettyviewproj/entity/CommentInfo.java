package com.prettyviewproj.entity;

import java.sql.Timestamp;

public class CommentInfo {
	
	private String commentID;
	
	private String userID;
	
	private String worksID;
	
	private String commentContent;
	
	private String commentTime;
	
	private int commentStatus;
	
	private int commentAditingStatus;
	
	public CommentInfo(String commentID, String userID, String worksID,
			String commentContent, String commentTime, int commentStatus,
			int commentAditingStatus) {
		

		this.commentID = commentID;
		
		this.userID = userID;
		
		this.worksID = worksID;
		
		this.commentContent = commentContent;
		
		this.commentTime = commentTime;
		
		this.commentStatus = commentStatus;
		
		this.commentAditingStatus = commentAditingStatus;
		
	}
	
	
	public CommentInfo() {
		
	}
	
	public CommentInfo(String userID, String worksID,
			String commentContent, String commentTime) {
		
		this.userID = userID;
		
		this.worksID = worksID;
		
		this.commentContent = commentContent;
		
		this.commentTime = commentTime;
		
	}
	
	
	public String getCommentID() {
		return commentID;
	}
	public void setCommentID(String commentID) {
		this.commentID = commentID;
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
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public int getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(int commentStatus) {
		this.commentStatus = commentStatus;
	}
	public int getCommentAditingStatus() {
		return commentAditingStatus;
	}
	public void setCommentAditingStatus(int commentAditingStatus) {
		this.commentAditingStatus = commentAditingStatus;
	}
	
	
}
