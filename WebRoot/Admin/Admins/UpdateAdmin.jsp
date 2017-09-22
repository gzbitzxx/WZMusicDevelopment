<%@page import="com.wz.dto.AdminDto"%>
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
 	AdminDto admin=(AdminDto)request.getAttribute("admins");
 %>

 <body>
    <div class="showbox">
        <form method="post">
            <div class="form-group">
                <label >账号</label>
                <input type="text" class="form-control"  placeholder="账号" name="accoutNumber" value="<%=admin.getAccoutNumber()%>" readonly>
            </div>
            <div class="form-group">
                <label>真实姓名</label>
                <input type="text" class="form-control"  placeholder="真实姓名" name="realName" value="<%=admin.getRealName()%>">
            </div>
            <div class="form-group">
                <label >密码</label> 
                <input type="password" class="form-control"  placeholder="密码" name="password" value="<%=admin.getPassword()%>">
            </div>
            <div class="form-group">
                <label>登陆ip</label>
                <input type="text" class="form-control" placeholder="登陆IP" name="loginIP" value="<%=admin.getLoginIP()%>">
            </div>
        </form>
    </div>
  </body>
</html>
