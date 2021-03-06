package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import com.wz.dto.MusicDto;
import com.wz.dto.MusicTypeDto;
import com.wz.test.MusicCRUD;

public class updateNewMusic extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 转换为map
		Map<String, Object> map = new HashMap<>();

		request.setCharacterEncoding("utf-8");
		String musicName = request.getParameter("musicName");
		int id=Integer.parseInt(request.getParameter("id"));
		
		int musicTypeID =Integer.parseInt(request.getParameter("musicTypeID"));
		String singer = request.getParameter("singer");
		String path = request.getParameter("path");

		MusicCRUD mu = new MusicCRUD();
		MusicDto dto = new MusicDto();
		
		MusicTypeDto mt=new MusicTypeDto();
		mt.setId(musicTypeID);
		
		dto.setMucicTypeDto(mt);
		dto.setMusicName(musicName);
		dto.setPath(path);
		dto.setId(id);
		dto.setSinger(singer);
		
		Boolean b=mu.insertMusic(dto);

		if (b) {
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
