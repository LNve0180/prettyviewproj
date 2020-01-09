package com.prettyviewproj.entity;

public class CommentFabulousInfo {
	private String userID;
	private String commentID;
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
	public CommentFabulousInfo(String userID, String commentID) {
		super();
		this.userID = userID;
		this.commentID = commentID;
	}
	public CommentFabulousInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
