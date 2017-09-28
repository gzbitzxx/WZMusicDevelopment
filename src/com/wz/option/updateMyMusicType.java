package com.wz.option;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.ArticleDto;
import com.wz.dto.MusicDto;
import com.wz.dto.UserDto;
import com.wz.test.ArticleCRUD;
import com.wz.test.MusicCRUD;
import com.wz.test.UserCRUD;

/**
 * 
 * @author TongZhou
 * 这个修改不想做了，感觉没多大的意思
 */
public class updateMyMusicType extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			request.setCharacterEncoding("utf-8");
			int id=Integer.parseInt(request.getParameter("id"));
			
			ArticleCRUD Article=new ArticleCRUD();
			ArticleDto dto=new ArticleDto();
			dto.setId(id);
			
			ArticleDto article1=Article.queryArticle(dto);
			request.setAttribute("article", article1);
			
			MusicCRUD music=new MusicCRUD();
			
			List<MusicDto> m=music.getMusic();
			request.setAttribute("music", m);
			
			UserCRUD userCRUD=new UserCRUD();
			List<UserDto> user=userCRUD.getUser();
			request.setAttribute("user", user);
			request.getRequestDispatcher("/Admin/Article/UpdateArticle.jsp").forward(request, response);
			
	}
}
