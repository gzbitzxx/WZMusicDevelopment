package com.wz.option;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.test.AdminCRUD;
import com.wz.test.MusicTypeCRUD;

public class listMusicType extends BaseServlet {

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
		MusicTypeCRUD musicType = new MusicTypeCRUD();
		
		request.setAttribute("musicType", musicType.getMusicTypePage(currentPage,pageSize));
		
		int size=musicType.getMusicType().size()%pageSize;
		//通过总页数和页面大小来计算页数
		if(size==0){
			totle=musicType.getMusicType().size()/pageSize;
		}else{
			totle=musicType.getMusicType().size()/pageSize+1;
		}
		
		request.setAttribute("currentPage",currentPage );
		request.setAttribute("totle", totle);
		request.getRequestDispatcher("/Admin/MusicType/ListMusicType.jsp")
				.forward(request, response);
	}
}
