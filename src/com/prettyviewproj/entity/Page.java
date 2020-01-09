package com.prettyviewproj.entity;

public class Page {
	private int pageNum;//当前页数
	private int totalPage;//总页数
	private int totalRecord;//总条数
	public Page() {

	}
	public Page(int pageNum, int totalPage, int totalRecord) {
		this.pageNum = pageNum;
		this.totalPage = totalPage;
		this.totalRecord = totalRecord;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
}
