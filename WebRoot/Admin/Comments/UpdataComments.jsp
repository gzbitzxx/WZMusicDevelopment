<%@page import="com.wz.dto.CommentsDto"%>
<%@page import="org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode"%>
<%@page import="com.wz.dto.UserDto"%>
<%@page import="com.wz.dto.MusicDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	CommentsDto comm = (CommentsDto) request.getAttribute("comment");
	List<MusicDto> musics = (List<MusicDto>) request.getAttribute("music");
	List<UserDto> user = (List<UserDto>) request.getAttribute("user");
%>

<body>
	<div class="showbox">
		<form method="post" action="#">
			<div class="form-group">
				<label>评论内容</label> <input type="hidden" class="form-control"
					value="<%=comm.getWords()%>" id="wordInput">

				<textarea rows="3" cols="20" class="form-control" name="words"
					id="wordShow"></textarea>
			</div>

			<div class="form-group">
				<label>作者</label><span class="text_userID"
					style="color:#FF0000;size="-2;" ></span> <br /> <select
					name="userID" class="dropdown"
					style="width:154px; border:1px solid #999; border-radius:5px; height:35px; line-height:35px;" id="userSelect">
					<%
						for (UserDto u : user) {
					%>
					<option value="<%=u.getId()%>"><%=u.getRealName()%></option>
					<%
						}
					%>
				</select>
			</div>

			<input type="hidden" value=<%=comm.getUserDto().getId()%>
				id="userIdInput">
			
			<input type="hidden" value=<%=comm.getMusicDto().getId()%>
				id="musicIdInput">
			
			<div class="form-group">
				<label>归属音乐</label> <span class="text_musicID"
					style="color:#FF0000;size="-2;" ></span> <br /> <select
					class="dropdown" name="musicID"
					style="width:154px; border:1px solid #999; border-radius:5px; height:35px; line-height:35px;" id="musicSelect"
					>
					<%
						for (MusicDto m : musics) {
					%>
					<option value="<%=m.getId()%>"><%=m.getMusicName()%></option>
					<%
						}
					%>
				</select>
			</div>

			<div class="form-group">
				<label>创建时间</label> <input type="text" class="form-control"
					name="date" placeholder="评论内容" value="<%=comm.getDate()%>" readonly>
			</div>

		</form>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			document.getElementById("wordShow").value = document.getElementById("wordInput").value;
	
			var uid = document.getElementById("userIdInput").value;
			var musicInput = document.getElementById("musicSelect");
	
			for (var i = 0; i < musicInput.options.length; i++) {
				if (musicInput.options[i].value == mid) {
					musicInput.options[i].selected = true
					break;
				}
			}
			
			var mid=document.getElementById("musicIdInput").value;
			var userInput = document.getElementById("userSelect");
	
			for (var i = 0; i < userInput.options.length; i++) {
				if (userInput.options[i].value == uid) {
					userInput.options[i].selected = true
					break;
				}
			}
	
		}
	</script>
</body>
</html>

