package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.IHistoryDao;
import com.prettyviewproj.entity.HistoryInfo;
import com.prettyviewproj.tools.DBTool;
import com.prettyviewproj.tools.TimeTool;

public class HistoryDao implements IHistoryDao {
	
	
	@Override
	public ArrayList<HistoryInfo> selectAllHistoryByUserID(String userID) {
		ArrayList<HistoryInfo> arrayHistoryInfo= new ArrayList<HistoryInfo>();
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql = " SELECT worksinfolist.worksID,historyinfolist.historyTime ,worksinfolist.worksName, "
					+ " worksinfolist.worksCategory,userinfolist.userName, "
					+ " worksinfolist.uploadAddress,userinfolist.userHeadPhoto,worksinfolist.worksIntroduction "
					+ " FROM worksinfolist,historyinfolist,userinfolist "
					+ " where historyinfolist.worksID = worksinfolist.worksID  "
					+ " and historyinfolist.userID='"+userID+"' "
					+ " and worksinfolist.userID=userinfolist.userID "
					+ " and worksinfolist.aditingStatus=1 "
					+ " and worksinfolist.worksStatus=1 "
					+ " ORDER BY historyinfolist.historyTime DESC ";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				HistoryInfo historyInfo = new HistoryInfo();
				
				historyInfo.setWorksID(rs.getInt(1)+"");
				
				String time = TimeTool.getTimeToString(rs.getTimestamp(2));
				
				historyInfo.setHistoryTime(time);
				
				historyInfo.setWorksName(rs.getString(3));
				
				historyInfo.setWorksCatrgory(rs.getString(4));
				
				historyInfo.setUserName(rs.getString(5));
				
				historyInfo.setUploadAddress(rs.getString(6));
				
				historyInfo.setUserheadPhoto(rs.getString(7));
				
				historyInfo.setWorksIntroduction(rs.getString(8));
				
				arrayHistoryInfo.add(historyInfo);
			}
			
			return arrayHistoryInfo;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;

	}

	@Override
	public boolean selectHistoryInfoIsExist(HistoryInfo historyInfo) {
		
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="select * from historyInfoList where userID='"+historyInfo.getUserID()+"' and"
					+ " worksID='"+historyInfo.getWorksID()+"'  ";
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
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
	public boolean deleteHistoryByHistoryInfo(HistoryInfo historyInfo) {
		
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="delete from historyInfoList where userID='"+historyInfo.getUserID()+"' and"
					+ " worksID='"+historyInfo.getWorksID()+"' and historyTime='"+historyInfo.getHistoryTime()+"' ";
			
			
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


	@Override
	public boolean insertHistoryInfo(HistoryInfo historyInfo) {

		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="insert into historyInfoList (userID,worksID,historyTime) values('"+historyInfo.getUserID()+"',"
					+ " '"+historyInfo.getWorksID()+"','"+historyInfo.getHistoryTime()+"') ";
			
			int isInsert =st.executeUpdate(sql);
			
			if(isInsert>0)
			{
				
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
	public boolean updateHistoryInfoTimeByHistoryInfo(HistoryInfo historyInfo) {
		// TODO Auto-generated method stub
Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="update historyinfolist SET historyTime='"+historyInfo.getHistoryTime()+"' where userID="+historyInfo.getUserID()+"  and worksID="+historyInfo.getWorksID();
			
			
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
}
