/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.ArrayList;

import com.prettyviewproj.entity.AnnouncementInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public interface IAnnouncementService {
	ArrayList<AnnouncementInfo> searchAllAnnouncementInfo();

	boolean alterAnnouncementStatusByID(String announcementID);

	boolean saveAnnouncementByAnnouncementInfo(AnnouncementInfo announcementInfo);
}
