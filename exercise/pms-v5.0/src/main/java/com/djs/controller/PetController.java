package com.djs.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.djs.dto.ChinaDTO;
import com.djs.entity.Category;
import com.djs.entity.Pet;
import com.djs.service.impl.PetServiceImpl;
import com.djs.service.IPetService;
import com.google.gson.Gson;

public class PetController {

	public String addCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Category c = new Category();
		c.setName(name);
		IPetService ips = new PetServiceImpl();
		ips.addCategory(c);
		response.getWriter().println("添加成功");
		return null;
	}

	public String findAllCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println(new Gson().toJson(new PetServiceImpl().findAllCategory()));
		return null;
	}
	
	public String upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Map<String,String> map = new HashMap<>();
		try {
			List<FileItem> list = upload.parseRequest(request);
			FileItem fi = list.get(0);
			request.getSession().setAttribute("img", fi.getName());
			InputStream in = fi.getInputStream();
			String path = request.getServletContext().getRealPath("/");
			path = path.replace("pms-v5.0", "upload");
			
			OutputStream out = new FileOutputStream(path+fi.getName());
			map.put("fileName", fi.getName());
			int n = 0;
			byte[] buffer = new byte[1024];
			while((n = in.read(buffer))!=-1) {
				out.write(buffer);
			}
			out.close();
			in.close();
			response.getWriter().println(new Gson().toJson(map));
			
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

	public String addPet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		String img = (String) request.getSession().getAttribute("img");
		String address = request.getParameter("address");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		Pet pet = new Pet(null, name, price, img, address, new Category(categoryId,null));
		IPetService ips = new PetServiceImpl();
		ips.addPet(pet);
		response.getWriter().println("添加宠物"+pet.getName()+"信息成功");
		return null;
	}

	public String findAllPet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println(new Gson().toJson(ChinaDTO.getAreas(request.getParameter("name"))));
		return null;
	}

}
