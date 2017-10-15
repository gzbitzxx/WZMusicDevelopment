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

/**
 * 查询个人发表文章信息 Servlet
 * @author TongZhou
 *
 */
public class showMyseclfArticle extends BaseServlet {
	
	/**
	 * doGet 方法
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//用户实体
		UserDto userDto=new UserDto();
		
		//创建 HttpSession 对象
		HttpSession hs=request.getSession();
		
		//获取 Session 中的用户
		userDto=(UserDto)hs.getAttribute("user");
		
		//文章CRUD
		ArticleCRUD article=new ArticleCRUD();
		
		//文章的实体
		ArticleDto dto=new ArticleDto();
		
		//获取文章的set用户  作为查询条件
		dto.setUserDto(userDto);
		
		//将获取的文章封装在 request 中
		request.setAttribute("article", article.queryMyselfArticles(dto));
		
		//页面跳转
		request.getRequestDispatcher("Page/Myself.jsp").forward(request, response);
	}

}
