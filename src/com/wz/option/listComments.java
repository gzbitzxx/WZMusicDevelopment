package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.CommentsDto;
import com.wz.test.CommentsCRUD;

public class listComments extends BaseServlet {
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
		}
		
		CommentsCRUD commentlist = new CommentsCRUD();
		List<CommentsDto> c = commentlist.getCommentPage(currentPage, pageSize);
		
		int size=commentlist.getComment().size()%pageSize;
		//通过总页数和页面大小来计算页数
		if(size==0){
			totle=commentlist.getComment().size()/pageSize;
		}else{
			totle=commentlist.getComment().size()/pageSize+1;
		}
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("commentlist", c);
		request.setAttribute("currentPage",currentPage );
		request.setAttribute("totle", totle);
		request.getRequestDispatcher("/Admin/Comments/ListComments.jsp").forward(request, response);
	}
}
