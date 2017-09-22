package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.AdminDto;
import com.wz.test.AdminCRUD;

import net.sf.json.JSONArray;


public class getAdminTest extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			AdminCRUD adminTest=new AdminCRUD();
			
			int currentPage=1;
			
			if(request.getParameter("currentPage")!=null){
				currentPage=Integer.parseInt(request.getParameter("currentPage").toString());
			};
			
			List<AdminDto> admin=adminTest.getAdmins();
			
			JSONArray json=JSONArray.fromObject(admin);
			
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json.toString());
			
			
	}
}
