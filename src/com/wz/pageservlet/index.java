package com.wz.pageservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.MusicDto;
import com.wz.option.BaseServlet;
import com.wz.test.MusicCRUD;


public class index extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//当前页
		int currentPage=1;
		
		//默认的页面条数的大小
		int pageSize=20;
		
		//总的页面数
		int totle=0;
		if(request.getParameter("page")!=null){
			currentPage=Integer.parseInt(request.getParameter("page").toString());
		};
		
		MusicCRUD music=new MusicCRUD();
		List<MusicDto> m=music.getMusicsPage(currentPage, pageSize);
		request.setAttribute("music", m);
		request.getRequestDispatcher("Page/Index.jsp").forward(request, response);
	}
}
