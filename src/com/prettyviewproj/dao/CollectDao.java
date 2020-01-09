package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.ICollectDao;
import com.prettyviewproj.entity.CollectInfo;
import com.prettyviewproj.entity.CollectShowInfo;
import com.prettyviewproj.tools.DBTool;
import com.prettyviewproj.tools.TimeTool;

public class CollectDao implements ICollectDao {
	private String collectInfoList="collectinfolist";
	@Override
	public boolean insertCollectInfoByCollectInfo(String userID, String worksID, String collectTime) {
		// TODO Auto-generated method stub
		System.out.println("dao");
		Statement st=null;
		boolean addCollectResult=false;
		ResultSet rs=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="insert into "+collectInfoList+ "(userID,worksID,collectTime)  values("+userID+","+worksID+",'"+collectTime+"')" ;
			int result=st.executeUpdate(sql);
			if(result==1)
				addCollectResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addCollectResult;
	}
	@Override
	public boolean deleteCollectInfoByUserIDWorksID(String userID, String worksID) {
		// TODO Auto-generated method stub
		Statement st=null;
		boolean deleteCollectResult=false;
		ResultSet rs=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="delete from "+collectInfoList+" where  userID="+userID+" and worksID="+worksID ;
			int result=st.executeUpdate(sql);
			if(result==1)
				deleteCollectResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteCollectResult;
	}
	@Override
	
	public ArrayList<CollectShowInfo> selectCollectInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		Statement st=null;
		ResultSet rs=null;
		ArrayList<CollectShowInfo> userCollectList=new ArrayList<CollectShowInfo>();
		
		try {
			st=DBTool.getConnection().createStatement();
			String sql="select collectinfolist.collectTime,worksinfolist.worksID,worksinfolist.worksName,worksinfolist.worksIntroduction, worksinfolist.uploadTime," + 
					"worksinfolist.uploadAddress,worksinfolist.aditingStatus,worksinfolist.aditingTime,worksinfolist.worksStatus," + 
					"worksinfolist.worksCategory from collectinfolist,worksinfolist where collectinfolist.worksID=worksinfolist.worksID and collectinfolist.userID="+userID;
			rs=st.executeQuery(sql);
			while(rs.next()) {
				String collectTime=TimeTool.getTimeToString(rs.getTimestamp(1));
				String worksID=rs.getInt(2)+"";
				String worksName=rs.getString(3);
				String worksIntroduction=rs.getString(4);
				String uploadTime=rs.getString(5);
				String uploadAddress=rs.getString(6);
				int aditingStatus=rs.getInt(7);
				String aditingTime=TimeTool.getTimeToString(rs.getTimestamp(8));
				int worksStatus=rs.getInt(9);
				String worksCategory=rs.getString(10);
				userCollectList.add(new CollectShowInfo(collectTime, worksID, worksName, worksIntroduction, uploadTime, uploadAddress, aditingStatus, aditingTime, worksStatus, worksCategory));
			}
			return userCollectList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public CollectInfo selectCollectInfoIsExist(String userID, String worksID) {
		// TODO Auto-generated method stub
		Statement st=null;
		ResultSet rs=null;
		CollectInfo collectInfo=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="select * from collectinfolist where userID="+userID+" and worksID="+worksID;
			rs=st.executeQuery(sql);
			if(rs.next()) {
				String collectTime=TimeTool.getTimeToString(rs.getTimestamp(3));
				collectInfo=new CollectInfo(userID,worksID,collectTime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return collectInfo;
	}
	
	
}
