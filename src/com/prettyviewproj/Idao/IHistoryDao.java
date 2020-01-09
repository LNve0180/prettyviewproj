package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.HistoryInfo;

public interface IHistoryDao {

	ArrayList<HistoryInfo> selectAllHistoryByUserID(String userID);

	boolean selectHistoryInfoIsExist(HistoryInfo historyInfo);

	boolean deleteHistoryByHistoryInfo(HistoryInfo historyInfo);

	boolean insertHistoryInfo(HistoryInfo historyInfo);
	
	boolean updateHistoryInfoTimeByHistoryInfo(HistoryInfo historyInfo);

}
