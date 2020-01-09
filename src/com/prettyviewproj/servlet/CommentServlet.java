package com.prettyviewproj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.prettyviewproj.Iservice.ICommentService;
import com.prettyviewproj.dao.CommentDao;
import com.prettyviewproj.entity.AdminInfo;
import com.prettyviewproj.entity.CommentInfo;
import com.prettyviewproj.entity.CommentReplyShowInfo;
import com.prettyviewproj.entity.ReplyInfo;
import com.prettyviewproj.entity.ReportCommentInfo;
import com.prettyviewproj.entity.UserInfo;
import com.prettyviewproj.service.CommentService;
import com.prettyviewproj.tools.TimeTool;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ICommentService commentService;  
    /**
     * @see BaseServlet#BaseServlet()
     */
    public CommentServlet() {
        super();
        commentService = new CommentService();
        // TODO Auto-generated constructor stub
    }
public void addCommentInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String addMsg="";
    	//session huoqu登陆者id -> userID
    	HttpSession session = request.getSession();
    	UserInfo loginUserInfo = (UserInfo)session.getAttribute("loginUserInfo");
    	String userID = loginUserInfo.getUserID();
    	//从界面获取 评论信息
    	String worksID= request.getParameter("worksID");
    	String commentContent= request.getParameter("commentcontent");
    	//获取时间
    	String commentTime = TimeTool.getTime();
    	CommentInfo commentInfo = new CommentInfo(userID,worksID,commentContent,commentTime);
    	//ICommentService commentService = new CommentService();
    	boolean isAdd = commentService.saveCommentInfo(commentInfo);
    	//传送信息给前台
    	if(isAdd==true) {
    		addMsg="发表成功！";
    	}else {
    		addMsg="发表失败！";
    	}
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonAddMsg = gson.toJson(addMsg);
    	out.write(jsonAddMsg);
    	out.flush();
    	out.close();
    }
    public void addReplyInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//session huoqu登陆者id -> userID
    	HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		String userID = loginUserInfo.getUserID();
    	//从界面获取 评论信息
    	String commentID= request.getParameter("commentID");
    	String replyContent= request.getParameter("replyCommentContent");
//    	String worksID = request.getParameter("worksNeedID");
//    	String url="CommentServlet?method=queryCommentReplyInfoByWorksID&worksID="+worksID;
    	String addMsg="";
    	//获取时间
    	String replyTime = TimeTool.getTime();
    	ReplyInfo replyInfo = new ReplyInfo(userID,commentID,replyContent,replyTime);
    	//ICommentService commentService = new CommentService();
    	boolean isAdd = commentService.saveReplyInfo(replyInfo);
    	//传送信息给前台
    	if(isAdd==true) {
    		addMsg="回复评论成功！";
    	}else {
    		addMsg="回复评论失败！";
    	}
//    	//转换json格式 传输至前台
//    	request.setAttribute("msg", addMsg);
//    	request.getRequestDispatcher(url).forward(request, response);
    	//传输信息到前台
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonAddMsg = gson.toJson(addMsg);
    	out.write(jsonAddMsg);
    	out.flush();
    	out.close();
    }
    public void addCommentFabulousInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//session获取userid
    	HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		String userID = loginUserInfo.getUserID();
    	//界面获取commentID
    	String commentID= request.getParameter("commentID");
    	String commentFabulousMsg="";
    	boolean isAdd = commentService.saveCommentFabulousInfo(userID,commentID);
    	if(isAdd==true) {
    		commentFabulousMsg="点赞成功！";
    	}else {
    		commentFabulousMsg="点赞失败！";
    	}
    	//传输信息到前台
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonAddMsg = gson.toJson(commentFabulousMsg);
    	System.out.println(jsonAddMsg);
    	out.write(jsonAddMsg);
    	out.flush();
    	out.close();
    }
    public void addReportCommentInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	//获取UserID
    	HttpSession session=request.getSession();
		UserInfo loginUserInfo=(UserInfo)session.getAttribute("loginUserInfo");
		String userID = loginUserInfo.getUserID();
    	//获取被举报评论ID
    	String commentID = request.getParameter("commentID");
    	//获取举报内容
    	String reportCommentReason = request.getParameter("reportCommentContent");
    	//获取时间
    	String replyCommentTime = TimeTool.getTime();
    	String addMsg ="";
    	ReportCommentInfo reportCommentInfo = new ReportCommentInfo(userID,commentID,reportCommentReason,replyCommentTime);
    	boolean isAdd = commentService.saveReportCommentInfo(reportCommentInfo);
    	if(isAdd==true) {
    		addMsg="举报成功!";
    	}else {
    		addMsg = "举报失败!";
    	}
    	//传输信息到前台
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonAddMsg = gson.toJson(addMsg);
    	out.write(jsonAddMsg);
    	out.flush();
    	out.close();
    }
    
    public void queryCommentReplyInfoByWorksID(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String worksID=request.getParameter("worksID");
		ArrayList<CommentReplyShowInfo> commentReplyInfoList=commentService.searchCommentReplyInfoByWorksID(worksID);
    	//传输信息到前台
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonAddMsg = gson.toJson(commentReplyInfoList);
    	out.write(jsonAddMsg);
    	out.flush();
    	out.close();
    }
    /*
     * 查询所有被举报作品
     * author:huangyulun
     * date:2019/05/12
     * */
    public void queryAllReportCommentInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	ArrayList<ReportCommentInfo> arrayReportCommentInfos = new ArrayList<ReportCommentInfo>();
    	arrayReportCommentInfos = commentService.searchAllReportCommentInfo();
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMsg = gson.toJson(arrayReportCommentInfos);
    	out.write(jsonMsg);
    	out.flush();
    	out.close();
    			
    }
    
    /*
     * 自动审核被举报评论
     * author:huangyulun
     * date:2019/05/12
     * */
    public void automaticAuditCommentReport(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	HttpSession session=request.getSession();
    	AdminInfo adminInfo = (AdminInfo) session.getAttribute("loginAdminInfo");
    	String adminID = adminInfo.getAdminID();
    	boolean isOK = commentService.automaticAuditCommentReport(adminID);
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonMsg = gson.toJson(isOK);
    	out.write(jsonMsg);
    	out.flush();
    	out.close();
    	
    }
}
