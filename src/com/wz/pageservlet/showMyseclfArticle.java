package com.wz.pageservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.dto.ArticleDto;
import com.wz.dto.UserDto;
import com.wz.option.BaseServlet;
import com.wz.test.ArticleCRUD;


public class showMyseclfArticle extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDto userDto=new UserDto();
		HttpSession hs=request.getSession();
		userDto=(UserDto)hs.getAttribute("user");
		ArticleCRUD article=new ArticleCRUD();
		ArticleDto dto=new ArticleDto();
		dto.setUserDto(userDto);
		
		
		request.setAttribute("article", article.queryMyselfArticles(dto));

		request.getRequestDispatcher("Page/Myself.jsp").forward(request, response);
	}

}
