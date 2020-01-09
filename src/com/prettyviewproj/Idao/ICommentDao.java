package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.CommentInfo;
import com.prettyviewproj.entity.CommentReplyShowInfo;
import com.prettyviewproj.entity.ReplyInfo;
import com.prettyviewproj.entity.ReportCommentInfo;

public interface ICommentDao {

	boolean insertCommentInfo(CommentInfo commentInfo);

	boolean insertReplyInfo(ReplyInfo replyInfo);

	boolean insertCommentFabulousInfo(String userID, String commentID);

	//boolean updateCommentAditingStatusByCommentID(String commentID);

	boolean insertReportCommentInfo(ReportCommentInfo reportCommentInfo);
	
	ArrayList<CommentReplyShowInfo> selectCommentReplyInfoByWorksID(String worksID);

	ArrayList<ReportCommentInfo> selectAllReportCommentInfo();

	boolean updateAllReportStatus(ArrayList<ReportCommentInfo> arrayReportCommentInfos);

	ArrayList<CommentInfo> selectCommentInfoByListCommentID(ArrayList<String> listCommentID);

	boolean updateCommentInfoByCommentInfos(ArrayList<CommentInfo> commentInfos);
}
