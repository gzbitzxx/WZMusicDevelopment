<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Hand.jsp' starting page</title>

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

</head>

<body>

	<!--标题头开始-->
	<div class="row">
		<div class="col-xs-12">
			<nav class="navbar navbar-inverse navbar-embossed" role="navigation"
				style="margin:0 auto 0;">
			<div class="navbar-header">
				<a class="navbar-brand">微知音乐</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse-01">
				<ul class="nav navbar-nav navbar-left">
					<li><a>发现音乐<span class="navbar-unread">1</span></a></li>
					<li><a href="Page/Center.jsp">我的音乐</a></li>
					<li><a href="Page/Friends.jsp">朋友</a></li>
					<li><a href="Page/Article.jsp">发现文章</a></li>
					<li><a href="Page/Myself.jsp">个人中心</a></li>
				</ul>
				<form class="navbar-form navbar-right" action="#" role="search">
					<div class="form-group">
						<div class="input-group">
							<input class="form-control" id="navbarInput-01" type="search"
								placeholder="Search"> <span class="input-group-btn">
								<button type="submit" class="btn">
									<span class="fui-search"></span>
								</button>
							</span>
						</div>
					</div>
				</form>
				<div
					style="float:right; margin-top:10px; font-weight:bold; font-family:Constantia, 'Lucida Bright', 'DejaVu Serif', Georgia, serif; font-size:16px;">
					<span class="fui-user"> <a href="#">欢迎幸福摩天轮</a></span>
				</div>
			</div>
			<!-- /.navbar-collapse --> </nav>
			<!-- /navbar -->
		</div>
		<!-- /.row -->
	</div>
	<!--标题头结束-->


	<script src="WZMusic/dist/js/vendor/jquery.min.js "></script>
	<script src="WZMusic/dist/js/vendor/video.js "></script>
	<script src="WZMusic/dist/js/flat-ui.min.js "></script>
	<script src="WZMusic/docs/assets/js/application.js "></script>
	<script src="WZMusic/js/jquery.roll-ad.js "></script>

	<script>
      videojs.options.flash.swf = "WZMusic/dist/js/vendors/video-js.swf ";
    </script>

	<script>
        RollAd.init($('.rollad'));
    </script>

	<script>
            var timer;
            var obj=document.getElementById('zxx_doo');
            window.onscroll=function(){
                    clearTimeout(timer);
                    timer=setTime(function(){
                        var scrolltop=document.body.scrolltop||document.documentElement.scrollTop||0;
                        obj.style.buttom=0-scroltop+'px';
                        },300);
                }    
    </script>

</body>
</html>
