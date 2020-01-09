/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;

import com.prettyviewproj.Idao.IAnnouncementDao;
import com.prettyviewproj.Iservice.IAnnouncementService;
import com.prettyviewproj.dao.AnnouncementDao;
import com.prettyviewproj.entity.AnnouncementInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/

public class AnnouncementService implements IAnnouncementService {

	private IAnnouncementDao announcementDao;
	
	public AnnouncementService() {
		
		announcementDao = new AnnouncementDao();
	}
	
	@Override
	public ArrayList<AnnouncementInfo> searchAllAnnouncementInfo() {
		
		ArrayList<AnnouncementInfo> announcementInfo = announcementDao.selectAllAnnouncementInfo();
		
		return announcementInfo;

	}

	@Override
	public boolean alterAnnouncementStatusByID(String announcementID) {
		if(announcementID!=null && announcementID!="") {
			boolean isAlter = announcementDao.updateAnnouncementStatusByID(announcementID);
			return isAlter;
		}else {
			return false;
		}
	}

	@Override
	public boolean saveAnnouncementByAnnouncementInfo(AnnouncementInfo announcementInfo) {
		if(announcementInfo!=null) {
			boolean isSave = announcementDao.insertAnnouncementByAnnouncementInfo(announcementInfo);
			return isSave;
		}else {
			return false;
		}
		
	}

}
