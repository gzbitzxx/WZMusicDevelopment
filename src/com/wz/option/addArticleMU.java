package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.MusicDto;
import com.wz.dto.UserDto;
import com.wz.test.MusicCRUD;
import com.wz.test.UserCRUD;

public class addArticleMU extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 实例化
		
		MusicCRUD music=new MusicCRUD();
		List<MusicDto> m=music.getMusic();
		
		request.setAttribute("music", m);
		
		
		UserCRUD userCRUD=new UserCRUD();
		List<UserDto> user=userCRUD.getUser();
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("Admin/Article/AddArticle.jsp").forward(request, response);
		
	}

}
