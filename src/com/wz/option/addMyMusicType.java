package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.ArticleDto;
import com.wz.dto.MusicDto;
import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.UserDto;
import com.wz.test.ArticleCRUD;
import com.wz.test.MyMusicTypeCRUD;

import net.sf.json.JSONArray;

/**
 * 
 * @author TongZhou
 *
 */
public class addMyMusicType extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//转换为map
		Map<String,Object> map=new HashMap<>();
		
		
		
		
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		int userID=Integer.parseInt(request.getParameter("userID"));
		
		
		UserDto userDto=new UserDto();
		userDto.setId(userID);
		
		MyMusicTypeCRUD my=new MyMusicTypeCRUD();
		
		MyMusicTypeDto dto=new MyMusicTypeDto();
		dto.setName(name);
		dto.setUserDto(userDto);
		
		
		if(my.AddMyMusicType(dto)){
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
