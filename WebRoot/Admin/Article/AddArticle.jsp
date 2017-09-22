<%@page import="org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode"%>
<%@page import="com.wz.dto.UserDto"%>
<%@page import="com.wz.dto.MusicDto"%>
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
    <link rel="stylesheet" type="text/css" href="weizhi/htmlframe/style/showbox.css" />
    <link rel="stylesheel" type="text/css" href="weizhi/htmlframe/plugings/wangEdit/wangEditor.css" />
    

  </head>
  <%
  		request.setCharacterEncoding("utf-8");
  		List<MusicDto> musics=(List<MusicDto>)request.getAttribute("music");
  		List<UserDto> user=(List<UserDto>)request.getAttribute("user");
   %>
  <body>
    <div class="showbox" style="width: 80%;"">
        <form method="post" action="#">
            <div class="form-group">
                <label >标题*</label><span  class="text_title" style="color:#FF0000;size="-2;" ></span>
                <input type="text" class="form-control title" name="title" placeholder="标题">
            </div>
            <div class="form-group">
                <label >作者</label><span  class="text_userID" style="color:#FF0000;size="-2;" ></span>
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
            <div class="form-group">
                <label >归属音乐</label><span  class="text_musicID" style="color:#FF0000;size="-2;" ></span>
                <br />
                <select class="dropdown musicID" name="musicID" style="width:154px; border:1px solid #999; border-radius:5px; height:35px; line-height:35px;">
                    <option selected="selected" value="1">-- 请选择音乐名称--</option>
                   <%for(MusicDto m:musics){ %>
                    <option value="<%=m.getId() %>" ><%=m.getMusicName() %></option>
                    <%} %>
                </select>
            </div>
            <div class="form-group">
                <label >内容</label>
                <!--  <textarea class="form-control" name="words" placeholder="内容" cols="30" rows="10"></textarea>-->
                <input name="words" type="hidden" class="inputword" />
                
                <div class="editW" ></div>
                
            </div>
        </form>
        	<div class="control">
                <button class="btn btn-large btn-info submit">提交</button>
                <button class="btn btn-large btn-info reset" >重置</button>
            </div>
    </div>
    
    <script type="text/javascript" src="weizhi/htmlframe/plugings/layui/layui.js"></script>
    <script type="text/javascript" src="weizhi/htmlframe/plugings/wangEdit/wangEditor.js"></script>
    
    
    <script type="text/javascript">
    
    	var E = window.wangEditor
		var editor2 = new E('.editW')
		editor2.create()
    
    	layui.use(["layer"],function(){
    		var $=layui.jquery;
    		var layer=layui.layer;
    		
    		$(".submit").click(function(){
    		
    		var l=editor2.txt.html();
    		
    			//设置wangEdit的
    			$(".inputword").val(l);
    			
    			var title=$(".title").val();
    			var userID=$(".userID").val();
    			var musicID=$(".musicID").val();
    			
    			if(title==""){
    				$(".text_title").text("请标题！");
    				return ;
    			}
    			if(userID==""){
    				$(".text_userID").text("请选择用户姓名！");
    				return ;
    			}
    			if(musicID==""){
    				$(".text_musicID").text("请选择音乐名称");
    				return ;
    			}
    			
    			//alert(accoutNumber);
    			 $.ajax({
    				url:"addArticle",
    				type:"POST",
    				data:$('form').serialize(),
    				success:function(da){
    					
    					if(da[0].status!=undefined){
    						if(da[0].status==true){
    							layer.msg(da[0].details,{icon:1,time:3000});
    							$("input").val("");
    							$("select").val("1");
    							$(".editW").val("");
    							editor2.txt.html('');
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
