package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.wz.common.EncodeByMd5;
import com.wz.dto.AdminDto;
import com.wz.test.AdminCRUD;

public class updateNewAdmin extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String,Object> map=new HashMap<>();
		
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String accoutNumber = request.getParameter("accoutNumber");
		String realName = request.getParameter("realName");
		String loginIP = request.getParameter("loginIP");
		String password = request.getParameter("password");
		
		if(password.length()!=32){
			try {
				password=EncodeByMd5.EncoderByMd5(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		

		AdminCRUD admin = new AdminCRUD();
		AdminDto ad = new AdminDto();
		ad.setId(id);
		ad.setAccoutNumber(accoutNumber);
		ad.setLoginIP(loginIP);
		ad.setPassword(password);
		ad.setRealName(realName);
		

		if (admin.insertAdmin(ad)) {

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
