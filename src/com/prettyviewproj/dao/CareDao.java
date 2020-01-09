package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.ICareDao;
import com.prettyviewproj.entity.CareInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.tools.DBTool;

public class CareDao implements ICareDao {
private ArrayList<UserInfo> arrayUserInfo;
	
	public CareDao(){
		
		 
	}
	/**
	*@author:黄羽伦
	*date:2018年12月23日
	*/
	@Override
	public boolean insertCareInfoByUserIDAndCaredID(String userID, String caredID) {
		
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="insert into careInfoList(userID,caredID) values('"+userID+"','"+caredID+"')";
			
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
	public boolean deleteCareInfoByUserIDAndCaredID(String userID, String caredID) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql="delete from careInfoList where userId='"+userID+"'and caredId='"+caredID+"'";
			int isUpdate = st.executeUpdate(sql);
			String is=isUpdate+"";
			if(isUpdate>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<UserInfo> selectCareInfoByUserID(String userID) {
		Statement st=null;
		try {
			
			st = DBTool.getConnection().createStatement();
			String sql="SELECT userinfolist.* from  careinfolist ,userinfolist WHERE " + 
					"	careinfolist.caredID = userinfolist.userID " + 
					"	and careinfolist.userID='"+userID+"'  ";
			ArrayList<UserInfo> arrayUserInfo = new ArrayList<UserInfo>();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserID(rs.getInt(1)+"");
				userInfo.setUserName(rs.getString(3));
				userInfo.setUserSex(rs.getString(4));
				userInfo.setUserOccupation(rs.getString(5));
				userInfo.setUserEmail(rs.getString(6));
				userInfo.setUserHeadPhoto(rs.getString(7));
				userInfo.setUserIntroduction(rs.getString(8));
				userInfo.setUserPhone(rs.getString(9));
				userInfo.setUserIDStatus(rs.getInt(10));
				userInfo.setCreatorStatus(rs.getInt(11));
				arrayUserInfo.add(userInfo);
			}
			return arrayUserInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CareInfo selectCareInfoIsExist(String userID, String caredID) {
		Statement st=null;
		try {		
			st = DBTool.getConnection().createStatement();
			String sql = "select * from careInfoList where userID='"+userID+"' AND caredID='"+caredID+"' ";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				CareInfo careInfo = new CareInfo();
				careInfo.setUserID(rs.getInt(1)+"");
				careInfo.setCaredID(rs.getInt(2)+"");
				return careInfo;
			}else {
				return null;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
