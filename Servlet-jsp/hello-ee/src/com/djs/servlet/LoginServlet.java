package com.djs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	public void LoginServlet() {
		System.out.println("6");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		if(uname.equals("juyuan") && pwd.equals("123")) {
			resp.sendRedirect("/html/success.html");
		}else {
			resp.sendRedirect("/html/defeat.html");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
