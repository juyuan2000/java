package com.djs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.djs.dto.ChinaDTO;
import com.google.gson.Gson;



public class ChinaController {
	
	public String province(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println(new Gson().toJson(ChinaDTO.getProvince()) );
		return null;
	}
	
	public String city(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println(new Gson().toJson(ChinaDTO.getCities(request.getParameter("name"))) );
		return null;
	}
	
	public String area(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println(new Gson().toJson(ChinaDTO.getAreas(request.getParameter("name"))) );
		return null;
	}

}
