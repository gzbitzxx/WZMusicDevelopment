<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.wz.dto.*"%>
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
<link rel="stylesheet"
	href="weizhi/htmlframe/plugings/bootstrap/css/site.min.css" />
<link rel="stylesheet" type="text/css"
	href="weizhi/htmlframe/style/showbox.css">
</head>
<%
 	request.setCharacterEncoding("utf-8");
 	ArticleDto article=(ArticleDto)request.getAttribute("article");
 	
 	List<MusicDto> musics=(List<MusicDto>)request.getAttribute("music");
  	List<UserDto> user=(List<UserDto>)request.getAttribute("user");
  	SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 ");
 %>

 <body>
    <div class="showbox" style="width: 80%;">
        <form method="post">
            <div class="form-group">
                <label >标题</label>
                <input type="text" class="form-control update_title" name="title" placeholder="标题" value="<%=article.getTitle()%>">
            </div>
            
            <input type="hidden" value=<%=article.getUserDto().getId()%>
				id="userIdInput">
			
			<input type="hidden" value=<%=article.getMusicDto().getId()%>
				id="musicIdInput">
            
            <div class="form-group">
                <label >作者</label>
                <br />
                <select  id="userSelect"  name="userID"  class="dropdown update_userID" style="width:154px; border:1px solid #999; border-radius:5px; height:35px; line-height:35px;">
                    
                    <%for(UserDto u: user){ %>
                    <option value="<%=u.getId() %>" ><%=u.getRealName() %></option>
                    <%
                    	} 
                    %>
                </select>
            </div>
            <div class="form-group">
                <label >归属音乐</label>
                <br />
                <select id="musicSelect" class="dropdown update_musicID"  name="musicID" style="width:154px; border:1px solid #999; border-radius:5px; height:35px; line-height:35px;">
                    
                   <%for(MusicDto m:musics){ %>
                    <option value="<%=m.getId() %>" ><%=m.getMusicName() %></option>
                    <%} %>
                </select>
            </div>
           	
            <div class="form-group">
                <label >内容</label>
                <div id="wangEdit"></div>
            </div>
            
            <div class="form-group">
            	 <label >创建时间</label>
                <input type="text" name="createTime" class="update_createTime" value="<%=formatter.format(article.getCreateTime())%>" readonly>
            </div>
            
            <div class="form-group">
            	  <input class="btn btn-primary btn-lg btn-block submit" value="修 改" type="button" style="width: 49%; float:left;" />
                 <input class="btn btn-primary btn-lg btn-block onsubmit" value="取消" type="button" style="width: 49%; float:right; margin-top: 0px;" />
            </div>
            <div class="form-group">
            	 <label style="margin-top: 40px;">  </label>
            </div>
        </form>
        
    </div>
  </body>
  <script type="text/javascript" src="weizhi/htmlframe/plugings/wangEdit/wangEditor.js"></script>
  <script src="weizhi/htmlframe/plugings/layui/layui.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	window.onload = function() {
    		var uid = document.getElementById("userIdInput").value;
    		var musicInput = document.getElementById("musicSelect");
    
    		for (var i = 0; i < musicInput.options.length; i++) {
    			if (musicInput.options[i].value == mid) {
    				musicInput.options[i].selected = true
    				break;
    			}
    		}
    
    		var mid = document.getElementById("musicIdInput").value;
    		var userInput = document.getElementById("userSelect");
    
    		for (var i = 0; i < userInput.options.length; i++) {
    			if (userInput.options[i].value == uid) {
    				userInput.options[i].selected = true
    				break;
    			}
    		}
    	}
    </script>
    
    <script type="text/javascript">
    	var E = window.wangEditor;
    	var editor2 = new E('#wangEdit');
    	editor2.create();
    	editor2.txt.html('<%=article.getWords()%>');
    	
		layui.use(['layer','laypage'], function() {
    		var $=layui.jquery,
    		layer=layui.layer;
			
			$(".submit").click(function(){
				var title=$(".update_title").val();
				var words=editor2.txt.html();
				var musicID=$(".update_musicID").val();
				var userID=$(".update_userID").val();
				var createTime=$(".update_createTime").val();
				var url="updateNewArticle?id=<%=article.getId()%>";
				
				var param = {"title": title, "words": words, "musicID": musicID,"userID":userID,"createTime":createTime}; 
				
				$.post(url, param, function(data) {
				  
                   if (data == 0) {
                   	parent.location.reload();
                      parent.layer.closeAll();
                   } else if(data==1) {  
                       alert("修改失败！");  
                   }  
               }); 
                
				
			});
			
			$(".onsubmit").click(function(){
				parent.layer.closeAll();
			});
			
			
		
		});
	
	</script>
	
    
</html>
