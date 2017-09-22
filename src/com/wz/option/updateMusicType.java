package com.wz.option;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.AdminDto;
import com.wz.dto.MusicTypeDto;
import com.wz.test.AdminCRUD;
import com.wz.test.MusicTypeCRUD;

public class updateMusicType extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			MusicTypeCRUD musicType=new MusicTypeCRUD();
			int id=Integer.parseInt(request.getParameter("id"));
			MusicTypeDto dto=new MusicTypeDto();
			dto.setId(id);
			MusicTypeDto musicTypes=musicType.queryMusicType(dto);
			System.out.println("111111111111111111111111111"+musicTypes);
			request.setCharacterEncoding("utf-8");
			request.setAttribute("musicTypes", musicTypes);
			request.getRequestDispatcher("/Admin/MusicType/UpdateMusicType.jsp").forward(request, response);
			
	}
}
