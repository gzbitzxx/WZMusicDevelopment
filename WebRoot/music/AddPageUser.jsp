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
    <link rel="stylesheet" type="text/css" href="weizhi/htmlframe/plugings/layui/css/layui.css" />
    

  </head>
  
  <body>
    <div class="showbox">
        <form class="layui-form" >
            <div class="form-group">
                <label >账号 *</label><span  class="text_accoutNumber" style="color:#FF0000;size="-2;" ></span>
                <input type="text" class="form-control accoutNumber"  placeholder="账号" name="accoutNumber">
            </div>

            <div class="form-group">
                <label >密码 *</label><span  class="text_password" style="color:#FF0000;size="-2;" ></span> 
                <input type="password" class="form-control password"  placeholder="密码" name="password">
            </div>
            <div class="form-group">
                <label >确认密码 *</label><span  class="text_passwordTrue" style="color:#FF0000;size="-2;" ></span> 
                <input type="password" class="form-control passwordTrue"  placeholder="密码" name="passwordTrue">
            </div>
        </form>
        	<div class="control" style="float: left;">
                <button class="btn btn-large btn-info submit">提交</button>
                <button class="btn btn-large btn-info reset" >重置</button>
            </div>
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
    		
    		$(".submit").click(function(){
    			
    			var accoutNumber=$(".accoutNumber").val();
    			var password=$(".password").val();
    			var passwordTrue=$(".passwordTrue").val();
    			if(accoutNumber==""){
    				$(".text_accoutNumber").text("请输入账号！");
    				return ;
    			}
    			if(password==""){
    				$(".text_password").text("请输入密码！");
    				return ;
    			}
    			if(passwordTrue==""){
    				$(".text_passwordTrue").text("请输入再次输入密码！");
    				return ;
    			}
    			if(passwordTrue!=password){
    				$(".text_passwordTrue").text("两次输入密码不匹配，请重新输入！");
    				$(".passwordTrue").val("");
    				return ;
    			}
    			//alert(accoutNumber);
    			 $.ajax({
    				url:"addPageUserServlet",
    				type:"POST",
    				data:$('form').serialize(),
    				success:function(da){
    					if(da==0){
    						layer.closeAll();
    						window.parent.parent.location.reload();
    					}else{
    						layer.closeAll();
    						alert("用户存在！");
    					}
    				}
    				
    			}); 
    		});
    		
    		$(".reset").click(function(){
    			$("input").val('');
    		});
    	});
    </script>
  </body>
</html>
