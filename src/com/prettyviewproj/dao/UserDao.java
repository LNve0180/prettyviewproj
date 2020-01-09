package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.IUserDao;
import com.prettyviewproj.entity.ApplicationInfo;
import com.prettyviewproj.entity.ApplicationShowInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.entity.UserShowInfo;
import com.prettyviewproj.tools.DBTool;
import com.prettyviewproj.tools.SqlTool;
import com.prettyviewproj.tools.TimeTool;

public class UserDao implements IUserDao {
	private String userInfoList="userinfolist";
	@Override
	public UserInfo inspectUserPassword(String userID) {
		// TODO Auto-generated method stub
		UserInfo userInfo=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="select userPassword,userName,userSex,userOccupation,"
					+ "userEmail,userHeadPhoto,userIntroduction,userPhone,userIDStatus"
					+ ",creatorStatus from "+userInfoList+" where userID="+userID;
			rs=st.executeQuery(sql);
			if(rs.next()){
				String userPassword=rs.getString(1);
				String userName=rs.getString(2);
				String userSex=rs.getString(3);
				String userOccuption=rs.getString(4);
				String userEmail=rs.getString(5);
				String userHeadPhoto=rs.getString(6);
				String userIntroduction=rs.getString(7);
				String userPhone=rs.getString(8);
				int userIDStatus=rs.getInt(9);
				int creatorStatus=rs.getInt(10);
				userInfo=new UserInfo(userID,userPassword,userName,userSex,userOccuption,userEmail,userHeadPhoto,userIntroduction,userPhone,userIDStatus,creatorStatus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return userInfo;
	}
	@Override
	public String insertUserInfoByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String userID="";
		Statement st=null;
		ResultSet rs=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="INSERT INTO "+userInfoList+" (userPassword,userName,userSex,userOccupation,userEmail,"
					+ "userHeadPhoto,userIntroduction,userPhone,userIDStatus,creatorStatus)"
					+ " values('"+userInfo.getUserPassword()+"','"+userInfo.getUserName()+"','"+userInfo.getUserSex()+"','"+userInfo.getUserOccupation()+"','"+userInfo.getUserEmail()
					+"','headPhoto/head.jpg','"+userInfo.getUserIntroduction()+"','"+userInfo.getUserPhone()+"',1,0)";
			 st.execute(sql,Statement.RETURN_GENERATED_KEYS);
			 rs=st.getGeneratedKeys();
			 if(rs.next())
			 {
				 userID=rs.getInt(1)+"";
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userID;
	}
	@Override
	public boolean updateUserInfoByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		Statement st=null;
		boolean alterUserInfoResult=false;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="update "+userInfoList+" set userName='"+userInfo.getUserName()+"'"+
					",userSex='"+userInfo.getUserSex()+"'"+
					",userOccupation='"+userInfo.getUserOccupation()+"'"+
					",userEmail='"+userInfo.getUserEmail()+"'"+
					",userIntroduction='"+userInfo.getUserIntroduction()+"'"+
					",userPhone='"+userInfo.getUserPhone()+"' where userID="+userInfo.getUserID();
			int rs=st.executeUpdate(sql);
			if(rs==1)
				alterUserInfoResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alterUserInfoResult;
	}
	@Override
	public String selectUserPasswordByUserID(String userID) {
		// TODO Auto-generated method stub
		String userPassword="";
		Statement st=null;
		ResultSet rs=null;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="select userPassword from "+userInfoList+" where userID="+userID;
			rs=st.executeQuery(sql);
			if(rs.next()){
				userPassword=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userPassword;
	}
	@Override
	public boolean updateUserPasswordByUserID(String userID, String userNewPassword) {
		// TODO Auto-generated method stub
		Statement st=null;
		boolean alterUserPasswordResult=false;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="update "+userInfoList+" set userPassword='"+userNewPassword+"' where userID="+userID;
			int rs=st.executeUpdate(sql);
			if(rs==1)
				alterUserPasswordResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alterUserPasswordResult;
	}
	@Override
	public boolean updateUserHeadPhotoByUserID(String userHeadPhoto, String userID) {
		// TODO Auto-generated method stub
		Statement st=null;
		boolean alterUserHeadPhotoResult=false;
		try {
			st=DBTool.getConnection().createStatement();
			String sql="update "+userInfoList+" set userHeadPhoto='"+userHeadPhoto+"' where userID="+userID;
			int rs=st.executeUpdate(sql);
			if(rs==1)
				alterUserHeadPhotoResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alterUserHeadPhotoResult;
	}
	
	
	@Override
	public UserShowInfo selectUserInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		UserShowInfo  userInfo=new UserShowInfo();
		Statement st=null;
		ResultSet rs=null;	
		try {
			st=DBTool.getConnection().createStatement();
			String sql="SELECT * from user_show_info where userID="+userID;
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				String userName=rs.getString(2);
				String userSex=rs.getString(3);
				String userOccupation=rs.getString(4); 
				String userHeadPhoto=rs.getString(5);
				String userIntroduction=rs.getString(6); 
				int userIDStatus=rs.getInt(7);
				int creatorStatus=rs.getInt(8);
				String careNum=rs.getString(9);
				String fansNum=rs.getString(10);
				userInfo.setUserID(userID);
				userInfo.setUserName(userName);
				userInfo.setUserSex(userSex);;
				userInfo.setUserOccupation(userOccupation);
				userInfo.setUserIntroduction(userIntroduction);
				userInfo.setUserIDStatus(userIDStatus);
				userInfo.setCreatorStatus(creatorStatus);
				userInfo.setUserHeadPhoto(userHeadPhoto);
				userInfo.setCareNum(careNum);
				userInfo.setFansNum(fansNum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}
	@Override
	public boolean  selectUserInfoIsExist(String userID) {
		// TODO Auto-generated method stub
				Statement st=null;
				ResultSet rs=null;
				boolean isExist=false;
				try {
					st=DBTool.getConnection().createStatement();
					String sql="select * from "+userInfoList+" where userID="+userID;
					rs=st.executeQuery(sql);
					if(rs.next()){
						isExist=true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return isExist;
	}
	
	/**
	*@author:黄羽伦
	*@parm:String userID
	*@return:ApplicationInfo
	*date:2018年12月23日
	*/
	@Override
	public ApplicationInfo selectApplicationInfoByUserID(String userID) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql="select * from applicationInfoList where userID ='"+userID+"' AND creatorApplyStatus != 2";
			ResultSet rs = st.executeQuery(sql);
			ApplicationInfo applicationInfo = new ApplicationInfo();
			if(rs.next()) {
				applicationInfo.setApplicationID(rs.getInt(1)+"");
				applicationInfo.setUserID(rs.getInt(2)+"");
				applicationInfo.setUserRealName(rs.getString(3));
				applicationInfo.setUserIDCardNum(rs.getString(4));
				applicationInfo.setCardPhotoFace(rs.getString(5));
				applicationInfo.setCardPhotoBack(rs.getString(6));
				applicationInfo.setApplicationTime(rs.getString(7));
				applicationInfo.setCreatorApplyStatus(rs.getInt(8));
			}
			return applicationInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	*@author:黄羽伦
	*@parm:ApplicationInfo applicationInfo
	*@return: boolean 
	*date:2018年12月23日
	*/
	@Override
	public boolean insertApplicationInfoByAppInfo(ApplicationInfo applicationInfo) {

		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql = "insert into applicationInfoList(userID,userRealName,userIDCardNum,cardPhotoFace,"
					+ " cardPhotoBack,applicationTime)values("
					+ " "+Integer.valueOf(applicationInfo.getUserID())+",'"+applicationInfo.getUserRealName()+"',"
							+ " '"+applicationInfo.getUserIDCardNum()+"', "
							+ " '"+applicationInfo.getCardPhotoFace()+"','"+applicationInfo.getCardPhotoBack()+"',"
									+ " '"+applicationInfo.getApplicationTime()+"'  )";

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
	
	/**
	*@author:黄羽伦
	*@parm:searchContent
	*@return:arrayUserShowInfo
	*date:2018年12月29日
	*/
	@Override
	public ArrayList<UserShowInfo> selectUserInfoBySearchContent(String searchContent) {
		System.out.println("UserDao:"+searchContent);
		ArrayList<UserShowInfo> arrayUserShowInfo =  new ArrayList<UserShowInfo>();
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql= SqlTool.getLikeUserSql2(searchContent);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				UserShowInfo userShowInfo = new UserShowInfo();
				userShowInfo.setUserID(rs.getString(1));
				userShowInfo.setUserName(rs.getString(2));
				userShowInfo.setUserSex(rs.getString(3));
				userShowInfo.setUserOccupation(rs.getString(4));
				userShowInfo.setUserHeadPhoto(rs.getString(5));
				userShowInfo.setUserIntroduction(rs.getString(6));
				userShowInfo.setUserIDStatus(rs.getInt(7));
				userShowInfo.setCreatorStatus(rs.getInt(8));
				userShowInfo.setCareNum(rs.getString(9));
				userShowInfo.setFansNum(rs.getString(10));
				arrayUserShowInfo.add(userShowInfo);
			}
			return arrayUserShowInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<ApplicationInfo> selectCrearorApplication() {
		Statement st=null;
		ArrayList<ApplicationInfo> arrayApplicationInfo = new ArrayList<ApplicationInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql ="SELECT applicationinfolist.* , userinfolist.userName "
					+ "FROM applicationinfolist,userinfolist "
					+ "WHERE creatorApplyStatus = 0 "
					+ "AND applicationinfolist.userID = userinfolist.userID "
					+ "ORDER BY applicationinfolist.applicationTime DESC ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				ApplicationInfo applicationInfo = new ApplicationInfo();
				applicationInfo.setApplicationID(rs.getString(1));
				applicationInfo.setUserID(rs.getString(2));
				applicationInfo.setUserRealName(rs.getString(3));
				applicationInfo.setUserIDCardNum(rs.getString(4));
				applicationInfo.setCardPhotoFace(rs.getString(5));
				applicationInfo.setCardPhotoBack(rs.getString(6));
				String time = TimeTool.getTimeToString(rs.getTimestamp(7));
				applicationInfo.setApplicationTime(time);
				applicationInfo.setCreatorApplyStatus(rs.getInt(8));
				applicationInfo.setUserName(rs.getString(9));
				arrayApplicationInfo.add(applicationInfo);
			}
			return arrayApplicationInfo;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ApplicationShowInfo selectApplicationDetailsInfoByUserID(String userID) {
		Statement st=null;
		ApplicationShowInfo applicationShowInfo = new ApplicationShowInfo();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT applicationinfolist.* , userinfolist.userName,userinfolist.userSex "
					+ "FROM applicationinfolist,userinfolist "
					+ "WHERE creatorApplyStatus = 0 "
					+ "AND applicationinfolist.userID = userinfolist.userID "
					+ "AND applicationinfolist.userID = "+userID+" ";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				applicationShowInfo.setApplicationID(rs.getString(1));
				applicationShowInfo.setUserID(rs.getString(2));
				applicationShowInfo.setUserRealName(rs.getString(3));
				applicationShowInfo.setUserIDCardNum(rs.getString(4));
				applicationShowInfo.setCardPhotoFace(rs.getString(5));
				applicationShowInfo.setCardPhotoBack(rs.getString(6));
				String time = TimeTool.getTimeToString(rs.getTimestamp(7));
				applicationShowInfo.setApplicationTime(time);
				applicationShowInfo.setCreatorApplyStatus(rs.getInt(8));
				applicationShowInfo.setUserName(rs.getString(9));
				applicationShowInfo.setUserSex(rs.getString(10));
			}
			return applicationShowInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean updateCreatorApplyStatusByUserIDAndStatus(String userID, String creatorApplyStatus) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "UPDATE applicationinfolist "
					+ "SET creatorApplyStatus = CASE userID "
					+ "WHEN "+userID+" THEN '"+creatorApplyStatus+"' "
					+ "END "
					+ "WHERE userID = "+userID+" ";
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
	public boolean updateCreatorStatusByUserID(String userID) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "UPDATE userinfolist "
					+ "SET creatorStatus = CASE userID "
					+ "WHEN "+userID+" THEN '1' "
					+ "END "
					+ "WHERE userID = "+userID+" ";
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
	
	

}
