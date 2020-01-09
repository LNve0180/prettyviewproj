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
import com.prettyviewproj.Iservice.IPersonalMessageService;
import com.prettyviewproj.entity.PersonalMessageInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.service.PersonalMessageService;
import com.prettyviewproj.tools.TimeTool;

/**
 * Servlet implementation class PersonalMessageServlet
 */
@WebServlet("/PersonalMessageServlet")
public class PersonalMessageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private IPersonalMessageService personalMessageService;
    /**
     * @see BaseServlet#BaseServlet()
     */
    public PersonalMessageServlet() {
        
    	personalMessageService = new PersonalMessageService();
    }
    
    public void queryPersonalMessageInfoByUserID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取userID
    	HttpSession session =request.getSession();
    	UserInfo loginUserInfo =  (UserInfo)session.getAttribute("loginUserInfo");
    	String userID = loginUserInfo.getUserID();
    	ArrayList<PersonalMessageInfo> arrayPersonalMessageInfo= new ArrayList<PersonalMessageInfo>();
    	arrayPersonalMessageInfo = personalMessageService.searchPersonalMessageInfoByUserID(userID);
		Gson gson = new Gson();
		String jsonAddMsg = gson.toJson(arrayPersonalMessageInfo);
		PrintWriter out = response.getWriter();
		out.write(jsonAddMsg);
		out.flush();
		out.close();
    }

    public void addPersonalMessageInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取userID
    	HttpSession session = request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID = loginUserInfo.getUserID();
    	//获取whisperedID
    	String whisperedID = request.getParameter("whisperedID");
    	//获取时间
    	String whisperTime = TimeTool.getTime();
    	System.out.println(whisperTime);
    	//获取私信内容内容
    	String whisperContent = request.getParameter("pmContent");
    	System.out.println(whisperContent);
    	String addMsg="";
    	PersonalMessageInfo personalMessageInfo = new PersonalMessageInfo(userID,whisperedID,whisperContent,whisperTime,1,null);
    	boolean isAdd = personalMessageService.savePersonalMessageInfo(personalMessageInfo);
    	if(isAdd==true) {
    		addMsg = "发送成功！";
    	}else {
    		addMsg = "发送失败！";
    	}
		Gson gson = new Gson();
		String jsonAddMsg = gson.toJson(addMsg);
		PrintWriter out = response.getWriter();
		out.write(jsonAddMsg);
		out.flush();
		out.close();
    }




}
