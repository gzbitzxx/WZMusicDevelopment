<%@page import="com.wz.dto.MyMusicTypeDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ListMymusicType.jsp' starting page</title>

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


<script src="weizhi/htmlframe/js/bootstrap.min.js"></script>

</head>
<%
	request.setCharacterEncoding("utf-8");
	Integer currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	Integer totle = Integer.parseInt(request.getAttribute("totle").toString());
	List<MyMusicTypeDto> myMusic = (List<MyMusicTypeDto>) request.getAttribute("myMusicType");
%>
  <body>
    <table class="layui-table">
		<caption style="text-align: center;">
			<h4>我的音乐类型列表</h4>
			<br>
			<button class="layui-btn addButton" style="float: right;"><i class="iconfont icon-icon48"></i> 添加文章</button>
		</caption>
		<colgroup>
			<col width="10%">
			<col width="30%">
			<col width="30%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th>编号</th>
				<th>类型名称</th>
				<th>用户名</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				int number=1;
				for (MyMusicTypeDto my : myMusic) {
			%>
			<tr>
				<td><%=number%></td>
				<td><%=my.getName()%></td>
				<td><%=my.getUserDto().getAccoutNumber()%></td>
				<td><i class="fa fa-pencil buttonUpdate" title="编辑"></i> <input
					type="hidden" value="<%=my.getId()%>"> <i
					class="fa fa-trash-o buttonDelete" title="删除"></i></td>

			</tr>
			<%
				number++;
				}
			%>
		</tbody>
	</table>
	<script src="weizhi/htmlframe/plugings/layui/layui.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		layui.use(['layer','laypage'], function() {
			var $=layui.jquery,
			layer=layui.layer,
			laypage=layui.laypage;
			
			//实现删除
			$(".buttonDelete").click(function(){
				var id = $(this).parent().find('input[type="hidden"]').val();
				$.ajax({
					url:"deleteMyMusicType?id="+id,
					type:"POST",
					success:function(da){
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
			
			//添加
			$(".addButton").click(function(){
				parent.layer.open({
					type:2,
					title:'添加文章',
					shadeClose:true,
    				area:['80%','90%'],
    				content:'addMyMusicTypeMU',
				});
				
    							
			});
			
			
		});
	</script>	
		
  </body>
</html>
