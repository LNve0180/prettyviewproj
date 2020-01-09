/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;

import com.prettyviewproj.Idao.IHistoryDao;
import com.prettyviewproj.Iservice.IHistoryService;
import com.prettyviewproj.dao.HistoryDao;
import com.prettyviewproj.entity.HistoryInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class HistoryService implements IHistoryService {

	private IHistoryDao historyDao;
	
	public HistoryService() {
		
		historyDao = new HistoryDao();
	}
	
	/**
	*@author:黄羽伦
	*@parm:userID
	*@return:arrayHistory
	*date:2018年12月24日
	*/
	@Override
	public ArrayList<HistoryInfo> searchAllHistoryByUserID(String userID) {
		
		ArrayList<HistoryInfo> arrayHistoryInfo = new ArrayList<HistoryInfo>();
		
		if(userID!=null) {
			
			arrayHistoryInfo = historyDao.selectAllHistoryByUserID(userID);
			
		}else {
			
			return null;
		}
		
		
		
		return arrayHistoryInfo;

	}

	/**
	*@author:黄羽伦
	*@parm:historyInfo
	*@return:true
	*date:2018年12月24日
	*/
	@Override
	public boolean removeHistoryByHistoryInfo(HistoryInfo historyInfo) {
		if(historyInfo!=null) {
				boolean isDelete = historyDao.deleteHistoryByHistoryInfo(historyInfo);
				return isDelete;
		}else {
			return false;
		}
	}

	/**
	*@author:黄羽伦
	*@parm:historyInfo
	*@return:boolean
	*date:2018年12月31日
	*/
	@Override
	public boolean saveHistoryInfo(HistoryInfo historyInfo) {
		if(historyInfo!=null) {
			boolean isExist =historyDao.selectHistoryInfoIsExist(historyInfo);
			System.out.println("service:"+isExist);
			if(isExist==true) {
				return historyDao.updateHistoryInfoTimeByHistoryInfo(historyInfo);
			}else {
				boolean isSave = historyDao.insertHistoryInfo(historyInfo);
				return isSave;
			}
		}
		return false;
		
	}

}
