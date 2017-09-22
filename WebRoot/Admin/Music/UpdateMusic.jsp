<%@page import="com.wz.dto.MusicDto"%>
<%@page import="com.wz.dto.MusicTypeDto"%>
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

<title>My JSP 'UpdateAdmin.jsp' starting page</title>

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
	MusicDto music = (MusicDto) request.getAttribute("musics");
	List<MusicTypeDto> type = (List<MusicTypeDto>) request.getAttribute("types");
%>

<body>
	<div class="showbox">
		<form method="post">
			<form method="post">
				<div class="form-group">
					<label>音乐名称</label> <input type="text"
						class="form-control musicName" name="musicName" placeholder="音乐名称"
						value="<%=music.getMusicName()%>">
				</div>
				<input type="hidden"
						value="<%=music.getMucicTypeDto().getId()%>" id="musicTypeInput">
						
				<div class="form-group">
					<label>类型名称</label> <br /> 
					<select id="musicTypeSelect" name="musicTypeID" class="dropdown"
						style="width:154px; border:1px solid #999; border-radius:5px; height:35px; line-height:35px;">
						<option selected="selected">-- 请选择类型--</option>
						<%
							for (MusicTypeDto mt : type) {
						%>
						<option value="<%=mt.getId()%>"><%=mt.getTypeName()%></option>
						<%
							}
						%>
					</select>
				</div>
				<div class="form-group">
					<label>歌手</label> <input type="text" class="form-control"
						name="singer" placeholder="歌手" value="<%=music.getSinger()%>">
				</div>
				
				<div class="form-group">
					<label>音乐路径</label> <input type="text" class="form-control"
						name="path" placeholder="文件路径" value="<%=music.getPath()%>" readonly>
				</div>
			</form>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			var mtId = document.getElementById("musicTypeInput").value;
			var mTypeSelect = document.getElementById("musicTypeSelect");
			
			for (var i = 0; i < mTypeSelect.options.length; i++) {
				if (mTypeSelect.options[i].value == mtId) {
					mTypeSelect.options[i].selected = true;
					break;
				}
			}
			
			var musicPath=document.getElementById("musicPath");
			
		}
	</script>
</body>
</html>
