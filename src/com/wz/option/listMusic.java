package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.MusicDto;
import com.wz.test.MusicCRUD;

public class listMusic extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//当前页
		int currentPage=1;
		
		//默认的页面条数的大小
		int pageSize=10;
		
		//总的页面数
		int totle=0;
		if(request.getParameter("page")!=null){
			currentPage=Integer.parseInt(request.getParameter("page").toString());
		};
		
		MusicCRUD music=new MusicCRUD();
		List<MusicDto> m=music.getMusicsPage(currentPage, pageSize);
		
		int size=music.getMusic().size()%pageSize;
		//通过总页数和页面大小来计算页数
		if(size==0){
			totle=music.getMusic().size()/pageSize;
		}else{
			totle=music.getMusic().size()/pageSize+1;
		}
		request.setAttribute("currentPage",currentPage );
		request.setAttribute("totle", totle);
		request.setAttribute("music", m);
		request.getRequestDispatcher("/Admin/Music/ListMusic.jsp").forward(request, response);
	}
}
