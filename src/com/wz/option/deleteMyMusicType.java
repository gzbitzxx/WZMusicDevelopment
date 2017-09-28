package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.ArticleDto;
import com.wz.dto.MyMusicTypeDto;
import com.wz.test.ArticleCRUD;
import com.wz.test.MyMusicTypeCRUD;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class deleteMyMusicType
 */
public class deleteMyMusicType extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,Object> map=new HashMap<>();
		
		int id = Integer.parseInt(request.getParameter("id"));
		MyMusicTypeCRUD my=new MyMusicTypeCRUD();
		MyMusicTypeDto dto=new MyMusicTypeDto();
		dto.setId(id);
		
		
		boolean b =my.DeleteMyMusicType(dto);
		if(b){
			map.put("status", true);
			map.put("details","删除成功！");
		}else{
			map.put("status", false);
			map.put("details","删除失败！");
			
		}
		
		JSONArray jsonArray = JSONArray.fromObject(map);
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter print=response.getWriter();
		
		print.write(jsonArray.toString());
		
		print.close();

	}


}
