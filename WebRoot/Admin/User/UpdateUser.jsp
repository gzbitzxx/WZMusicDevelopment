<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.wz.dto.UserDto"%>
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

	<link rel="stylesheet" href="weizhi/htmlframe/plugings/bootstrap/css/site.min.css" />
    <link rel="stylesheet" type="text/css" href="weizhi/htmlframe/style/showbox.css">
    <link rel="stylesheet" type="text/css" href="weizhi/htmlframe/plugings/layui/css/layui.css" />
    
	<%
	request.setCharacterEncoding("utf-8");
 	UserDto user=(UserDto)request.getAttribute("users");
	%>
  </head>
  
  <body>
    <div class="showbox">
        <form class="layui-form" >
        
            <div class="form-group">
                <label >账号 </label>
                <input type="text" class="form-control"  placeholder="账号" name="accoutNumber" value="<%=user.getAccoutNumber()%>" readonly>
            </div>
             
            <div class="form-group">
                <label>真实姓名 </label>
                <input type="text" class="form-control "  placeholder="真实姓名" name="realName" value="<%=user.getRealName()%>">
            </div>
            
            <div class="form-group">
			    <label>性别</label>
			    <div class="layui-input-block">
			      <input type="radio" name="sex" value="男" title="男" checked="">
			      <input type="radio" name="sex" value="女" title="女">
			      <input type="radio" name="sex" value="其他" title="其他">
			    </div>
  			</div>
            
            <div class="form-group">
                <label>爱好</label>
                <input type="text" class="form-control"  placeholder="爱好" name="hobby" value="<%=user.getHobby()%>">
            </div>
            
            <div class="form-group">
                <label>出生日期</label>
                <div class="layui-input-inline">
        		<input type="text" name="brithday" id="date" lay-verify="date" placeholder="yyyy-mm-dd" value="<%=user.getBrithday().substring(0, 10)%>" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
      			</div>
            </div>
            
            <div class="form-group">
                <label >密码 </label>
                <input type="password" class="form-control"  placeholder="密码" name="password" value="<%=user.getPassword()%>">
            </div>
            
            <div class="form-group">
                <label>登陆ip</label>
                <input type="text" class="form-control" placeholder="登陆IP" name="loginIP" value="<%=user.getLoginIP()%>">
            </div>
            
            <div class="form-group">
                <label >访问量</label>
                <input type="text" class="form-control"  placeholder="密码" name="view" value="<%=user.getView()%>">
            </div>
            
        </form>
    </div>
    <script type="text/javascript" src="weizhi/htmlframe/plugings/layui/layui.js"></script>
    
    <script type="text/javascript">
    	layui.use(["form","layer","laydate","layedit"],function(){
    		//在使用Layui 的样式时，就需要时使用这句代码
    		var form = layui.form()
    		,layedit = layui.layedit
    		,laydate = layui.laydate;
    		
    		var $=layui.jquery;
    		var layer=layui.layer;
    		//创建一个编辑器
    		var editIndex = layedit.build('LAY_demo_editor');
    		
    	});
    </script>
  </body>
</html>
