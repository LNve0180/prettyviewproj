/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.ArrayList;
import java.util.HashMap;

import com.prettyviewproj.entity.ApplicationInfo;
import com.prettyviewproj.entity.ApplicationShowInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.entity.UserShowInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public interface IUserService {
	UserInfo judgeUserPassword(String userID,String userPassword);
	String saveUserInfoByUserInfo(UserInfo userInfo);
	boolean alterUserInfoByUserInfo(UserInfo userInfo);
	boolean judgeUserOldPasswordByUserID(String userID,String userOldPassword);
	boolean updateUserPasswordByUserID(String userID,String userNewPassword);
	boolean alterUserHeadPhotoByUserID(String userHeadPhoto,String userID);
	boolean findUserInfoIsExist(String userID);
	UserShowInfo searchUserInfoByUserID(String userID);
	
	String saveApplicationInfoByAppInfo(ApplicationInfo applicationInfo);

	ArrayList<UserShowInfo> searchUserInfoBySearchContent(String searchContent);
	ArrayList<ApplicationInfo> searchCreatorApplicationInfo();
	ApplicationShowInfo searchApplicationByUserID(String userID);
	boolean alterCreatorApplyStatus(String userID, String creatorApplyStatus);
	


	
}
