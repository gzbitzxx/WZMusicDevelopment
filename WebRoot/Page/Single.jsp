<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Single.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="WZMusic/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	<!-- Loading Flat UI -->
	<link href="WZMusic/dist/css/flat-ui.css" rel="stylesheet">
	<link href="WZMusic/docs/assets/css/demo.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="WZMusic/css/roll-ad.css">
	<link rel="shortcut icon" href="WZMusic/img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="WZMusic/css/wz_index.css">

  </head>
  
  <body >
	<div class="wz_index_head_one">
    	<a href="#" class="wz_index_head_one_title" >我的歌手<small>(1)</small></a>
    </div>
    
    <div class="wz_right_world4_singer">
        <img src="WZMusic/images/swj.jpg " class="wz_right_world4_singe_pic">
        <div style="text-align:center; ">
             <p id="wz_right_world4_singe_name">尚雯婕</p>
             <p>中国台湾原住民歌手</p>
        </div>
    </div>
</body>
</html>
