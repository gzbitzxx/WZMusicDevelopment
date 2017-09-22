package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.dto.AdminDto;
import com.wz.test.AdminCRUD;

public class exitLogin extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 注销session
		boolean f=false;
		HttpSession hs = request.getSession(true);
		hs.removeAttribute("admin");
		
		response.sendRedirect("login.jsp");
		
	}
}
