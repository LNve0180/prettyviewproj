package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.IAnnouncementDao;
import com.prettyviewproj.entity.AnnouncementInfo;
import com.prettyviewproj.tools.DBTool;
import com.prettyviewproj.tools.TimeTool;

public class AnnouncementDao implements IAnnouncementDao {
	
	public AnnouncementDao () {

	}
	
	/**
	*@author:黄羽伦
	*@parm:null
	*@return:announcementInfo
	*date:2018年12月24日
	*/
	@Override
	public ArrayList<AnnouncementInfo> selectAllAnnouncementInfo() {
		
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="SELECT announcementinfolist.* ,admininfolist.adminName,admininfolist.adminHeadPhoto"
					+ "  FROM announcementinfolist,admininfolist "
					+ " WHERE announcementinfolist.adminID=admininfolist.adminID AND announcementinfolist.announcementStatus=1 "
					+ "ORDER BY announcementinfolist.announcementTime DESC";
			
			ArrayList<AnnouncementInfo> announcementInfo = new ArrayList<AnnouncementInfo>();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				AnnouncementInfo announcment = new AnnouncementInfo();
				
				announcment.setAnnouncementID(rs.getInt(1)+"");
				
				announcment.setAdminID(rs.getInt(2)+"");
				
				announcment.setAnnouncementContent(rs.getString(3));
				
				announcment.setAnnouncementTheme(rs.getString(4));
				
				String time = TimeTool.getTimeToString(rs.getTimestamp(5));
				
				announcment.setAnnouncementTime(time);
				
				announcment.setAnnouncementCategory(rs.getString(6));
				
				announcment.setAnnouncementStatus(rs.getInt(7));
				
				announcment.setAdminName(rs.getString(8));
				
				announcment.setAdminHeadPhoto(rs.getString(9));

				announcementInfo.add(announcment);
				
			}
			
			return announcementInfo;
			
			}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	
	}

	@Override
	public boolean updateAnnouncementStatusByID(String announcementID) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "UPDATE announcementinfolist SET announcementStatus = 0 WHERE announcementID = "+announcementID+" ";
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
	public boolean insertAnnouncementByAnnouncementInfo(AnnouncementInfo announcementInfo) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "INSERT INTO announcementinfolist"
					+ "(adminID,announcementContent,announcementTheme,announcementTime,announcementCategory)"
					+ "VALUES ('"+announcementInfo.getAdminID()+"','"+announcementInfo.getAnnouncementContent()+"'"
							+ ",'"+announcementInfo.getAnnouncementTheme()+"','"+announcementInfo.getAnnouncementTime()+"','"+announcementInfo.getAnnouncementCategory()+"')";
			int isInsert = st.executeUpdate(sql);
			if(isInsert>0) {
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
