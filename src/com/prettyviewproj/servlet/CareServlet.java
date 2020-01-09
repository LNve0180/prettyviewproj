package com.prettyviewproj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.prettyviewproj.Iservice.ICareService;
import com.prettyviewproj.entity.CareInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.service.CareService;

/**
 * Servlet implementation class CareServelet
 */
@WebServlet("/CareServlet")
public class CareServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
     
	private ICareService careService;
    /**
     * @see BaseServlet#BaseServlet()
     */
    public CareServlet() {
    	
    	careService = new CareService();
    	
    }
    public void addCareInfoByUserIDAndCaredID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取userID caredID
    	HttpSession session =request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID= loginUserInfo.getUserID();
    	String caredID= request.getParameter("caredID"); 	
    	String careMsg="";
    	boolean isAdd = careService.saveCareInfoByUserIDAndCaredID(userID,caredID);
    	if(isAdd==true) {
    		careMsg = "关注成功！";
    	}else {
    		careMsg = "关注失败！";
    	}
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMsg = gson.toJson(careMsg);
    	out.write(jsonMsg);
    	out.flush();
    	out.close();
    }
    
    public void cutoffCareInfoByUserIDAndCaredID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取userID caredID
    	HttpSession session =request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID= loginUserInfo.getUserID();
    	String caredID= request.getParameter("caredID");
    	String careDeleteMsg="";
    	ICareService careService = new CareService();
    	boolean isDelete = careService.removeCareInfoByUserIDAndCaredID(userID,caredID);
    	if(isDelete==true) {
    		careDeleteMsg = "已取消关注！";
    	}else {
    		careDeleteMsg = "取消关注失败！";
    	}
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMsg = gson.toJson(careDeleteMsg);
    	out.write(jsonMsg);
    	out.flush();
    	out.close();
    }
    
    public void queryCareInfoByUserID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取userID 
    	HttpSession session =request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID= loginUserInfo.getUserID();
    	ArrayList<UserInfo> arrayUserInfo = careService.searchCareInfoByUserID(userID);
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMsg = gson.toJson(arrayUserInfo);
    	out.write(jsonMsg);
    	out.flush();
    	out.close();
    }

    public void searchCareInfoIsExist(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取userID caredID
    	HttpSession session =request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID= loginUserInfo.getUserID();
    	String caredID= request.getParameter("caredID");
    	System.out.println(userID);
    	System.out.println(caredID);
    	String careExistMsg="";
    	ICareService careService = new CareService();
    	CareInfo careInfo = careService.findCareInfoIsExist(userID,caredID);
    	if(careInfo!=null) {
    		careExistMsg="存在";
    	}else {
    		careExistMsg="不存在";
    	}
    	PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String jsonCareExistMsg = gson.toJson(careExistMsg);
		out.write(jsonCareExistMsg);  
	    out.flush();  
	    out.close();
    }
    
    public void getTest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	HttpSession session =request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID= loginUserInfo.getUserID();
    	String caredID= request.getParameter("caredID");
    	System.out.println(userID);
    	System.out.println(caredID);
    	PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String jsonCareExistMsg = gson.toJson("balala");
		out.write(jsonCareExistMsg);  
	    out.flush();  
	    out.close();
    	
    }
}
