package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.CollectInfo;
import com.prettyviewproj.entity.CollectShowInfo;

public interface ICollectDao {
	boolean insertCollectInfoByCollectInfo(String userID,String worksID,String collectTime);
	boolean deleteCollectInfoByUserIDWorksID(String userID,String worksID);
	ArrayList<CollectShowInfo> selectCollectInfoByUserID(String userID);
	CollectInfo  selectCollectInfoIsExist(String userID,String worksID);
	
}
