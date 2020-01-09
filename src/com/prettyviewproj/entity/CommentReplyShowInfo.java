package com.prettyviewproj.entity;

public class CommentReplyShowInfo {
	private String userID;

	private String userName;

	private String userHeadPhoto;

	private String worksID;

	private String commentContent;
	
	private String commentID;

	private String commentTime;

	private String replyUserID;

	private String replyUserName;

	private String replyUserHeadPhoto;
	
	private String replyContent;
	
	private String replyTime;
	
	private String CommentFabulousNum;

	public CommentReplyShowInfo(String userID, String userName, String userHeadPhoto, String worksID,
			String commentContent, String commentID, String commentTime, String replyUserID, String replyUserName,
			String replyUserHeadPhoto, String replyContent, String replyTime, String commentFabulousNum) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userHeadPhoto = userHeadPhoto;
		this.worksID = worksID;
		this.commentContent = commentContent;
		this.commentID = commentID;
		this.commentTime = commentTime;
		this.replyUserID = replyUserID;
		this.replyUserName = replyUserName;
		this.replyUserHeadPhoto = replyUserHeadPhoto;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		CommentFabulousNum = commentFabulousNum;
	}

	public CommentReplyShowInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHeadPhoto() {
		return userHeadPhoto;
	}

	public void setUserHeadPhoto(String userHeadPhoto) {
		this.userHeadPhoto = userHeadPhoto;
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

	public String getCommentID() {
		return commentID;
	}

	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getReplyUserID() {
		return replyUserID;
	}

	public void setReplyUserID(String replyUserID) {
		this.replyUserID = replyUserID;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public String getReplyUserHeadPhoto() {
		return replyUserHeadPhoto;
	}

	public void setReplyUserHeadPhoto(String replyUserHeadPhoto) {
		this.replyUserHeadPhoto = replyUserHeadPhoto;
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

	public String getCommentFabulousNum() {
		return CommentFabulousNum;
	}

	public void setCommentFabulousNum(String commentFabulousNum) {
		CommentFabulousNum = commentFabulousNum;
	}

	
}
