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
import com.prettyviewproj.Iservice.INoticeService;
import com.prettyviewproj.entity.AdminInfo;
import com.prettyviewproj.entity.NoticeInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.service.NoticeService;
import com.prettyviewproj.tools.TimeTool;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/NoticeServlet")
public class NoticeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
    private INoticeService noticeService ;
    /**
     * @see BaseServlet#BaseServlet()
     */
    public NoticeServlet() {
    	
    	noticeService = new NoticeService();
    }
    
    
    public void queryAllNoticeInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	ArrayList<NoticeInfo> noticeInfo = noticeService.searchAllNoticeInfo();
    	if(noticeInfo!=null) {
    		request.setAttribute("arrayNoticeInfo", noticeInfo);
    		request.getRequestDispatcher("noticeForm.jsp").forward(request, response);
    	}else {
    		String nouticeMsg = "查询失败！";
    		request.setAttribute("nouticeMsg", nouticeMsg);
    		request.getRequestDispatcher("noticeForm.jsp").forward(request, response);
    	}
    }
    /*
     * 查询个人通知信息
     * author:huangyulun
     * date:2019/04/21
     * */
    public void queryNoticeInfoByUserID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");	
		String userID = loginUserInfo.getUserID();
    	ArrayList<NoticeInfo> noticeInfo = noticeService.searchNoticeInfoByUserID(userID);
    	Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String jsonNoticeInfo=gs.toJson(noticeInfo);
		out.write(jsonNoticeInfo);
		out.flush();
		out.close();
    }
    
    /*
     * 添加审核创作者信息通知
     * author:huangyulun
     * date:2019/05/10
     * */
    public void addCreatorReviewNoticeMsg(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	HttpSession session = request.getSession();
		AdminInfo adminInfo = (AdminInfo) session.getAttribute("loginAdminInfo");
		String adminID = adminInfo.getAdminID();
		String userID = request.getParameter("userID");
		String noticeContent = request.getParameter("noticeContent");
		boolean isAdd = noticeService.saveCreatorReviewNoticeMsg(userID,adminID,noticeContent);
		String msgString="";
		if(isAdd) {
			msgString="true";
		}else {
			msgString="false";
		}
    	Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		String jsonMsg=gs.toJson(msgString);
		out.write(jsonMsg);
		out.flush();
		out.close();
    }
}
