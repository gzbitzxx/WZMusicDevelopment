package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.MusicTypeDto;
import com.wz.test.MusicTypeCRUD;

public class addMusicMTY extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 实例化
		MusicTypeCRUD musicType = new MusicTypeCRUD();
		List <MusicTypeDto> types=musicType.getMusicType();
		request.setAttribute("types", types);
		request.getRequestDispatcher("Admin/Music/AddMusic.jsp").forward(request, response);
		
	}
}
