<%@page import="com.wz.dto.MusicTypeDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="weizhi/htmlframe/plugings/bootstrap/css/site.min.css" />
    <link rel="stylesheet" type="text/css" href="weizhi/htmlframe/style/showbox.css">
    

  </head>
  <%
  	request.setCharacterEncoding("utf-8");
  	MusicTypeDto mt=(MusicTypeDto)request.getAttribute("musicTypes");
  %>
  <body>
    <div class="showbox">
        <form method="post">
            <div class="form-group">
                <label >音乐类型名称 </label>
                <input type="text" class="form-control typeName"  placeholder="音乐类型名称" name="typeName" value="<%=mt.getTypeName()%>">
            </div>
            <div class="form-group">
                <label>排序</label>
                <input type="text" class="form-control orderNumber"  placeholder="排序" name="orderNumber" value="<%=mt.getOrderNumber()%>">
            </div>
        </form>
    </div>
    
  </body>
</html>
