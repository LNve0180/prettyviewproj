/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.ArrayList;

import com.prettyviewproj.entity.CommentInfo;
import com.prettyviewproj.entity.CommentReplyShowInfo;
import com.prettyviewproj.entity.ReplyInfo;
import com.prettyviewproj.entity.ReportCommentInfo;
/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public interface ICommentService {
	boolean saveCommentInfo(CommentInfo commentInfo);

	boolean saveReplyInfo(ReplyInfo replyInfo);

	boolean saveCommentFabulousInfo(String userID, String commentID);

	boolean saveReportCommentInfo(ReportCommentInfo reportCommentInfo);
	
	ArrayList<CommentReplyShowInfo> searchCommentReplyInfoByWorksID(String worksID);

	ArrayList<ReportCommentInfo> searchAllReportCommentInfo();

	boolean automaticAuditCommentReport(String adminID);
}
