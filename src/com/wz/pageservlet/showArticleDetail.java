package com.wz.pageservlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.ArticleDto;
import com.wz.option.BaseServlet;
import com.wz.test.ArticleCRUD;


public class showArticleDetail extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		ArticleDto updata=new ArticleDto();
		// 实例化
		int id=Integer.parseInt(request.getParameter("id"));
		ArticleDto a=new ArticleDto();
		a.setId(id);
		
		ArticleCRUD ar=new ArticleCRUD();
		updata=ar.queryArticle(a);
		updata.setLikeNumber(updata.getLikeNumber()+1);
		ar.insertArticle(updata);
		request.setAttribute("article", updata);
		request.getRequestDispatcher("Page/ShowArticle.jsp").forward(request, response);
	}
}
