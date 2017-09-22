package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
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

public class addComment extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 转换为map
		Map<String, Object> map = new HashMap<>();

		request.setCharacterEncoding("utf-8");
		String words = request.getParameter("words");
		
		int userID = Integer.parseInt(request.getParameter("userID"));
		int musicID = Integer.parseInt(request.getParameter("musicID"));

		CommentsCRUD comm = new CommentsCRUD();
		UserDto udto = new UserDto();
		udto.setId(userID);
		
		MusicDto musicDto=new MusicDto();
		musicDto.setId(musicID);
		
		CommentsDto dto = new CommentsDto();
		
		dto.setUserDto(udto);
		dto.setWords(words);
		dto.setMusicDto(musicDto);
		// 获取当前的日期
		Date date = new Date();
		// 设置要获取到什么样的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取String类型的时间
		String createdate = sdf.format(date);

		dto.setDate(createdate);

		if (comm.insertComment(dto)) {
			map.put("status", true);
			map.put("details", "插入成功！");
		} else {
			map.put("status", false);
			map.put("details", "插入失败！");

		}

		// 转换为json
		JSONArray jsonArray = JSONArray.fromObject(map);
		response.setContentType("application/json;charset=utf-8");

		PrintWriter print = response.getWriter();

		print.write(jsonArray.toString());

		print.close();

	}

}
