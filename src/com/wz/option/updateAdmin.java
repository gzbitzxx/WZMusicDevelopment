package com.wz.option;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.AdminDto;
import com.wz.test.AdminCRUD;

public class updateAdmin extends BaseServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			AdminCRUD admin=new AdminCRUD();
			AdminDto dto=new AdminDto();
			dto.setId(id);
			AdminDto admins=admin.queryAdmin(dto);
			request.setCharacterEncoding("utf-8");
			request.setAttribute("admins", admins);
			request.getRequestDispatcher("/Admin/Admins/UpdateAdmin.jsp").forward(request, response);
			
	}

}
