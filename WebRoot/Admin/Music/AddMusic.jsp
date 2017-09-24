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
  		List<MusicTypeDto> type=(List<MusicTypeDto>)request.getAttribute("types");
  %>
  <body>
    <div class="showbox">
        <form method="post" enctype="multipart/form-data">
            
            <div class="form-group">
                <label >类型名称</label><span  class="text_musicTypeID" style="color:#FF0000;size="-2;" ></span>
                <br />
                <select name="musicTypeID" class="dropdown" style="width:154px; border:1px solid #999; border-radius:5px; height:35px; line-height:35px;">
                    <option selected="selected" value="1">-- 请选择类型--</option>
                    <%for(MusicTypeDto mt : type){ %>
                    <option value="<%=mt.getId() %>" ><%=mt.getTypeName() %></option>
                    <%
                    	} 
                    %>
                </select>
            </div>
            <div class="form-group">
                <label >音乐路径</label><span  class="text_path" style="color:#FF0000;size="-2;" ></span>
                <input type="file" class="form-control fileupdate" name="path"  value="选择上传音乐文件">
                <input type="hidden" name="filepath" id="filepath"/>
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
    		
    		//文件上传
    		$(".submit").click(function(){
					   var formData = new FormData($("form")[0]);  
							 $.ajax({
								url:"UploadServlet",//想要的servlet中
								type:"POST",
								data: formData,  
						        async: false,  
						        cache: false,  
						        contentType: false,  
						        processData: false,
								success:function(da){
								console.log(da);
				    				if(da[0].status!=undefined){
				    					if(da[0].status==true){
				    					$("#filepath").val(da[0].details);
				    					$.ajax({
						    				url:"addMusic",
						    				type:"POST",
						    				data:$('form').serialize(),
						    				success:function(da){
					    						if(da[0].status!=undefined){
					    						if(da[0].status==true){
    											layer.msg(da[0].details,{icon:1,time:3000});
    											$("input").val("");
    											$("select").val("1");
    											parent.layer.closeAll();
    											//window.parent.location.reload();
							    		}else{
							    				layer.msg(da[0].details,{icon:2,time:3000});
							    				}
							    			}
							    		}
							    				
							    	}); 
				    					
				    					
				    				}else{
				    					layer.msg(da[0].details,{icon:2,time:3000});
				    					}
				    			}
								}
						})
    		 });
    		
    		
    	});
    </script>
  </body>
</html>
