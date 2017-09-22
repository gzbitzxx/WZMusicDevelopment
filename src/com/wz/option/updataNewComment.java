package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.CommentsDto;
import com.wz.dto.MusicDto;
import com.wz.dto.UserDto;
import com.wz.test.CommentsCRUD;

import net.sf.json.JSONArray;

public class updataNewComment extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String,Object> map=new HashMap<>();
		
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String words=request.getParameter("words");
		int userID=Integer.parseInt(request.getParameter("userID"));
		int musicID=Integer.parseInt(request.getParameter("musicID"));
		String date=request.getParameter("date");
		
		CommentsCRUD comm = new CommentsCRUD();
		CommentsDto dto = new CommentsDto();
		
		UserDto udto = new UserDto();
		udto.setId(userID);
		
		MusicDto musicDto=new MusicDto();
		musicDto.setId(musicID);
		
		dto.setId(id);
		dto.setWords(words);
		dto.setUserDto(udto);
		dto.setMusicDto(musicDto);
		
		//获取当前的日期
        dto.setDate(date);

		if(comm.updataComment(dto)){
			map.put("status", true);
			map.put("details","修改成功！");
		}else{
			map.put("status", false);
			map.put("details","修改失败！");
			
		}
		JSONArray json=JSONArray.fromObject(map);
		response.setContentType("application/json;chartset=utf-8");
		PrintWriter print=response.getWriter();
		print.write(json.toString());
		print.close();

	}
}
