package com.wz.option;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.AdminDto;
import com.wz.dto.UserDto;
import com.wz.test.AdminCRUD;
import com.wz.test.UserCRUD;

public class updateUser extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			UserCRUD userTest=new UserCRUD();
			int id=Integer.parseInt(request.getParameter("id"));
			UserCRUD user=new UserCRUD();
			
			System.out.println("-------------------"+id);
			
			UserDto dto=new UserDto();
			dto.setId(id);
			
			UserDto users=user.queryUser(dto);
			request.setCharacterEncoding("utf-8");
			request.setAttribute("users", users);
			request.getRequestDispatcher("/Admin/User/UpdateUser.jsp").forward(request, response);
			
	}
}
