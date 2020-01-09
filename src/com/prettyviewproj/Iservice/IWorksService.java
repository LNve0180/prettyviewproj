
package com.prettyviewproj.Iservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.prettyviewproj.entity.FabulousInfo;
import com.prettyviewproj.entity.ReportWorksInfo;
import com.prettyviewproj.entity.WorksInfo;
import com.prettyviewproj.entity.WorksReviewInfo;
import com.prettyviewproj.entity.WorksShowInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public interface IWorksService {
	ArrayList<WorksShowInfo> searchWorksInfoByCategoryID(String worksCategory);
	ArrayList<WorksShowInfo> searchLatestWorksInfo();
	ArrayList<WorksShowInfo> searchWorksInfoRandomly();
	ArrayList<WorksShowInfo> searchTopWorksInfoByCollectNum();
	ArrayList<WorksShowInfo> searchTopWorksInfoByCommentNum();
	ArrayList<WorksShowInfo> searchTopWorksInfoByFabulousNum();
	ArrayList<WorksShowInfo> searchWorksInfoByUserID(String userID);
	WorksShowInfo searchWorksInfoByWorksID(String worksID);

	
	boolean saveFabulousInfo(String userID, String worksID);

	ArrayList<WorksShowInfo> searchWorksInfoBySearchContent(String searchContent);

	FabulousInfo findFabulousInfoIsExist(String userID, String worksID);

	boolean saveReportWorksInfo(ReportWorksInfo reportWorksInfo);

	ArrayList<WorksShowInfo> searchWorksCareInfoByUserID(String userID);
	ArrayList<WorksReviewInfo> searchWorksReviewInfo();
	Map<String, Object> searchWorksReviewDetails(String worksID);
//	HashMap<String,String> alterReportWorksInfo(String worksID, String reportStatus,String reportResult);
	HashMap<String, Object> getPageInfomation(String pageNum);
	ArrayList<WorksShowInfo> searchUnaditedWorksInfo();
	boolean reviewNewWorks(WorksInfo worksInfo,String reviewReason,String adminID);
	boolean saveWorksInfoByWorksInfo(WorksInfo worksInfo);
	ArrayList<WorksShowInfo> searchMyWorksInfoByUserID(String userID);
	boolean alterWorksInfoByWorksInfo(WorksInfo worksInfo);
	boolean removeWorksInfoByWorksID(String worksID);
	ArrayList<WorksShowInfo> searchMyUnaditedWorksInfo(String userID);
	ArrayList<WorksShowInfo> compareSimilarWorksService(String fname);
	boolean alterReportWorksInfo(ArrayList<ReportWorksInfo> reportWorksInfos, WorksShowInfo worksShowInfo,
			String adminID);
}
