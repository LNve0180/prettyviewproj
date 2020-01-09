/**
 *
 */
package com.prettyviewproj.tools;

import java.util.ArrayList;
import java.util.List;

import com.prettyviewproj.entity.CommentInfo;
import com.prettyviewproj.entity.NoticeInfo;
import com.prettyviewproj.entity.ReportWorksInfo;
import com.prettyviewproj.jieba.JiebaSegmenter;

/**
 * @author:黄羽伦
 * @description:动态生成模糊查询sql语句
 * @date:2018年12月28日
 */
public class SqlTool {

	public static String getLikeWorksSql(String searchContent) {

		String sql = "select distinct * from works_show_info where worksStatus=1 AND userIDStatus=1 ";

		String temp = searchContent.replaceAll("\\s*", "");

		char[] ch = temp.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			sql += "AND worksName LIKE '%" + ch[i] + "%' ";

		}

		return sql;
	}

	public static String getLikeWorksSql2(String searchContent) {

		String sql = "select distinct * from works_show_info where worksStatus=1 and aditingStatus=1 AND userIDStatus=1 ";
		JiebaSegmenter segmenter = new JiebaSegmenter();

		List<String> temp = segmenter.sentenceProcess(searchContent);

		for (int i = 0; i < temp.size(); i++) {
			if(i==0) {
				sql+="and (worksName LIKE '%" + temp.get(i) + "%' ";
			}else {
				sql += "or worksName LIKE '%" + temp.get(i) + "%' ";
			}
			if(i==temp.size()-1) {
				sql+=")";
			}
		}
		System.out.println(sql);
		return sql;
	}

	public static String getLikeUserSql2(String searchContent) {

		String sql = "select * from user_show_info where userIDStatus=1 AND creatorStatus=1 ";

		JiebaSegmenter segmenter = new JiebaSegmenter();

		List<String> temp = segmenter.sentenceProcess(searchContent);

		for (int i = 0; i < temp.size(); i++) {
			if(i==0) {
				sql+="and (userName LIKE '%" + temp.get(i) + "%' ";
			}else {
				sql += "or userName LIKE '%" + temp.get(i) + "%' ";
			}
			if(i==temp.size()-1) {
				sql+=")";
			}
		}
		System.out.println(sql);
		return sql;
	}

	public static String getLikeUserSql(String searchContent) {

		String sql = "select * from user_show_info where userIDStatus=1 AND creatorStatus=1 ";

		String temp = searchContent.replaceAll("\\s*", "");

		char[] ch = temp.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			sql += "AND userName LIKE '%" + ch[i] + "%' ";

		}

		return sql;
	}
	
	public static String getSqlByCommentIDs(ArrayList<String> listCommentID) {
		int i;
		String inID="";
			for(i = 0;i < listCommentID.size(); i++) {
				inID += listCommentID.get(i)+",";
			}
			System.out.println(inID);
			//去逗号
			inID = inID.substring(0,inID.length() - 1);//去掉最后的,号
			String sql = "SELECT * FROM commentInfoList where commentID IN ("+inID+")";
			System.out.println(sql);
		return sql;
	}
	
	public static String getSqlByCommentInfos(ArrayList<CommentInfo> commentInfos) {
		String sql="";
		String inID="";
		int i;
		for(i = 0 ; i < commentInfos.size(); i++) {
			inID += commentInfos.get(i).getCommentID()+",";
		}
		//去逗号
		inID = inID.substring(0,inID.length() - 1);//去掉最后的,号
		sql = "UPDATE commentinfolist SET commentStatus = 0 WHERE commentID IN ("+inID+")";
		return sql;
	}
	
	public static String getSqlByNoticeInfos(ArrayList<NoticeInfo> noticeInfos) {
		String sql="";
		String sqlTemp="";
		int i;
		for(i = 0; i < noticeInfos.size(); i++) {
			sqlTemp += "('"+noticeInfos.get(i).getAdminID()+"','"+noticeInfos.get(i).getNoticeContent()+"','"+noticeInfos.get(i).getNoticeTheme()+"',"
					+ " '"+noticeInfos.get(i).getNoticeTime()+"','"+noticeInfos.get(i).getUserID()+"'),";
		}
		//去逗号
		sqlTemp = sqlTemp.substring(0,sqlTemp.length() - 1);//去掉最后的,号
		sql = "INSERT INTO noticeinfolist (adminID,noticeContent,noticeTheme,noticeTime,userID) values"+sqlTemp;
		System.out.println(sql);
		return sql;
	}
	
	public static String getSqlByReportWorksInfos(ArrayList<ReportWorksInfo> reportWorksInfos) {
		String worksID = reportWorksInfos.get(0).getWorksID();
		String reportResult = reportWorksInfos.get(0).getReportResult();
		String reportStatus = reportWorksInfos.get(0).getReportStatus()+"";
		System.out.println("sqlTool:"+worksID);
		System.out.println("sqlTool:"+reportResult);
		System.out.println("sqlTool:"+reportStatus);
		String sql="UPDATE reportWorksList SET reportResult = '"+reportResult+"' , reportStatus='"+reportStatus+"' WHERE worksID='"+worksID+"' ";
		System.out.println("sqlTool:"+sql);
		return sql;
	}
}
