package com.wz.option;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.wz.common.EncodeByMd5;
import com.wz.dto.AdminDto;
import com.wz.test.AdminCRUD;

public class addAdmin extends BaseServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		//转换为map
		Map<String,Object> map=new HashMap<>();
		
		
		request.setCharacterEncoding("utf-8");
		String accoutNumber=request.getParameter("accoutNumber");
		String realName=request.getParameter("realName");
		String password=request.getParameter("password");
		String loginIP=request.getRemoteAddr();
		String newpassword=null;
		
		try {
			newpassword=EncodeByMd5.EncoderByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		AdminCRUD admin = new AdminCRUD();
		AdminDto ad = new AdminDto();
		ad.setAccoutNumber(accoutNumber);
		ad.setLoginIP(loginIP);
		ad.setPassword(newpassword);
		ad.setRealName(realName);
		
		if(admin.AddAdmin(ad)){
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
