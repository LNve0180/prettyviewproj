package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.CareInfo;
import com.prettyviewproj.entity.UserInfo;

public interface ICareDao {

	boolean insertCareInfoByUserIDAndCaredID(String userID, String caredID);

	boolean deleteCareInfoByUserIDAndCaredID(String userID, String caredID);

	ArrayList<UserInfo> selectCareInfoByUserID(String userID);

	CareInfo selectCareInfoIsExist(String userID, String caredID);

}
