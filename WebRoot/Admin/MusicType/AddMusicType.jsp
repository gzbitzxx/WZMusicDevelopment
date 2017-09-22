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
  
  <body>
    <div class="showbox">
        <form method="post">
            <div class="form-group">
                <label >音乐类型名称 *</label><span  class="text_typeName" style="color:#FF0000;size="-2;" ></span>
                <input type="text" class="form-control typeName"  placeholder="音乐类型名称" name="typeName">
            </div>
            <div class="form-group">
                <label>排序*</label><span  class="text_orderNumber" style="color:#FF0000;size="-2;" ></span>
                <input type="text" class="form-control orderNumber"  placeholder="排序" name="orderNumber">
            </div>
        </form>
        	<div class="control">
                <button class="btn btn-large btn-info submit">提交</button>
                <button class="btn btn-large btn-info reset" >重置</button>
            </div>
    </div>
    
    <script type="text/javascript" src="weizhi/htmlframe/plugings/layui/layui.js"></script>
    <script type="text/javascript">
    	layui.use(["layer"],function(){
    		var $=layui.jquery;
    		var layer=layui.layer;
    		
    		$(".submit").click(function(){
    			
    			var typeName=$(".typeName").val();
    			var orderNumber=$(".orderNumber").val();
    			if(typeName==""){
    				$(".text_typeName").text("请输入账号！");
    				return ;
    			}
    			if(orderNumber==""){
    				$(".text_orderNumber").text("请输入用户名！");
    				return ;
    			}
    			
    			 $.ajax({
    				url:"addMusicType",
    				type:"POST",
    				data:$('form').serialize(),
    				success:function(da){
    					
    					if(da[0].status!=undefined){
    						if(da[0].status==true){
    							layer.msg(da[0].details,{icon:1,time:3000});
    							$("input").val("");
    							parent.layer.closeAll();
    							//window.parent.location.reload();
    						}else{
    							layer.msg(da[0].details,{icon:2,time:3000});
    						}
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
