package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.wz.dto.AdminDto;
import com.wz.dto.ArticleDto;
import com.wz.dto.MusicDto;
import com.wz.dto.UserDto;
import com.wz.test.AdminCRUD;
import com.wz.test.ArticleCRUD;

import net.sf.json.JSONArray;

public class addArticle extends BaseServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//转换为map
		Map<String,Object> map=new HashMap<>();
		
		
		
		
		request.setCharacterEncoding("utf-8");
		//int likeNumber=Integer.parseInt(request.getParameter("likeNumber"));
		int likeNumber=0;
		int musicID=Integer.parseInt(request.getParameter("musicID"));
		String title=request.getParameter("title");
		int userID=Integer.parseInt(request.getParameter("userID"));
		String words=request.getParameter("words");
		Date createTime=new Date();
		
		ArticleCRUD article = new ArticleCRUD();
		ArticleDto ar = new ArticleDto();
		
		MusicDto musicDto=new MusicDto();
		musicDto.setId(musicID);
		
		UserDto userDto=new UserDto();
		userDto.setId(userID);
		
	
		ar.setCreateTime(createTime);
		ar.setLikeNumber(likeNumber);
		ar.setMusicDto(musicDto);
		ar.setTitle(title);
		ar.setUserDto(userDto);
		ar.setWords(words);
		
		if(article.AddArticle(ar)){
			map.put("status", true);
			map.put("details","插入成功！");
		}else{
			map.put("status", false);
			map.put("details","插入失败！");
			
		}
		
		//转换为json
		JSONArray jsonArray = JSONArray.fromObject(map);
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter print=response.getWriter();
		
		print.write(jsonArray.toString());
		
		print.close();
		
		
	}
	
}
