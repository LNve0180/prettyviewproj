package com.prettyviewproj.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.prettyviewproj.Iservice.IAdminService;
import com.prettyviewproj.entity.AdminInfo;
import com.prettyviewproj.service.AdminService;
import com.prettyviewproj.tools.TimeTool;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;

	/**
	 * @see BaseServlet#BaseServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
		adminService = new AdminService();
	}
    
    /*
     * 查询作品数据
     * author:huangyulun
     * date:2019/04/22
     * */
    public void queryWorksData(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	IAdminService adminService = new AdminService();
    	HashMap<String,String> dataMap = adminService.searchWorksData();
    	Gson gson = new Gson();
    	PrintWriter out = response.getWriter();
    	String jsonDataMap = gson.toJson(dataMap);
    	out.write(jsonDataMap);
    	out.flush();
    	out.close();
    }
    
    /*
     * 查询各个总数数量
     * author:huangyulun
     * date:2019/04/22
     * */
    public void queryCountData(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	IAdminService adminService = new AdminService();
    	HashMap<String,String> dataMap = adminService.searchCountData();
    	Gson gson = new Gson();
    	PrintWriter out = response.getWriter();
    	String jsonDataMap = gson.toJson(dataMap);
    	out.write(jsonDataMap);
    	out.flush();
    	out.close();
    }
    
    /*
     * 管理员是否存在
     * author:dingyanpeng
     * date:2019/04/01
     * */
	public void searchAdminIsExist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminID = request.getParameter("adminID");
		if (adminID != null && adminService.findAdminInfoIsExist(adminID)) {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			out.write(gs.toJson("true"));
			out.flush();
			out.close();
		} else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			out.write(gs.toJson("false"));
			out.flush();
			out.close();
		}

	}
	/*
     * 管理员账号和密码是否正确
     * author:dingyanpeng
     * date:2019/04/01
     * */
	public void checkAdminPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String adminID = request.getParameter("adminID");
		String adminPassword = request.getParameter("adminPassword");
		AdminInfo adminInfo = adminService.judgeUserPassword(adminID, adminPassword);
		if (adminID != "" && adminPassword != "" && adminInfo != null
				&& adminInfo.getAdminPassword().equals(adminPassword)) {
			adminInfo.setAdminPassword(""); 
			HttpSession session = request.getSession();
			session.setAttribute("loginAdminInfo", adminInfo);
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			out.write(gs.toJson(adminInfo));
			out.flush();
			out.close();
		} else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			out.write(gs.toJson("null"));
			out.flush();
			out.close();
		}
	}
	/*
     * 添加管理员
     * author:dingyanpeng
     * date:2019/04/01
     * */
	public void addAdminInfoByAdminInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 头像
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
		
		AdminInfo adminInfo = new AdminInfo(multi.getParameter("adminID"), multi.getParameter("adminPassword"),
				multi.getParameter("adminName"), multi.getParameter("adminSex"), multi.getParameter("adminEmail"),
				"headPhoto/" + fname, multi.getParameter("adminPhone"));
		if(adminService.saveAdminInfoByAdminInfo(adminInfo)) {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			out.write(gs.toJson("true"));
			out.flush();
			out.close();
		}else {
			Gson gs = new Gson();
			PrintWriter out = response.getWriter();
			out.write(gs.toJson("false"));
			out.flush();
			out.close();
		}
		 
	}
	
	/*
	 * 获取管理员信息
	 * author:huangyulun
	 * date:2019/05/01
	 * */
	public void getAdminInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminInfo adminInfo = (AdminInfo) session.getAttribute("loginAdminInfo");
    	Gson gson = new Gson();
    	PrintWriter out = response.getWriter();
    	String jsonAdmin = gson.toJson(adminInfo);
    	out.write(jsonAdmin);
    	out.flush();
    	out.close();
	}
}
