package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.CommentsDto;
import com.wz.dto.MusicDto;
import com.wz.dto.UserDto;
import com.wz.test.CommentsCRUD;
import com.wz.test.MusicCRUD;
import com.wz.test.UserCRUD;
/**
 * 获取评论数据，返回 jsp 页面
 * @author TongZhou
 *
 */
public class updataComment extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		CommentsCRUD comm=new CommentsCRUD();
		CommentsDto dto=new CommentsDto();
		dto.setId(id);
		
		CommentsDto comment = comm.queryComment(dto);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("comment", comment);
		
		MusicCRUD music=new MusicCRUD();
		List<MusicDto> m=music.getMusic();
		
		request.setAttribute("music", m);
		
		
		UserCRUD userCRUD=new UserCRUD();
		List<UserDto> user=userCRUD.getUser();
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/Admin/Comments/UpdataComments.jsp").forward(request, response);
	}
}
