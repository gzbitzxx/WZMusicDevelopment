package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.wz.dto.AdminDto;
import com.wz.dto.MusicTypeDto;
import com.wz.test.AdminCRUD;
import com.wz.test.MusicTypeCRUD;

public class addMusicType extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 转换为map
		Map<String, Object> map = new HashMap<>();

		request.setCharacterEncoding("utf-8");
		String typeName = request.getParameter("typeName");
		int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));

		// 实例化
		MusicTypeCRUD musicType = new MusicTypeCRUD();

		MusicTypeDto mt = new MusicTypeDto();
		mt.setTypeName(typeName);
		mt.setOrderNumber(orderNumber);

		if (musicType.AddMusicType(mt)) {
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
