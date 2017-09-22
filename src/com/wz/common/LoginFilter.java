package com.wz.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.dto.AdminDto;

/**
 * 这是实现 拦截器的代码
 * @author TongZhou
 *
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//获取在下面代码中的request、respone、session对象
		HttpServletRequest servletRequest=(HttpServletRequest)request;
		HttpServletResponse servletResponse=(HttpServletResponse)response;
		HttpSession session=servletRequest.getSession();
		
		//获取请求的URL 
		String path=servletRequest.getRequestURI();
		
		//输出看一下路径
		//System.out.println("path查看一下路径"+path);
		
		int id=0;
		AdminDto x=(AdminDto)session.getAttribute("admin");
		if(x!=null){
			id=x.getId();
			System.out.println("有。。。。。。。。。。。。。。。。。。。。。。。。。。。。。"+id);
		}
		
		//登陆页面不需要过滤
		if(path.indexOf("/login.jsp")>-1){
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		//判断如果没有员工的信息，就跳转到登陆页面
		if(id==0){
			servletResponse.sendRedirect("../login.jsp");
		}else{
			chain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
}
