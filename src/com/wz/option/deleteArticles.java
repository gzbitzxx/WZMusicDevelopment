package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.dto.AdminDto;
import com.wz.dto.ArticleDto;
import com.wz.test.AdminCRUD;
import com.wz.test.ArticleCRUD;

import net.sf.json.JSONArray;

public class deleteArticles extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,Object> map=new HashMap<>();
		
		int id = Integer.parseInt(request.getParameter("id"));
		ArticleCRUD article = new ArticleCRUD();
		ArticleDto dto = new ArticleDto();
		dto.setId(id);
		boolean b = article.DeleteArticle(dto);
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
