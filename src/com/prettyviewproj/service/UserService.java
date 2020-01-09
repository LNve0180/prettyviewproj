/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.prettyviewproj.Idao.IUserDao;
import com.prettyviewproj.Iservice.IUserService;
import com.prettyviewproj.dao.UserDao;
import com.prettyviewproj.entity.ApplicationInfo;
import com.prettyviewproj.entity.ApplicationShowInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.entity.UserShowInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class UserService implements IUserService {
		private IUserDao userDao=new UserDao();
	@Override
	public UserInfo judgeUserPassword(String userID, String userPassword) {
		// TODO Auto-generated method stub
		UserInfo userInfo=userDao.inspectUserPassword(userID);
		if(userInfo!=null){
			return userInfo;
		}else{
			return null;
		}
		
		 
	}
	@Override
	public String saveUserInfoByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		if(userInfo!=null)
		{
			return userDao.insertUserInfoByUserInfo(userInfo);
		}
		return null;
	}
	@Override
	public boolean alterUserInfoByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		if(userInfo!=null)
		{
			return userDao.updateUserInfoByUserInfo(userInfo);
		}
		return false;
	}
	@Override
	public boolean judgeUserOldPasswordByUserID(String userID, String userOldPassword) {
		// TODO Auto-generated method stub
		String userPassword=userDao.selectUserPasswordByUserID(userID);
		if(userPassword.equals("")||userID.equals("")) {
			return false;
		}else
		{
			return userPassword.equals(userOldPassword);
		}
		
	}
	@Override
	public boolean updateUserPasswordByUserID(String userID, String userNewPassword) {
		// TODO Auto-generated method stub
		return userDao.updateUserPasswordByUserID(userID, userNewPassword);
	}
	@Override
	public boolean alterUserHeadPhotoByUserID(String userHeadPhoto, String userID) {
		// TODO Auto-generated method stub
		return userDao.updateUserHeadPhotoByUserID(userHeadPhoto, userID);
	}
	@Override
	public UserShowInfo searchUserInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		if(userID.equals(""))
		{
			return null;
		}else
		{
			return userDao.selectUserInfoByUserID(userID);
		}
	}
	@Override
	public boolean findUserInfoIsExist(String userID) {
		// TODO Auto-generated method stub
		if(userID!=null&&userDao.selectUserInfoIsExist(userID))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}

	@Override
	public String saveApplicationInfoByAppInfo(ApplicationInfo applicationInfo) {
		String msg = "";
		if(applicationInfo!=null) {
			//存不存在
			System.out.println("service:"+applicationInfo.getUserID());
			ApplicationInfo appInfo = userDao.selectApplicationInfoByUserID(applicationInfo.getUserID());
			//判断用户id 申请id 为空
			if(appInfo.getUserID() == null && appInfo.getApplicationID()==null) {
				boolean isSave = userDao.insertApplicationInfoByAppInfo(applicationInfo);
				if(isSave==true) {
					msg = "申请成功！";
					return msg;
				}else {
					msg="申请失败!";
					return msg;
				}
			} else {
				msg = "您已提交申请，请勿再次提交。";
				return msg;
			}
		}else {
			msg="申请失败!";
			return msg;
		}
	}


	@Override
	public ArrayList<UserShowInfo> searchUserInfoBySearchContent(String searchContent) {
		//判断参数是否为空
		if(searchContent!=null) {
			ArrayList<UserShowInfo> arrayUserShowInfo = new ArrayList<UserShowInfo>();
			arrayUserShowInfo = userDao.selectUserInfoBySearchContent(searchContent);
			return arrayUserShowInfo;
		}else {
			return null;
		}	
	}
	
	@Override
	public ArrayList<ApplicationInfo> searchCreatorApplicationInfo() {
		ArrayList<ApplicationInfo> arrayApplicationInfo = new ArrayList<ApplicationInfo>();
		arrayApplicationInfo = userDao.selectCrearorApplication();
		return arrayApplicationInfo;
	}
	
	@Override
	public ApplicationShowInfo searchApplicationByUserID(String userID) {
		if(userID != null) {
			ApplicationShowInfo applicationShowInfo = userDao.selectApplicationDetailsInfoByUserID(userID);
			return applicationShowInfo;
		}else {
			return null;
		}
		
	}
	
	@Override
	public boolean alterCreatorApplyStatus(String userID, String creatorApplyStatus) {
		System.out.println("service"+userID);
		System.out.println("service"+creatorApplyStatus);
		if(userID!=null && userID != "" && creatorApplyStatus!=null && creatorApplyStatus != "") {
			System.out.println("service:走1");
			if(creatorApplyStatus.equals("1")) {//通过
				boolean isAlter = userDao.updateCreatorApplyStatusByUserIDAndStatus(userID,creatorApplyStatus);
				System.out.println("zou");
				if(isAlter) {
					boolean isCreatorStatus = userDao.updateCreatorStatusByUserID(userID);
					return isCreatorStatus;
				}else {
					return false;
				}
			}else if(creatorApplyStatus.equals("2")){
				boolean isAlter = userDao.updateCreatorApplyStatusByUserIDAndStatus(userID,creatorApplyStatus);
				return isAlter;
			}
		}
		return false;
	}
	
	
	
	
}
