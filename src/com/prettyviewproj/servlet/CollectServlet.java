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
import com.prettyviewproj.Iservice.ICollectService;
import com.prettyviewproj.entity.CollectShowInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.service.CollectService;
import com.prettyviewproj.tools.TimeTool;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/CollectServlet")
public class CollectServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private ICollectService collectService=new CollectService();
    /**
     * @see BaseServlet#BaseServlet()
     */
 

    public void addCollectInfoByCollectInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	System.out.print("lala");
    	String worksID=request.getParameter("worksID");
		System.out.print(worksID);
		HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		System.out.print("before if");
		boolean result=collectService.saveCollectInfoByCollectInfo(loginUserInfo.getUserID(), worksID, TimeTool.getTime());
		if(result)
		{
			System.out.print("ca");
			Gson gs=new Gson();
			PrintWriter out=response.getWriter();
			out.write(gs.toJson("收藏成功"));
			out.flush();
			out.close();
		}
		else 
		{
			Gson gs=new Gson();
			PrintWriter out=response.getWriter();
			out.write(gs.toJson("收藏失败"));
			out.flush();
			out.close();
		}
	}
    public void cutoffCollectInfoByUserIDWorksID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		System.out.println(request.getParameter("worksID"));
		String deleteResult="";
		if(collectService.removeCollectInfoByUserIDWorksID(loginUserInfo.getUserID(), request.getParameter("worksID")))
		{
			
			deleteResult="true";
		}
		else
		{
			deleteResult="false";
		}
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		out.write(gs.toJson(deleteResult));
		out.flush();
		out.close();

	}
    
    public void queryCollectInfoByUserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		System.out.println(loginUserInfo.getUserID());
		ArrayList<CollectShowInfo> collectShowInfoList=collectService.searchCollectInfoByUserID(loginUserInfo.getUserID());
		System.out.println(collectShowInfoList.size());
		if(collectShowInfoList.size()!=0)
		{
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String jsonSearchResult = gson.toJson(collectShowInfoList);
			out.write(jsonSearchResult);
			out.flush();
			out.close();
		}
		else
		{
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String jsonAddResult = gson.toJson("null");
			out.write(jsonAddResult);
			out.flush();
			out.close();
		}

		
	}
    
    public void searchCollectInfoIsExist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String worksID=request.getParameter("worksID");
    	HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		
		if(collectService.findCollectInfoIsExist(loginUserInfo.getUserID(), worksID))
		{
			System.out.print("ca");
			Gson gs=new Gson();
			PrintWriter out=response.getWriter();
			out.write(gs.toJson("已收藏"));
			out.flush();
			out.close();
		}
		else
		{
			Gson gs=new Gson();
			PrintWriter out=response.getWriter();
			out.write(gs.toJson("未收藏"));
			out.flush();
			out.close();
		}
		
	}
    

}
