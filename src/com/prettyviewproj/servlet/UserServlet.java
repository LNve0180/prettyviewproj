package com.prettyviewproj.servlet;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.prettyviewproj.Iservice.IUserService;
import com.prettyviewproj.entity.ApplicationInfo;
import com.prettyviewproj.entity.ApplicationShowInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.entity.UserShowInfo;
import com.prettyviewproj.service.UserService;
import com.prettyviewproj.tools.TimeTool;


/**
 * Servlet implementation class UserServelet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService=new UserService();
	/**
	 * @see BaseServlet#BaseServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 用户登录 判断密码是否正确 正确则返回UserInfo
	 * author:dyp
	 * date:2019/05/03
	 * 
	 * */
	public void checkUserPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPassword= request.getParameter("userPassword");
		UserInfo  userInfo=userService.judgeUserPassword(userID, userPassword);
		HttpSession session=request.getSession();
		String reUserInfo="";
		PrintWriter out=response.getWriter();
		Gson gs=new Gson();
		if(userInfo.getUserPassword().equals(userPassword)&&userInfo!=null)
		{
			userInfo.setUserPassword("");
			session.setAttribute("loginUserInfo",userInfo);
			reUserInfo=gs.toJson(userInfo);
		}
		else
		{
			reUserInfo=gs.toJson("false");		
		}
		out.write(reUserInfo);
		out.flush();
		out.close();	
	}
	
	public void addUserInfoByUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo userInfo=new UserInfo();
		userInfo.setUserPassword(request.getParameter("userPassword"));
		userInfo.setUserName(request.getParameter("userName"));
		userInfo.setUserSex(request.getParameter("userSex"));
		userInfo.setUserEmail(request.getParameter("userEmail"));
		userInfo.setUserPhone(request.getParameter("userPhone"));
		userInfo.setUserOccupation(request.getParameter("userOccupation"));
		userInfo.setUserIntroduction(request.getParameter("userIntroduction"));
		userInfo.setUserHeadPhoto("headPhoto/head.jpg");
		userInfo.setCreatorStatus(0);
		userInfo.setUserIDStatus(1);
		String userID=userService.saveUserInfoByUserInfo(userInfo);
		if(userID.equals("")||userID==null)
		{
			userID="null";
		}
		else
		{
			userInfo.setUserID(userID);
			userInfo.setUserPassword("");
			HttpSession session=request.getSession();
			session.setAttribute("loginUserInfo", userInfo);
		}
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String reUserID=gs.toJson(userID);
		out.write(reUserID);
		out.flush();
		out.close();
	}
	
	public void modifyUserInfoByUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo userInfo=new UserInfo();
		HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");			
		userInfo.setUserID(loginUserInfo.getUserID());
		userInfo.setUserName(request.getParameter("userName"));
		userInfo.setUserSex(request.getParameter("userSex"));
		userInfo.setUserEmail(request.getParameter("userEmail"));
		userInfo.setUserPhone(request.getParameter("userPhone"));
		userInfo.setUserOccupation(request.getParameter("userOccupation"));
		userInfo.setUserIntroduction(request.getParameter("userIntroduction"));
		String alterResult="";
		if(userService.alterUserInfoByUserInfo(userInfo))
		{
			loginUserInfo.setUserName(userInfo.getUserName());
			loginUserInfo.setUserSex(userInfo.getUserSex());
			loginUserInfo.setUserEmail(userInfo.getUserEmail());
			loginUserInfo.setUserPhone(userInfo.getUserPhone());
			loginUserInfo.setUserOccupation(userInfo.getUserOccupation());
			loginUserInfo.setUserIntroduction(userInfo.getUserIntroduction());
			session.setAttribute("loginUserInfo", loginUserInfo);
			alterResult="true";
		}
		else
		{
			alterResult="false";
		}
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String reAlterResult=gs.toJson(alterResult);
		out.write(reAlterResult);
		out.flush();
		out.close();

	}
	public void checkUserOldPasswordByUserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userOldPassword=request.getParameter("userOldPassword");
		HttpSession session=request.getSession();
		System.out.println(userOldPassword);
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		PrintWriter out=response.getWriter();
		String isRight="";
		if(userService.judgeUserOldPasswordByUserID(loginUserInfo.getUserID(), userOldPassword))
		{
			isRight="true";
		}
		else
		{
			isRight="false";
		}
		Gson gs=new Gson();
		String reIsResult=gs.toJson(isRight);
		out.write(reIsResult);
		out.flush();
		out.close();
}

	/*
	 * 用户登录 判断用户是否存在
	 * author:dyp
	 * date:2019/05/03
	 * 
	 * */
	public void searchUserInfoIsExist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID=request.getParameter("userID");
		System.out.println(userID);
		String isExists="";
		if(userService.findUserInfoIsExist(userID))
		{
			isExists="true";
		}
		else
		{
			isExists="false";
		}
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String userIsExists=gs.toJson(isExists);
		out.write(userIsExists);
		out.flush();
		out.close();	
	}
	public void modifyUserPasswordByUserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userNewPassword=request.getParameter("userNewPassword");
		HttpSession session=request.getSession();
		System.out.println(userNewPassword);
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		String updateResult="";
		if(userService.updateUserPasswordByUserID(loginUserInfo.getUserID(), userNewPassword))
		{
			updateResult="true";
		}
		else
		{
			updateResult="false";
		}
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String reUpdateResult=gs.toJson(updateResult);
		out.write(reUpdateResult);
		out.flush();
		out.close();
	}

	public void modifyUserHeadPhotoByUserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String addResult = "";
		String uploadTime = TimeTool.getUploadTimeFormat();
		String fname = "";
		MultipartRequest multi = null;
		String saveDirectory = "D:\\eclipse-workspace-new\\PrettyViewProj\\WebContent\\headPhoto\\";// 服务器上存储路径
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
	
		String updateResult="";
		if(userService.alterUserHeadPhotoByUserID("headPhoto/" + fname, loginUserInfo.getUserID())){
			loginUserInfo.setUserHeadPhoto("headPhoto/" + fname);
			session.setAttribute("loginUserInfo", loginUserInfo);
			updateResult="true";
		}
		else {
			updateResult="true";
		}
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String reUpdateResult=gs.toJson(updateResult);
		out.write(reUpdateResult);
		out.flush();
		out.close();

	}
	
	public void queryUserInfoByUserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID=request.getParameter("userID");
		UserShowInfo userInfo=userService.searchUserInfoByUserID(userID);
		if(userInfo!=null)
		{
			Gson gs=new Gson();
			PrintWriter out=response.getWriter();
			String userShowInfo=gs.toJson(userInfo);
			out.write(userShowInfo);
			out.flush();
			out.close();
		}
		else
		{
			Gson gs=new Gson();
			PrintWriter out=response.getWriter();
			String userShowInfo=gs.toJson("不存在");
			out.write(userShowInfo);
			out.flush();
			out.close();
		}
	
	}
	
	//黄羽伦
    public void addApplicationInfoByAppInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//从session获取用户数据
    	HttpSession session = request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID = loginUserInfo.getUserID();
    	//获取时间
    	String applicationTime = TimeTool.getTime();
    	System.out.println(applicationTime);
    	String fname = "";
    	//保存路径
    	String saveDirectory = "D:/eclipse-workspace-new/PrettyViewProj/WebContent/images";// 服务器上存储路径
		String dirFlag = System.getProperty("file.separator"); // 自动匹配操作系统文件路径
//    	String filePath="";
    	MultipartRequest mReq = new MultipartRequest(request, saveDirectory,1024*1024*10,"UTF-8");
    	//获取输入信息
    	String userRealName = mReq.getParameter("realname");
    	String userIDCarNum = mReq.getParameter("IDnum");
    	System.out.println(userRealName);
    	System.out.println(userIDCarNum);
    	Enumeration<String> files = mReq.getFileNames();
    	ArrayList path = new ArrayList<String>();
    	while(files.hasMoreElements()){
    		File file = mReq.getFile(files.nextElement().toString());
    		if(file.exists()) {
    			fname = file.getName();
				// 获取系统当前时间
				String currentTimeMillis = applicationTime.replace(":", "").replace(".", "");
				String t1_fname = fname.substring(0, fname.lastIndexOf("."));
				String t2_fname = fname.substring(fname.lastIndexOf("."));
				fname = t1_fname + "_" + currentTimeMillis + t2_fname;
				File newfile = new File(saveDirectory + dirFlag + fname);
				file.renameTo(newfile);
    		}
			path.add("images/"+fname);
    	}
    	String userIDCardFace = (String)path.get(0);
    	String userIDCardBack = (String)path.get(1);
    	ApplicationInfo applicationInfo = new ApplicationInfo(userID,userRealName,userIDCarNum,
    	userIDCardFace,userIDCardBack,applicationTime);
    	String saveMsg = userService.saveApplicationInfoByAppInfo(applicationInfo);
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String jsonSaveMsg=gs.toJson(saveMsg);
		out.write(jsonSaveMsg);
		out.flush();
		out.close();
    }

    public void queryUserInfoBySearchContent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//从界面获取搜索信息。
    	String searchContent= request.getParameter("searchcontent");
    	System.out.println("userServlet:searchContent:"+searchContent);
    	ArrayList<UserShowInfo> arrayUserShowInfo = new ArrayList<UserShowInfo>();
    	arrayUserShowInfo = userService.searchUserInfoBySearchContent(searchContent);
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String jsonMsg=gs.toJson(arrayUserShowInfo);
		out.write(jsonMsg);
		out.flush();
		out.close();
    }
   
    /*
         * 查询待审核创作者
     * author:huangyulun
     * dateL2019/04/14
     * */
    public void queryCreatorApplicationInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	ArrayList<ApplicationInfo> arrayApplicationInfo = new ArrayList<ApplicationInfo>();
    	arrayApplicationInfo = userService.searchCreatorApplicationInfo();
    	//直接返回,若为空前端显示无
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonApplicationInfo = gson.toJson(arrayApplicationInfo);
    	out.write(jsonApplicationInfo);
    	out.flush();
    	out.close();
    }
    
    /*
         * 查询创作者申请信息
     * author:huangyulun
     * date:2019/04/14
     * */
    public void queryApplicationInfoByUserID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String userID = request.getParameter("userID");
    	System.out.println("queryCreatorApplicationInfoByUserID "+ userID);
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	if(userID != null) {
    		ApplicationShowInfo applicationShowInfo = userService.searchApplicationByUserID(userID);
    		if(applicationShowInfo!=null) {
    	    	String jsonApplicationShowInfo = gson.toJson(applicationShowInfo);
    	    	out.write(jsonApplicationShowInfo);
    	    	out.flush();
    	    	out.close();
    		}else {
    			System.out.println("查询结果为空！");
    		}
    	}else {
    		System.out.println("用户ID为空！");
    	}
    }
    
    /*
     * 审核创作者信息
     * author:huangyulun
     * date:2019/04/15 
     * */
    public void modifyCreatorApplyStatus(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String userID = request.getParameter("userID");
    	String creatorApplyStatus = request.getParameter("creatorApplyStatus");
    	System.out.println(userID);
    	System.out.println(creatorApplyStatus);
    	if(userID != null &&userID!="" && creatorApplyStatus != null && creatorApplyStatus!="") {
    		String msgString="";
    		boolean isAlter = userService.alterCreatorApplyStatus(userID,creatorApplyStatus);
    		System.out.println("servlet"+isAlter);
    		if(isAlter) {
    			msgString="true";
    		}else {
    			msgString="false";
    		}
        	PrintWriter out = response.getWriter();
        	Gson gson = new Gson();
        	String jsonMsg = gson.toJson(msgString);
        	out.write(jsonMsg);
        	out.flush();
        	out.close();
    	}else {
    		System.out.println("参数为空");
    	}
    }
    
    
    /*
     * 获取用户session
     * author:huangyulun
     * date:2019/04/24
     * */
    public void getUserLoginInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	HttpSession session=request.getSession();
    	UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
    	Gson gson = new Gson();
    	PrintWriter out = response.getWriter();
    	String jsonLoginUserInfo = gson.toJson(loginUserInfo);
    	out.write(jsonLoginUserInfo);
    	out.flush();
    	out.close();
    }
}
