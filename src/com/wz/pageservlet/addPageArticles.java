package com.wz.pageservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.dto.MusicDto;
import com.wz.dto.UserDto;
import com.wz.test.MusicCRUD;
import com.wz.test.UserCRUD;

public class addPageArticles extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 实例化
		
		MusicCRUD music=new MusicCRUD();
		List<MusicDto> m=music.getMusic();
		
		request.setAttribute("music", m);
		
		
		HttpSession s = request.getSession();
		UserDto user = (UserDto) s.getAttribute("user");
		if(user==null){
			request.getRequestDispatcher("Page/Lands.jsp").forward(request, response);
			
		}else{
			request.setAttribute("user", user);
			request.getRequestDispatcher("Page/AddPageArticle.jsp").forward(request, response);
		}
		
		
		
	}

}
