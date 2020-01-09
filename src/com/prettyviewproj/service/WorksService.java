/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prettyviewproj.Idao.INoticeDao;
import com.prettyviewproj.Idao.IWorksDao;
import com.prettyviewproj.Iservice.ICommentService;
import com.prettyviewproj.Iservice.IWorksService;
import com.prettyviewproj.dao.NoticeDao;
import com.prettyviewproj.dao.WorksDao;
import com.prettyviewproj.entity.FabulousInfo;
import com.prettyviewproj.entity.NoticeInfo;
import com.prettyviewproj.entity.Page;
import com.prettyviewproj.entity.ReportWorksInfo;
import com.prettyviewproj.entity.WorksInfo;
import com.prettyviewproj.entity.WorksReviewInfo;
import com.prettyviewproj.entity.WorksShowInfo;
import com.prettyviewproj.jieba.JiebaSegmenter;
import com.prettyviewproj.phash.ImagePHash;
import com.prettyviewproj.tools.TimeTool;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class WorksService implements IWorksService {
	//黄羽伦的（dyp你别忘了改）
	private IWorksDao worksDao ;
	private INoticeDao noticeDao;
	private ArrayList<WorksShowInfo> arrayworksShowInfo;
	public static final int pageSize = 40; //每一页显示的数量
	
	public WorksService() {
		worksDao = new WorksDao();
		noticeDao = new NoticeDao();
		arrayworksShowInfo = new ArrayList<WorksShowInfo>();
		
	}
	
	@Override
	public ArrayList<WorksShowInfo> searchWorksInfoByCategoryID(String worksCategory) {
		// TODO Auto-generated method stub
		if(worksCategory!=null)
		{
			return worksDao.selectWorksInfoByCategoryID(worksCategory);
		}
		return null;
	}
	@Override
	public ArrayList<WorksShowInfo> searchLatestWorksInfo() {
		// TODO Auto-generated method stub
		return worksDao.selecLatestWorksInfo();
	}
	@Override
	public ArrayList<WorksShowInfo> searchWorksInfoRandomly() {
		// TODO Auto-generated method stub
		return worksDao.selectWorksInfoRandomly();
	}
	@Override
	public ArrayList<WorksShowInfo> searchTopWorksInfoByCollectNum() {
		// TODO Auto-generated method stub
		return worksDao.selectTopWorksInfoByCollectNum();
	}
	@Override
	public ArrayList<WorksShowInfo> searchTopWorksInfoByCommentNum() {
		// TODO Auto-generated method stub
		return worksDao.selectTopWorksInfoByCommentNum();
	}
	@Override
	public ArrayList<WorksShowInfo> searchTopWorksInfoByFabulousNum() {
		// TODO Auto-generated method stub
		return worksDao.selectTopWorksInfoByFabulousNum();
	}

	@Override
	public ArrayList<WorksShowInfo> searchWorksInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		if(userID!=null)
		{
			return worksDao.selectWorksInfoByUserID(userID);
		}
		return null;
	}

	@Override
	public WorksShowInfo searchWorksInfoByWorksID(String worksID) {
		// TODO Auto-generated method stub
	
			return worksDao.selectWorksInfoByWorksID(worksID);

	}
	
	/**
	*@author:黄羽伦
	*@parm:String userID,String worksID
	*@return:boolean
	*date:2018年12月23日
	*/
	
	@Override
	public boolean saveFabulousInfo(String userID, String worksID) {
		
		//判断参数是否为空和格式
		
		boolean isSave = worksDao.insertFabulousInfo(userID,worksID);
		
		
		return isSave;

	}

	/**
	*@author:黄羽伦
	*@parm:searchContent
	*@return:WorksShowInfo
	*date:2018年12月27日
	*/
	@Override
	public ArrayList<WorksShowInfo> searchWorksInfoBySearchContent(String searchContent) {
		//判断格式
		if(searchContent!=null) {
			ArrayList<WorksShowInfo> arrayworksShowInfo = new ArrayList<WorksShowInfo>();
			arrayworksShowInfo = worksDao.selectWorksInfoBySearchContent(searchContent);
			return arrayworksShowInfo;
		}
		return null;
	}

	/**
	*@author:黄羽伦
	*@parm:userID,worksID
	*@return:fabulousInfo
	*date:2018年12月30日
	*/
	@Override
	public FabulousInfo findFabulousInfoIsExist(String userID, String worksID) {

		if(userID!=null && worksID!=null) {
			
			FabulousInfo fabulousInfo = worksDao.selectFabulousInfoIsExist(userID,worksID);
			
			return fabulousInfo;
			
		}
		return null;
		
	}

	/**
	*@author:黄羽伦
	*@parm:reportWorksInfo
	*@return:boolean
	*date:2018年12月30日
	*/
	@Override
	public boolean saveReportWorksInfo(ReportWorksInfo reportWorksInfo) {
		
		if(reportWorksInfo!=null) {
		
			boolean isSave = worksDao.insertReportWorksInfo(reportWorksInfo);
			
			return isSave;
			
		}else {

			return false;
			
		}

		
	}

	/**
	*@author:黄羽伦
	*@parm:userID
	*@return:worksShowInfo
	*date:2019年1月2日
	*/
	@Override
	public ArrayList<WorksShowInfo> searchWorksCareInfoByUserID(String userID) {

		if(userID!=null) {
			
			ArrayList<WorksShowInfo> arrayWorksShowInfo = worksDao.queryWorksCareInfoByUserID(userID);
			
			return arrayWorksShowInfo;
		}
		
		return null;
		
	}

	/*
	 * 查询审核信息
	 * author:huangyulun
	 * date:2019/04/06
	 * */
	@Override
	public ArrayList<WorksReviewInfo> searchWorksReviewInfo() {
		ArrayList<WorksReviewInfo> worksReviewInfo = worksDao.selectWorksReviewInfo();
		if(worksReviewInfo!=null) {
			return worksReviewInfo;
		}
		return null;
	}

	@Override
	public Map<String, Object> searchWorksReviewDetails(String worksID) {
		Map<String, Object> worksReviewDetailsMap = new HashMap<String, Object>();
		System.out.println(worksID);
		if(worksID != null) {
			WorksShowInfo worksShowInfo = worksDao.selectWorksInfoByWorksID(worksID);
			ArrayList<ReportWorksInfo> reportWorksInfo = worksDao.selectReportWorksInfoByWorksId(worksID);
			if(worksShowInfo !=null && reportWorksInfo!=null) {
				worksReviewDetailsMap.put("WorksShowInfo", worksShowInfo);
				worksReviewDetailsMap.put("ReportWorksInfo", reportWorksInfo);
				return worksReviewDetailsMap;
			}
		}
		return null;
	}

//	@Override
//	public HashMap<String,String> alterReportWorksInfo(String worksID, String reportStatus,String reportResult) {
//		HashMap<String,String> returnMsg = new HashMap<String,String>();
//		String flag="0"; //操作是否成功标志，0:false, 1:true; 默认是0: false
//		if(worksID != null && reportStatus != null) {
//			boolean isAlter = false;
//			if(reportStatus.equals("1")) {
//				reportResult = "审核结果：通过";
//				isAlter = worksDao.updateReportWorksInfoByWorksID(worksID,reportStatus,reportResult);
//				if(isAlter == true) {
//					//flag = "1";
//					//修改作品状态 worksStatus= :还原操作
//					boolean isWorksStatus = worksDao.updateWorksStatusReturnByWorksID(worksID);
//					if(isWorksStatus == true) {
//						flag = "1";
//					}else {
//						System.out.println("修改worksStatus失败");
//						flag = "0";
//					}
//					returnMsg.put("reportStatus",reportStatus);
//					returnMsg.put("flag",flag);
//					return returnMsg;
//				}else {
//					//flag = "0";
//					returnMsg.put("reportStatus",reportStatus);
//					returnMsg.put("flag",flag);
//					//return isAlter;
//					return returnMsg;
//				}
//
//			}else if(reportStatus.equals("0")) {
//				reportResult = "审核结果："+reportResult;
//				isAlter = worksDao.updateReportWorksInfoByWorksID(worksID,reportStatus,reportResult);
//				if(isAlter == true) {
//					//修改作品状态 worksStatus=0 :删除操作
//					boolean isWorksStatus = worksDao.updateWorksStatusByWorksID(worksID);
//					if(isWorksStatus == true) {
//						flag = "1";
//					}else {
//						System.out.println("修改worksStatus失败");
//						flag = "0";
//					}
//					returnMsg.put("reportStatus",reportStatus);
//					returnMsg.put("flag",flag);
//					return returnMsg;
//				}else {
//					System.out.println("当reportStatus=0时，操作失败。");
//					//return false;
//					flag = "0";
//					returnMsg.put("reportStatus",reportStatus);
//					returnMsg.put("flag",flag);
//					return returnMsg;
//				}
//			}else {
//				//return false;
//				returnMsg.put("reportStatus",reportStatus);
//				returnMsg.put("flag",flag);
//				return returnMsg;
//			}
//			
//		}
//		returnMsg.put("reportStatus",reportStatus);
//		returnMsg.put("flag",flag);
//		return returnMsg;
//		
//	}

	
	@Override
	public ArrayList<WorksShowInfo> searchUnaditedWorksInfo() {
		// TODO Auto-generated method stub
		return worksDao.selectUnaditedWorksInfo();
	}

	@Override
	public boolean reviewNewWorks(WorksInfo worksInfo,String reviewReason,String adminID) {
		// TODO Auto-generated method stub
		if(worksInfo!=null&&reviewReason!=null)
		{
			//修改状态
			boolean updateResult=worksDao.updateAditingStatusByWorksID(worksInfo.getWorksID(),worksInfo.getAditingStatus()+"",worksInfo.getAditingTime());
			//发通知
			String noticeContent="";
			if(worksInfo.getAditingStatus()==1) {
				noticeContent="尊敬的用户，你好，你于"+worksInfo.getUploadTime()+"上传的作品<<"+worksInfo.getWorksName()+">>，经过我们的层层审查，觉得你的作品符合要求，恭喜你！！!作品通过ヽ(✿ﾟ▽ﾟ)ノ" ;	
			}else {
				noticeContent="尊敬的用户，你好，你于"+worksInfo.getUploadTime()+"上传的作品<<"+worksInfo.getWorksName()+">>，经过我们的层层审查，因为"+reviewReason+"，所以我们觉得你的作品不符合要求，非常抱歉，你的作品并未通过Σ( ° △ °|||)︴";
			}
			NoticeInfo noticeInfo=new NoticeInfo(adminID, noticeContent, "系统通知", TimeTool.getTime(),1,worksInfo.getUserID());
			INoticeDao noticeDao=new NoticeDao();
			noticeDao.insertNoticeInfoByNoticeInfo(noticeInfo);
			return updateResult;
		}
		else {
			return false;
		}
	}

	@Override
	public HashMap<String, Object> getPageInfomation(String pageNum) {
		HashMap<String,Object> pageMap = new HashMap<String,Object>();
		//获取数据总数
		int totalRecord = worksDao.countWorksRecord();
		int totalPage = ( totalRecord + pageSize - 1) / pageSize;
		//从pageNum页开始查找
		int limitBegin = ( Integer.parseInt(pageNum) - 1 ) * pageSize;
		System.out.println("总数量:"+totalRecord);
		System.out.println("总页数:"+totalPage);
		System.out.println("开始查找数:"+limitBegin);
		ArrayList<WorksShowInfo> arrayWorksShowInfo = worksDao.selectPageWorksShowInfo(limitBegin,pageSize);
		if(arrayWorksShowInfo != null) {
			Page page = new Page();
			page.setPageNum(Integer.parseInt(pageNum));
			page.setTotalRecord(totalRecord);
			page.setTotalPage(totalPage);
			pageMap.put("page",page);
			pageMap.put("arrayWorksShowInfo", arrayWorksShowInfo);
			return pageMap;
		}
		return null;
	}
	
	@Override
	public ArrayList<WorksShowInfo> searchMyWorksInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		if(userID!=null) {
			return worksDao.selectMyWorksInfoByUserID(userID);
		}else
		return null;
	}

	@Override
	public boolean saveWorksInfoByWorksInfo(WorksInfo worksInfo) {
		// TODO Auto-generated method stub
		if(worksInfo!=null) {
			return worksDao.insertWorksInfoByWorksInfo(worksInfo);
		}else
			return false;
	}

	@Override
	public boolean alterWorksInfoByWorksInfo(WorksInfo worksInfo) {
		// TODO Auto-generated method stub
		if(worksInfo!=null) {
			return worksDao.updateWorksInfoByWorksInfo(worksInfo);
		}else
			return false;
	}

	@Override
	public boolean removeWorksInfoByWorksID(String worksID) {
		// TODO Auto-generated method stub
		if(worksID!=null) {
			return worksDao.deleteWorksInfoByWorksID(worksID);
		}else
			return false;
	}
	
	@Override
	public ArrayList<WorksShowInfo> searchMyUnaditedWorksInfo(String userID) {
		// TODO Auto-generated method stub
		if(userID!=null) {
			return worksDao.selectMyUnaditedWorksInfo(userID);
		}else
		return null;
	}
	
	public void getSimilarity(){
	
	}
	
	@Override
	public ArrayList<WorksShowInfo> compareSimilarWorksService(String fname) {
		ArrayList<WorksShowInfo> worksShowInfos = worksDao.selectAllWorksInfo();
		ArrayList<WorksShowInfo> arrayWorksShowInfos = new ArrayList<WorksShowInfo>();
		// 比较
		String path = "D:/eclipse-workspace-new/PrettyViewProj/WebContent/imagesTemp/";
		String path2 = "D:/eclipse-workspace-new/PrettyViewProj/WebContent/";
		int i;
		int length = worksShowInfos.size();
		ImagePHash phash = new ImagePHash();
		
		long startTime = System.currentTimeMillis(); 
		
		for(i = 0; i < length; i++) {
			boolean similarity = phash.imgChk(path + fname, path2 + worksShowInfos.get(i).getUploadAddress(), 15);
			if(similarity) {
				arrayWorksShowInfos.add(worksShowInfos.get(i));
			}
		}
		
		long endTime = System.currentTimeMillis();
		float seconds = (endTime - startTime) / 1000F;
		System.out.println(Float.toString(seconds) + " seconds."); 
		return arrayWorksShowInfos;
	}

	@Override
	public boolean alterReportWorksInfo(ArrayList<ReportWorksInfo> reportWorksInfos, WorksShowInfo worksShowInfo,
			String adminID) {
		
			if(reportWorksInfos != null && worksShowInfo != null && adminID !=null && adminID != "") {
				//修改report信息 包含 reportStatus、reportResult
				boolean isUpdate = worksDao.updateReportStatusReturn(reportWorksInfos);
				if(isUpdate) {
					ArrayList<NoticeInfo> noticeInfos = new ArrayList<NoticeInfo>();
					NoticeInfo noticeInfo = null;
					String noticeContent="";
					int i;
					int j;
					//获取举报者ID
					List<String> arrayUserID = new ArrayList<String>();
					List<String> listID = new ArrayList<String>();
					for (int k = 0; k < reportWorksInfos.size(); k++) {
						arrayUserID.add(reportWorksInfos.get(k).getUserID());
					}
					for (int k = 0; k < arrayUserID.size(); k++) {
						if(!listID.contains(arrayUserID.get(k))){
							listID.add(arrayUserID.get(k));
			            }
					}
					for (int k = 0; k < listID.size(); k++) {
						System.out.println("listID:"+listID.get(k));
					}
					//0：拒绝 1：通过
					if(reportWorksInfos.get(0).getReportStatus()==0) {
						//修改作品状态
						boolean isUpdateStatus = worksDao.updateWorksStatusByWorksID(worksShowInfo.getWorksID());
						if(isUpdateStatus) {
							//发通知 给举报者
							for(j = 0; j < listID.size(); j++) {
								noticeContent = "您于"+reportWorksInfos.get(j).getReportTime()+"举报的《"+worksShowInfo.getWorksName()+"》作品，举报成功(o゜▽゜)o☆，感谢您的监督，我们会做得更好。";
								noticeInfo = new NoticeInfo(adminID,noticeContent, "系统通知", TimeTool.getTime(),1,listID.get(j));
								noticeInfos.add(noticeInfo);
							}
							//发通知 给作者
							noticeContent="您于"+worksShowInfo.getUploadTime()+"上传的《"+worksShowInfo.getWorksName()+"》的作品被举报已经处理（；´д｀）ゞ，希望您能遵守规则及时纠正，以免再犯，感谢您的配合,";
							noticeInfo = new NoticeInfo(adminID,noticeContent, "系统通知", TimeTool.getTime(),1,worksShowInfo.getUserID());
							noticeInfos.add(noticeInfo);
						}
					}else {
						//发通知 给举报者
						for(j = 0; j < listID.size(); j++) {
							noticeContent = "您于"+reportWorksInfos.get(j).getReportTime()+"举报的《"+worksShowInfo.getWorksName()+"》作品，举报失败(；′⌒`)，感谢您的监督，我们会做得更好。";
							noticeInfo = new NoticeInfo(adminID,noticeContent, "系统通知", TimeTool.getTime(),1,listID.get(j));
							noticeInfos.add(noticeInfo);
						}
					}
					//添加notice
					boolean isInsert = noticeDao.insertNoticeInfoByArrayNoticeInfo(noticeInfos);
					if(isInsert) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}
		return false;
	}
	
	public static void main(String[] args) {
		IWorksService service = new WorksService();
		//service.searchWorksReviewDetails("112");
		//service.alterReportWorksInfo("113","0","审核结果：不通过");
//		String pageNum = "1";
//		service.getPageInfomation(pageNum);
//		String str = "小七赖美云";
//		JiebaSegmenter segmenter = new JiebaSegmenter();
//		List<String> segmenterList = segmenter.sentenceProcess(str);
//		System.out.println("Controller: "+segmenterList);

	}
}
