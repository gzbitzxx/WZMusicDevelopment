package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.common.BrithDayNumber;
import com.wz.dto.AdminDto;
import com.wz.dto.ArticleDto;
import com.wz.dto.MusicDto;
import com.wz.dto.UserDto;
import com.wz.test.AdminCRUD;
import com.wz.test.ArticleCRUD;

import net.sf.json.JSONArray;

public class updateNewArticle extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		
		int likeNumber = 0;
		String title = request.getParameter("title");
		String words = request.getParameter("words");
		int musicID=Integer.parseInt(request.getParameter("musicID"));
		int userID=Integer.parseInt(request.getParameter("userID"));
		String date=request.getParameter("createTime");
		
		MusicDto musicDto=new MusicDto();
		musicDto.setId(musicID);

		ArticleCRUD article = new ArticleCRUD();
		ArticleDto dto = new ArticleDto();
		
		UserDto userDto=new UserDto();
		userDto.setId(userID);
		
		dto.setId(id);
		dto.setLikeNumber(likeNumber);
		dto.setMusicDto(musicDto);
		dto.setTitle(title);
		dto.setUserDto(userDto);
		dto.setWords(words);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 ");
		
		Date data = null;
		try {
			data = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setCreateTime(data);
		

		if (article.insertArticle(dto)) {
			response.getWriter().write("0");
		} else {
			response.getWriter().write("1");
		}
		

	}

}
