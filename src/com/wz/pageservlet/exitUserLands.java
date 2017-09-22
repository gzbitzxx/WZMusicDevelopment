package com.wz.pageservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.option.BaseServlet;


public class exitUserLands extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 注销session
		HttpSession hs = request.getSession();
		hs.removeAttribute("user");
		
		response.getWriter().write("0");
		
	}
}
