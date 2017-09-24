<%@page import="com.wz.common.DeleteHtmlTeg"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.wz.dto.ArticleDto"%>
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

<title>文章推荐</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Loading Bootstrap -->

<link href="WZMusic/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Loading Flat UI -->
<link rel="stylesheet"
	href="weizhi/htmlframe/plugings/layui/css/layui.css" media="all">
<link href="WZMusic/dist/css/flat-ui.css" rel="stylesheet">
<link href="WZMusic/docs/assets/css/demo.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="WZMusic/css/roll-ad.css">
<link rel="shortcut icon" href="WZMusic/img/favicon.ico">
<link rel="stylesheet" type="text/css" href="WZMusic/css/wz_index.css">
<link rel="stylesheet" type="text/css" href="WZMusic/css/friend.css">
<link rel="stylesheet" type="text/css" href="WZMusic/css/Article.css">



</head>
<%
	request.setCharacterEncoding("utf-8");
	HttpSession s = request.getSession();
	UserDto user = (UserDto) s.getAttribute("user");

	String realName = null;
	int uID = 0;
	if (user != null) {
		realName = (String) user.getRealName();
		uID = user.getId();
	}

	Integer currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	Integer totle = Integer.parseInt(request.getAttribute("totle").toString());
	List<ArticleDto> articles = (List<ArticleDto>) request.getAttribute("article");
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 ");
	int number = (currentPage - 1) * 10 + 1;
%>

<body style="background:rgb(245,245,245);">
	<div style=" width::100%; ">
		<div style="width:1080px; margin:0 auto 0;">
			<div style="clear:both;"></div>
			<!--清除浮动-->
			<div class="wz_index_body">
				<!--中间内容部分-->
				<!--Left内容-->
				<div class="wz_index_title">
					<!--标题begin-->
					<div class="wz_index_head_one">
						<span class="wz_index_head_one_title"><a
							href="javascript:return false;">文章动态</a></span> <span class="wz_left">
							<button type="button" class="btn btn-info addArticle">
								<span class="glyphicon glyphicon-pencil">发文章吧</span>
							</button>
						</span>
					</div>
					<!--标题end-->

					<!--comment Begin-->
					<%
						for (ArticleDto ar : articles) {
					%>
					<div class="comment_A">
						<!--Comment Right Begin-->
						<div class="comment_Part" style="">
							<div>
								<div class="col-xs-3" style="height:40px; float:left;">
									<a href="javascript:return false;"
										class="btn btn-block btn-lg btn-info" style="font-size:10px;"><%=formatter.format(ar.getCreateTime())%></a>
								</div>
								<div class="Article_title">
									<a href="showArticleDetail?id=<%=ar.getId()%>"><%=ar.getTitle()%></a>
								</div>
							</div>
							<br>
							<p class="count"
								style="clear: both; font-size: 14px; margin-left:10px;margin-right:10px; height:170px;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;摘要：<%=DeleteHtmlTeg.Html2Text(ar.getWords()).replace("&nbsp;", "").replace(" ", "").length() >= 150
						? DeleteHtmlTeg.Html2Text(ar.getWords()).replace("&nbsp;", "").replace(" ", "").substring(0,
								150) + "..."
						: DeleteHtmlTeg.Html2Text(ar.getWords()).replace(" ", "").replace("&nbsp;", "")%>
								<a href="showArticleDetail?id=<%=ar.getId()%>"> 阅读全文</a>
							</p>

							<div>
								<small>&nbsp;&nbsp;posted @ <%=formatter.format(ar.getCreateTime())%>
									<%=ar.getUserDto().getRealName()%> 阅读(<%=ar.getLikeNumber()%>)
									评论(0) <%
										if (uID == ar.getUserDto().getId()) {
									%> <small class="deletePageArticle"><a
										href="javascript:return false;">删除</a></small><input type="hidden"
									value="<%=ar.getId()%>"> <small
									class="updatePageArticle"><a
										href="javascript:return false;">修改</a></small> <%
 	}
 %>
								</small> <small style="float:right;">来源：《<%=ar.getMusicDto().getMusicName()%>--<%=ar.getMusicDto().getSinger()%>》
								</small>
							</div>

						</div>
						<!--Comment Right End-->

					</div>
					<!--comment End-->
					<%
						}
					%>
					<div style="margin-left: 50px;" id="dome2"></div>
					<!-- 底部加宽一点开始 -->
					<div style="height: 20px;width: 100%;"></div>
					<!-- 底部加宽一点开始 -->
					<input value="<%=currentPage%>" class="currentPageNumber"
						type="hidden" /> <input value="<%=totle%>"
						class="totlePageNumber" type="hidden" />

				</div>
				<!--Left END-->

				<!--right内容-->
				<div
					style="width: 28%; float: right; min-height:400px; height:auto!important; height:400px;">
					<%
						if (realName == null) {
					%>
					<div style="width:100%; height:225px;">
						<div class="wz_right_part_mysef">
							<img src="WZMusic/images/noImages.png" height="150"
								style="float:left;">
							<div style="float:left; text-align:center;">
								<p>
									<i class="buttonDelete" style="color:#16a085">请登录</i>
								</p>
								<p class="wz_right_world">Lv.0</p>
								<p class="wz_right_world3">未签到</p>
							</div>
						</div>
						<div style="background:#9B9B9B; width:100%; height:75px;">
							<div class="wz_right_world2">
								<p>0</p>
								<p>动态</p>
							</div>
							<div class="wz_right_world2">
								<p>0</p>
								<p>关住</p>
							</div>
							<div class="wz_right_world2">
								<p>0</p>
								<p>粉丝</p>
							</div>
						</div>
					</div>
					<%
						} else {
					%>

					<div style="width:100%; height:225px;">
						<div class="wz_right_part_mysef">
							<img src="WZMusic/images/zxx.jpg" height="150"
								style="float:left;">
							<div style="float:left; text-align:center;">
								<p>
									<a href="#"><%=realName%></a>
								</p>
								<p class="wz_right_world">Lv.5</p>
								<p class="wz_right_world3">已签到</p>
							</div>
						</div>
						<div style="background:#9B9B9B; width:100%; height:75px;">
							<div class="wz_right_world2">
								<p>0</p>
								<p>动态</p>
							</div>
							<div class="wz_right_world2">
								<p>10</p>
								<p>关住</p>
							</div>
							<div class="wz_right_world2">
								<p>20</p>
								<p>粉丝</p>
							</div>
						</div>
					</div>
					<%
						}
					%>

				</div>
			</div>
		</div>

		<div style="clear:both; "></div>

		<script src="WZMusic/dist/js/vendor/jquery.min.js"></script>
		<script src="WZMusic/dist/js/vendor/video.js "></script>
		<script src="WZMusic/dist/js/flat-ui.min.js "></script>
		<script src="WZMusic/docs/assets/js/application.js "></script>
		<script src="WZMusic/js/jquery.roll-ad.js "></script>
		<script src="weizhi/htmlframe/plugings/layui/layui.js"
			type="text/javascript"></script>

		<script type="text/javascript">
		
			var windowIndex;
		
			layui.use([ 'layer', 'laypage' ], function() {
				var $ = layui.jquery,
					layer = layui.layer,
					laypage = layui.laypage;
		
				//这是跳转到登陆页面的 button 事件
				$(".buttonDelete").click(function() {
					windowIndex = layer.open({
						type : 2,
						title : '用户登陆',
						shadeClose : true,
						area : [ '420px', '70%' ],
						content : 'Page/Lands.jsp',
					});
				});
		
				//这是发表文章的点击事件
				$(".addArticle").click(function() {
					layer.open({
						type : 2,
						title : "添加文章",
						shadeClose : true,
						area : [ '80%', '90%' ],
						content : 'addPageArticles',
					});
				});
		
				//注销登录
				$(".exituserLands").click(function() {
					$.ajax({
						url : "exitUserLands",
						success : function(data) {
							if (data == 0) {
								window.location.reload();
							} else {
								alert("注销失败！");
							}
						}
					});
				});
				//删除文章
				$(".deletePageArticle").click(function() {
					var id = $(this).parent().find('input[type="hidden"]').val();
					$.ajax({
						url : "deleteArticles?id=" + id,
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
		
				//修改文章
				$(".updatePageArticle").click(function() {
					var id = $(this).parent().find('input[type="hidden"]').val();
		
					windowIndex =layer.open({
						type : 2,
						title : '修改文章',
						shadeClose : true,
						/* 
						btn : [ '修改', '取消' ], 
						*/
						shade : 0.8,
						maxmin : true,
						area : [ '70%', '90%' ],
						content : 'updateArticle?id=' + id,
					});
		
		
				});
		
		
			});
		
		
			function closeWindow() {
				if (windowIndex != undefined) {
					layer.close(windowIndex);
					window.location.reload();
				}
			}
		</script>

		<script type="text/javascript">
			layui.use([ 'layer', 'laypage' ], function() {
				var $ = layui.jquery,
					layer = layui.layer,
					laypage = layui.laypage;
		
		
				//分页
				laypage({
					cont : 'dome2', //分页容器的id
					pages : $(".totlePageNumber").val(), //总页数
					skin : '#3498db', //自定义选中色值 //,skip: true //开启跳页
					curr : $(".currentPageNumber").val(),
					jump : function(obj, first) {
						if (!first) {
							location.href = 'getArticle?page=' + obj.curr;
						}
					}
				});
		
		
			});
		</script>

</body>
</html>
