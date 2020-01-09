/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;

import com.prettyviewproj.Idao.INoticeDao;
import com.prettyviewproj.Iservice.INoticeService;
import com.prettyviewproj.dao.NoticeDao;
import com.prettyviewproj.entity.NoticeInfo;
import com.prettyviewproj.tools.TimeTool;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class NoticeService implements INoticeService {
	
	private INoticeDao noticeDao;

	public NoticeService() {
		
		noticeDao = new NoticeDao();
	}
	
	/**
	*@author:黄羽伦
	*@parm:null
	*@return:noticeInfo
	*date:2018年12月24日
	*/
	@Override
	public ArrayList<NoticeInfo> searchAllNoticeInfo() {
		ArrayList<NoticeInfo> noticeInfo = new ArrayList<NoticeInfo>();
		noticeInfo = noticeDao.selectAllNoticeInfo();
		return noticeInfo;
	}

	@Override
	public ArrayList<NoticeInfo> searchNoticeInfoByUserID(String userID) {
		ArrayList<NoticeInfo> noticeInfo = noticeDao.selectNoticeInfoByUserID(userID);
		if(noticeInfo!=null) {
			boolean isUpdate = noticeDao.updateNoticeStatusByUserID(userID);
		}
		return noticeInfo;
	}

	@Override
	public boolean saveCreatorReviewNoticeMsg(String userID, String adminID, String noticeContent) {
		if(userID != "" && userID !=null && adminID != null &&adminID!=""&&noticeContent!=null&&noticeContent!="") {
			NoticeInfo noticeInfo = new NoticeInfo(adminID, noticeContent, "系统通知", TimeTool.getTime(),1,userID);
			boolean isInsert = noticeDao.insertNoticeInfoByNoticeInfo(noticeInfo);
			return isInsert;
		}
		return false;
	}

}
