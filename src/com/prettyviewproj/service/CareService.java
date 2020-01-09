/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;

import com.prettyviewproj.Idao.ICareDao;
import com.prettyviewproj.Iservice.ICareService;
import com.prettyviewproj.dao.CareDao;
import com.prettyviewproj.entity.CareInfo;
import com.prettyviewproj.entity.UserInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class CareService implements ICareService {

	private ICareDao careDao;
	
	private ArrayList<UserInfo> arrayUserInfo;
	
	public CareService() {
		
		careDao = new CareDao();
		
		arrayUserInfo = new ArrayList<UserInfo>();
		
	}
	/**
	*@author:黄羽伦
	*@parm:
	*@return:
	*date:2018年12月23日
	*/
	@Override
	public boolean saveCareInfoByUserIDAndCaredID(String userID, String caredID) {
		
		//判断 userID, caredID 符合格式 不为空
		
		boolean isSave = careDao.insertCareInfoByUserIDAndCaredID(userID,caredID);
		
		
		return isSave;

	}
	/**
	*@author:黄羽伦
	*@parm:
	*@return:
	*date:2018年12月23日
	*/
	@Override
	public boolean removeCareInfoByUserIDAndCaredID(String userID, String caredID) {
		
		//判断是否符合格式 不为空。
		boolean isRemove = careDao.deleteCareInfoByUserIDAndCaredID(userID,caredID);
				
		
		return isRemove;

	}
	/**
	*@author:黄羽伦
	*@parm:String userID
	*@return:ArrayList<UserInfo>
	*date:2018年12月23日
	*/
	@Override
	public ArrayList<UserInfo> searchCareInfoByUserID(String userID) {
		//判断参数是否为空 符合格式
		arrayUserInfo = careDao.selectCareInfoByUserID(userID);
		return arrayUserInfo;
	}

	public CareInfo findCareInfoIsExist(String userID, String caredID) {
		if(userID!=null && caredID!=null) {
			CareInfo careInfo = careDao.selectCareInfoIsExist(userID,caredID);
			if(careInfo!=null) {
				return careInfo;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}
