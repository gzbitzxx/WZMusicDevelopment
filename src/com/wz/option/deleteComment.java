package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.CommentsDto;
import com.wz.test.CommentsCRUD;

import net.sf.json.JSONArray;

public class deleteComment extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,Object> map=new HashMap<>();
		
		int id = Integer.parseInt(request.getParameter("id"));
		CommentsCRUD comm = new CommentsCRUD();
		CommentsDto dto = new CommentsDto();
		dto.setId(id);
		
		if(comm.delectComment(dto)){
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
