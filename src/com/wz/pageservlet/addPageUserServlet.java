package com.wz.pageservlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.common.EncodeByMd5;
import com.wz.dto.UserDto;
import com.wz.option.BaseServlet;
import com.wz.test.UserCRUD;

public class addPageUserServlet extends BaseServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String accoutNumber = req.getParameter("accoutNumber");
		String password = req.getParameter("password");
		String IP = req.getRemoteAddr();
		String sex = "其他";
		int age = 0;

		UserDto userDto = new UserDto();
		try {
			password = EncodeByMd5.EncoderByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		userDto.setAccoutNumber(accoutNumber);
		userDto.setPassword(password);
		userDto.setLoginIP(IP);
		userDto.setSex(sex);
		userDto.setAge(age);
		userDto.setHobby("");
		userDto.setRealName("");
		userDto.setView("0");
		userDto.setBrithday("1970-01-01");
		UserCRUD userCRUD = new UserCRUD();
		UserDto user = userCRUD.queryUser(userDto);

		if (user == null) {
			if (userCRUD.AddUser(userDto)) {
				resp.getWriter().write("0");
			} else {
				resp.getWriter().write("1");
			}
		}
	}
}
