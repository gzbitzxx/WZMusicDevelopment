package com.wz.pageservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.dto.MusicDto;
import com.wz.dto.UserDto;
import com.wz.option.BaseServlet;
import com.wz.test.MusicCRUD;
import com.wz.test.UserCRUD;

/**
 * 访问自己的信息
 * 
 * @author TongZhou
 *
 */
public class myselfInfo extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 实例化
		int id = Integer.parseInt(request.getParameter("id"));

		UserCRUD user = new UserCRUD();

		UserDto dto = new UserDto();
		dto.setId(id);

		dto = user.queryUser(dto);
		
		request.setAttribute("user", dto);
		request.getRequestDispatcher("Page/ShowMyself.jsp").forward(request, response);

	}

}
