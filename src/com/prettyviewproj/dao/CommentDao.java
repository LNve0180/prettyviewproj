package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.ICommentDao;
import com.prettyviewproj.entity.CommentInfo;
import com.prettyviewproj.entity.CommentReplyShowInfo;
import com.prettyviewproj.entity.ReplyInfo;
import com.prettyviewproj.entity.ReportCommentInfo;
import com.prettyviewproj.tools.DBTool;
import com.prettyviewproj.tools.SqlTool;
import com.prettyviewproj.tools.TimeTool;

public class CommentDao implements ICommentDao {
public CommentDao() {

	}
	
	/**
	*@author:黄羽伦
	*@parm:commentInfo
	*@return:boolean
	*date:2018年12月25日
	*/
	@Override
	public boolean insertCommentInfo(CommentInfo commentInfo) {
		
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="insert into commentinfolist (userID,worksID,commentContent,commentTime) VALUES("
					+ " '"+commentInfo.getUserID()+"','"+commentInfo.getWorksID()+"','"+commentInfo.getCommentContent()+"',"
							+ " '"+commentInfo.getCommentTime()+"' ) ";
			
			int isInsert =st.executeUpdate(sql);
			
			if(isInsert>0){
				
				return true;
				
			}else{
				
				return false;
				
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
	}

	/**
	*@author:黄羽伦
	*@parm:replyInfo
	*@return:boolean
	*date:2018年12月25日
	*/
	@Override
	public boolean insertReplyInfo(ReplyInfo replyInfo) {
		
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="insert into replyInfolist (userID,commentID,replyContent,replyTime) VALUES("
					+ " '"+replyInfo.getUserID()+"','"+replyInfo.getCommentID()+"','"+replyInfo.getReplyContent()+"',"
							+ " '"+replyInfo.getReplyTime()+"' ) ";
			
			int isInsert =st.executeUpdate(sql);
			
			if(isInsert>0){
				
				return true;
				
			}else{
				
				return false;
				
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
	}

	/**
	*@author:黄羽伦
	*@parm:userID,commentID
	*@return:boolean
	*date:2018年12月25日
	*/
	@Override
	public boolean insertCommentFabulousInfo(String userID, String commentID) {

		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
		
			String sql="insert into commentfabulouslist(userID,commentID) values('"+userID+"','"+commentID+"')";
			
			int isInsert =st.executeUpdate(sql);
			
			if(isInsert>0){
				
				return true;
				
			}else{
				
				return false;
				
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
	}

	/**
	*@author:黄羽伦
	*@parm:reportCommentInfo
	*@return:boolean
	*date:2018年12月25日
	*/
	@Override
	public boolean insertReportCommentInfo(ReportCommentInfo reportCommentInfo) {
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="insert into reportCommentList(userID,commentID,reportCommentReason,reportCommentTime) values("
					+ " '"+reportCommentInfo.getUserID()+"','"+reportCommentInfo.getCommentID()+"',"
							+ " '"+reportCommentInfo.getReportCommentReason()+"','"+reportCommentInfo.getReportCommentTime()+"' )";
			
			int isInsert =st.executeUpdate(sql);
			
			if(isInsert>0){
				
				return true;
				
			}else{
				
				return false;
				
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		return false;
		
	}

	@Override
	public ArrayList<CommentReplyShowInfo> selectCommentReplyInfoByWorksID(String worksID) {
		// TODO Auto-generated method stub
		ArrayList<CommentReplyShowInfo> commentReplyInfoList=new  ArrayList<CommentReplyShowInfo>();
		Statement st=null;
		ResultSet rs=null;
		
		try {
			st=DBTool.getConnection().createStatement();
			String sql="select * from comment_reply_show_info where worksID="+worksID;
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				String userID=rs.getInt(1)+"";
				String userName=rs.getString(2);
				String userHeadPhoto=rs.getString(3);
				String commentContent=rs.getString(5);
				String commentID=rs.getInt(6)+"";
				String commentTime=TimeTool.getTimeToString(rs.getTimestamp(7));
				String replyUserID=rs.getString(8);
				String replyUserName=rs.getString(9);
				String replyUserHeadPhoto=rs.getString(10);
				String replyContent=rs.getString(11);
				String replyTime=rs.getString(12);
				String commentFabulousNum=rs.getString(13);
				commentReplyInfoList.add(new CommentReplyShowInfo(userID, userName, userHeadPhoto, worksID, commentContent, commentID, commentTime, replyUserID, replyUserName, replyUserHeadPhoto, replyContent,replyTime, commentFabulousNum) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commentReplyInfoList;
		
	}

	@Override
	public ArrayList<ReportCommentInfo> selectAllReportCommentInfo() {
		ArrayList<ReportCommentInfo> arrayReportCommentInfos = new ArrayList<ReportCommentInfo>();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="SELECT * from reportCommentList where reportCommentStatus = 1 ";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				ReportCommentInfo reportCommentInfo=new ReportCommentInfo();
				reportCommentInfo.setUserID(rs.getString(1));
				reportCommentInfo.setCommentID(rs.getString(2));
				reportCommentInfo.setReportCommentReason(rs.getString(3));
				reportCommentInfo.setReportCommentStatus(rs.getInt(4));
				reportCommentInfo.setReportCommentResult(rs.getString(5));
				String time=TimeTool.getTimeToString(rs.getTimestamp(6));
				reportCommentInfo.setReportCommentTime(time);
				arrayReportCommentInfos.add(reportCommentInfo);
			}
			return arrayReportCommentInfos;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAllReportStatus(ArrayList<ReportCommentInfo> arrayReportCommentInfos) {
		Statement st=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="UPDATE reportcommentlist SET reportCommentStatus = 0";
			int isUpdate = st.executeUpdate(sql);
			if(isUpdate > 0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<CommentInfo> selectCommentInfoByListCommentID(ArrayList<String> listCommentID) {
		Statement st=null;
		ResultSet rs=null;
		ArrayList<CommentInfo> commentInfos = new ArrayList<CommentInfo>();
		try {
			st=DBTool.getConnection().createStatement();
			String sql=SqlTool.getSqlByCommentIDs(listCommentID);
			rs = st.executeQuery(sql);
			while(rs.next()) {
				CommentInfo commentInfo = new CommentInfo();
				commentInfo.setCommentID(rs.getString(1));
				commentInfo.setUserID(rs.getString(2));
				commentInfo.setWorksID(rs.getString(3));
				commentInfo.setCommentContent(rs.getString(4));
				commentInfo.setCommentTime(rs.getString(5));
				commentInfo.setCommentStatus(rs.getInt(6));
				commentInfo.setCommentAditingStatus(rs.getInt(7));
				commentInfos.add(commentInfo);
			}
			return commentInfos;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateCommentInfoByCommentInfos(ArrayList<CommentInfo> commentInfos) {
		Statement st=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql=SqlTool.getSqlByCommentInfos(commentInfos);
			int isUpdate = st.executeUpdate(sql);
			if(isUpdate > 0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	*@author:黄羽伦
	*@parm:commentID
	*@return:boolean
	*date:2018年12月25日
	*//*
	@Override
	public boolean updateCommentAditingStatusByCommentID(String commentID) {
		
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="UPDATE commentinfolist SET commentAditingStatus=2 WHERE commentID='"+commentID+"' ";
			
			int isUpdate = st.executeUpdate(sql);
			
			if(isUpdate>0) {
				
				return true;
			}else {
				
				return false;
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}
*/
}
