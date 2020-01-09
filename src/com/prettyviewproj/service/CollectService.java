/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;

import com.prettyviewproj.Idao.ICollectDao;
import com.prettyviewproj.Iservice.ICollectService;
import com.prettyviewproj.dao.CollectDao;
import com.prettyviewproj.entity.CollectShowInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class CollectService implements ICollectService {
	private ICollectDao collectDao=new CollectDao();
	@Override
	public boolean saveCollectInfoByCollectInfo(String userID, String worksID, String collectTime) {
		// TODO Auto-generated method stub
		if(userID!=null&&worksID!=null&&collectTime!=null)
		{
			return collectDao.insertCollectInfoByCollectInfo(userID, worksID, collectTime);
		}
		return false;
	}
	@Override
	public boolean removeCollectInfoByUserIDWorksID(String userID, String worksID) {
		// TODO Auto-generated method stub
		if(userID!=null&&worksID!=null)
		{
			return collectDao.deleteCollectInfoByUserIDWorksID(userID, worksID);
		}
		return false;
	}
	@Override
	public ArrayList<CollectShowInfo> searchCollectInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		if(userID!=null)
		{
			return collectDao.selectCollectInfoByUserID(userID);
		}
		return null;
	}
	@Override
	public boolean findCollectInfoIsExist(String userID, String worksID) {
		// TODO Auto-generated method stub
		if(userID==null||userID.equals("")||collectDao.selectCollectInfoIsExist(userID, worksID)==null){
			return false;
		}
		else
		{
			return true;
		}
	}

}
