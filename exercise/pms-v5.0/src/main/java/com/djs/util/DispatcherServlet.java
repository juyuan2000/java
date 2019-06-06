package com.djs.util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="*.action",loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String path = request.getRequestURI();
			String key = path.substring(path.lastIndexOf("/"));
			
			Map<String,XmlHelper.Mapper> map =XmlHelper.getMap();
			XmlHelper.Mapper mapper = map.get(key);
			
			try {
				Class<?> clazz = Class.forName(mapper.getClazz());
				Method method = clazz.getMethod(mapper.getMethod(), 
						HttpServletRequest.class,HttpServletResponse.class);
				String retVal = (String) method.invoke(Bean.getBean(clazz), request,response);
				if(retVal!=null) {
					response.sendRedirect(retVal);
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
