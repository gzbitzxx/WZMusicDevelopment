<%@page import="com.wz.dto.UserDto"%>
<%@page import="com.wz.dto.MusicDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddMyMusicType.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="weizhi/htmlframe/plugings/bootstrap/css/site.min.css" />
    <link rel="stylesheet" type="text/css" href="weizhi/htmlframe/style/showbox.css" />

  </head>
  <%
  		request.setCharacterEncoding("utf-8");
  		List<UserDto> user=(List<UserDto>)request.getAttribute("user");
   %>
  <body>
     <div class="showbox" style="width: 80%;"">
        <form method="post" action="#">
            <div class="form-group">
                <label >我的音乐类型名称</label><span  class="text_name" style="color:#FF0000;size="-2;" ></span>
                <input type="text" class="form-control title" name="name" placeholder="标题">
            </div>
            <div class="form-group">
                <label >用户名</label><span  class="text_userID" style="color:#FF0000;size="-2;" ></span>
                <br />
                <select name="userID" class="dropdown userID" style="width:154px; border:1px solid #999; border-radius:5px; height:35px; line-height:35px;">
                    <option selected="selected" value="1">-- 请选择用户名称--</option>
                    <%for(UserDto u: user){ %>
                    <option value="<%=u.getId() %>" ><%=u.getRealName() %></option>
                    <%
                    	} 
                    %>
                </select>
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
    			
    			var title=$(".title").val();
    			var userID=$(".userID").val();
    			
    			if(title==""){
    				$(".text_name").text("请创建音乐类型名");
    				return ;
    			}
    			if(userID==""){
    				$(".text_userID").text("请选择用户姓名！");
    				return ;
    			}
    			
    			
    			//alert(accoutNumber);
    			 $.ajax({
    				url:"addMyMusicType",
    				type:"POST",
    				data:$('form').serialize(),
    				success:function(da){
    					
    					if(da[0].status!=undefined){
    						if(da[0].status==true){
    							layer.msg(da[0].details,{icon:1,time:3000});
    							$("input").val("");
    							$("select").val("1");
    							parent.layer.closeAll();
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
