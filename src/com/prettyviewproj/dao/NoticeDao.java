package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.INoticeDao;
import com.prettyviewproj.entity.AnnouncementInfo;
import com.prettyviewproj.entity.NoticeInfo;
import com.prettyviewproj.tools.DBTool;
import com.prettyviewproj.tools.SqlTool;
import com.prettyviewproj.tools.TimeTool;

public class NoticeDao implements INoticeDao { 
	
	private String noticeinfolist ="noticeinfolist";
	private String adminInfoList = "adminInfoList";
	/**
	*@author:黄羽伦
	*@parm:null
	*@return:noticeInfo
	*date:2018年12月24日
	*/
	
	@Override
	public ArrayList<NoticeInfo> selectAllNoticeInfo() {
		ArrayList<NoticeInfo> noticeInfo = new ArrayList<NoticeInfo>();
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql="SELECT "+noticeinfolist+".*,"+adminInfoList+".adminName  "
					+ "from "+adminInfoList+","+noticeinfolist+"  "
					+ "WHERE "+noticeinfolist+".noticeStatus=1 "
					+ "GROUP BY "+noticeinfolist+".noticeID "
					+ "ORDER BY "+noticeinfolist+".noticeTime DESC ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				NoticeInfo notice = new NoticeInfo();
				notice.setNoticeID(rs.getInt(1)+"");
				notice.setAdminID(rs.getInt(2)+"");
				notice.setNoticeContent(rs.getString(3));
				notice.setNoticeTheme(rs.getString(4));
				String time = TimeTool.getTimeToString(rs.getTimestamp(5));
				notice.setNoticeTime(time);
				notice.setNoticeStatus(rs.getInt(6));
				notice.setAdminName(rs.getString(7));
				noticeInfo.add(notice);
			}
			return noticeInfo;
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean insertNoticeInfoByNoticeInfo(NoticeInfo noticeInfo) {
		// TODO Auto-generated method stub
		boolean insertResult=false;
		Statement st=null;
		try {
			st=DBTool.getConnection().createStatement();
			String  sql="insert into noticeinfolist(adminID,noticeContent,noticeTheme,noticeTime,userID) values("+noticeInfo.getAdminID()+",'"+noticeInfo.getNoticeContent()+"','"+noticeInfo.getNoticeTheme()+"','"+noticeInfo.getNoticeTime()+"',"+noticeInfo.getUserID()+")";
			if(st.executeUpdate(sql)==1) {
				insertResult=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return insertResult;
	}

	@Override
	public ArrayList<NoticeInfo> selectNoticeInfoByUserID(String userID) {
		ArrayList<NoticeInfo> noticeInfo = new ArrayList<NoticeInfo>();
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql="SELECT "+noticeinfolist+".*,"+adminInfoList+".adminName  "
					+ "from "+adminInfoList+","+noticeinfolist+"  "
					+ "WHERE "+noticeinfolist+".noticeStatus != 2 "
					+ "AND userID = '"+userID+"' "
					+ "GROUP BY "+noticeinfolist+".noticeID "
					+ "ORDER BY "+noticeinfolist+".noticeTime DESC ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				NoticeInfo notice = new NoticeInfo();
				notice.setNoticeID(rs.getInt(1)+"");
				notice.setAdminID(rs.getInt(2)+"");
				notice.setNoticeContent(rs.getString(3));
				notice.setNoticeTheme(rs.getString(4));
				String time = TimeTool.getTimeToString(rs.getTimestamp(5));
				notice.setNoticeTime(time);
				notice.setNoticeStatus(rs.getInt(6));
				notice.setAdminName(rs.getString(7));
				noticeInfo.add(notice);
			}
			return noticeInfo;
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateNoticeStatusByUserID(String userID) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql="UPDATE noticeinfolist SET noticeStatus = 0 WHERE userID = '"+userID+"'";
			int isUpdate = st.executeUpdate(sql);
			if(isUpdate > 0) {
				return true;
			}else {
				return false;
			}
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertNoticeInfoByArrayNoticeInfo(ArrayList<NoticeInfo> noticeInfos) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql=SqlTool.getSqlByNoticeInfos(noticeInfos);
			int isInsert = st.executeUpdate(sql);
			if(isInsert > 0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



}
