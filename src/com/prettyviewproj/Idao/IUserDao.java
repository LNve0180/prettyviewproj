package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.ApplicationInfo;
import com.prettyviewproj.entity.ApplicationShowInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.entity.UserShowInfo;

public interface IUserDao {
	UserInfo inspectUserPassword(String userID);
	String insertUserInfoByUserInfo(UserInfo userInfo);
	boolean updateUserInfoByUserInfo(UserInfo userInfo);
	String selectUserPasswordByUserID(String userID);
	boolean updateUserPasswordByUserID(String userID,String userNewPassword);
	boolean updateUserHeadPhotoByUserID(String userHeadPhoto,String userID);
	UserShowInfo selectUserInfoByUserID (String userID);
	boolean selectUserInfoIsExist(String userID);
	
	ApplicationInfo selectApplicationInfoByUserID(String UserID);

	boolean insertApplicationInfoByAppInfo(ApplicationInfo applicationInfo);

	ArrayList<UserShowInfo> selectUserInfoBySearchContent(String searchContent);
	ArrayList<ApplicationInfo> selectCrearorApplication();
	ApplicationShowInfo selectApplicationDetailsInfoByUserID(String userID);
	boolean updateCreatorApplyStatusByUserIDAndStatus(String userID, String creatorApplyStatus);
	boolean updateCreatorStatusByUserID(String userID);
	

}
