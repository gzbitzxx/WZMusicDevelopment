<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="WZMusic/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	 <link href="WZMusic/dist/css/flat-ui.css" rel="stylesheet">
    <link href="WZMusic/docs/assets/css/demo.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="WZMusic/css/roll-ad.css">
    <link rel="shortcut icon" href="WZMusic/img/favicon.ico">
    <link href="WZMusic/css/login.css" rel="stylesheet">
</head>

<body style="background:rgb(245,245,245); width:100%;">
	<form method="post" >
		<div style="width:100%;  margin:0 auto 0;">
			<div>
				<div class="">
					<div class="login-form">
						<span  class="text_number" style="color:#FF0000;size: 1px;" ></span>
						<div class="form-group">
							<input type="text" class="form-control login-field login_number" value=""
								placeholder="请输入账号"  name="number" /> 
							<label class="login-field-icon fui-user" for="login-name"></label>
						</div>

						<span  class="text_password" style="color:#FF0000;size: 1px;" ></span>
						<div class="form-group">
							<input type="password" class="form-control login-field login_pass" value=""
								placeholder="请输入密码"  name="password"/> <label
								class="login-field-icon fui-lock" for="login-pass"></label>
						</div>
						
						<span  class="text_verification" style="color:#FF0000;size: 1px;" ></span>
						<br>
						<div class="form-group" style="width:70%; float: left;">
							 <label class="login-field-icon fui-lock" ></label>
							 <input type="text" class="form-control login-field login_verification" value=""
								placeholder="请输入验证码" name="verification"  />
						</div>
						
						<div class="form-group" style="width:30%; float: right; margin-top:4px;">
							 <img src="imageServlet" id="ImageClick">
						</div>
						
						<div style="clear: both;"></div>
						
						<div class="form-group">
							 <input class="btn btn-primary btn-lg btn-block submit" value="登  录" type="button" />
						</div>
						
						<div class="form-group">
							<span style="width: 50%; float: left; text-align: center;">
								<a href="">忘记密码？</a>
							</span>
							<span style="width: 50%; float: left; text-align: center;">
								<a href="Page/AddPageUser.jsp">注册</a>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<script src="WZMusic/dist/js/vendor/jquery.min.js "></script>
	<script type="text/javascript" src="weizhi/htmlframe/plugings/layui/layui.js"></script>
	
	<script type="text/javascript">
		layui.use(['layer','laypage'], function() {
    		var $=layui.jquery,
    		layer=layui.layer;
		
			$("#ImageClick").click(function(){
				var vcode=document.getElementById('ImageClick');
				vcode.src="imageServlet?nocache="+new Date().getTime();//防止缓存
			});
			
			$(".submit").click(function(){
			
				var number=$(".login_number").val();
				var password=$(".login_pass").val();
				var verification=$(".login_verification").val();
				
				if(number==""){
					$(".text_number").text("请输入账号！");
					return;
				}
				if(password==""){
					$(".text_password").text("请输入密码！");
					return;
				}
				if(verification==""){
					$(".text_verification").text("请输验证码！");
					return;
				}
				
				var url="lands";
				
				var param = {"number": number, "password": password, "verification": verification}; 
				
				$.post(url, param, function(data) {
				  
                   if (data == 0) {
                       parent.layer.closeAll();
                       window.parent.location.reload();
                   } else if(data==1) {  
                       alert("用户名或者密码有误！");  
                   }else{
                   	alert("验证码有误！");
                   }  
               });  
			});
		});
	
	</script>
</body>
</html>
