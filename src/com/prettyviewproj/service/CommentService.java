/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;
import java.util.List;

import com.prettyviewproj.Idao.ICommentDao;
import com.prettyviewproj.Idao.INoticeDao;
import com.prettyviewproj.Iservice.ICommentService;
import com.prettyviewproj.dao.CommentDao;
import com.prettyviewproj.dao.NoticeDao;
import com.prettyviewproj.entity.CommentInfo;
import com.prettyviewproj.entity.CommentReplyShowInfo;
import com.prettyviewproj.entity.NoticeInfo;
import com.prettyviewproj.entity.ReplyInfo;
import com.prettyviewproj.entity.ReportCommentInfo;
import com.prettyviewproj.sensitivewdfilter.WordFilter;
import com.prettyviewproj.tools.TimeTool;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class CommentService implements ICommentService {
private ICommentDao commentDao;
private INoticeDao noticeDao;
	public CommentService() {
		commentDao = new CommentDao();
		noticeDao = new NoticeDao();
	}
	
	/**
	*@author:黄羽伦
	*@parm:commentInfo
	*@return:boolean
	*date:2018年12月25日
	*/
	@Override
	public boolean saveCommentInfo(CommentInfo commentInfo) {
		
		//判断格式
		
			boolean isSave = commentDao.insertCommentInfo(commentInfo);
		
		
		return isSave;

	}


	@Override
	public boolean saveReplyInfo(ReplyInfo replyInfo) {
		
		//判断格式
		
		boolean isSave = commentDao.insertReplyInfo(replyInfo);
	
	
		return isSave;
	}

	/**
	*@author:黄羽伦
	*@parm:userID,commentID
	*@return:boolean
	*date:2018年12月25日
	*/
	@Override
	public boolean saveCommentFabulousInfo(String userID, String commentID) {
		
		//判断参数是否为空和格式
		

		boolean isSave = commentDao.insertCommentFabulousInfo(userID,commentID);
				
				
		return isSave;

	}

	/**
	*@author:黄羽伦
	*@parm:reportCommentInfo
	*@return:boolean
	*date:2018年12月25日
	*//*
	@Override
	public boolean saveCommentReportInfo(ReportCommentInfo reportCommentInfo) {

		//判断参数是否为空
			boolean isSave = commentDao.insertCommentReportInfo(reportCommentInfo);
			
			if(isSave==true) {
				
				boolean isUpdate = commentDao.updateCommentAditingStatusByCommentID(reportCommentInfo.getCommentID());
				
				if(isUpdate==true) {
					
					return true;
					
				}else {
					
					return false;
				}
				
			}else {
				
				return false;
			}
		
	}
*/
	/**
	*@author:黄羽伦
	*@parm:reportCommentInfo
	*@return:boolean
	*date:2018年12月30日
	*/
	@Override
	public boolean saveReportCommentInfo(ReportCommentInfo reportCommentInfo) {

		if(reportCommentInfo!=null) {
			
			boolean isSave = commentDao.insertReportCommentInfo(reportCommentInfo);
			
			return isSave;
		}
		
		
		return false;
		
	}

	@Override
	public ArrayList<CommentReplyShowInfo> searchCommentReplyInfoByWorksID(String worksID) {
		// TODO Auto-generated method stub
		if(worksID!=null)
		{
			return commentDao.selectCommentReplyInfoByWorksID(worksID);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public ArrayList<ReportCommentInfo> searchAllReportCommentInfo() {
		ArrayList<ReportCommentInfo> arrayReportCommentInfos = commentDao.selectAllReportCommentInfo();
		return arrayReportCommentInfos;
	}

	@Override
	public boolean automaticAuditCommentReport(String adminID) {
		ArrayList<ReportCommentInfo> arrayReportCommentInfos = commentDao.selectAllReportCommentInfo();
		if(arrayReportCommentInfos != null && arrayReportCommentInfos.size() > 0) {
			System.out.println("查询出来的未审核的举报信息"+arrayReportCommentInfos.size());
			//修改状态
			boolean isUpdate = commentDao.updateAllReportStatus(arrayReportCommentInfos);
			if(isUpdate) {
				//查询评论信息
				ArrayList<String> listCommentID = new ArrayList<String>();
				for(int i = 0; i < arrayReportCommentInfos.size();i++) {
					
					listCommentID.add(arrayReportCommentInfos.get(i).getCommentID());
				}
				ArrayList<CommentInfo> commentInfos = commentDao.selectCommentInfoByListCommentID(listCommentID);
				//判断敏感词
				ArrayList<CommentInfo> commentInfosTemp = new ArrayList<CommentInfo>();
				ArrayList<NoticeInfo> noticeInfos = new ArrayList<NoticeInfo>();
				NoticeInfo noticeInfo = null;
				int i;
				for(i = 0; i < commentInfos.size(); i++) {
					boolean isExist = WordFilter.isContains(commentInfos.get(i).getCommentContent());
					String noticeContent="";
					if(isExist) {
						//改变实例里的Status
						commentInfos.get(i).setCommentStatus(0);
						commentInfosTemp.add(commentInfos.get(i));//有敏感词的用来修改comment状态的
						int j;
						for(j = 0; j < arrayReportCommentInfos.size(); j++) {
							if(commentInfos.get(i).getCommentID().equals(arrayReportCommentInfos.get(j).getCommentID())) {
								noticeContent="您于"+arrayReportCommentInfos.get(j).getReportCommentTime()+"举报的评论，举报成功(o゜▽゜)o☆，感谢您的监督，我们会做得更好";
								noticeInfo = new NoticeInfo(adminID, noticeContent, "系统通知", TimeTool.getTime(),1,arrayReportCommentInfos.get(j).getUserID());
								noticeInfos.add(noticeInfo);
							}
						}
						String noticeContent2="您于"+commentInfos.get(i).getCommentTime()+"发表的评论，被举报成功（；´д｀）ゞ，希望您能及时纠正不良言语";
						noticeInfo = new NoticeInfo(adminID, noticeContent2, "系统通知", TimeTool.getTime(),1,commentInfos.get(i).getUserID());
						noticeInfos.add(noticeInfo);
					}else {
						int j ;
						for(j = 0; j < arrayReportCommentInfos.size(); j++) {
							if(commentInfos.get(i).getCommentID().equals(arrayReportCommentInfos.get(j).getCommentID())) {
								noticeContent="您于"+arrayReportCommentInfos.get(j).getReportCommentTime()+"举报的评论，举报失败(；′⌒`)，感谢您的监督，我们会做得更好";
								noticeInfo = new NoticeInfo(adminID, noticeContent, "系统通知", TimeTool.getTime(),1,arrayReportCommentInfos.get(j).getUserID());
								noticeInfos.add(noticeInfo);
							}
						}
					}
				}
				//修改commentInfo
				boolean isUpdateCommentStatus = commentDao.updateCommentInfoByCommentInfos(commentInfosTemp);
				//添加通知
				boolean isInsert = noticeDao.insertNoticeInfoByArrayNoticeInfo(noticeInfos);
				if(isUpdateCommentStatus && isInsert) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ICommentService service = new CommentService();
		service.automaticAuditCommentReport("1");
	}
}
