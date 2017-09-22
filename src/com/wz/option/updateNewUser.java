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

import com.wz.common.BrithDayNumber;
import com.wz.common.EncodeByMd5;
import com.wz.dto.AdminDto;
import com.wz.dto.UserDto;
import com.wz.test.AdminCRUD;
import com.wz.test.UserCRUD;

public class updateNewUser extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String,Object> map=new HashMap<>();
		
		request.setCharacterEncoding("utf-8");
		String accoutNumber=request.getParameter("accoutNumber");
		String realName=request.getParameter("realName");
		String password=request.getParameter("password");
		String brithday=request.getParameter("brithday");
		String hobby=request.getParameter("hobby");
		int age=BrithDayNumber.getAgeFromBirthTime(brithday);
		String sex=request.getParameter("sex");
		String view=request.getParameter("view");
		int id=Integer.parseInt(request.getParameter("id"));
		String loginIP=request.getParameter("loginIP");

		if(password.length()!=32){
			try {
				password=EncodeByMd5.EncoderByMd5(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		
		
		UserCRUD user = new UserCRUD();
		UserDto ad = new UserDto();
		ad.setId(id);
		ad.setAge(age);
		ad.setAccoutNumber(accoutNumber);
		ad.setPassword(password);
		ad.setRealName(realName);
		ad.setBrithday(brithday);
		ad.setHobby(hobby);
		ad.setSex(sex);
		ad.setView(view);
		ad.setLoginIP(loginIP);
		

		if (user.insertUser(ad)) {

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
