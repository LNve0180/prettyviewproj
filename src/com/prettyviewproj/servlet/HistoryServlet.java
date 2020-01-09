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
import com.prettyviewproj.Iservice.IHistoryService;
import com.prettyviewproj.entity.HistoryInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.service.HistoryService;
import com.prettyviewproj.tools.TimeTool;



/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/HistoryServlet")
public class HistoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private IHistoryService historyService;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public HistoryServlet() {
    	
    	historyService = new HistoryService();
        
    }

	/**
	 *HttpServletRequest request, HttpServletResponse response
	 */
    
     public void queryAllHistoryByUserID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	 //获取userID session
    	 String userID= request.getParameter("userID");
    	 System.out.println("servlet:"+userID);
    	 ArrayList<HistoryInfo> arrayHistory = historyService.searchAllHistoryByUserID(userID);
		 Gson gs = new Gson();
		 PrintWriter out = response.getWriter();
		 String jsonMsg = gs.toJson(arrayHistory);
		 out.write(jsonMsg);
		 out.flush();
		 out.close();
     }

     public void cutoffHistoryByHistoryInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		/*
		 * HttpSession session =request.getSession(); UserInfo userInfo =
		 * (UserInfo)session.getAttribute("loginUserInfo"); String userID=
		 * userInfo.getUserID();
		 */
    	 String userID = request.getParameter("userID");
    	 String worksID=request.getParameter("worksID");
    	 String historyTime=request.getParameter("historyTime");
    	 System.out.println(userID);
    	 System.out.println(worksID);
    	 System.out.println(historyTime);
    	 String delHistoryMsg="";
    	 HistoryInfo historyInfo = new HistoryInfo(userID,worksID,historyTime);
    	 boolean isModify = historyService.removeHistoryByHistoryInfo(historyInfo);
    	 if(isModify==true) {
    		 delHistoryMsg="删除成功！";
    	 }else {
    		 delHistoryMsg="服务器出现了一点小问题，删除失败！";
    	 }
		 Gson gs = new Gson();
		 PrintWriter out = response.getWriter();
		 String jsonMsg = gs.toJson(delHistoryMsg);
		 out.write(jsonMsg);
		 out.flush();
		 out.close();
     }
     
     public void addHistoryInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	 //session获取userID
    	 HttpSession session = request.getSession();
     	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
     	String userID = loginUserInfo.getUserID();
    	 //前台获取worksID
    	 String worksID = request.getParameter("worksID");
    	 String hisotryTime = TimeTool.getTime();
    	 HistoryInfo historyInfo = new HistoryInfo(userID,worksID,hisotryTime);
    	 IHistoryService historyService = new HistoryService();
    	 boolean isAdd = historyService.saveHistoryInfo(historyInfo);
    	 System.out.println(isAdd);
    	 String addMsg = "";
    	 if(isAdd==true) {
    		 addMsg="成功";
    	 }else if(isAdd==false) {
    		 addMsg="失败";
    	 }
     	PrintWriter out = response.getWriter();
     	Gson gson = new Gson();
     	String jsonAddMsg = gson.toJson(addMsg);
     	out.write(jsonAddMsg);
     	out.flush();
     	out.close();
     }
}
