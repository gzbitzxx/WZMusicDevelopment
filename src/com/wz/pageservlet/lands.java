package com.wz.pageservlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.common.EncodeByMd5;
import com.wz.dto.AdminDto;
import com.wz.dto.UserDto;
import com.wz.option.BaseServlet;
import com.wz.test.AdminCRUD;
import com.wz.test.UserCRUD;

public class lands extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session
		HttpSession hs = request.getSession();

		request.setCharacterEncoding("utf-8");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		
		try {
			password=EncodeByMd5.EncoderByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		String image = request.getParameter("verification").toLowerCase();
		String fcode=null;
		if(hs.getAttribute("fcode")!=null){
			fcode = ((String) hs.getAttribute("fcode")).toLowerCase();
		}
		
		if (!image.equals(fcode)) {
			response.getWriter().write("2");
			return;
		}

		UserCRUD user = new UserCRUD();
		List<UserDto> a = user.getUser();
		int id = 0;
		for (UserDto dto : a) {
			if (dto.getAccoutNumber().equals(number) && dto.getPassword().equals(password)) {
				id=dto.getId();
				hs.setAttribute("user", dto);
				break;
			}
		}

		if (id != 0) {
			response.getWriter().write("0");
		} else {
			response.getWriter().write("1");
		}

	}
       
}
