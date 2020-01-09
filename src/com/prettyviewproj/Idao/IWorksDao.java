package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.FabulousInfo;
import com.prettyviewproj.entity.ReportWorksInfo;
import com.prettyviewproj.entity.WorksInfo;
import com.prettyviewproj.entity.WorksReviewInfo;
import com.prettyviewproj.entity.WorksShowInfo;

public interface IWorksDao {
	ArrayList<WorksShowInfo> selectWorksInfoByCategoryID(String worksCategory);
	ArrayList<WorksShowInfo> selecLatestWorksInfo();
	ArrayList<WorksShowInfo> selectWorksInfoRandomly();
	ArrayList<WorksShowInfo> selectTopWorksInfoByCollectNum();
	ArrayList<WorksShowInfo> selectTopWorksInfoByCommentNum();
	ArrayList<WorksShowInfo> selectTopWorksInfoByFabulousNum();
	ArrayList<WorksShowInfo> selectWorksInfoByUserID(String userID);
	WorksShowInfo selectWorksInfoByWorksID(String worksID);
	
	boolean insertFabulousInfo(String userID, String worksID);

	ArrayList<WorksShowInfo> selectWorksInfoBySearchContent(String searchContent);

	FabulousInfo selectFabulousInfoIsExist(String userID, String worksID);

	boolean insertReportWorksInfo(ReportWorksInfo reportWorksInfo);

	ArrayList<WorksShowInfo> queryWorksCareInfoByUserID(String userID);
	ArrayList<WorksReviewInfo> selectWorksReviewInfo();
	ArrayList<ReportWorksInfo> selectReportWorksInfoByWorksId(String worksID);
	boolean updateReportWorksInfoByWorksID(String worksID, String reportStatus, String reportResult);
	boolean updateWorksStatusByWorksID(String worksID);
	boolean updateWorksStatusReturnByWorksID(String worksID);
	int countWorksRecord();
	ArrayList<WorksShowInfo> selectPageWorksShowInfo(int limitBegin, int pagesize);
	ArrayList<WorksShowInfo> selectUnaditedWorksInfo();
	boolean updateAditingStatusByWorksID(String worksID, String aditingStatus,String aditingTime);
	ArrayList<WorksShowInfo> selectMyWorksInfoByUserID(String userID);
	boolean insertWorksInfoByWorksInfo(WorksInfo worksInfo);
	boolean updateWorksInfoByWorksInfo(WorksInfo worksInfo);
	boolean deleteWorksInfoByWorksID(String worksID);
	ArrayList<WorksShowInfo> selectMyUnaditedWorksInfo(String userID);
	ArrayList<WorksShowInfo> selectAllWorksInfo();
	boolean updateReportStatusReturn(ArrayList<ReportWorksInfo> reportWorksInfos);

}
