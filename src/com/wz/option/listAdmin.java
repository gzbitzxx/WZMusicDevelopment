package com.wz.option;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.test.AdminCRUD;

public class listAdmin extends BaseServlet {

	
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
			AdminCRUD admin=new AdminCRUD();
			request.setAttribute("admin", admin.getAdminPage(currentPage,pageSize));
			
			int size=admin.getAdmins().size()%pageSize;
			//通过总页数和页面大小来计算页数
			if(size==0){
				totle=admin.getAdmins().size()/pageSize;
			}else{
				totle=admin.getAdmins().size()/pageSize+1;
			}
			
			request.setAttribute("currentPage",currentPage );
			request.setAttribute("totle", totle);
			request.getRequestDispatcher("/Admin/Admins/ListAdmin.jsp").forward(request, response);
	}

}
