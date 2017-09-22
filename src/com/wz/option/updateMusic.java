package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.AdminDto;
import com.wz.dto.MusicDto;
import com.wz.dto.MusicTypeDto;
import com.wz.test.AdminCRUD;
import com.wz.test.MusicCRUD;
import com.wz.test.MusicTypeCRUD;

public class updateMusic extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			MusicCRUD music=new MusicCRUD();
			MusicDto dto=new MusicDto();
			dto.setId(id);
			
			
			MusicDto musics=music.queryMusic(dto);
			//传送实体给显示列表
			request.setCharacterEncoding("utf-8");
			request.setAttribute("musics", musics);
			
			//下拉列表
			MusicTypeCRUD musicType = new MusicTypeCRUD();
			List <MusicTypeDto> types=musicType.getMusicType();
			request.setAttribute("types", types);
			
			request.getRequestDispatcher("/Admin/Music/UpdateMusic.jsp").forward(request, response);
			
	}
}
