package com.wz.option;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wz.test.UserCRUD;

public class listUser extends BaseServlet {

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
		
		UserCRUD user = new UserCRUD();
		
		int size=user.getUser().size()%pageSize;
		//通过总页数和页面大小来计算页数
		if(size==0){
			totle=user.getUser().size()/pageSize;
		}else{
			totle=user.getUser().size()/pageSize+1;
		}
		
		request.setAttribute("user", user.getUsersPage(currentPage, pageSize));
		request.setAttribute("currentPage",currentPage );
		request.setAttribute("totle", totle);
		request.getRequestDispatcher("/Admin/User/ListUser.jsp").forward(request, response);
	}
}
