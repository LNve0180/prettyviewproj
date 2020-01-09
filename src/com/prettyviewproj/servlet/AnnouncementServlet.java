package com.prettyviewproj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.prettyviewproj.Iservice.IAnnouncementService;
import com.prettyviewproj.entity.AnnouncementInfo;
import com.prettyviewproj.service.AnnouncementService;
import com.prettyviewproj.tools.TimeTool;

/**
 * Servlet implementation class AnnouncementServlet
 */
@WebServlet("/AnnouncementServlet")
public class AnnouncementServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public AnnouncementServlet() {
        
    }
    
    public void queryAllAnnoucementInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	IAnnouncementService announcementService = new AnnouncementService();
    	ArrayList<AnnouncementInfo> announcementInfo = announcementService.searchAllAnnouncementInfo();
		Gson gson = new Gson();
		String jsonAddMsg = gson.toJson(announcementInfo);
		PrintWriter out = response.getWriter();
		out.write(jsonAddMsg);
		out.flush();
		out.close();
    	
    }
    
    /*
     *管理员查询所有公告信息
     *author:huangyulun
     *date:2019/04/01 
     * */
    public void queryAnnouncementInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	IAnnouncementService announcementService = new AnnouncementService();
    	ArrayList<AnnouncementInfo> announcementInfo = announcementService.searchAllAnnouncementInfo();
    	PrintWriter out = response.getWriter();
    	String jsonAnnouncementInfo="1";// 1:查询为空。
    	if(announcementInfo!=null) {
    		//将查询的数据返回
    		Gson gson = new Gson();
    		jsonAnnouncementInfo = gson.toJson(announcementInfo);
    	}
		out.write(jsonAnnouncementInfo);
    	out.flush();
    	out.close();
    }
    
    /*
     * 管理员删除公告
     * author:huangyulun
     * data:2019/04/01
     * */
    public void modifyAnnouncementStatusByID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String announcementID = request.getParameter("announcementID");
    	String msg = "";
    	IAnnouncementService announcementService = new AnnouncementService();
    	boolean isModify = announcementService.alterAnnouncementStatusByID(announcementID);
    	if(isModify==true) {
    		msg = "true";
    	}else {
    		msg = "false";
    	}
    	PrintWriter out = response.getWriter();
    	out.write(msg);
    	out.flush();
    	out.close();
    }
    
    /*
     * 管理员发布公告
     * author:huangyulun
     * data:2019/04/03
     * */
    public void addAnnouncementByAnnouncementInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String adminID = request.getParameter("adminID");//管理员ID
    	String announcementType = request.getParameter("announcementType");//公告类别
    	String announcementTheme = request.getParameter("announcementTheme");//公告主题
    	String announcementContent = request.getParameter("announcementContent");//公告内容
    	String announcementTime = TimeTool.getTime();//发布时间
    	System.out.println("Servlet:adminID = "+adminID);
    	System.out.println("Servlet:announcementTheme = "+announcementTheme);
    	System.out.println("Servlet:announcementType = "+announcementType);
    	System.out.println("Servlet:announcementContent = "+announcementContent);
    	System.out.println("Servlet:announcementTime = "+announcementTime);
    	String msg = "";
    	AnnouncementInfo announcementInfo = new AnnouncementInfo(adminID,announcementContent,announcementTheme,announcementTime,announcementType);
    	if(announcementInfo!=null) {
    		IAnnouncementService announcementService = new AnnouncementService();
    		boolean isAdd = announcementService.saveAnnouncementByAnnouncementInfo(announcementInfo);
    		if(isAdd==true) {
    			msg="true";
    		}else {
    			msg="false";
    		}
    		PrintWriter out = response.getWriter();
        	out.write(msg);
        	out.flush();
        	out.close();
    	}
    }
}
