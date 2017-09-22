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

import com.wz.dto.AdminDto;
import com.wz.dto.MusicTypeDto;
import com.wz.test.AdminCRUD;
import com.wz.test.MusicTypeCRUD;

public class updateNewMusicType extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String,Object> map=new HashMap<>();
		
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String typeName = request.getParameter("typeName");
		int orderNumber =Integer.parseInt(request.getParameter("orderNumber"));
		

		MusicTypeCRUD musicType = new MusicTypeCRUD();
		MusicTypeDto ad = new MusicTypeDto();
		ad.setId(id);ad.setTypeName(typeName);
		ad.setOrderNumber(orderNumber);
		

		if (musicType.insertMusicType(ad)) {

			map.put("status", true);
			map.put("details", "插入成功");
		} else {
			map.put("status", false);
			map.put("details", "插入失败");
		}
		JSONArray json=JSONArray.fromObject(map);
		response.setContentType("application/json;chartset=utf-8");
		PrintWriter print=response.getWriter();
		print.write(json.toString());
		print.close();

	}
}
