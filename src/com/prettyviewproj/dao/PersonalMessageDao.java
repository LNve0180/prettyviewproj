package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.IPersonalMessageDao;
import com.prettyviewproj.entity.PersonalMessageInfo;
import com.prettyviewproj.tools.DBTool;
import com.prettyviewproj.tools.TimeTool;

public class PersonalMessageDao implements IPersonalMessageDao {
	private String personalMessageList="personalMessageList";
	private String userInfoList ="userinfolist";
	public PersonalMessageDao() {
	
	}
	/**
	*@author:黄羽伦
	*@parm:
	*@return:
	*date:2019年1月2日
	*/
	@Override
	public boolean insertPersonalMessageInfo(PersonalMessageInfo personalMessageInfo) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql=" INSERT into "+personalMessageList+" (userID,whisperedID,whisperContent,whisperTime) "
					+ " VALUE ('"+personalMessageInfo.getUserID()+"','"+personalMessageInfo.getWhisperedID()+"', "
							+ " '"+personalMessageInfo.getWhisperContent()+"','"+personalMessageInfo.getWhisperTime()+"')";
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
	*@parm:
	*@return:
	*date:2019年1月2日
	*/
	@Override
	public ArrayList<PersonalMessageInfo> selectPersonalMessageInfoByUserID(String userID) {
		Statement st=null;
		ArrayList<PersonalMessageInfo> arrayPersonalMessageInfo = new ArrayList<PersonalMessageInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql=" SELECT  * from "+personalMessageList+" "
					+ "  LEFT JOIN (SELECT userName,userID from "+userInfoList+" ) AS a"
					+ "  ON "+personalMessageList+".whisperedID=a.userID WHERE "+personalMessageList+".userID='"+userID+"'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				PersonalMessageInfo personalMessageInfo = new PersonalMessageInfo();
				personalMessageInfo.setUserID(rs.getString(1));
				personalMessageInfo.setWhisperedID(rs.getString(2));
				personalMessageInfo.setWhisperContent(rs.getString(3));
				String time = TimeTool.getTimeToString(rs.getTimestamp(4));
				personalMessageInfo.setWhisperTime(time);//String
				personalMessageInfo.setWhisperedName(rs.getString(6));
				arrayPersonalMessageInfo.add(personalMessageInfo);
			}
			return arrayPersonalMessageInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
