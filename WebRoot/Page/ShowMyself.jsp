<%@page import="com.wz.dto.UserDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>个人中心</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Loading Bootstrap -->
<link href="WZMusic/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Loading Flat UI -->
<link href="WZMusic/dist/css/flat-ui.css" rel="stylesheet">
<link href="WZMusic/docs/assets/css/demo.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="WZMusic/css/roll-ad.css">
<link rel="shortcut icon" href="WZMusic/img/favicon.ico">
<link rel="stylesheet" type="text/css" href="WZMusic/css/wz_index.css">

<link href="weizhi/htmlframe/plugings/layui/css/layui.css"
	rel="stylesheet" type="text/css" />
<%
	request.setCharacterEncoding("utf-8");
	HttpSession s = request.getSession();
	UserDto user = (UserDto) s.getAttribute("user");
%>

</head>

<body style="background:rgb(245,245,245);">
	<div style=" width:100%; ">
		<div style="width:1080px; margin:0 auto 0;">
			<!--标题头结束-->
			<div class="wz_index_body">
				<!--Left内容-->
				<div class="wz_index_title" style="width:100%;">
					<div class="wz_index_head_one">
						<span class="wz_index_head_one_title"><a href="#"
							style="text-align:center;margin-left:45%;">个人信息</a></span>
							<button class="layui-btn addButton" style="float: right;"><i class="iconfont icon-icon48"></i> 修改个人信息 </button>
					</div>
					<!--开始-->
					<div style="width: 95%; margin:0 auto 0;">
						<div class="layui-form-item">
							<label class="layui-form-label" style="width:20%;">账号:</label> <label
								class="layui-form-label" style="width:80%; text-align:left;"><%=user.getAccoutNumber()%></label>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label" style="width:20%;">姓名:</label> <label
								class="layui-form-label" style="width:80%; text-align:left;"><%=user.getRealName()%></label>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label" style="width:20%;">性别:</label> <label
								class="layui-form-label" style="width:80%; text-align:left;"><%=user.getSex()%></label>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label" style="width:20%;">爱好:</label> <label
								class="layui-form-label" style="width:80%; text-align:left;"><%=user.getHobby()%></label>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label" style="width:20%;">出生日期:</label>
							<label class="layui-form-label"
								style="width:80%; text-align:left;"><%=user.getBrithday()%></label>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label" style="width:20%;">访问量:</label> <label
								class="layui-form-label" style="width:80%; text-align:left;"><%=user.getView()%></label>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label" style="width:20%;">注册ip:</label>
							<label class="layui-form-label"
								style="width:80%; text-align:left;"><%=user.getLoginIP()%></label>
						</div>

					</div>
					<!--结束-->

				</div>
			</div>
		</div>
	</div>

	<div style="clear:both; "></div>
	<!--底部的播放栏结束-->
	<script src="weizhi/htmlframe/plugings/layui/layui.js"
		type="text/javascript"></script>

	<script type="text/javascript">
	
		layui.use([ 'layer', 'laypage' ], function() {
			var $ = layui.jquery,
				layer = layui.layer,
				laypage = layui.laypage;
	
			$(".buttonDelete").click(function() {
				 layer.open({
					type : 2,
					title : '用户登陆',
					shadeClose : true,
					area : [ '420px', '70%' ],
					content : 'Page/Lands.jsp',
				});
			});
			
			$(".addButton").click(function(){
				var id=<%=user.getId()%>;
				layer.open({
					type : 2,
					title : '修改用户',
					shadeClose : true,
					btn : [ '修改', '取消' ],
					shade : 0.8,
					area : [ '80%', '100%' ],
					content : 'updateUser?id=' + id, //iframe的url
					yes : function(index, layero) {
						var user = layer.getChildFrame("form", index);
						$.ajax({
							url : "updateNewUser?id=" + id,
							data : user.serialize(),
							type : "POST",
							success : function(data) {
								window.location.reload();
								layer.close(index);
							}
						});
					},
					btn1 : function(index, layero) {
						layer.close(index);
					}
				});
			});
	
		});
	
	</script>



</body>
</html>
