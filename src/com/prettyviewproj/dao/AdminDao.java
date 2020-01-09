package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.IAdminDao;
import com.prettyviewproj.entity.AdminInfo;
import com.prettyviewproj.entity.WorksLastMonthData;
import com.prettyviewproj.tools.DBTool;

public class AdminDao implements IAdminDao {

	@Override
	public ArrayList<WorksLastMonthData> selectLastMonthWorksData(String timeBegin, String timeEnd) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT "
					+ "DATE_FORMAT(uploadTime, '%Y-%m-%d') triggerDay,COUNT(worksID) triggerCount "
					+ "FROM worksinfolist "
					+ "WHERE uploadTime BETWEEN '"+timeBegin+"' "
					+ "AND '"+timeEnd+"' "
					+ "GROUP BY triggerDay "
					+ "ORDER BY uploadTime ";
			ArrayList<WorksLastMonthData> arrayData = new ArrayList<WorksLastMonthData>();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				WorksLastMonthData worksLastMonthData = new WorksLastMonthData();
				worksLastMonthData.setWorksDate(rs.getString(1));
				worksLastMonthData.setWorksNum(rs.getString(2));
				arrayData.add(worksLastMonthData);
			}
			return arrayData;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String selectUserNum() {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT COUNT(userID) AS userNum "
					+ "FROM userinfolist "
					+ "WHERE userIDStatus = 1";
			ResultSet rs = st.executeQuery(sql);
			String userNum = "";
			if(rs.next()) {
				userNum = rs.getString(1);
			}
			return userNum;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String selectCreatorNum() {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT COUNT(userID) AS creatorNum "
					+ "FROM userinfolist "
					+ "WHERE userIDStatus = 1 "
					+ "AND creatorStatus = 1 ";
			ResultSet rs = st.executeQuery(sql);
			String creatorNum = "";
			if(rs.next()) {
				creatorNum = rs.getString(1);
			}
			return creatorNum;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String selectWorksNum() {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT COUNT(worksID) AS worksNum "
					+ "FROM worksinfolist "
					+ "WHERE worksStatus = 1 ";
			ResultSet rs = st.executeQuery(sql);
			String worksNum = "";
			if(rs.next()) {
				worksNum = rs.getString(1);
			}
			return worksNum;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public boolean selectAdminInfoIsExist(String adminID) {
		// TODO Auto-generated method stub
		boolean isExist=false;
		Statement st=null;
		ResultSet rs=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="select * from admininfolist where adminID="+adminID;
			rs=st.executeQuery(sql);
			if(rs.next()) {
				isExist=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return isExist;
	}
	
	@Override
	public AdminInfo inspectAdminPassword(String adminID, String adminPassword) {
		// TODO Auto-generated method stub
		AdminInfo adminInfo=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="select * from admininfolist where adminID="+adminID;
			rs=st.executeQuery(sql);
			if(rs.next()) {
				String adminRealPassword=rs.getString(2);
				String adminName=rs.getString(3);
				String adminSex=rs.getString(4);
				String adminEmail=rs.getString(5);
				String adminHeadPhoto=rs.getString(6);
				String adminPhone=rs.getString(7);
				adminInfo=new AdminInfo(adminID, adminRealPassword, adminName, adminSex, adminEmail, adminHeadPhoto, adminPhone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return adminInfo;
	}

	@Override
	public boolean insertAdminInfoByAdminInfo(AdminInfo adminInfo) {
		// TODO Auto-generated method stub
		Statement st=null;
		
		boolean addResult=false;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="insert into adminInfoList values("+adminInfo.getAdminID()+",'"+adminInfo.getAdminPassword()+"','"+adminInfo.getAdminName()+"','"+adminInfo.getAdminSex()+"','"+adminInfo.getAdminEmail()+"','"+adminInfo.getAdminHeadPhoto()+"','"+adminInfo.getAdminPhone()+"')";
			if(st.executeUpdate(sql)==1) {
				addResult=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return addResult;	
	}
	
}
