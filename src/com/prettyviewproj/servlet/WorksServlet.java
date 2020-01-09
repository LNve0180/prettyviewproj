package com.prettyviewproj.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oreilly.servlet.MultipartRequest;
import com.prettyviewproj.Iservice.IWorksService;
import com.prettyviewproj.entity.AdminInfo;
import com.prettyviewproj.entity.FabulousInfo;
import com.prettyviewproj.entity.ReportWorksInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.entity.WorksInfo;
import com.prettyviewproj.entity.WorksReviewInfo;
import com.prettyviewproj.entity.WorksShowInfo;
import com.prettyviewproj.service.WorksService;
import com.prettyviewproj.tools.TimeTool;

/**
 * Servlet implementation class WorksServelet
 */
@WebServlet("/WorksServlet")
public class WorksServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       private IWorksService worksService=new WorksService();
    /**
     * @see BaseServlet#BaseServlet()
     */
    public WorksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void queryWorksInfoByWorksCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String worksCategory = request.getParameter("worksCategory");

		ArrayList<WorksShowInfo> worksListByWorksCategory = null;
		worksListByWorksCategory = worksService.searchWorksInfoByCategoryID(worksCategory);

		if (worksListByWorksCategory != null) {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson(worksListByWorksCategory);
			out.write(result);
			out.flush();
			out.close();
		} else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson("null");
			out.write(result);
			out.flush();
			out.close();
		}
		// worksService.searchWorksInfoByCategoryID(worksCategory);
	}

	
	
	public void queryLatestWorksInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<WorksShowInfo> latestWorksList = worksService.searchLatestWorksInfo();
		if (latestWorksList != null) {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson(latestWorksList);
			out.write(result);
			out.flush();
			out.close();
		} else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson("null");
			out.write(result);
			out.flush();
			out.close();
		}

	}
	
	public void queryWorksInfoRandomly(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<WorksShowInfo> worksInfoListRandomly = worksService.searchWorksInfoRandomly();
		if (worksInfoListRandomly != null) {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson(worksInfoListRandomly);
			out.write(result);
			out.flush();
			out.close();
		} else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson("null");
			out.write(result);
			out.flush();
			out.close();
		}

	}
	
	public void queryTopWorksInfoByCollectNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<WorksShowInfo> worksListByCollect = worksService.searchTopWorksInfoByCollectNum();
		if (worksListByCollect != null) {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson(worksListByCollect);
			out.write(result);
			out.flush();
			out.close();
		} else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson("null");
			out.write(result);
			out.flush();
			out.close();
		}

	}
	
	public void queryTopWorksInfoByCommentNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<WorksShowInfo> worksListByComment = worksService.searchTopWorksInfoByCommentNum();
		if (worksListByComment != null) {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson(worksListByComment);
			out.write(result);
			out.flush();
			out.close();
		} else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson("null");
			out.write(result);
			out.flush();
			out.close();
		}

	}
	
	public void queryTopWorksInfoByFabulousNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<WorksShowInfo> worksListByFabulous = worksService.searchTopWorksInfoByFabulousNum();
		if (worksListByFabulous != null) {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson(worksListByFabulous);
			out.write(result);
			out.flush();
			out.close();
		} else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String result = gs.toJson("null");
			out.write(result);
			out.flush();
			out.close();
		}

	}
	
	public void queryWorksInfoByUserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = (String) request.getParameter("userID");
		ArrayList<WorksShowInfo> worksInfoList = worksService.searchWorksInfoByUserID(userID);
		String reResult="";
		Gson gs = new Gson();
		PrintWriter out = response.getWriter();
		if (worksInfoList != null) {
			reResult=gs.toJson(worksInfoList);
		} else {
			reResult="null";
		}
		out.write(reResult);
		out.flush();
		out.close();

	}
	
	public void queryWorksInfoByWorksID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String worksID=(String)request.getParameter("worksID");
		WorksShowInfo worksInfo=worksService.searchWorksInfoByWorksID(worksID);	
		if(worksInfo==null)
		{
			Gson gs=new Gson();
			PrintWriter out=response.getWriter();
			String result=gs.toJson("null");
			out.write(result);
			out.flush();
			out.close();
		}
		else
		{
			Gson gs=new Gson();
			PrintWriter out=response.getWriter();
			String userShowInfo=gs.toJson(worksInfo);
			out.write(userShowInfo);
			out.flush();
			out.close();
		}
	}

	
	//黄羽伦
    public void addFabulousInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	HttpSession session = request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID = loginUserInfo.getUserID();
    	//获取worksID
    	String worksID= request.getParameter("worksID");
    	String fabulousMsg="";
    	boolean isAdd = worksService.saveFabulousInfo(userID,worksID);
    	if(isAdd==true) {
    		fabulousMsg="点赞成功！";
    	}else {
    		
    		fabulousMsg="点赞失败！";
    	}
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonFabulousMsg = gson.toJson(fabulousMsg);
    	out.write(jsonFabulousMsg);
    	out.flush();
    	out.close();
    }

    
    public void queryWorksCareInfoByUserID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//从session获取userID
    	HttpSession session = request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID = loginUserInfo.getUserID();
    	ArrayList<WorksShowInfo> arrayWorksShowInfo = new ArrayList<WorksShowInfo>();
    	arrayWorksShowInfo = worksService.searchWorksCareInfoByUserID(userID);
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMsg = gson.toJson(arrayWorksShowInfo);
    	out.write(jsonMsg);
    	out.flush();
    	out.close();
    }
    
    public void queryWorksInfoBySearchContent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

    	//从界面获取searchContent
    	String searchContent = request.getParameter("searchcontent");
    	System.out.println(searchContent);
    	ArrayList<WorksShowInfo> arrayWorksShowInfo = new ArrayList<WorksShowInfo>();
    	//arrayWorksShowInfo.clear();//清除原先的内容
    	arrayWorksShowInfo = worksService.searchWorksInfoBySearchContent(searchContent);
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMsg = gson.toJson(arrayWorksShowInfo);
    	out.write(jsonMsg);
    	out.flush();
    	out.close();

    }
    
    
    public void searchFabulousInfoIsExist(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取userID
    	HttpSession session = request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID = loginUserInfo.getUserID();
    	String worksID = request.getParameter("worksID");
    	System.out.println(worksID);
    	String fabulousExistMsg="";
    	FabulousInfo fabulousInfo = worksService.findFabulousInfoIsExist(userID,worksID);
    	if(fabulousInfo!=null) {
    		fabulousExistMsg="存在";
    	}else{
    		fabulousExistMsg="不存在";
    	}
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonFabulousMsg = gson.toJson(fabulousExistMsg);
    	out.write(jsonFabulousMsg);
    	out.flush();
    	out.close();
    	
    }
    
    
    public void addReportWorksInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取userID
    	HttpSession session = request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID = loginUserInfo.getUserID();
    	//获取worksID
    	String worksID = request.getParameter("worksID");
    	//获取reportContent
    	String reportReason = request.getParameter("reportContent");
    	//获取时间
    	String reportTime = TimeTool.getTime();
    	String addMsg="";
    	ReportWorksInfo reportWorksInfo = new ReportWorksInfo(userID,worksID,reportReason, reportTime);
    	boolean isAdd = worksService.saveReportWorksInfo(reportWorksInfo);
    	if(isAdd==true) {
    		addMsg="举报成功！";
    	}else {
    		addMsg="举报提交失败！";
    	}
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonAddMsg = gson.toJson(addMsg);
    	out.write(jsonAddMsg);
    	out.flush();
    	out.close();
    }
	
    /* 管理员审核被举报作品信息
     * author:huangyulun
     * date:2019/04/04
     */
    public void queryWorksReviewInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	ArrayList<WorksReviewInfo> worksReviewInfo = new ArrayList<WorksReviewInfo>();
    	worksReviewInfo = worksService.searchWorksReviewInfo();
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	if(worksReviewInfo!=null) {
        	String jsonWorksReviewInfo = gson.toJson(worksReviewInfo);
        	out.write(jsonWorksReviewInfo);
        	out.flush();
        	out.close();
    	}
    }
    
    /*管理员查看作品审核详情
     * author:huangyulun
     * data:2019/04/06
     * */
    public void queryWorksReviewDetails(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String worksID = request.getParameter("worksID");
    	System.out.println(worksID);
    	Map<String, Object> worksReviewDetailsMap = worksService.searchWorksReviewDetails(worksID);
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	if(worksReviewDetailsMap != null) {
    		String jsonMap = gson.toJson(worksReviewDetailsMap);
        	out.write(jsonMap);
        	out.flush();
        	out.close();
    	}else {
    		System.out.println("map is null");
    	}
    }
    
    /*管理员作品审核  0:不通过  1:通过
     * author:huangyulun
     * date:2019/04/06
     * */
    public void modifyReportWorksInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String worksID = request.getParameter("worksID");
    	String reportStatus = request.getParameter("reportStatus");
    	String reportResult = request.getParameter("reportResult");
    	String jsonWorksShowInfo = request.getParameter("worksShowInfo");
    	String jsonReportWorksInfos = request.getParameter("reportWorksInfos");
		HttpSession session = request.getSession();
		AdminInfo adminInfo = (AdminInfo) session.getAttribute("loginAdminInfo");
		String adminID = adminInfo.getAdminID();
    	Gson gson = new Gson();
    	WorksShowInfo worksShowInfo = gson.fromJson(jsonWorksShowInfo, WorksShowInfo.class);
    	ArrayList<ReportWorksInfo> reportWorksInfos = gson.fromJson(jsonReportWorksInfos,  new TypeToken<ArrayList<ReportWorksInfo>>() {}.getType());
    	worksShowInfo.setWorksStatus(Integer.parseInt(reportStatus));
    	for(int i = 0 ; i < reportWorksInfos.size(); i++) {
    		if(Integer.parseInt(reportStatus)==1) {
    			reportWorksInfos.get(i).setReportResult("审核结果：通过");
    		}else if(Integer.parseInt(reportStatus)==0){
    			reportWorksInfos.get(i).setReportResult("审核结果："+reportResult);
    		}
    		reportWorksInfos.get(i).setReportStatus(Integer.parseInt(reportStatus));
    	}
    	boolean isAlter = worksService.alterReportWorksInfo(reportWorksInfos,worksShowInfo,adminID);
    	String msgString="";
    	if(isAlter) {
    		msgString="true";
    	}else {
    		msgString="false";
    	}
    	PrintWriter out = response.getWriter();
    	String jsonMsg = gson.toJson(msgString);
    	out.write(jsonMsg);
    	out.flush();
    	out.close();
    	
    }
//    public void modifyReportWorksInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
//    	String worksID = request.getParameter("worksID");
//    	String reportStatus = request.getParameter("reportStatus");
//    	String reportResult = request.getParameter("reportResult");
////    	String msg = "";
//    	if(worksID != null && reportStatus != null) {
//    		HashMap<String,String> returnMsg = worksService.alterReportWorksInfo(worksID,reportStatus,reportResult);
////    		if(isModify == true) {
////    			msg = "true";
////    		}else {
////    			msg = "false";
////    		}
//        	PrintWriter out = response.getWriter();
//        	Gson gson = new Gson();
//        	String jsonMsg = gson.toJson(returnMsg);
//        	out.write(jsonMsg);
//        	out.flush();
//        	out.close();
//    	}else {
//    		System.out.println("参数为空");
//    	}
//    }
    
    /*管理员查看未审核的作品
     * author:dingyanpeng
     * data:2019/05/01
     * */
    public void queryUnaditedWorksInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		ArrayList<WorksShowInfo> arrayUnaditedWorksShowInfo = new ArrayList<WorksShowInfo>();
		// arrayWorksShowInfo.clear();//清除原先的内容
		arrayUnaditedWorksShowInfo = worksService.searchUnaditedWorksInfo();
		if (arrayUnaditedWorksShowInfo != null) {		
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			String unaditedWorksShowInfo = gs.toJson(arrayUnaditedWorksShowInfo);
			out.write(unaditedWorksShowInfo);
			out.flush();
			out.close();
			System.out.println("Servlet: not null");
		} else {
			// request errorMsg
			System.out.println("servlet:null ");
		}

	}
    
    /*修改作品的审核状态
     * author:dingyanpeng
     * data:2019/05/01
     * */
    public void reviewNewWorks(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String worksID = request.getParameter("worksID");
    	String worksName =  request.getParameter("worksName");
    	String uploadTime = request.getParameter("uploadTime");
    	String aditingStatus = request.getParameter("reviewStatus");
    	String reviewReason = request.getParameter("reviewReason");
    	String userID = request.getParameter("userID");
    	String aditingTime = TimeTool.getTime();
    	HttpSession session = request.getSession();
    	AdminInfo adminInfo = (AdminInfo) session.getAttribute("loginAdminInfo");
    	String adminID = adminInfo.getAdminID();
    	WorksInfo worksInfo = new WorksInfo();
    	worksInfo.setWorksID(worksID);
    	worksInfo.setWorksName(worksName);
    	worksInfo.setUploadTime(uploadTime);
    	worksInfo.setAditingTime(aditingTime);
    	worksInfo.setUserID(userID);
    	worksInfo.setAditingStatus(Integer.parseInt(aditingStatus));
    	String updateMsg="";
//    	HashMap<String,String> returnMsg = new HashMap<String,String>();
    	if(worksService.reviewNewWorks(worksInfo, reviewReason, adminID)) {
    		updateMsg = "true";
    	}else {
    		updateMsg = "false";
    	}
//    	returnMsg.put("flag",updateMsg);
//    	returnMsg.put("aditingStatus",aditingStatus);
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson ();
    	String jsonUpdateMsg = gson.toJson(updateMsg);
    	out.write(jsonUpdateMsg);
    	out.flush();
    	out.close();
    	
    }

    
    /*
	 * 创作者上传作品 author:dyp date:2019/05/01
	 */
	public void addWorksInfoByWorksInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String addResult = "";
		String uploadTime = TimeTool.getUploadTimeFormat();
		String fname = "";
		MultipartRequest multi = null;
		String saveDirectory = "D:/eclipse-workspace-new/PrettyViewProj/WebContent/images";// 服务器上存储路径
		String dirFlag = System.getProperty("file.separator"); // 自动匹配操作系统文件路径
		multi = new MultipartRequest(request, saveDirectory, 1 * 100 * 1024 * 1024, "UTF-8");
		Enumeration efs = multi.getFileNames();
		while (efs.hasMoreElements()) {
			File file = multi.getFile(efs.nextElement().toString());
			if (file.exists()) {
				fname = file.getName();
				// 获取系统当前时间
				String currentTimeMillis = uploadTime.replace(":", "").replace(".", "");
				String t1_fname = fname.substring(0, fname.lastIndexOf("."));
				String t2_fname = fname.substring(fname.lastIndexOf("."));
				fname = t1_fname + "_" + currentTimeMillis + t2_fname;
				File newfile = new File(saveDirectory + dirFlag + fname);
				file.renameTo(newfile);
			}
		}
		// UserID是登陆用户的ID 别忘改
		HttpSession session = request.getSession();
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");

		WorksInfo worksInfo = new WorksInfo("", loginUserInfo.getUserID(), multi.getParameter("worksName"),
				multi.getParameter("worksIntroduction"), uploadTime.substring(0, uploadTime.indexOf(".")),
				"images/" + fname, 2, null, 1, multi.getParameter("worksCategory"));
		if (worksService.saveWorksInfoByWorksInfo(worksInfo)) {
			addResult = "true";
		} else {
			addResult = "false";
		}
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String jsonAddResult = gson.toJson(addResult);
		out.write(jsonAddResult);
		out.flush();
		out.close();
	}


	/*
	 * 查看我的作品 author:dyp date:2019/05/01
	 */
	 public void queryMyWorksInfoByUserID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		HttpSession session = request.getSession();
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		ArrayList<WorksShowInfo> myWorksInfo = worksService.searchMyWorksInfoByUserID(loginUserInfo.getUserID());
	    PrintWriter out = response.getWriter();
	    Gson gson = new Gson();
	    String jsonMap = gson.toJson(myWorksInfo);
	    out.write(jsonMap);
	    out.flush();
	    out.close();
	}

	 /*
		 * 修改作品信息 author:dyp date:2019/05/01
		 */
		public void modifyWorksInfoByWorksInfo(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String updateResult="";
			WorksInfo worksInfo = new WorksInfo();
			worksInfo.setWorksID(request.getParameter("worksID"));
			worksInfo.setWorksName(request.getParameter("worksName"));
			worksInfo.setWorksIntroduction(request.getParameter("worksIntroduction"));
			worksInfo.setWorksCategory(request.getParameter("worksCategory"));
			System.out.println(worksInfo.toString());
			if (worksService.alterWorksInfoByWorksInfo(worksInfo)) {
				updateResult="true";
			} else {
				updateResult="false";
			}
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String jsonUpdateResult = gson.toJson(updateResult);
			out.write(jsonUpdateResult);
			out.flush();
			out.close();
			
		}


	/*
	 * 创作者删除作品 author:dyp date:2019/05/01
	 */
	public void cutoffWorksInfoByWorksID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String worksID = request.getParameter("worksID");
		String returnMsg = "";
		if (worksService.removeWorksInfoByWorksID(worksID)) {
			returnMsg = "true";
		} else {
			returnMsg = "false";
		}
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String jsonMsg = gson.toJson(returnMsg);
		out.write(jsonMsg);
		out.flush();
		out.close();

	}
    
	/*
	 * 查询待审核作品
	 * author:dingyanpeng
	 * date:2019/05/02
	 * */
	public void queryMyUnaditedWorksInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo userInfo = new UserInfo();
		HttpSession session = request.getSession();
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		ArrayList<WorksShowInfo> myWorksInfo = worksService.searchMyUnaditedWorksInfo(loginUserInfo.getUserID());
	    PrintWriter out = response.getWriter();
	    Gson gson = new Gson();
	    String jsonWorksInfo = gson.toJson(myWorksInfo);
	    out.write(jsonWorksInfo);
	    out.flush();
	    out.close();

	}

	
    /*
     * 作品信息分页
     * author:huangyulun
     * date:2019/04/27
     * */
    public void getPageInfomation(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String pageNum = request.getParameter("pageNum");
    	HashMap<String,Object> pageMap = worksService.getPageInfomation(pageNum);
    	if(pageMap == null) {
    		System.out.println("null");
    	}
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMap = gson.toJson(pageMap);
    	out.write(jsonMap);
    	out.flush();
    	out.close();
    }
    
    /*
          * 图片搜索图片
     *author:huangyulun
     *date:2019/05/10 
     * */
    public void compareSimilarWorks(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String addResult = "";
		String uploadTime = TimeTool.getUploadTimeFormat();
		String fname = "";
		MultipartRequest multi = null;
		String saveDirectory = "D:/eclipse-workspace-new/PrettyViewProj/WebContent/imagesTemp";// 服务器上存储路径
		String dirFlag = System.getProperty("file.separator"); // 自动匹配操作系统文件路径
		multi = new MultipartRequest(request, saveDirectory, 1 * 100 * 1024 * 1024, "UTF-8");
		Enumeration efs = multi.getFileNames();
		while (efs.hasMoreElements()) {
			File file = multi.getFile(efs.nextElement().toString());
			if (file.exists()) {
				fname = file.getName();
				// 获取系统当前时间
				String currentTimeMillis = uploadTime.replace(":", "").replace(".", "");
				String t1_fname = fname.substring(0, fname.lastIndexOf("."));
				String t2_fname = fname.substring(fname.lastIndexOf("."));
				fname = t1_fname + "_" + currentTimeMillis + t2_fname;
				File newfile = new File(saveDirectory + dirFlag + fname);
				file.renameTo(newfile);
			}
		}
			System.out.println(fname);
			//到servlice
			ArrayList<WorksShowInfo> arrayWorksShowInfos = worksService.compareSimilarWorksService(fname);
	    	PrintWriter out = response.getWriter();
	    	Gson gson = new Gson();
	    	String jsonWorksShowInfo = gson.toJson(arrayWorksShowInfos);
	    	out.write(jsonWorksShowInfo);
	    	out.flush();
	    	out.close();
    }
    
    public void getTest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
//    	String testInfo = request.getParameter("aaa");
//    	System.out.println("WorksServlet:"+testInfo);
    	String testInfo = request.getParameter("worksID");
    	System.out.println("WorksServlet:"+testInfo);
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMap = gson.toJson(testInfo);
    	out.write(jsonMap);
    	out.flush();
    	out.close();
    }
}
