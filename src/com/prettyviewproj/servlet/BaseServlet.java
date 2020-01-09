package com.prettyviewproj.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
       
    }
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//获取method值=方法名
		String methodName = req.getParameter("method");
		System.out.println("BaseServlet:"+methodName);
		if(methodName == null || methodName.isEmpty()) {
			System.out.println("不存在 "+methodName+" 的方法1");
		}
		//获取当前类的对象
		Class c = this.getClass();
		Method method = null; // 初始化反射
		try {
			//获得method对象
			method = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);//(方法名，参数类型.class，参数类型.class)
		}catch(Exception e){
			System.out.println("不存在 "+methodName+" 的方法2");
		}
		try {
			//执行映射
			String result= (String) method.invoke(this,req,resp);
			System.out.println(result);
		}catch(Exception e){
			System.out.println("调用 "+methodName+" 方法异常");
		}
	}

}
