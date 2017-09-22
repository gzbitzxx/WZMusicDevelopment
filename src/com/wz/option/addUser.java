package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import net.sf.json.JSONArray;

import com.wz.common.BrithDayNumber;
import com.wz.common.EncodeByMd5;
import com.wz.dto.AdminDto;
import com.wz.dto.UserDto;
import com.wz.test.AdminCRUD;
import com.wz.test.UserCRUD;

/**
 * 添加用户
 * @author TongZhou
 *
 */
public class addUser extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//转换为map
		Map<String,Object> map=new HashMap<>();
		
			
		request.setCharacterEncoding("utf-8");
		String accoutNumber=request.getParameter("accoutNumber");
		String realName=request.getParameter("realName");
		String password=request.getParameter("password");
		String brithday=request.getParameter("brithday");
		int age=BrithDayNumber.getAgeFromBirthTime(brithday);
		String hobby=request.getParameter("hobby");
		String sex=request.getParameter("sex");
		String view=request.getParameter("view");
		String loginIP=request.getRemoteAddr();
		
		try {
			password=EncodeByMd5.EncoderByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		UserCRUD user = new UserCRUD();
		UserDto dto = new UserDto();
		dto.setAccoutNumber(accoutNumber);
		dto.setAge(age);
		dto.setBrithday(brithday);
		dto.setHobby(hobby);
		dto.setSex(sex);
		dto.setLoginIP(loginIP);
		dto.setPassword(password);
		dto.setRealName(realName);
		dto.setView(view);
		
		if(user.AddUser(dto)){
			map.put("status", true);
			map.put("details","插入成功！");
		}else{
			map.put("status", false);
			map.put("details","插入失败！");
			
		}
		
		//转换为json
		JSONArray jsonArray = JSONArray.fromObject(map);
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter print=response.getWriter();
		
		print.write(jsonArray.toString());
		
		print.close();
		
		
	}
	
}
