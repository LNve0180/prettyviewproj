package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.AnnouncementInfo;

public interface IAnnouncementDao {

	/**
	 *@author:黄羽伦
	 *@parm:null
	 *@return:announcementInfo
	 *date:2018年12月24日
	 */
	ArrayList<AnnouncementInfo> selectAllAnnouncementInfo();

	boolean updateAnnouncementStatusByID(String announcementID);

	boolean insertAnnouncementByAnnouncementInfo(AnnouncementInfo announcementInfo);

}
