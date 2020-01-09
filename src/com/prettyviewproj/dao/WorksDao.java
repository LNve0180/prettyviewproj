package com.prettyviewproj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prettyviewproj.Idao.IWorksDao;
import com.prettyviewproj.entity.FabulousInfo;
import com.prettyviewproj.entity.ReportWorksInfo;
import com.prettyviewproj.entity.WorksInfo;
import com.prettyviewproj.entity.WorksReviewInfo;
import com.prettyviewproj.entity.WorksShowInfo;
import com.prettyviewproj.tools.DBTool;
import com.prettyviewproj.tools.SqlTool;
import com.prettyviewproj.tools.TimeTool;

public class WorksDao implements IWorksDao {

	@Override
	public ArrayList<WorksShowInfo> selectWorksInfoByCategoryID(String worksCategory) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		ArrayList<WorksShowInfo> worksListByWorksCategory= new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "select * from works_show_info where worksCategory='" + worksCategory + "' and aditingStatus!=0 and worksStatus=1 ORDER BY  RAND() LIMIT 12";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				WorksShowInfo worksShowInfo = new WorksShowInfo();
				
				worksShowInfo.setUserID(rs.getString(1));

				worksShowInfo.setUserName(rs.getString(2));

				worksShowInfo.setUserHeadPhoto(rs.getString(3));

				worksShowInfo.setUserIDStatus(rs.getInt(4));

				worksShowInfo.setCreatorStatus(rs.getInt(5));

				worksShowInfo.setWorksID(rs.getString(6));

				worksShowInfo.setWorksName(rs.getString(7));

				worksShowInfo.setWorksIntroduction(rs.getString(8));

				String time = TimeTool.getTimeToString(rs.getTimestamp(9));

				worksShowInfo.setUploadTime(time);// String

				worksShowInfo.setUploadAddress(rs.getString(10));

				worksShowInfo.setAditingStatus(rs.getInt(11));

				worksShowInfo.setWorksStatus(rs.getInt(12));

				worksShowInfo.setWorksCategory(rs.getString(13));

				worksShowInfo.setCollectNum(rs.getString(14));

				worksShowInfo.setFabulousNum(rs.getString(15));

				worksShowInfo.setCommentNum(rs.getString(16));

				worksListByWorksCategory.add(worksShowInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worksListByWorksCategory;
	}

	@Override
	public ArrayList<WorksShowInfo> selecLatestWorksInfo() {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		ArrayList<WorksShowInfo> latestWorksList= new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info where  worksStatus=1 and aditingStatus!=0 order by uploadTime desc  limit 12";
			rs = st.executeQuery(sql);
			while (rs.next()) {
			WorksShowInfo worksShowInfo = new WorksShowInfo();
				
				worksShowInfo.setUserID(rs.getString(1));

				worksShowInfo.setUserName(rs.getString(2));

				worksShowInfo.setUserHeadPhoto(rs.getString(3));

				worksShowInfo.setUserIDStatus(rs.getInt(4));

				worksShowInfo.setCreatorStatus(rs.getInt(5));

				worksShowInfo.setWorksID(rs.getString(6));

				worksShowInfo.setWorksName(rs.getString(7));

				worksShowInfo.setWorksIntroduction(rs.getString(8));

				String time = TimeTool.getTimeToString(rs.getTimestamp(9));

				worksShowInfo.setUploadTime(time);// String

				worksShowInfo.setUploadAddress(rs.getString(10));

				worksShowInfo.setAditingStatus(rs.getInt(11));

				worksShowInfo.setWorksStatus(rs.getInt(12));

				worksShowInfo.setWorksCategory(rs.getString(13));

				worksShowInfo.setCollectNum(rs.getString(14));

				worksShowInfo.setFabulousNum(rs.getString(15));

				worksShowInfo.setCommentNum(rs.getString(16));

				latestWorksList.add(worksShowInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return latestWorksList;
	}

	@Override
	public ArrayList<WorksShowInfo> selectWorksInfoRandomly() {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		ArrayList<WorksShowInfo> worksInfoListRandomly= new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info where  worksStatus=1 and aditingStatus!=0 order by rand() limit 12";
			rs = st.executeQuery(sql);
			while (rs.next()) {
			WorksShowInfo worksShowInfo = new WorksShowInfo();
				
				worksShowInfo.setUserID(rs.getString(1));

				worksShowInfo.setUserName(rs.getString(2));

				worksShowInfo.setUserHeadPhoto(rs.getString(3));

				worksShowInfo.setUserIDStatus(rs.getInt(4));

				worksShowInfo.setCreatorStatus(rs.getInt(5));

				worksShowInfo.setWorksID(rs.getString(6));

				worksShowInfo.setWorksName(rs.getString(7));

				worksShowInfo.setWorksIntroduction(rs.getString(8));

				String time = TimeTool.getTimeToString(rs.getTimestamp(9));

				worksShowInfo.setUploadTime(time);// String

				worksShowInfo.setUploadAddress(rs.getString(10));

				worksShowInfo.setAditingStatus(rs.getInt(11));

				worksShowInfo.setWorksStatus(rs.getInt(12));

				worksShowInfo.setWorksCategory(rs.getString(13));

				worksShowInfo.setCollectNum(rs.getString(14));

				worksShowInfo.setFabulousNum(rs.getString(15));

				worksShowInfo.setCommentNum(rs.getString(16));

				worksInfoListRandomly.add(worksShowInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worksInfoListRandomly;
	}

	@Override
	public ArrayList<WorksShowInfo> selectTopWorksInfoByCollectNum() {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		ArrayList<WorksShowInfo> worksListByCollect= new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info where  worksStatus=1 and aditingStatus!=0 order by collectNum desc limit 12";
			rs = st.executeQuery(sql);
			while (rs.next()) {
			WorksShowInfo worksShowInfo = new WorksShowInfo();
				
				worksShowInfo.setUserID(rs.getString(1));

				worksShowInfo.setUserName(rs.getString(2));

				worksShowInfo.setUserHeadPhoto(rs.getString(3));

				worksShowInfo.setUserIDStatus(rs.getInt(4));

				worksShowInfo.setCreatorStatus(rs.getInt(5));

				worksShowInfo.setWorksID(rs.getString(6));

				worksShowInfo.setWorksName(rs.getString(7));

				worksShowInfo.setWorksIntroduction(rs.getString(8));

				String time = TimeTool.getTimeToString(rs.getTimestamp(9));

				worksShowInfo.setUploadTime(time);// String

				worksShowInfo.setUploadAddress(rs.getString(10));

				worksShowInfo.setAditingStatus(rs.getInt(11));

				worksShowInfo.setWorksStatus(rs.getInt(12));

				worksShowInfo.setWorksCategory(rs.getString(13));

				worksShowInfo.setCollectNum(rs.getString(14));

				worksShowInfo.setFabulousNum(rs.getString(15));

				worksShowInfo.setCommentNum(rs.getString(16));

				worksListByCollect.add(worksShowInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worksListByCollect;
	}

	@Override
	public ArrayList<WorksShowInfo> selectTopWorksInfoByCommentNum() {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		ArrayList<WorksShowInfo> worksListByComment= new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info where  worksStatus=1 and aditingStatus!=0 order by commentNum desc limit 12";
			rs = st.executeQuery(sql);
			while (rs.next()) {
			WorksShowInfo worksShowInfo = new WorksShowInfo();
				
				worksShowInfo.setUserID(rs.getString(1));

				worksShowInfo.setUserName(rs.getString(2));

				worksShowInfo.setUserHeadPhoto(rs.getString(3));

				worksShowInfo.setUserIDStatus(rs.getInt(4));

				worksShowInfo.setCreatorStatus(rs.getInt(5));

				worksShowInfo.setWorksID(rs.getString(6));

				worksShowInfo.setWorksName(rs.getString(7));

				worksShowInfo.setWorksIntroduction(rs.getString(8));

				String time = TimeTool.getTimeToString(rs.getTimestamp(9));

				worksShowInfo.setUploadTime(time);// String

				worksShowInfo.setUploadAddress(rs.getString(10));

				worksShowInfo.setAditingStatus(rs.getInt(11));

				worksShowInfo.setWorksStatus(rs.getInt(12));

				worksShowInfo.setWorksCategory(rs.getString(13));

				worksShowInfo.setCollectNum(rs.getString(14));

				worksShowInfo.setFabulousNum(rs.getString(15));

				worksShowInfo.setCommentNum(rs.getString(16));

				worksListByComment.add(worksShowInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worksListByComment;
	}

	@Override
	public ArrayList<WorksShowInfo> selectTopWorksInfoByFabulousNum() {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		ArrayList<WorksShowInfo> worksListByFabulous= new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info where  worksStatus=1 and aditingStatus!=0 order by fabulousNum desc limit 12";
			rs = st.executeQuery(sql);
			while (rs.next()) {
			WorksShowInfo worksShowInfo = new WorksShowInfo();
				
				worksShowInfo.setUserID(rs.getString(1));

				worksShowInfo.setUserName(rs.getString(2));

				worksShowInfo.setUserHeadPhoto(rs.getString(3));

				worksShowInfo.setUserIDStatus(rs.getInt(4));

				worksShowInfo.setCreatorStatus(rs.getInt(5));

				worksShowInfo.setWorksID(rs.getString(6));

				worksShowInfo.setWorksName(rs.getString(7));

				worksShowInfo.setWorksIntroduction(rs.getString(8));

				String time = TimeTool.getTimeToString(rs.getTimestamp(9));

				worksShowInfo.setUploadTime(time);// String

				worksShowInfo.setUploadAddress(rs.getString(10));

				worksShowInfo.setAditingStatus(rs.getInt(11));

				worksShowInfo.setWorksStatus(rs.getInt(12));

				worksShowInfo.setWorksCategory(rs.getString(13));

				worksShowInfo.setCollectNum(rs.getString(14));

				worksShowInfo.setFabulousNum(rs.getString(15));

				worksShowInfo.setCommentNum(rs.getString(16));

				worksListByFabulous.add(worksShowInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worksListByFabulous;
	}
	
	
	@Override
	public ArrayList<WorksShowInfo> selectWorksInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		ArrayList<WorksShowInfo> worksInfoList= new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info where  worksStatus=1 and aditingStatus!=0  and userID="+userID;
			rs = st.executeQuery(sql);
			while (rs.next()) {
			WorksShowInfo worksShowInfo = new WorksShowInfo();
				
				worksShowInfo.setUserID(rs.getString(1));

				worksShowInfo.setUserName(rs.getString(2));

				worksShowInfo.setUserHeadPhoto(rs.getString(3));

				worksShowInfo.setUserIDStatus(rs.getInt(4));

				worksShowInfo.setCreatorStatus(rs.getInt(5));

				worksShowInfo.setWorksID(rs.getString(6));

				worksShowInfo.setWorksName(rs.getString(7));

				worksShowInfo.setWorksIntroduction(rs.getString(8));

				String time = TimeTool.getTimeToString(rs.getTimestamp(9));

				worksShowInfo.setUploadTime(time);// String

				worksShowInfo.setUploadAddress(rs.getString(10));

				worksShowInfo.setAditingStatus(rs.getInt(11));

				worksShowInfo.setWorksStatus(rs.getInt(12));

				worksShowInfo.setWorksCategory(rs.getString(13));

				worksShowInfo.setCollectNum(rs.getString(14));

				worksShowInfo.setFabulousNum(rs.getString(15));

				worksShowInfo.setCommentNum(rs.getString(16));

				worksInfoList.add(worksShowInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worksInfoList;
	}

	@Override
	public WorksShowInfo selectWorksInfoByWorksID(String worksID) {
		Statement st = null;
		ResultSet rs = null;
		WorksShowInfo worksInfo= new WorksShowInfo();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info where  worksStatus=1 and aditingStatus!=0  and worksID="+worksID;
			rs = st.executeQuery(sql);
			if(rs.next()) {
				
			worksInfo.setUserID(rs.getString(1));

				worksInfo.setUserName(rs.getString(2));

				worksInfo.setUserHeadPhoto(rs.getString(3));

				worksInfo.setUserIDStatus(rs.getInt(4));

				worksInfo.setCreatorStatus(rs.getInt(5));

				worksInfo.setWorksID(rs.getString(6));

				worksInfo.setWorksName(rs.getString(7));

				worksInfo.setWorksIntroduction(rs.getString(8));

				String time = TimeTool.getTimeToString(rs.getTimestamp(9));

				worksInfo.setUploadTime(time);// String

				worksInfo.setUploadAddress(rs.getString(10));

				worksInfo.setAditingStatus(rs.getInt(11));

				worksInfo.setWorksStatus(rs.getInt(12));

				worksInfo.setWorksCategory(rs.getString(13));

				worksInfo.setCollectNum(rs.getString(14));

				worksInfo.setFabulousNum(rs.getString(15));

				worksInfo.setCommentNum(rs.getString(16));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worksInfo;
	}
	
	
	/**
	*@author:黄羽伦
	*@parm:userID,worksID
	*@return:boolean
	*date:2018年12月23日
	*/
	
	@Override
	public boolean insertFabulousInfo(String userID, String worksID) {
		
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="insert into fabulouslist(userID,worksID) values('"+userID+"','"+worksID+"')";
			
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
	*@parm:searchContent
	*@return:arrayWorksShowInfo
	*date:2018年12月23日
	*/

	@Override
	public ArrayList<WorksShowInfo> selectWorksInfoBySearchContent(String searchContent) {
		System.out.println("Dao:"+searchContent);
		ArrayList<WorksShowInfo> arrayWorksShowInfo =  new ArrayList<WorksShowInfo>();
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql= SqlTool.getLikeWorksSql2(searchContent);
			ResultSet rs = st.executeQuery(sql); 
			while(rs.next()) {
				WorksShowInfo worksShowInfo = new WorksShowInfo();
				worksShowInfo.setUserID(rs.getString(1));
				worksShowInfo.setUserName(rs.getString(2));
				worksShowInfo.setUserHeadPhoto(rs.getString(3));
				worksShowInfo.setUserIDStatus(rs.getInt(4));
				worksShowInfo.setCreatorStatus(rs.getInt(5));
				worksShowInfo.setWorksID(rs.getString(6));
				worksShowInfo.setWorksName(rs.getString(7));
				worksShowInfo.setWorksIntroduction(rs.getString(8));
				String time = TimeTool.getTimeToString(rs.getTimestamp(9));
				worksShowInfo.setUploadTime(time);//String
				worksShowInfo.setUploadAddress(rs.getString(10));
				worksShowInfo.setAditingStatus(rs.getInt(11));
				worksShowInfo.setWorksStatus(rs.getInt(12));
				worksShowInfo.setWorksCategory(rs.getString(13));
				worksShowInfo.setCollectNum(rs.getString(14));
				worksShowInfo.setFabulousNum(rs.getString(15));
				worksShowInfo.setCommentNum(rs.getString(16));
				arrayWorksShowInfo.add(worksShowInfo);
			}
			return arrayWorksShowInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	*@author:黄羽伦
	*@parm:userID,worksID
	*@return:fabulousInfo
	*date:2018年12月30日
	*/
	@Override
	public FabulousInfo selectFabulousInfoIsExist(String userID, String worksID) {
		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql= "select * from fabulouslist where userID='"+userID+"' AND worksID='"+worksID+"'";
						
			ResultSet rs = st.executeQuery(sql); 
			
			if(rs.next()) {
				
				FabulousInfo fabulousInfo = new FabulousInfo();
				
				fabulousInfo.setUserID(rs.getInt(1)+"");
				
				fabulousInfo.setWorksID(rs.getInt(2)+"");
				
				return fabulousInfo;
				
			}
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}

	/**
	*@author:黄羽伦
	*@parm:reportWorksInfo
	*@return:boolean
	*date:2018年12月30日
	*/
	@Override
	public boolean insertReportWorksInfo(ReportWorksInfo reportWorksInfo) {

		Statement st=null;
		
		try {
			
			st = DBTool.getConnection().createStatement();
			
			String sql="insert into reportWorkslist (userID,worksID,reportReason,reportTime)"
					+ " values ('"+reportWorksInfo.getUserID()+"','"+reportWorksInfo.getWorksID()+"',"
							+ " '"+reportWorksInfo.getReportReason()+"','"+reportWorksInfo.getReportTime()+"')";
			
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
	*@parm:userID
	*@return:worksShowInfo
	*date:2019年1月2日
	**/
	@Override
	public ArrayList<WorksShowInfo> queryWorksCareInfoByUserID(String userID) {
		Statement st=null;
		ArrayList<WorksShowInfo> arrayWorksShowInfo =  new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql="SELECT * from works_show_info WHERE  worksStatus=1 AND aditingStatus=1 AND userID IN  "
					+ " (SELECT caredID FROM careinfolist WHERE userID='"+userID+"')"
					+"ORDER BY works_show_info.uploadTime DESC";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				WorksShowInfo worksShowInfo = new WorksShowInfo();
				worksShowInfo.setUserID(rs.getString(1));
				worksShowInfo.setUserName(rs.getString(2));
				worksShowInfo.setUserHeadPhoto(rs.getString(3));
				worksShowInfo.setUserIDStatus(rs.getInt(4));
				worksShowInfo.setCreatorStatus(rs.getInt(5));
				worksShowInfo.setWorksID(rs.getString(6));
				worksShowInfo.setWorksName(rs.getString(7));
				worksShowInfo.setWorksIntroduction(rs.getString(8));
				String time = TimeTool.getTimeToString(rs.getTimestamp(9));
				worksShowInfo.setUploadTime(time);//String
				worksShowInfo.setUploadAddress(rs.getString(10));
				worksShowInfo.setAditingStatus(rs.getInt(11));
				worksShowInfo.setWorksStatus(rs.getInt(12));
				worksShowInfo.setWorksCategory(rs.getString(13));
				worksShowInfo.setCollectNum(rs.getString(14));
				worksShowInfo.setFabulousNum(rs.getString(15));
				worksShowInfo.setCommentNum(rs.getString(16));
				arrayWorksShowInfo.add(worksShowInfo);
			}
			return arrayWorksShowInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<WorksReviewInfo> selectWorksReviewInfo() {
		Statement st=null;
		ArrayList<WorksReviewInfo> arrayWorskReviewInfo = new ArrayList<WorksReviewInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT worksinfolist.worksID,worksinfolist.worksName,COUNT(worksinfolist.worksID) AS reportNum "
					+ "FROM worksinfolist,reportworkslist "
					+ "WHERE worksinfolist.worksID = reportworkslist.worksID "
					+ "AND reportworkslist.reportStatus = 2 "
					+ "GROUP BY worksinfolist.worksID ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				WorksReviewInfo worksReviewInfo = new WorksReviewInfo();
				worksReviewInfo.setWorksID(rs.getString(1));
				worksReviewInfo.setWorksName(rs.getString(2));
				worksReviewInfo.setReportNum(rs.getString(3));
				arrayWorskReviewInfo.add(worksReviewInfo);
			}
			return arrayWorskReviewInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ReportWorksInfo> selectReportWorksInfoByWorksId(String worksID) {
		Statement st=null;
		ArrayList<ReportWorksInfo> arrayReportWorksInfo = new ArrayList<ReportWorksInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * "
					+ "FROM reportworkslist "
					+ "WHERE worksID = "+worksID+" "
					+ "AND reportStatus = 2 "
					+ "ORDER BY reportTime DESC ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				ReportWorksInfo reportWorksInfo = new ReportWorksInfo();
				reportWorksInfo.setUserID(rs.getString(1));
				reportWorksInfo.setWorksID(rs.getString(2));
				reportWorksInfo.setReportReason(rs.getString(3));
				String time = TimeTool.getTimeToString(rs.getTimestamp(4));
				reportWorksInfo.setReportTime(time);
				reportWorksInfo.setReportResult(rs.getString(5));
				reportWorksInfo.setReportStatus(rs.getInt(6));
				arrayReportWorksInfo.add(reportWorksInfo);
			}
			return arrayReportWorksInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateReportWorksInfoByWorksID(String worksID, String reportStatus, String reportResult) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "UPDATE reportworkslist "
					+ "SET reportResult = CASE worksID "
					+ "WHEN "+worksID+" THEN '"+reportResult+"' "
					+ "END, "
					+ "reportStatus = CASE worksID "
					+ "WHEN "+worksID+" THEN '"+reportStatus+"' "
					+ "END "
					+ "WHERE worksID = "+worksID+" ";
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
	public boolean updateWorksStatusByWorksID(String worksID) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "UPDATE worksinfolist "
					+ "SET worksStatus = CASE worksID "
					+ "WHEN "+worksID+" THEN '0' "
					+ "END "
					+ "WHERE worksID = "+worksID+"";
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
	public boolean updateWorksStatusReturnByWorksID(String worksID) {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "UPDATE worksinfolist "
					+ "SET worksStatus = CASE worksID "
					+ "WHEN "+worksID+" THEN '1' "
					+ "END "
					+ "WHERE worksID = "+worksID+"";
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
	public int countWorksRecord() {
		Statement st=null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT COUNT(worksID) AS pageRecord\r\n" + 
					"FROM works_show_info\r\n" + 
					"WHERE worksStatus = 1 \r\n" + 
					"AND aditingStatus = 1 ";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				String temp = rs.getString(1);
				int pageRecord = Integer.parseInt(temp);
				return pageRecord;
			}
			return 0;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<WorksShowInfo> selectUnaditedWorksInfo() {
		Statement st = null;
		ArrayList<WorksShowInfo> arrayWorksShowInfo = new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info WHERE aditingStatus=2";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				WorksShowInfo worksShowInfo = new WorksShowInfo();
				worksShowInfo.setUserID(rs.getString(1));
				worksShowInfo.setUserName(rs.getString(2));
				worksShowInfo.setUserHeadPhoto(rs.getString(3));
				worksShowInfo.setUserIDStatus(rs.getInt(4));
				worksShowInfo.setCreatorStatus(rs.getInt(5));
				worksShowInfo.setWorksID(rs.getString(6));
				worksShowInfo.setWorksName(rs.getString(7));
				worksShowInfo.setWorksIntroduction(rs.getString(8));
				String time = TimeTool.getTimeToString(rs.getTimestamp(9));
				worksShowInfo.setUploadTime(time);// String
				worksShowInfo.setUploadAddress(rs.getString(10));
				worksShowInfo.setAditingStatus(rs.getInt(11));
				worksShowInfo.setWorksStatus(rs.getInt(12));
				worksShowInfo.setWorksCategory(rs.getString(13));
				worksShowInfo.setCollectNum(rs.getString(14));
				worksShowInfo.setFabulousNum(rs.getString(15));
				worksShowInfo.setCommentNum(rs.getString(16));
				arrayWorksShowInfo.add(worksShowInfo);
			}
			return arrayWorksShowInfo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAditingStatusByWorksID(String worksID, String aditingStatus,String aditingTime) {
		boolean updateResult = false;
		Statement st = null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "update worksinfolist set aditingStatus="+aditingStatus+",aditingTime='"+aditingTime+"'  where worksID="+worksID;
			if (st.executeUpdate(sql) == 1) {
				updateResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateResult;
	}


	
	
	@Override
	public ArrayList<WorksShowInfo> selectPageWorksShowInfo(int limitBegin, int pagesize) {
		Statement st=null;
		try{
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * \r\n" + 
					"FROM works_show_info \r\n" + 
					"WHERE worksStatus = 1 \r\n" + 
					"AND aditingStatus = 1 \r\n" + 
					"LIMIT "+limitBegin+","+pagesize+" ";
			ResultSet rs = st.executeQuery(sql);
			ArrayList<WorksShowInfo> arrayWorksShowInfo = new ArrayList<WorksShowInfo>();
			while(rs.next()) {
				WorksShowInfo worksShowInfo = new WorksShowInfo();
				worksShowInfo.setUserID(rs.getString(1));
				worksShowInfo.setUserName(rs.getString(2));
				worksShowInfo.setUserHeadPhoto(rs.getString(3));
				worksShowInfo.setUserIDStatus(rs.getInt(4));
				worksShowInfo.setCreatorStatus(rs.getInt(5));
				worksShowInfo.setWorksID(rs.getString(6));
				worksShowInfo.setWorksName(rs.getString(7));
				worksShowInfo.setWorksIntroduction(rs.getString(8));
				String time = TimeTool.getTimeToString(rs.getTimestamp(9));
				worksShowInfo.setUploadTime(time);//String
				worksShowInfo.setUploadAddress(rs.getString(10));
				worksShowInfo.setAditingStatus(rs.getInt(11));
				worksShowInfo.setWorksStatus(rs.getInt(12));
				worksShowInfo.setWorksCategory(rs.getString(13));
				worksShowInfo.setCollectNum(rs.getString(14));
				worksShowInfo.setFabulousNum(rs.getString(15));
				worksShowInfo.setCommentNum(rs.getString(16));
				arrayWorksShowInfo.add(worksShowInfo);
			}
			return arrayWorksShowInfo;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* 创作者删除作品
     * author:dyp
     * date:2019/05/01
     */
	
	@Override
	public boolean deleteWorksInfoByWorksID(String worksID) {
		boolean deleteResult = false;
		Statement st = null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "update worksinfolist set worksStatus=2 where worksID=" + worksID;
			if (st.executeUpdate(sql) == 1) {
				deleteResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deleteResult;
	}
	
	/* 创作者修改作品信息
     * author:dyp
     * date:2019/05/01
     */
	@Override
	public boolean updateWorksInfoByWorksInfo(WorksInfo worksInfo) {
		// TODO Auto-generated method stub
		boolean updateResult = false;
		Statement st = null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "update worksinfolist set worksName='" + worksInfo.getWorksName() + "',"
					+ "worksIntroduction='" + worksInfo.getWorksIntroduction() + "',worksCategory='" + worksInfo.getWorksCategory()
					+ "' where worksID=" + worksInfo.getWorksID();
			if (st.executeUpdate(sql) == 1) {
				updateResult = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updateResult;
	}
	
	/* 创作者插入作品
     * author:dyp
     * date:2019/05/01
     */
	@Override
	public boolean insertWorksInfoByWorksInfo(WorksInfo worksInfo) {
		// TODO Auto-generated method stub
		boolean insertResult = false;
		Statement st = null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "insert into worksinfolist(userID,worksName,worksIntroduction,uploadTime,uploadAddress,aditingStatus,aditingTime,worksStatus,worksCategory) "
					+ "values(" + worksInfo.getUserID() + ",'" + worksInfo.getWorksName() + "','"
					+ worksInfo.getWorksIntroduction() + "','" + worksInfo.getUploadTime() + "','"
					+ worksInfo.getUploadAddress() + "','2',null,1,'" + worksInfo.getWorksCategory() + "')";
			if (st.executeUpdate(sql) == 1) {
				insertResult = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return insertResult;
	}

	/* 创作者查看我的作品
     * author:dyp
     * date:2019/05/01
     */
	@Override
	public ArrayList<WorksShowInfo> selectMyWorksInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		Statement st = null;
		ArrayList<WorksShowInfo> arrayWorksShowInfo = new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info WHERE worksStatus=1 and aditingStatus=1  and  userID="+userID;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				WorksShowInfo worksShowInfo = new WorksShowInfo();
				worksShowInfo.setUserID(rs.getString(1));
				worksShowInfo.setUserName(rs.getString(2));
				worksShowInfo.setUserHeadPhoto(rs.getString(3));
				worksShowInfo.setUserIDStatus(rs.getInt(4));
				worksShowInfo.setCreatorStatus(rs.getInt(5));
				worksShowInfo.setWorksID(rs.getString(6));
				worksShowInfo.setWorksName(rs.getString(7));
				worksShowInfo.setWorksIntroduction(rs.getString(8));
				String time = TimeTool.getTimeToString(rs.getTimestamp(9));
				worksShowInfo.setUploadTime(time);// String
				worksShowInfo.setUploadAddress(rs.getString(10));
				worksShowInfo.setAditingStatus(rs.getInt(11));
				worksShowInfo.setWorksStatus(rs.getInt(12));
				worksShowInfo.setWorksCategory(rs.getString(13));
				worksShowInfo.setCollectNum(rs.getString(14));
				worksShowInfo.setFabulousNum(rs.getString(15));
				worksShowInfo.setCommentNum(rs.getString(16));
				arrayWorksShowInfo.add(worksShowInfo);
			}
			return arrayWorksShowInfo;
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
	}
	
	/* 查看待审核作品
     * author:dyp
     * date:2019/05/01
     */
	@Override
	public ArrayList<WorksShowInfo> selectMyUnaditedWorksInfo(String userID) {
		// TODO Auto-generated method stub
				Statement st = null;
				ArrayList<WorksShowInfo> arrayWorksShowInfo = new ArrayList<WorksShowInfo>();
				try {
					st = DBTool.getConnection().createStatement();
					String sql = "SELECT * from works_show_info WHERE worksStatus=1 and aditingStatus=2  and  userID="+userID;
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						WorksShowInfo worksShowInfo = new WorksShowInfo();
						worksShowInfo.setUserID(rs.getString(1));
						worksShowInfo.setUserName(rs.getString(2));
						worksShowInfo.setUserHeadPhoto(rs.getString(3));
						worksShowInfo.setUserIDStatus(rs.getInt(4));
						worksShowInfo.setCreatorStatus(rs.getInt(5));
						worksShowInfo.setWorksID(rs.getString(6));
						worksShowInfo.setWorksName(rs.getString(7));
						worksShowInfo.setWorksIntroduction(rs.getString(8));
						String time = TimeTool.getTimeToString(rs.getTimestamp(9));
						worksShowInfo.setUploadTime(time);// String
						worksShowInfo.setUploadAddress(rs.getString(10));
						worksShowInfo.setAditingStatus(rs.getInt(11));
						worksShowInfo.setWorksStatus(rs.getInt(12));
						worksShowInfo.setWorksCategory(rs.getString(13));
						worksShowInfo.setCollectNum(rs.getString(14));
						worksShowInfo.setFabulousNum(rs.getString(15));
						worksShowInfo.setCommentNum(rs.getString(16));
						arrayWorksShowInfo.add(worksShowInfo);
					}
					return arrayWorksShowInfo;
				} catch (SQLException e) {

					e.printStackTrace();

				}
				return null;
	}

	@Override
	public ArrayList<WorksShowInfo> selectAllWorksInfo() {
		Statement st = null;
		ArrayList<WorksShowInfo> arrayWorksShowInfo = new ArrayList<WorksShowInfo>();
		try {
			st = DBTool.getConnection().createStatement();
			String sql = "SELECT * from works_show_info WHERE worksStatus = 1 AND aditingStatus = 1 ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				WorksShowInfo worksShowInfo = new WorksShowInfo();
				worksShowInfo.setUserID(rs.getString(1));
				worksShowInfo.setUserName(rs.getString(2));
				worksShowInfo.setUserHeadPhoto(rs.getString(3));
				worksShowInfo.setUserIDStatus(rs.getInt(4));
				worksShowInfo.setCreatorStatus(rs.getInt(5));
				worksShowInfo.setWorksID(rs.getString(6));
				worksShowInfo.setWorksName(rs.getString(7));
				worksShowInfo.setWorksIntroduction(rs.getString(8));
				String time = TimeTool.getTimeToString(rs.getTimestamp(9));
				worksShowInfo.setUploadTime(time);// String
				worksShowInfo.setUploadAddress(rs.getString(10));
				worksShowInfo.setAditingStatus(rs.getInt(11));
				worksShowInfo.setWorksStatus(rs.getInt(12));
				worksShowInfo.setWorksCategory(rs.getString(13));
				worksShowInfo.setCollectNum(rs.getString(14));
				worksShowInfo.setFabulousNum(rs.getString(15));
				worksShowInfo.setCommentNum(rs.getString(16));
				arrayWorksShowInfo.add(worksShowInfo);
			}
			return arrayWorksShowInfo;
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
	}

	@Override
	public boolean updateReportStatusReturn(ArrayList<ReportWorksInfo> reportWorksInfos) {
		Statement st = null;
		try {
			st = DBTool.getConnection().createStatement();
			String sql=SqlTool.getSqlByReportWorksInfos(reportWorksInfos);
			int isInsert = st.executeUpdate(sql);
			if(isInsert > 0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
