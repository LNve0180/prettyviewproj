package com.prettyviewproj.entity;
/*
 * 月作品实体
 * author:huangyulun
 * date:2019/04/22
 * */
public class WorksLastMonthData {

	private String worksDate;//日期
	private String worksNum;//日期当天作品数量
	public WorksLastMonthData() {;
	}
	public WorksLastMonthData(String worksDate, String worksNum) {
		this.worksDate = worksDate;
		this.worksNum = worksNum;
	}
	public String getWorksDate() {
		return worksDate;
	}
	public void setWorksDate(String worksDate) {
		this.worksDate = worksDate;
	}
	public String getWorksNum() {
		return worksNum;
	}
	public void setWorksNum(String worksNum) {
		this.worksNum = worksNum;
	}
	
}
