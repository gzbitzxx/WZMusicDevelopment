package com.wz.pageservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.option.BaseServlet;
import com.wz.test.ArticleCRUD;

public class getArticle extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 当前页
		int currentPage = 1;

		// 默认的页面条数的大小
		int pageSize = 10;

		// 总的页面数
		int totle = 0;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page").toString());
		}
		
		ArticleCRUD article = new ArticleCRUD();
		
		int size=article.getArticle().size()%pageSize;
		//通过总页数和页面大小来计算页数
		if(size==0){
			totle=article.getArticle().size()/pageSize;
		}else{
			totle=article.getArticle().size()/pageSize+1;
		}
		
		request.setAttribute("article", article.getArticlePage(currentPage, pageSize));
		request.setAttribute("currentPage",currentPage );
		request.setAttribute("totle", totle);
		request.getRequestDispatcher("Page/Article.jsp").forward(request, response);
	}
}
