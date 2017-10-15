<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>微知音乐管理后台登陆</title>
    
     <link rel="stylesheet" href="weizhi/htmlframe/plugings/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="weizhi/htmlframe/style/hui.css"/>
    <link rel="stylesheet" href="weizhi/iconfont/iconfont.css"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="shortcut icon" href="WZMusic/img/favicon.ico">
  </head>
  
  <body style="background:url('weizhi/htmlframe/imgs/login-bg.jpg');background-size: 100%;">
   <div class="hui-login-panel hui-radius">
  		<form method="post" action="loginWZ"  class="formsubmit">
  		
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2 style="margin: 0px;padding: 0px;text-align: center;color:#4FC1E9;font-size: 30px;">管理员登陆</h2>
                </div>
            </div>
            <br>
            <br>
            <span  class="text_adminNumber" style="color:#FF0000;size="-2;" ></span>
            <div class="row">
                <div class="col-md-12">
                        <div class="hui-input-group hui-panel-radius">
                            <i class="iconfont icon-touxiang"></i>
                            <input type="text" class="hui-input-primary hui-radius adminNumber" placeholder="账号" name="adminNumber"/>
                        </div>
                </div>
            </div>
            <br>
            <br>
            <span  class="text_adminPassword" style="color:#FF0000;size="-2;" ></span>
            <div class="row">
                <div class="col-md-12">
                        <div class="hui-input-group hui-panel-radius">
                            <i class="iconfont icon-mima"></i>
                            <input type="password" class="hui-input-primary hui-radius adminPassword" placeholder="密码" name="adminPassword"/>
                        </div>

                </div>
            </div>
            <br>
            <br>
            <span  class="text_image" style="color:#FF0000;size="-2;" ></span>
            <div class="row">
                <div class="col-md-6">
                   <div class="hui-input-group">
                       <i class="iconfont icon-yanzhengma"></i>
                       <input type="text" class="hui-input-primary hui-radius image" placeholder="验证码" name="image"/>
                   </div>
                </div>
                <div class="col-md-6" style="padding-left: 1px;">
                    <img src="imageServlet" id="ImageClick">
                </div>
            </div>
            <br>
            <br>
            <div class="row">
                <div class="col-md-12" style="text-align: center;">
                       <input class="hui-btn hui-btn-primary hui-radius submit" value="登录" type="button" />
                </div>
            </div>
            <br>
            <br>
            <div class="row">
                <div class="col-md-12" style="text-align: center;">
                       <div style="font-size: 13px;">
                           Copyright © 2017 <a href="#" target="_blank">微知音乐</a> Powered by 幸福摩天轮
                       </div>
                </div>
            </div>
        </div>
        </form> <!-- 表单 -->
    </div>
    
     <script type="text/javascript" src="weizhi/htmlframe/plugings/layui/layui.js"></script>
    <script type="text/javascript">
    	layui.use(["layer"],function(){
    		var $=layui.jquery;
    		var layer=layui.layer;
    		$("#ImageClick").click(
    			function(){
    					var vcode=document.getElementById('ImageClick'); 
   						vcode.src ='imageServlet?nocache='+new Date().getTime(); //防止缓存
    				}
    			);
    	
    		
    		$(".submit").click(function(){
    			
    			var adminNumber=$(".adminNumber").val();
    			var adminPassword=$(".adminPassword").val();
    			var image =$(".image").val();
    			
    			if(adminNumber==""){
    				$(".text_adminNumber").text("请输入账号！");
    				return;
    			}
    			
    			if(adminPassword==""){
    				$(".text_adminPassword").text("请输入密码！");
    				return;
    			}
    			if(image==""){
    				$(".text_image").text("请输入验证码！");
    				return;
    			}
    			$(".formsubmit").submit();
    		});
    		
    	});
    </script>
    -->
  </body>
  
</html>
