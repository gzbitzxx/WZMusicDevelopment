package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.common.EncodeByMd5;
import com.wz.dto.AdminDto;
import com.wz.dto.UserDto;
import com.wz.test.AdminCRUD;
import com.wz.test.UserCRUD;

import net.sf.json.JSONArray;

public class loginWZ extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session
		HttpSession hs = request.getSession();

		request.setCharacterEncoding("utf-8");
		String adminNumber = request.getParameter("adminNumber");
		String adminPassword = request.getParameter("adminPassword");
		
		try {
			adminPassword=EncodeByMd5.EncoderByMd5(adminPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		String image = request.getParameter("image").toLowerCase();
		String fcode=null;
		if(hs.getAttribute("fcode")!=null){
			fcode = ((String) hs.getAttribute("fcode")).toLowerCase();
		}
		
		if (!image.equals(fcode)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		AdminCRUD admin = new AdminCRUD();
		List<AdminDto> a = admin.getAdmins();
		int id = 0;
		for (AdminDto dto : a) {
			if (dto.getAccoutNumber().equals(adminNumber) && dto.getPassword().equals(adminPassword)) {
				id = dto.getId();
				hs.setAttribute("admin", dto);
				break;
			}
		}

		if (id != 0) {
			request.getRequestDispatcher("Admin/index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
