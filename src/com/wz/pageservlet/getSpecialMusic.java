package com.wz.pageservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dao.MusicDao;
import com.wz.dto.MusicDto;
import com.wz.option.BaseServlet;
import com.wz.test.ArticleCRUD;
import com.wz.test.MusicCRUD;

/*
 * 获取特别的音乐
 * 
 */
public class getSpecialMusic extends BaseServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//默认的当前页数
		int currentPage=1;
		
		//默认的页面的大小
		int pageSize=20;
		
		int totle=0;
		
		if(request.getParameter("page")!=null){
			currentPage=Integer.parseInt(request.getParameter("page").toString());
		}
		
		MusicCRUD musicCRUD=new MusicCRUD();
		
		List<MusicDto> music=musicCRUD.getMusicsPage(currentPage, pageSize);
		
		request.setAttribute("music", music);
		request.getRequestDispatcher("Page/Lovesong.jsp").forward(request, response);
		
	}
}
