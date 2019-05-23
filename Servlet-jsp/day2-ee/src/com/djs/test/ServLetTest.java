package com.djs.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServLetTest extends HttpServlet {
	
	public ServLetTest() {
		System.out.println("我被创建了");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("初始化");
	}
	@Override
	public void destroy() {
		System.out.println("-------------------------------------");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("姓名");
//		String name = req.getParameterMap()("name");
		Map<String, String[]> pp = req.getParameterMap();
		for (String s : pp.keySet() ) {
			System.out.println(Arrays.deepToString(pp.get(s)));
		}
		System.out.println(name);
		
		System.out.println(req.getRemoteAddr());
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
