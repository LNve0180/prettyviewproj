package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.NoticeInfo;

public interface INoticeDao {


	ArrayList<NoticeInfo> selectAllNoticeInfo();
	boolean insertNoticeInfoByNoticeInfo(NoticeInfo noticeInfo);
	ArrayList<NoticeInfo> selectNoticeInfoByUserID(String userID);
	boolean updateNoticeStatusByUserID(String userID);
	boolean insertNoticeInfoByArrayNoticeInfo(ArrayList<NoticeInfo> noticeInfos);
}
