<%@page import="com.wz.dto.UserDto"%>
<%@page import="com.wz.dto.AdminDto"%>
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

<link rel="stylesheet" href="weizhi/iconfont/iconfont.css" />
<link rel="stylesheet" href="weizhi/htmlframe/style/flat-ui.css" />
<link rel="stylesheet" href="weizhi/htmlframe/style/demo.css" />
<link rel="stylesheet" href="weizhi/htmlframe/style/bootstrap.min.css" />
<link rel="stylesheet"
	href="weizhi/htmlframe/iconfont/font-awesome-4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="weizhi/htmlframe/plugings/layui/css/layui.css" media="all">


</head>

<body>
	<%
		request.setCharacterEncoding("utf-8");
		Integer currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
		Integer totle = Integer.parseInt(request.getAttribute("totle").toString());
		List<UserDto> users = (List<UserDto>) request.getAttribute("user");
		int number = (currentPage - 1) * 10 + 1;
		
	%>
	<table class="layui-table">
		<caption style="text-align: center;">
			<h4>微知用户列表</h4>
			<br>
			<button class="layui-btn addButton" style="float: right;"><i class="iconfont icon-icon48"></i> 添加用户</button>
		</caption>
		<colgroup>
			<col width="5%">
			<col width="10%">
			<col width="10%">
			<col width="6%">
			<col width="6%">
			<col width="15%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="6%">
			<col width="17%">
		</colgroup>
		<thead>
			<tr>
				<th>编号</th>
				<th>账号</th>
				<th>真实姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>爱好</th>
				<th>出生日期</th>
				<th>密码</th>
				<th>登陆IP</th>
				<th>访问量</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (UserDto us : users) {
			%>
			<tr>
				<td><%=number%></td>
				<td><%=us.getAccoutNumber()%></td>
				<td><%=us.getRealName()%></td>
				<td><%=us.getSex()%></td>
				<td><%=us.getAge()%></td>
				<td><%=us.getHobby()%></td>
				<td><%=us.getBrithday().substring(0, 10)%></td>
				<td><%=us.getPassword()%></td>
				<td><%=us.getLoginIP()%></td>
				<td><%=us.getView()%></td>
				<td><i class="fa fa-pencil buttonUpdate" title="编辑"></i> <input
					type="hidden" value="<%=us.getId()%>"> <i
					class="fa fa-trash-o buttonDelete" title="删除"></i></td>
			</tr>
			<%
				number++;
				}
			%>
		</tbody>
	</table>
	<div id="dome2"></div>
	<input value="<%=currentPage%>" class="currentPageNumber" type="hidden" />
	<input value="<%=totle%>" class="totlePageNumber" type="hidden" />

	<script src="weizhi/htmlframe/plugings/layui/layui.js"
		type="text/javascript"></script>

	<script type="text/javascript">
	
		layui.use([ 'layer', 'laypage' ], function() {
	
			var $ = layui.jquery,
				layer = layui.layer,
				laypage = layui.laypage;
	
	
			//分页
			laypage({
				cont : 'dome2', //分页容器的id
				pages : $(".totlePageNumber").val(), //总页数
				skin : '#5FB878', //自定义选中色值 //,skip: true //开启跳页
				curr : $(".currentPageNumber").val(),
				jump : function(obj, first) {
					if (!first) {
						location.href = 'user?page=' + obj.curr;
					}
				}
			});
	
	
			$(".buttonUpdate").click(function() {
				var id = $(this).parent().find('input[type="hidden"]').val();
	
				//layer.open({ //这句是让整个后面都不可见
				parent.layer.open({
					type : 2,
					title : '修改用户',
					shadeClose : true,
					btn : [ '修改', '取消' ],
					shade : 0.8,
					area : [ '80%', '100%' ],
					content : 'updateUser?id=' + id, //iframe的url
					yes : function(index, layero) {
						var user = parent.layer.getChildFrame("form", index);
						$.ajax({
							url : "updateNewUser?id=" + id,
							data : user.serialize(),
							type : "POST",
							success : function(data) {
								window.location.reload();
								parent.layer.close(index);
							}
						});
					},
					btn1 : function(index, layero) {
						parent.layer.close(index);
					}
				});
	
	
			});
	
			$(".buttonDelete").click(function() {
				var id = $(this).parent().find('input[type="hidden"]').val();
				$.ajax({
					url : "deleteUser?id=" + id,
					type : "POST",
					success : function(da) {
						if (da[0].status == true) {
							layer.msg(da[0].details, {
								icon : 1,
								time : 3000
							});
						} else {
							layer.msg(da[0].details, {
								icon : 2,
								time : 3000
							});
						}
						window.location.reload();
					}
				});
	
			});
			
			$(".addButton").click(function(){
				parent.layer.open({
					type:2,
					title:'添加用户',
					shadeClose:true,
    				area:['80%','90%'],
    				content:'Admin/User/AddUser.jsp',
				});
				
    							
			});
	
	
	
		});
	</script>

</body>
</html>
