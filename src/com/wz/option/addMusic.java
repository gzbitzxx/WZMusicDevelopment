package com.wz.option;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import net.sf.json.JSONArray;

import com.wz.dto.AdminDto;
import com.wz.dto.MusicDto;
import com.wz.dto.MusicTypeDto;
import com.wz.test.AdminCRUD;
import com.wz.test.MusicCRUD;

public class addMusic extends BaseServlet {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		// 转换为map
		Map<String, Object> map = new HashMap<>();
		
		
		//获取传入的参数
		String musicName = request.getParameter("musicName");
		int musicTypeID = Integer.parseInt(request.getParameter("musicTypeID"));
		String singer = request.getParameter("singer");
		String path = request.getParameter("filepath");
				//(String) request.getSession().getAttribute("filePath");
		System.out.println("这厮路径......................................"+path);
		
		if(path!=null){
			request.getSession().removeAttribute("filepath");
		}

		MusicCRUD mu = new MusicCRUD();
		MusicDto dto = new MusicDto();
		MusicTypeDto mt = new MusicTypeDto();
		mt.setId(musicTypeID);
		dto.setMucicTypeDto(mt);
		dto.setMusicName(musicName);
		dto.setPath(path);
		dto.setSinger(singer);

		Boolean b = mu.AddMusic(dto);

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
