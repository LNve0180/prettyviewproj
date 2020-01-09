/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.ArrayList;

import com.prettyviewproj.entity.NoticeInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/

public interface INoticeService {
	ArrayList<NoticeInfo> searchAllNoticeInfo();
	ArrayList<NoticeInfo> searchNoticeInfoByUserID(String userID);
	boolean saveCreatorReviewNoticeMsg(String userID, String adminID, String noticeContent);
}
